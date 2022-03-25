import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author : hianian
 * @Time : 2022/3/23 20:09
 * @File : Solution_0013_02.java
 */
public class Solution_0013_02 {

    public static List<List<Integer>> resList = new ArrayList<>();

    public static List<List<Integer>> levelOrder(TreeNode root) {

//        checkFun01(root, 0);
        checkFun02(root);

        return resList;
    }

    // DFS--递归方式
    // 不容易想到
    public static void checkFun01(TreeNode node, Integer deep) {

        if (node == null) {
            return;
        }

        deep++;

        if (resList.size() < deep) {
            //当层级增加时，list的Item也增加，利用list的索引值进行层级界定
            List<Integer> item = new ArrayList<>();
            resList.add(item);
        }

        // 获得存储当前层的list。
        resList.get(deep - 1).add(node.val);

        // 递归左节点，注意，虽然是递归，但是各层的deep互不影响，即左节点递归之后的deep和下面有节点的deep没关系。
        // 因为递归是重新分配了空间
        checkFun01(node.left, deep);

        // 递归右节点
        checkFun01(node.right, deep);
    }

    // BFS--迭代方式--借助队列
    public static void checkFun02(TreeNode node) {
        if (node == null) return;

        // 借助队列
        Queue<TreeNode> que = new LinkedList<>();

        // 首先将根节点加入，即第一层要遍历一个节点
        que.offer(node);

        while (!que.isEmpty()) {

            // 新的一层，要创建新的List
            List<Integer> itemList = new ArrayList<>();

            // 记录这一层要遍历的节点数量，（因为遍历节点的时候，要将遍历节点的子节点加入到队列中，所以要记住遍历的节点数量）
            int len = que.size();

            // 依据数量，循环弹出对应数量的节点，并同时将其子节点加入到队列中。
            while (len > 0) {
                TreeNode tmpNode = que.poll();
                itemList.add(tmpNode.val);

                if (tmpNode.left != null) que.offer(tmpNode.left);
                if (tmpNode.right != null) que.offer(tmpNode.right);
                len--;
            }

            // 将一层的结果加入到最终结果中
            resList.add(itemList);
        }
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
