/**
 * @Author : hianian
 * @Time : 2022/4/12 19:22
 * @File : Solution_0038_02.java
 *
 * 前面提到过，只要两个链表相交，那么就一定不会分开。
 *
 * 这句话意味着，两条链表末尾的节点是一一对应的。
 *
 * 如果二者相交，那么末尾节点就是相同的；如果不想交，那么末尾节点就不同。
 *
 * 因为，可以从较长的链表开始遍历，当遍历到剩余节点和较短链表节点个数相同时；两条链表开始同时遍历，对比节点是否相同，如果相同，则说明
 * 当前节点是相交节点；如果不同，则继续遍历。
 */
public class Solution_0038_02 {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode newHeadA = headA, newHeadB = headB;
        int lengthA = 0, lengthB = 0;

        // 计算两条链表的长度
        while(newHeadA != null) {
            lengthA += 1;
            newHeadA = newHeadA.next;
        }

        while(newHeadB != null) {
            lengthB += 1;
            newHeadB = newHeadB.next;
        }

        // 较长的链表为newHeadA，较短的链表为newHeadB
        if(lengthA > lengthB) {
            newHeadA = headA;
            newHeadB = headB;
        } else {
            newHeadA = headB;
            newHeadB = headA;
        }

        // 开始遍历
        int sum = Math.abs(lengthA - lengthB);
        while(sum > 0) {
            newHeadA = newHeadA.next;
            sum--;
        }

        while(newHeadA != null) {
            if(newHeadA == newHeadB) {
                return newHeadA;
            } else {
                newHeadA = newHeadA.next;
                newHeadB = newHeadB.next;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        System.out.println();
        ListNode ln1 = new ListNode(5);
        ListNode ln2 = new ListNode(4, ln1);
        ListNode ln3 = new ListNode(8, ln2);

        ListNode ln4 = new ListNode(1, ln3);
        ListNode lnA = new ListNode(4, ln4);

        ListNode ln6 = new ListNode(1, ln3);
        ListNode ln7 = new ListNode(0, ln6);
        ListNode lnB = new ListNode(5, ln7);

        ListNode intersectionNode = getIntersectionNode(lnA, lnB);
        System.out.println(intersectionNode.val);

//        ListNode ln1 = new ListNode(4);
//        ListNode ln2 = new ListNode(6, ln1);
//        ListNode ln3 = new ListNode(2, ln2);
//
//        ListNode ln4 = new ListNode(5);
//        ListNode ln5 = new ListNode(1, ln4);
//
//        ListNode intersectionNode = getIntersectionNode(ln3, ln5);
//        System.out.println(intersectionNode);
    }
}
