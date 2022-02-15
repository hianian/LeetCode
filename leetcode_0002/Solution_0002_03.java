/**
 * @Author : hianian
 * @Time : 2022/2/15 10:44
 * @File : Solution_0002_03.java
 */
public class Solution_0002_03 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){

        ListNode head = new ListNode();

        ListNode temp = head;

        int next = 0;


        while(l1 != null || l2 != null){

            int result = 0;

//            if(l1 == null){
//                result = l2.val + next;
//            } else if(l2 == null){
//                result = l1.val + next;
//            } else {
//                result = l1.val + l2.val + next;
//            }

            result += next;
            if(l1 != null){
                result += l1.val;
            }

            if(l2 != null){
                result += l2.val;
            }

            if(result > 9){
                result = result % 10;
                next = 1;
            } else {
                next = 0;
            }

            // 不再创建新节点，采用原有参数的节点
            if(l1 != null){
                l1.val = result;
                temp.next = l1;
            } else {
                // 两条链表必有一条非空
                l2.val = result;
                temp.next = l2;
            }

//            if(l1 == null){
//                l2 = l2.next;
//            } else if(l2 == null){
//                l1 = l1.next;
//            } else{
//                l1 = l1.next;
//                l2 = l2.next;
//            }

            if(l1 != null){
                l1 = l1.next;
            }

            if(l2 != null){
                l2 = l2.next;
            }

            temp = temp.next;

        }

        if(next != 0){
            temp.next = new ListNode(next);
        }

        return head.next;
    }

    public static void main(String[] args) {

//        ListNode l1 = new ListNode(0);
//
//        ListNode l2 = new ListNode(0);

//        ListNode l1 = new ListNode(2);
//        ListNode tempL1 = l1;
//        tempL1.next = new ListNode(4);
//        tempL1 = tempL1.next;
//        tempL1.next = new ListNode(3);
//
//        ListNode l2 = new ListNode(5);
//        ListNode tempL2 = l2;
//        tempL2.next = new ListNode(6);
//        tempL2 = tempL2.next;
//        tempL2.next = new ListNode(4);

        ListNode l1 = new ListNode(9);
        ListNode tempL1 = l1;
        tempL1.next = new ListNode(9);
        tempL1 = tempL1.next;
        tempL1.next = new ListNode(9);
        tempL1 = tempL1.next;
        tempL1.next = new ListNode(9);
        tempL1 = tempL1.next;
        tempL1.next = new ListNode(9);
        tempL1 = tempL1.next;
        tempL1.next = new ListNode(9);
        tempL1 = tempL1.next;
        tempL1.next = new ListNode(9);

        ListNode l2 = new ListNode(9);
        ListNode tempL2 = l2;
        tempL2.next = new ListNode(9);
        tempL2 = tempL2.next;
        tempL2.next = new ListNode(9);
        tempL2 = tempL2.next;
        tempL2.next = new ListNode(9);

        ListNode result = addTwoNumbers(l1, l2);

        while(result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}
