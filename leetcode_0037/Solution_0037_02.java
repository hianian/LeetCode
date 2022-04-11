/**
 * @Author : hianian
 * @Time : 2022/4/11 20:01
 * @File : Solution_0037_02.java
 *
 * 上一个方法，本质上也是O(n)的时间复杂度，但是扫描了3次。这里参考博客，改进一下
 *
 * 采用双指针法。要删除的是倒数第n个节点，也就是说，要删除的节点距离尾结点相差n个。那么采用双指针法：快指针和慢指针，
 * 使得二者在开始遍历的时候，就相差n个节点。依次向后遍历，那么当快指针到达尾结点的时候，此时的慢指针必定是要删除的那个节点。
 * 如此只遍历了一次。
 *
 * 上面只是大致的思路，具体的细节需要纠正。比如我们要找的是要删除节点的前一个节点。
 * 比如，如果要删除的是第一个节点，也就是倒数第length个节点，依照上面的流程，slow指针还来不及赋值就结束了，也就是说slow指针此时指向
 * 的就是第0个节点。
 *
 * 也就是说，必须要构造一个链表，比原链表要长一点，此时加一个空的头节点即可。
 */
public class Solution_0037_02 {

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode newHead = new ListNode();
        newHead.next = head;

        ListNode fast = newHead;
        ListNode slow;

        while(n > 0) {
            fast = fast.next;
            n--;
        }

        slow = newHead;

        // 注意，要fast是尾结点时终止遍历
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 此时fast到达尾结点，slow指向的就是要删除节点的前一个节点
        slow.next = slow.next.next;

        return newHead.next;
    }

    public static void main(String[] args) {

        ListNode ln1 = new ListNode(5);
        ListNode ln2 = new ListNode(4, ln1);
        ListNode ln3 = new ListNode(3, ln2);
        ListNode ln4 = new ListNode(2, ln3);
        ListNode ln5 = new ListNode(1, ln4);

        ListNode listNode = removeNthFromEnd(ln1, 1);

        while(listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
