import java.util.HashMap;

/**
 * @Author : hianian
 * @Time : 2022/4/12 19:58
 * @File : Solution_0039.java
 *
 * 这道题，依然先采用哈希表来做一下。
 *
 * 遍历链表，检索哈希表是否已有该节点，如有，该节点则是入环第一个节点，否则存入哈希表。直到遍历完链表。
 *
 * 怎么说呢，这种方法的时间复杂度和空间复杂度均为 O(n)。
 */
public class Solution_0039 {

    public static ListNode detectCycle(ListNode head) {
        int index = 0;
        HashMap<ListNode, Integer> hashMap = new HashMap<>();

        while(head != null) {

            Integer integer = hashMap.get(head);

            if(integer != null) {
                // 不等于空，说明哈希表中已经存储过该节点，那么该节点一定是入环的第一个节点。
                return head;
            } else {
                // 不包含，则继续遍历，并入表。
                hashMap.put(head, index);
                index ++;
                head = head.next;
            }
        }

        // 遍历完，说明没有环
        return null;
    }

    public static void main(String[] args) {
        System.out.println();

//        ListNode ln1 = new ListNode(-4);
//        ListNode ln2 = new ListNode(0, ln1);
//        ListNode ln3 = new ListNode(2, ln2);
//        ListNode ln4 = new ListNode(3, ln3);
//
//        ln1.next = ln3;
//
//        ListNode listNode = detectCycle(ln4);
//        System.out.println(listNode.val);

//        ListNode ln1 = new ListNode(1);
//        ListNode ln2 = new ListNode(2);
//
//        ln1.next = ln2;
//        ln2.next = ln1;
//
//        System.out.println(detectCycle(ln1).val);

        ListNode ln1 = new ListNode(1);
        System.out.println(detectCycle(ln1));
    }
}
