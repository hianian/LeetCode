import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author : hianian
 * @Time : 2022/3/30 19:56
 * @File : Solution_0020.java
 *
 * 这道题就是层序遍历，累加深度即可。
 */
public class Solution_0020 {
    public static int maxDepth(TreeNode root) {

        if(root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int length, depth = 0;

        while(!queue.isEmpty()) {

            length = queue.size();

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

            depth ++;
        }

        return depth;
    }

    public static void main(String[] args) {
        System.out.println();

        TreeNode tn1 = new TreeNode(9);

        TreeNode tn2 = new TreeNode(15);
        TreeNode tn3 = new TreeNode(7);
        TreeNode tn4 = new TreeNode(20, tn2, tn3);

        TreeNode root = new TreeNode(3, tn1, tn4);

        int result = maxDepth(root);
        System.out.println(result);
    }
}
