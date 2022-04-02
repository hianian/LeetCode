import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author : hianian
 * @Time : 2022/4/1 19:55
 * @File : Solution_0025.java
 *
 * 这道题判断是否是平衡二叉树，即求左右子树的深度，判断深度差是否大于1。
 *
 * 注意，还要判断，左右子树是否为平衡二叉树。（因为可能两棵子树都不是平衡二叉树，但是高度相同）
 */
public class Solution_0025 {

    public static boolean isBalanced(TreeNode root) {

        if(root == null) {
            return true;
        }

        int left_depth = getDepth(root.left);
        int right_depth = getDepth(root.right);

        // 如果高度差大于1，说明肯定不是二叉树，不用再进行后续判断。
        if(Math.abs(left_depth - right_depth) > 1) {
            return false;
        }

        boolean leftResult = isBalanced(root.left);
        boolean rightResult = isBalanced(root.right);

        return leftResult && rightResult;
    }

    public static int getDepth(TreeNode root) {

        if(root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int length, depth = 0;

        while(!queue.isEmpty()) {

            length = queue.size();
            depth ++;
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

        return depth;
    }

    public static void main(String[] args) {
        System.out.println();

        TreeNode tn1 = new TreeNode(15);
        TreeNode tn2 = new TreeNode(7);
        TreeNode tn3 = new TreeNode(20, tn1, tn2);
        TreeNode tn4 = new TreeNode(9);
        TreeNode tn5 = new TreeNode(3, tn3, tn4);

        System.out.println(isBalanced(tn5));
    }
}
