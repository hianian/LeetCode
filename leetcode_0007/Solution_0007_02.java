/**
 * @Author : hianian
 * @Time : 2022/2/20 14:20
 * @File : Solution_0007_02.java
 *
 * 递归解法，即下一次合并的是 链表中 去掉 当前已知节点剩余的 部分 和 另一个链表
 */
public class Solution_0007_02 {
    public static ListNodes mergeTwoLists(ListNodes list1, ListNodes list2) {

        // 有一条链表为空，直接链接另一条链表即可。
        if(list1 == null) {
            return list2;
        } else if(list2 == null){
            return list1;
        } else {

            // 两条链表均为非空，那么就比较元素
            if(list1.val < list2.val){
                // list1节点比较小，也就是它放在前面，那么返回结果中的它之后的链表怎么计算呢？
                // 就是list1所在链表剩余的链表和list2链表进行合并后的链表，递归调用该方法。
                list1.next = mergeTwoLists(list1.next, list2);
                return list1;
            } else {
                // 同上
                list2.next = mergeTwoLists(list1, list2.next);
                return list2;
            }
        }
    }

    public static void main(String[] args) {
        ListNodes l1 = new ListNodes(1);
        ListNodes tempL1 = l1;
        tempL1.next = new ListNodes(2);
        tempL1 = tempL1.next;
        tempL1.next = new ListNodes(4);

        ListNodes l2 = new ListNodes(1);
        ListNodes tempL2 = l2;
        tempL2.next = new ListNodes(3);
        tempL2 = tempL2.next;
        tempL2.next = new ListNodes(4);


//        ListNodes l1 = null;
//
//        ListNodes l2 = new ListNodes(0);

//        ListNodes l1 = null;
//        ListNodes l2 = null;

        ListNodes head = mergeTwoLists(l1, l2);

        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
