import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author : hianian
 * @Time : 2022/3/30 20:16
 * @File : Solution_0021.java
 *
 * 这道题也可以用层序遍历来做，只要遍历的时候，其左右孩子节点都为空，那么它就是叶子节点，
 * 记录其当前深度，并与当前最小深度相比，取最小。
 *
 * 注意，因为是层序遍历，所以一层层的遍历，第一次出现叶子节点，就是其整棵树的最小深度、
 */
public class Solution_0021 {

    public static int minDepth(TreeNode root) {

        if(root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int length, mini = 0, depth = 0;

        all: while(!queue.isEmpty()) {

            depth ++;
            length = queue.size();

            while(length > 0) {
                root = queue.poll();

                // 叶子节点，记录其深度
                if(root.left == null && root.right == null) {
                    mini = depth;

                    break all;
                } else {

                    if(root.left != null) {
                        queue.offer(root.left);
                    }

                    if(root.right != null) {
                        queue.offer(root.right);
                    }
                }

                length --;
            }
        }

        return mini;
    }

    public static void main(String[] args) {

        TreeNode tn1 = new TreeNode(9);

        TreeNode tn2 = new TreeNode(15);
        TreeNode tn3 = new TreeNode(7);
        TreeNode tn4 = new TreeNode(20, tn2, tn3);

        TreeNode root = new TreeNode(3, tn1, tn4);

        System.out.println(minDepth(root));
    }
}
