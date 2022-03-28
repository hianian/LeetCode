## question: 二叉树的层平均值（简单）

给定一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10-5 以内的答案可以被接受。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/average-of-levels-in-binary-tree

示例 1：

![示例1](https://assets.leetcode.com/uploads/2021/03/09/avg1-tree.jpg)
```text
输入：root = [3,9,20,null,null,15,7]
输出：[3.00000,14.50000,11.00000]
解释：第 0 层的平均值为 3,第 1 层的平均值为 14.5,第 2 层的平均值为 11 。
因此返回 [3, 14.5, 11] 。
```
示例 2:
```text
输入：root = [3,9,20,15,7]
输出：[3.00000,14.50000,11.00000]
```

提示：
```text
树中节点数量在 [1, 104] 范围内
-231 <= Node.val <= 231 - 1
```