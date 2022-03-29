import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author : hianian
 * @Time : 2022/3/28 19:40
 * @File : Solution_0017.java
 *
 * 这道题似乎也比较简单，和二叉树类似，只不过在入栈的时候需要遍历孩子List。
 */
public class Solution_0017 {

    public static List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> result = new ArrayList<>();

        if(root == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        List<Integer> subList;

        queue.offer(root);

        int length;

        while(!queue.isEmpty()) {
            length = queue.size();
            subList = new ArrayList<>();

            while(length > 0) {
                root = queue.poll();
                subList.add(root.val);

                // 将孩子List入栈
                if(root.children != null) {
                    queue.addAll(root.children);
                }

                length --;
            }

            result.add(subList);
        }

        return result;
    }

    public static void main(String[] args) {

        Node n1 = new Node(5);
        Node n2 = new Node(6);

        List<Node> l1 = new ArrayList<>();
        l1.add(n1);
        l1.add(n2);

        Node n3 = new Node(3, l1);
        Node n4 = new Node(2);
        Node n5 = new Node(4);

        List<Node> l2 = new ArrayList<>();
        l2.add(n3);
        l2.add(n4);
        l2.add(n5);

        Node root = new Node(1, l2);

        List<List<Integer>> result = levelOrder(root);

        for(List<Integer> l: result) {

            for(Integer i: l) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }
}
