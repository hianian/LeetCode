## question: 二叉树的所有路径（简单）

给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。

叶子节点 是指没有子节点的节点。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-paths
 
示例 1：

![示例1](https://assets.leetcode.com/uploads/2021/03/12/paths-tree.jpg)

```text
输入：root = [1,2,3,null,5]
输出：["1->2->5","1->3"]
```

示例 2：
```text
输入：root = [1]
输出：["1"]
```

提示：
```text
树中节点的数目在范围 [1, 100] 内
-100 <= Node.val <= 100
```