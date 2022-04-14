import java.util.HashMap;
import java.util.List;

/**
 * @Author : hianian
 * @Time : 2022/4/11 20:29
 * @File : Solution_0038.java
 *
 * 这道题首先要明确一点的是：只要二者相交，那么后面的节点一定是相同的，因为一个节点只有一个后缀节点，所以后续链表不会分叉。
 *
 * 一种思路是：遍历其中一条链表，在遍历的时候，将节点加入到HashMap中，然后再遍历另一条链表，遍历的时候，依次检索是否出现在HashMap中
 * 如有，该节点就是相交的第一个节点。
 */
public class Solution_0038 {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        HashMap<ListNode, Integer> hashMap = new HashMap<>();
        boolean flag = true;

        // 存储A链表
        int index = 0;
        while(headA != null) {
            hashMap.put(headA, index);
            headA = headA.next;
            index ++;
        }

        while(headB != null) {
            Integer integer = hashMap.get(headB);

            if(integer != null) {
                flag = false;
                break;
            } else {
                headB = headB.next;
            }
        }

        // 注意，如果是正常结束循环，那么就不是相交，否则，当前节点就是相交节点
        return !flag ? headB : null;
    }

    public static void main(String[] args) {
        System.out.println();

//        ListNode ln1 = new ListNode(5);
//        ListNode ln2 = new ListNode(4, ln1);
//        ListNode ln3 = new ListNode(8, ln2);
//
//        ListNode ln4 = new ListNode(1, ln3);
//        ListNode lnA = new ListNode(4, ln4);
//
//        ListNode ln6 = new ListNode(1, ln3);
//        ListNode ln7 = new ListNode(0, ln6);
//        ListNode lnB = new ListNode(5, ln7);
//
//        ListNode intersectionNode = getIntersectionNode(lnA, lnB);
//        System.out.println(intersectionNode.val);

        ListNode ln1 = new ListNode(4);
        ListNode ln2 = new ListNode(6, ln1);
        ListNode ln3 = new ListNode(2, ln2);

        ListNode ln4 = new ListNode(5);
        ListNode ln5 = new ListNode(1, ln4);

        ListNode intersectionNode = getIntersectionNode(ln3, ln5);
        System.out.println(intersectionNode);
    }
}
