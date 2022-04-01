import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author : hianian
 * @Time : 2022/3/30 20:37
 * @File : Solution_0022.java
 *
 * 这道题，实际上就是遍历每个节点，将节点的左右孩子互换一下。
 * 可以在层序遍历的时候，将其左右孩子互换。
 */
public class Solution_0022 {

    public static TreeNode invertTree(TreeNode root) {

        if(root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int length;
        TreeNode node, temp;

        while(!queue.isEmpty()) {

            length = queue.size();

            while(length > 0) {
                node = queue.poll();

                // 左右节点交换
                temp = node.left;
                node.left = node.right;
                node.right = temp;

                // 入队列，保存下一层要遍历的节点
                if(node.left != null) {
                    queue.offer(node.left);
                }

                if(node.right != null) {
                    queue.offer(node.right);
                }

                length --;
            }
        }

        return root;
    }

    // 递归方法
    public static TreeNode recurive(TreeNode root) {

        if(root == null) {
            return root;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        recurive(root.left);
        recurive(root.right);

        return root;
    }

    public static void main(String[] args) {

        TreeNode tn1 = new TreeNode(1);
        TreeNode tn2 = new TreeNode(3);
        TreeNode tn3 = new TreeNode(2, tn1, tn2);

        TreeNode tn4 = new TreeNode(6);
        TreeNode tn5 = new TreeNode(9);
        TreeNode tn6 = new TreeNode(7, tn4, tn5);

        TreeNode root = new TreeNode(4, tn3, tn6);

        TreeNode newRoot = invertTree(root);
//        TreeNode newRoot = recurive(root);

        // 层序遍历，验证结果
        List<List<Integer>> result = Solution_0013_03.levelOrder(root);
        for(List<Integer> i: result) {
            for(Integer j : i) {
                System.out.print(j + "  ");
            }
            System.out.println();
        }
    }
}
