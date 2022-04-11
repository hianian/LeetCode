/**
 * @Author : hianian
 * @Time : 2022/4/11 19:06
 * @File : Solution_0036.java
 *
 * 这道题先用一个头结点，后续遍历所给链表，将依次其插入到 头结点 后面即可。
 */
public class Solution_0036 {

    public static ListNode reverseList(ListNode head) {

        ListNode newHead = new ListNode();
        ListNode temp;

        while(head != null) {

            // 保留下一个要遍历的节点
            temp = head.next;

            // 将当前遍历的节点插入到新的头结点和链表之间，相当于逆序
            head.next = newHead.next;
            newHead.next = head;

            head = temp;
        }

        return newHead.next;
    }

    public static void main(String[] args) {

        ListNode ln1 = new ListNode(5);
        ListNode ln2 = new ListNode(4, ln1);
        ListNode ln3 = new ListNode(3, ln2);
        ListNode ln4 = new ListNode(2, ln3);
        ListNode ln5 = new ListNode(1, ln4);

        System.out.println();

        ListNode result = reverseList(ln5);

        while(result != null) {
            System.out.println(result.val);

            result = result.next;
        }
    }
}
