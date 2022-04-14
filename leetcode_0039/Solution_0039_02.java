/**
 * @Author : hianian
 * @Time : 2022/4/12 20:21
 * @File : Solution_0039_02.java
 *
 * 上面的方法的时间和空间复杂度均为O(n)，这里改进一下。
 *
 * 首先判断是否存在环。可以采用快慢指针来做。
 *      定义两个指针，一前一后，依次遍历。如果不存在环，则最终是空；如果存在环，那么必定前指针会跑到到后指针的后面。
 *
 *      快慢指针的速度怎么确定呢？
 *          肯定不能是一样的，因为如果是一样的话，快指针永远在慢指针前面。
 *
 *          可以快指针是2，慢指针是1. 这样的话，虽然第一次快指针是快的，但是从环的角度来看，相当于快指针在快速接近慢指针（一次移动一个位置）；
 *          而且二者的速度相差为1，不存在跨越问题。必定存在相遇的那一刻。
 *
 *      那么怎么确定入环节点呢？
 *          似乎是在环的 “结尾”处相遇。此时结尾的下一个节点就是入环节点。
 */
public class Solution_0039_02 {

    public static ListNode detectCycle(ListNode head) {

        ListNode newHead = new ListNode();
        newHead.next = head;

        // 定义快慢指针，在第一次遍历环的时候，slow.next = fast
        ListNode fast = head;
        ListNode slow = newHead;

        while(fast != null) {

            // 如果第二次入环，那么在入环处，
            if(fast == slow) {

            }

        }

        return null;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
