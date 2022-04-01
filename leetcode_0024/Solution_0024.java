import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author : hianian
 * @Time : 2022/4/1 19:28
 * @File : Solution_0024.java
 *
 * 这道题直接层序遍历即可。
 */
public class Solution_0024 {

    public static int countNodes(TreeNode root) {

        if(root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        int length, sum = 0;

        while(!queue.isEmpty()) {

            length = queue.size();
            sum += length;

            while(length > 0) {
                root = queue.poll();

                if(root.left != null) {
                    queue.offer(root.left);
                }

                if(root.right != null) {
                    queue.offer(root.right);
                }

                length --;
            }
        }

        return sum;
    }

    public static void main(String[] args) {

        TreeNode tn1 = new TreeNode(4);
        TreeNode tn2 = new TreeNode(5);
        TreeNode tn3 = new TreeNode(2, tn1, tn2);
        TreeNode tn4 = new TreeNode(6);
        TreeNode tn5 = new TreeNode(3, tn4, null);
        TreeNode root = new TreeNode(1, tn3, tn5);

        System.out.println(countNodes(root));
    }
}
