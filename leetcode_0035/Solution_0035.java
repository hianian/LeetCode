import java.util.Stack;

/**
 * @Author : hianian
 * @Time : 2022/4/9 11:26
 * @File : Solution_0035.java
 *
 * 这道题，首先想到的一个方法是：
 *      遍历字符串，遇到空格停下，生成一个单词，入栈。
 *      最后，依次出栈，添加空格，形成字符串。
 */
public class Solution_0035 {

    public static String reverseWords(String s) {

        char[] chars = s.toCharArray();

        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(char c: chars) {

            if(c == ' ') {
                // 形成单词，入栈，并清空sb
                if(sb.length() != 0) {
                    stack.push(sb.toString());
                    sb = new StringBuilder();
                }

            } else {
                sb.append(c);
            }
        }

        // 注意，如果最后不是以空格结尾，那么就会剩余一个单词。
        if(sb.length() != 0) {
            stack.push(sb.toString());
        }

        sb = new StringBuilder();

        while(! stack.isEmpty()) {
            sb.append(stack.pop());
            sb.append(" ");
        }

        // 去掉最后一个空格
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }

    public static void main(String[] args) {

//        String s = "  the   sky is blue  ";
//        String s = "  hello world  ";
        String s = "a good   example";
        String result = reverseWords(s);
        System.out.println(result);
    }
}
