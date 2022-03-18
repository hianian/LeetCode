import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author : hianian
 * @Time : 2022/3/18 19:17
 * @File : Solution_0010.java
 */
public class Solution_0010 {

    public static void recurive(TreeNode root, List<Integer> result) {

        if(root != null) {

            // 先序，所以先访问根
            result.add(root.val);

            // 再将递归遍历左子树
            recurive(root.left, result);

            // 再递归遍历右子树
            recurive(root.right, result);
        }
    }

    // 递归做法
    public static List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        recurive(root, result);

        return result;
    }

    // 迭代做法（非递归）
    public static List<Integer> preorderTraversalPlus(TreeNode root){

        Stack<TreeNode> sta = new Stack<>();
        List<Integer> result = new ArrayList<>();

        if(root != null) {
            sta.push(root);
        }

        while(!sta.isEmpty()){
            root = sta.pop();
            result.add(root.val);

            // 注意，先序是 中左右，所以入栈的时候，要先方右子树，再放左子树
            if(root.right != null) {
                sta.push(root.right);
            }

            if(root.left != null) {
                sta.push(root.left);
            }
        }

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

        List<Integer> integers = preorderTraversalPlus(root);
        for(Integer i: integers){
            System.out.println(i);
        }
    }
}
