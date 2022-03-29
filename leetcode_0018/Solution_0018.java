import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author : hianian
 * @Time : 2022/3/28 20:20
 * @File : Solution_0018.java
 */
public class Solution_0018 {

    public static List<Integer> largestValues(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        if(root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        int length, max = root.val;

        queue.offer(root);

        while(!queue.isEmpty()) {

            length = queue.size();
            max = queue.peek().val; // 只取并不弹栈，方便初始化值。

            while(length > 0) {

                root = queue.poll();
                max = Math.max(max, root.val);

                if(root.left != null) {
                    queue.offer(root.left);
                }

                if(root.right != null) {
                    queue.offer(root.right);
                }

                length --;
            }

            result.add(max);
        }

        return result;
    }

    public static void main(String[] args) {

        TreeNode tn1 = new TreeNode(5);
        TreeNode tn2 = new TreeNode(3);
        TreeNode tn3 = new TreeNode(3, tn1, tn2);

        TreeNode tn4 = new TreeNode(9);
        TreeNode tn5 = new TreeNode(2, null, tn4);

        TreeNode root = new TreeNode(1, tn3, tn5);

        List<Integer> result = largestValues(root);
        for(Integer i: result){
            System.out.println(i);
        }

    }
}
