import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author : hianian
 * @Time : 2022/3/29 20:01
 * @File : Solution_0019.java
 *
 * 这道题也是层序遍历，在遍历的时候，将其next指针赋值为当前层的下一个节点
 */
public class Solution_0019 {

    public static Nodes connect(Nodes root) {

        if(root == null) {
            return null;
        }

        Queue<Nodes> queue = new LinkedList<>();

        queue.offer(root);

        int length;

        while(!queue.isEmpty()) {
            length = queue.size();

            // 空节点
            Nodes nodes = new Nodes();

            while(length > 0) {
                nodes.next = queue.poll();
                nodes = nodes.next;
                length --;

                if(nodes.left != null) {
                    queue.offer(nodes.left);
                }

                if(nodes.right != null) {
                    queue.offer(nodes.right);
                }
            }

            // 注意，最后一个节点的next设为null
            nodes.next = null;
        }

        return root;
    }

    public static void main(String[] args) {
        Nodes n1 = new Nodes(4);
        Nodes n2 = new Nodes(5);
        Nodes n3 = new Nodes(2, n1, n2, null);

        Nodes n4 = new Nodes(6);
        Nodes n5 = new Nodes(7);
        Nodes n6 = new Nodes(3, n4, n5, null);

        Nodes root = new Nodes(1, n3, n6, null);

        root = connect(root);

        // 先序遍历输出
        Queue<Nodes> queue = new LinkedList<>();
        queue.offer(root);
        int length;

        while(!queue.isEmpty()) {

            length = queue.size();

            while(length > 0) {

                root = queue.poll();
                System.out.print(root.val);
                System.out.print("{");
                System.out.print(root.next);
                System.out.print("}");
                System.out.println();

                if(root.left != null) {
                    queue.offer(root.left);
                }

                if(root.right != null) {
                    queue.offer(root.right);
                }

                length --;
            }
        }
    }
}
