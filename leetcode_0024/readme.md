## question: 完全二叉树的节点个数（中等）

给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。

完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/count-complete-tree-nodes 

示例 1：

![示例1](https://assets.leetcode.com/uploads/2021/01/14/complete.jpg)
```text
输入：root = [1,2,3,4,5,6]
输出：6
```
示例 2：
```text
输入：root = []
输出：0
```

示例 3：
```text
输入：root = [1]
输出：1
```

提示：
```text
树中节点的数目范围是[0, 5 * 104]
0 <= Node.val <= 5 * 104
题目数据保证输入的树是 完全二叉树
```