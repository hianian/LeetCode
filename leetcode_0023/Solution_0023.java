import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author : hianian
 * @Time : 2022/3/31 19:17
 * @File : Solution_0023.java
 *
 * 参考：https://programmercarl.com/0101.%E5%AF%B9%E7%A7%B0%E4%BA%8C%E5%8F%89%E6%A0%91.html
 */
public class Solution_0023 {

    public static boolean isSymmetric(TreeNode root) {

        boolean result = true;

        if(root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        TreeNode left, right;

        while(!queue.isEmpty()) {

            // 每次取两个节点，判断是否对称
            left = queue.poll();
            right = queue.poll();

            // 均为空，则说明对称
            if(left == null && right == null) {
                continue;
            }

            // 都不为空
            if(left != null && right != null) {

                if(left.val != right.val) {
                    result = false;
                    break;
                }

            } else {
                // 有一个为空
                result = false;
                break;
            }

            // 左节点的左孩子、右节点的右孩子
            queue.offer(left.left);
            queue.offer(right.right);

            // 左节点的右孩子、右节点的左孩子
            queue.offer(left.right);
            queue.offer(right.left);

        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println();

        TreeNode tn1 = new TreeNode(3);
        TreeNode tn2 = new TreeNode(4);
        TreeNode tn3 = new TreeNode(2, tn1, tn2);
        TreeNode tn4 = new TreeNode(4);
        TreeNode tn5 = new TreeNode(3);
        TreeNode tn6 = new TreeNode(2, tn4, tn5);
        TreeNode root = new TreeNode(1, tn3, tn6);

        System.out.println(isSymmetric(root));

        TreeNode tns1 = new TreeNode(3);
        TreeNode tns2 = new TreeNode(2, null, tns1);
        TreeNode tns3 = new TreeNode(3);
        TreeNode tns4 = new TreeNode(2, null, tns3);
        TreeNode tns5 = new TreeNode(1, tns2, tns4);

        System.out.println(isSymmetric(tns5));
    }
}
