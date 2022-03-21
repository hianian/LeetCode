import java.awt.print.PrinterGraphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @Author : hianian
 * @Time : 2022/3/18 20:45
 * @File : Solution_0012.java
 */
public class Solution_0012 {

    public static void recurive(TreeNode root, List<Integer> result){

        if(root != null) {
            recurive(root.left, result);
            recurive(root.right, result);
            result.add(root.val);
        }
    }

    // 递归
    public static List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        recurive(root, result);

        return result;
    }

    // 迭代（非递归）
    public static List<Integer> postorderTraversalPlus(TreeNode root) {

        // 注意，后续遍历（左右中）和前序遍历（中左右）的非递归写法很相似
        // 前序遍历的非递归（中左右），在入栈的时候，改变一下顺序，即中左右，那么实际访问顺序就是中右左
        // 此时，将访问顺序保存，然后再逆序就是左右中了，即后续遍历了。

        List<Integer> result = new ArrayList<>();

        Stack<TreeNode> sta = new Stack<>();

        if( root != null) {
            sta.push(root);
        }

        while(!sta.isEmpty()) {
            root = sta.pop();

            // 注意，逆序加入栈中（左右），取出来就是右左，也就是中右左，最后反转result中的即可。
            result.add(root.val);

            if(root.left != null) {
                sta.push(root.left);
            }

            if(root.right != null) {
                sta.push(root.right);
            }
        }

        Collections.reverse(result);

        return result;
    }


    public static void main(String[] args) {
        TreeNode tn1 = new TreeNode(3);
        TreeNode tn2 = new TreeNode(2, tn1, null);
        TreeNode root = new TreeNode(1, null, tn2);

//        List<Integer> integers = preorderTraversal(root);
//        List<Integer> integers = preorderTraversal(null);
//        List<Integer> integers = preorderTraversal(new TreeNode(1));
//        for(Integer i : integers){
//            System.out.println(i);
//        }

//        List<Integer> integers = postorderTraversal(root);
        List<Integer> integers = postorderTraversalPlus(root);
        for(Integer i: integers){
            System.out.println(i);
        }
    }
}
