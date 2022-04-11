/**
 * @Author : hianian
 * @Time : 2022/4/11 19:46
 * @File : Solution_0037.java
 *
 * 怎么说呢，这道题似乎可以先反转链表，然后倒数第几个就是反转后的正数第几个
 *
 * 最后再反转 反转后的删除后的 链表
 */
public class Solution_0037 {

    // 反转链表
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

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode tempResult = reverseList(head);
        ListNode result;

        if(n == 1) {
            return reverseList(tempResult.next);
        }

        // 找到要删除节点的前一个节点
        result = tempResult;
        for (int i = 1; i < n - 1; i++) {
            tempResult = tempResult.next;
        }

        // 注意，此处不会超过链表范围，即tempResult.next绝不为空
        // 删除节点
        tempResult.next = tempResult.next.next;

        // 注意反转最终结果
        return reverseList(result);
    }

    public static void main(String[] args) {


        ListNode ln1 = new ListNode(5);
        ListNode ln2 = new ListNode(4, ln1);
        ListNode ln3 = new ListNode(3, ln2);
        ListNode ln4 = new ListNode(2, ln3);
        ListNode ln5 = new ListNode(1, ln4);

        ListNode listNode = removeNthFromEnd(ln2, 1);

        while(listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
