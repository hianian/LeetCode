/**
 * @Author : hianian
 * @Time : 2022/2/20 13:50
 * @File : Solution_0007.java
 *
 * 这道题没什么可说的，直接比较就行；也可以尝试一下递归的解法。
 */

//Definition for singly-linked list.
class ListNodes {
    int val;
    ListNodes next;
    ListNodes() {}
    ListNodes(int val) { this.val = val; }
    ListNodes(int val, ListNodes next) { this.val = val; this.next = next; }
}

public class Solution_0007 {

    public static ListNodes mergeTwoLists(ListNodes list1, ListNodes list2) {

        ListNodes head = new ListNodes();
        ListNodes temp = head;

        while(list1 != null && list2 != null){

            if(list1.val >= list2.val){
                temp.next = list2;
                list2 = list2.next;
            } else {
                temp.next = list1;
                list1 = list1.next;
            }

            temp = temp.next;
        }

        temp.next = list1 == null ? list2 : list1;

        return head.next;
    }

    public static void main(String[] args) {

//        ListNodes l1 = new ListNodes(1);
//        ListNodes tempL1 = l1;
//        tempL1.next = new ListNodes(2);
//        tempL1 = tempL1.next;
//        tempL1.next = new ListNodes(4);
//
//        ListNodes l2 = new ListNodes(1);
//        ListNodes tempL2 = l2;
//        tempL2.next = new ListNodes(3);
//        tempL2 = tempL2.next;
//        tempL2.next = new ListNodes(4);


//        ListNodes l1 = null;
//
//        ListNodes l2 = new ListNodes(0);

        ListNodes l1 = null;
        ListNodes l2 = null;

        ListNodes head = mergeTwoLists(l1, l2);

        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }


    }
}
