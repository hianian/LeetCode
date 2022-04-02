/**
 * @Author : hianian
 * @Time : 2022/4/1 20:43
 * @File : Solution_0025_02.java
 *
 * 上述方法在获取高度的时候重复了很多次。其实在获取高度的时候可以采用递归的方法来做，
 *
 * 并且，获取高度的方法可以优化，即左右子节点的最大高度+1即为当前节点的高度。
 *
 * 同时，如果左右子节点的高度差大于1，就说明当前节点不是平衡二叉树，那么总的二叉树就必定不是平衡二叉树了。
 */
public class Solution_0025_02 {

    public static boolean isBalanced(TreeNode root) {

        return getDepth(root) != -1;
    }

    public static int getDepth(TreeNode root) {

        if(root == null) {
            return 0;
        }

        // 获取左节点的高度
        int left = getDepth(root.left);

        // 如果左孩子节点返回值为-1，表示不是平衡二叉树，所以直接返回即可，无序后续判断。
        if(left == -1) {
            return -1;
        }

        int right = getDepth(root.right);

        if(right == -1) {
            return -1;
        }

        // 如果高度差大于1，说明不是当前节点不是平衡二叉树，返回-1
        if(Math.abs(left - right) > 1) {
            return -1;
        }

        // 说明当前节点是平衡二叉树，返回其高度，注意左右子节点的最大值 + 1（当前节点）
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {

        TreeNode tn1 = new TreeNode(15);
        TreeNode tn2 = new TreeNode(7);
        TreeNode tn3 = new TreeNode(20, tn1, tn2);
        TreeNode tn4 = new TreeNode(9);
        TreeNode tn5 = new TreeNode(3, tn3, tn4);

        System.out.println(isBalanced(tn5));
    }
}
