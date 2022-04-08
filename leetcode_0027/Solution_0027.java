import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @Author : hianian
 * @Time : 2022/4/6 18:13
 * @File : Solution_0027.java
 *
 *
 */
public class Solution_0027 {

    public static boolean isValid(String s) {

        // 如果是奇数个字符，则肯定不匹配
        if(s.length() % 2 != 0) {
            return false;
        }

        List<Character> left = new ArrayList<>();
        List<Character> right = new ArrayList<>();

        left.add('(');
        left.add('{');
        left.add('[');

        right.add(')');
        right.add('}');
        right.add(']');

        Stack<Character> stack = new Stack<>();

        char[] chars = s.toCharArray();

        for(char c: chars) {

            // 判断是否是左括号，是的话，就入栈
            if(left.contains(c)) {
                stack.push(c);
            } else {

                // 有括号，开始弹栈匹配
                // 如果栈为空，说明不匹配
                if(stack.isEmpty()) {
                    return false;
                }

                Character pop = stack.pop();

                // 获取当前右括号对应的左括号，判断与栈中的括号是否一致，一致则说明匹配。
                int i = right.indexOf(c);
                Character character = left.get(i);

                if(pop != character) return false;
            }
        }

        // 最后判断栈是否为空，空则表示匹配完，否则没有匹配完。
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println();

//        String s = "()";
//        String s = "(){}[]";
//        String s = "(]";
//        String s = "([)]";
//        String s = "{[]}";
        String s = "}{";
        System.out.println(isValid(s));

    }
}
