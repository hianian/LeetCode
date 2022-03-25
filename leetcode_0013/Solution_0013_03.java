import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author : hianian
 * @Time : 2022/3/24 21:00
 * @File : Solution_0013_03.java
 *
 * 针对02中的BFS方法，自己实现一遍
 */
public class Solution_0013_03 {

    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if(root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        int length;

        while(!queue.isEmpty()) {

            length = queue.size();
            List<Integer> subResult = new ArrayList<>();

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

        return  result;
    }

    public static void main(String[] args) {
        TreeNode tn1 = new TreeNode(7);
        TreeNode tn2 = new TreeNode(15);
        TreeNode tn3 = new TreeNode(20, tn2, tn1);

        TreeNode tn4 = new TreeNode(9);

        TreeNode root = new TreeNode(3, tn4, tn3);

        List<List<Integer>> result = levelOrder(root);
        for(List<Integer> i: result) {
            for(Integer j : i) {
                System.out.print(j + "  ");
            }
            System.out.println();
        }
    }
}
