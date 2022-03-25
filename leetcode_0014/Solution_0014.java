import java.util.*;

/**
 * @Author : hianian
 * @Time : 2022/3/25 19:51
 * @File : Solution_0014.java
 */
public class Solution_0014 {

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if(root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int length;

        while(!queue.isEmpty()) {

            List<Integer> subResult = new ArrayList<>();
            length = queue.size();

            while(length > 0) {

                root = queue.poll();
                subResult.add(root.val);

                if(root.left != null) {
                    queue.offer(root.left);
                }

                if(root.right != null) {
                    queue.offer(root.right);
                }

                length --;
            }

            result.add(subResult);
        }

        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        TreeNode tn1 = new TreeNode(7);
        TreeNode tn2 = new TreeNode(15);
        TreeNode tn3 = new TreeNode(20, tn2, tn1);

        TreeNode tn4 = new TreeNode(9);

        TreeNode root = new TreeNode(3, tn4, tn3);

        List<List<Integer>> result = levelOrderBottom(root);
        for(List<Integer> i: result) {
            for(Integer j : i) {
                System.out.print(j + "  ");
            }
            System.out.println();
        }
    }
}
