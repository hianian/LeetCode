import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author : hianian
 * @Time : 2022/3/25 20:23
 * @File : Solution_0016.java
 *
 * 这道题仍然比较简单，在层序遍历的基础上，累加每一层的值，并求和取平均即可
 */
public class Solution_0016 {

    public static List<Double> averageOfLevels(TreeNode root) {

        List<Double> result = new ArrayList<>();

        if(root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int length, tempLength;
        double sum = 0.0;

        while(!queue.isEmpty()){

            length = queue.size();
            tempLength = length;

            while(length > 0){
                root = queue.poll();

                sum += root.val;

                if(root.left != null) {
                    queue.offer(root.left);
                }

                if(root.right != null) {
                    queue.offer(root.right);
                }

                length --;
            }

            result.add(sum / (tempLength + 0.0));
            sum = 0;
        }

        return result;

    }

    public static void main(String[] args) {
        TreeNode tn1 = new TreeNode(7);
        TreeNode tn2 = new TreeNode(15);
        TreeNode tn3 = new TreeNode(20, tn2, tn1);

        TreeNode tn4 = new TreeNode(9);

        TreeNode root = new TreeNode(3, tn4, tn3);

        List<Double> result = averageOfLevels(root);
        for(Double i: result) {
            System.out.println(i);
        }
    }
}
