import java.util.Stack;

/**
 * @Author : hianian
 * @Time : 2022/4/6 19:40
 * @File : Solution_0029.java
 *
 * 逆波兰表达式求值。即操作符在两个操作数的后面。
 *
 * 因为都是双目运算符，似乎也可以用栈来做。遇到运算符，就弹栈（弹两次，将两个操作数弹栈），计算结果，并将结果入栈
 *
 * 注意，题目要求都是整数，所以无需考虑小数
 *
 * 注意，要考虑操作数的运算顺序。先弹出来的是第二个操作数。
 */
public class Solution_0029 {

    public static int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();
        Integer first, second;

        for(String s: tokens) {

            if(s.equals("+")) {

                second = stack.pop();
                first = stack.pop();

                stack.push(first + second);

            } else if(s.equals("-")) {

                second = stack.pop();
                first = stack.pop();

                stack.push(first - second);

            } else if(s.equals("*")) {

                second = stack.pop();
                first = stack.pop();

                stack.push(first * second);

            } else if(s.equals("/")) {

                second = stack.pop();
                first = stack.pop();

                stack.push(first / second);

            } else {
                stack.push(Integer.parseInt(s));
            }
        }

        // 最终栈中必定只剩一个元素，也就是表达式的结果
        return stack.pop();
    }

    public static void main(String[] args) {

//        String[] tokens = {"2", "1", "+", "3", "*"};
//        String[] tokens = {"4", "13", "5", "/", "+"};
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(tokens));
    }
}
