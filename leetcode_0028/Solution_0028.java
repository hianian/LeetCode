import java.util.Stack;

/**
 * @Author : hianian
 * @Time : 2022/4/6 19:02
 * @File : Solution_0028.java
 */
public class Solution_0028 {

    public static String removeDuplicates(String s) {

        Stack<Character> stack = new Stack<>();

        char[] chars = s.toCharArray();

        for(char c: chars) {

            if(stack.isEmpty() || stack.peek() != c) {
                // 栈为空，或者相邻元素不相同
                stack.push(c);
            } else {
                // 不为空且相邻元素相同，弹栈，并继续看下一个元素是否和栈顶元素匹配
                stack.pop();
            }
        }

        // 最后将栈中的元素组成字符串。
        Stack<Character> result = new Stack<>();

        while(!stack.isEmpty()) {
            result.push(stack.pop());
        }

        StringBuilder sb = new StringBuilder();
        while(!result.isEmpty()) {
            sb.append(result.pop());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println();

//        String s = "abbaca";
        String s = "asadf";
        System.out.println(removeDuplicates(s));
    }
}
