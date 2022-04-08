## question: 有效的括号（简单）

给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

有效字符串需满足：

+ 左括号必须用相同类型的右括号闭合。
+ 左括号必须以正确的顺序闭合。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-parentheses

示例 1：
```text
输入：s = "()"
输出：true
```

示例 2：
```text
输入：s = "()[]{}"
输出：true
```

示例 3：
```text
输入：s = "(]"
输出：false
```

示例 4：
```text
输入：s = "([)]"
输出：false
```

示例 5：
```text
输入：s = "{[]}"
输出：true
```

提示：

```text
1 <= s.length <= 104
s 仅由括号 '()[]{}' 组成
```