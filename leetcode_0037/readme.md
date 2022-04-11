## question: 删除链表的倒数第N个结点（中等）

给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list

示例 1：

![示例1](https://assets.leetcode.com/uploads/2020/10/03/remove_ex1.jpg)

输入：head = [1,2,3,4,5], n = 2
输出：[1,2,3,5]``
``

示例 2：
```text
输入：head = [1], n = 1
输出：[]
```

示例 3：
```text
输入：head = [1,2], n = 1
输出：[1]
```

提示：
```text
链表中结点的数目为 sz
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
```