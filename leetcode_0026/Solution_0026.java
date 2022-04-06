import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : hianian
 * @Time : 2022/4/2 19:35
 * @File : Solution_0026.java
 *
 * 这道题似乎可以用深度优点搜索来做。
 *
 * 采用递归的方法，即当前节点的所有路径 是 当前节点值 + 左右孩子节点的所有路径
 *
 * 左右孩子节点的所有路径，则又回到了问题本身。
 */
public class Solution_0026 {

    public static List<String> binaryTreePaths(TreeNode root) {

        // 递归结束条件
        if(root == null) {
            return null;
        }

        List<String> result = new ArrayList<>();

        // 求解其左右孩子节点的所有路径
        List<String> leftResult = binaryTreePaths(root.left);
        List<String> rightResult = binaryTreePaths(root.right);

        // 当前节点和左孩子的所有路径重新组合形成新的路径
        if(leftResult != null) {

            for(String str: leftResult) {
                result.add(root.val + "->" + str);
            }
        }

        // 当前节点和右孩子的所有路径重新组合形成新的路径
        if(rightResult != null) {

            for(String str: rightResult) {
                result.add(root.val + "->" + str);
            }
        }

        // 如果是叶子节点，那么该节点的后续路径只有自己一条。
        if(leftResult == null && rightResult == null) {
            result.add(root.val + "");
        }

        return result;
    }

    public static void main(String[] args) {

        TreeNode tn1 = new TreeNode(5);
        TreeNode tn2 = new TreeNode(2, null, tn1);
        TreeNode tn3 = new TreeNode(3);
        TreeNode tn4 = new TreeNode(1, tn2, tn3);

//        TreeNode tn5 = new TreeNode(1);

        List<String> strings = binaryTreePaths(tn4);
        for(String str: strings) {
            System.out.println(str);
        }
    }
}