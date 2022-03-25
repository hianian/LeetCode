import java.util.*;

/**
 * @Author : hianian
 * @Time : 2022/3/21 20:47
 * @File : Solution_0013.java
 */
public class Solution_0013 {

    public static List<List<Integer>> levelOrder(TreeNode root) {

        // 存储结果
        List<List<Integer>> result = new ArrayList<>();

        if(root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // 以及节点的孩子数量
        Queue<Integer> nodeChilds = new LinkedList<>();

        // 首先将1加入到nodeChilds中，相当于只有一个根节点
        nodeChilds.offer(1);

        // 保存节点的孩子节点个数
        int offerLength = 0;

        // 保存多少个节点值存入一个List中。
        int pollLength = nodeChilds.poll();

        // 保存result中的子List
        List<Integer> subResult = new ArrayList<>();

        while(!queue.isEmpty()) {

            // 如果是0，说明上一个子节点的孩子节点已经遍历完，此时需要将形成的该子List加入到result中，并生成新的List。
            // 注意，如果是最后一个子List，那么因为已经队列为空，所以需要在循环结束后将子List加入result中。
            if(pollLength == 0) {
                result.add(subResult);
                subResult = new ArrayList<>();

                // 获取下一个节点的子节点数
                pollLength = nodeChilds.poll();
            }

            root = queue.poll();

            // 将子节点加入，并数量自减1
            subResult.add(root.val);
            pollLength -= 1;

            if(root.left != null) {
                queue.offer(root.left);
                offerLength += 1;
            }

            if(root.right != null) {
                queue.offer(root.right);
                offerLength += 1;
            }

            // 注意，只有这一层节点的孩子节点数量不是0时，也就是有孩子时，才将孩子数量加入，并将offerLength清零
            // 什么时候清零呢？当这一层结束后再清零
            // 怎么判断这一层是否有没有结束呢？即 pollLength 为 0 时，说明
            if(offerLength != 0 && pollLength == 0) {

                nodeChilds.offer(offerLength);
                offerLength = 0;
            }
        }

        // 将最后一个子List加入到result中
        result.add(subResult);

        return result;
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
