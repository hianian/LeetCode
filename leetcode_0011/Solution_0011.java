import com.sun.source.tree.Tree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author : hianian
 * @Time : 2022/3/18 20:08
 * @File : Solution_0011.java
 */
public class Solution_0011 {

    public static void recurive(TreeNode root, List<Integer> result){

        if(root != null){
            recurive(root.left, result);
            result.add(root.val);
            recurive(root.right, result);
        }
    }


    // 递归
    public static List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        recurive(root, result);

        return result;
    }

    // 迭代（非递归）
    public static List<Integer> inorderTraversalPlus(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> sta = new Stack<>();

        while(root != null || !sta.isEmpty()){

            if(root != null){
                sta.push(root);
                root = root.left;
            } else {
                // 左子树遍历完毕，将左子树的根节点弹出，并访问。
                root = sta.pop();
                result.add(root.val);

                // 访问根节点的右子树
                root = root.right;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        TreeNode tn1 = new TreeNode(3);
        TreeNode tn2 = new TreeNode(2, tn1, null);
        TreeNode root = new TreeNode(1, null, tn2);

//        List<Integer> integers = inorderTraversal(root);
//        List<Integer> integers = preorderTraversal(null);
//        List<Integer> integers = preorderTraversal(new TreeNode(1));
//        for(Integer i : integers){
//            System.out.println(i);
//        }

        List<Integer> integers = inorderTraversalPlus(root);
        for(Integer i: integers){
            System.out.println(i);
        }
    }
}
