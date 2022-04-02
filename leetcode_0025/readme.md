## question: 平衡二叉树（简单）

给定一个二叉树，判断它是否是高度平衡的二叉树。

本题中，一棵高度平衡二叉树定义为：

一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/balanced-binary-tree

示例 1：

![示例1](https://assets.leetcode.com/uploads/2020/10/06/balance_1.jpg)
```text
输入：root = [3,9,20,null,null,15,7]
输出：true
```

示例 2：

![示例2](https://assets.leetcode.com/uploads/2020/10/06/balance_2.jpg)
```text
输入：root = [1,2,2,3,3,null,null,4,4]
输出：false
```

示例 3：
```text
输入：root = []
输出：true
```

提示：
```text
树中的节点数在范围 [0, 5000] 内
-104 <= Node.val <= 104
```