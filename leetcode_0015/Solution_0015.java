import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author : hianian
 * @Time : 2022/3/25 20:08
 * @File : Solution_0015.java
 *
 * 这道题本质上还是层序遍历，只不过层序遍历后，只保存每层最右侧的节点。也就是说，只保存最后面的那个节点
 */
public class Solution_0015 {

    public static List<Integer> rightSideView(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        if(root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int length;

        while(!queue.isEmpty()){

            length = queue.size();

            while(length > 0) {

                root = queue.poll();

                if(root.left != null){
                    queue.offer(root.left);
                }

                if(root.right != null) {
                    queue.offer(root.right);
                }

                length --;
            }

            // 遍历循环结束，即root表示的是该层最后一个节点。
            result.add(root.val);
        }

        return result;
    }


    public static void main(String[] args) {
        TreeNode tn1 = new TreeNode(7);
        TreeNode tn2 = new TreeNode(15);
        TreeNode tn3 = new TreeNode(20, tn2, tn1);

        TreeNode tn4 = new TreeNode(9);

        TreeNode root = new TreeNode(3, tn4, tn3);

        List<Integer> result = rightSideView(root);
        for(Integer i: result) {
            System.out.println(i);
        }
    }
}
