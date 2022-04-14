import java.util.Arrays;

/**
 * @Author : hianian
 * @Time : 2022/4/13 16:40
 * @File : Solution_0040_02.java
 *
 * 上一种方法用到了栈，其实这是不必要的开销。完全可以在字符数组的基础上进行修改。
 *
 * 在上一种方法的基础上，采用定位指针保留即将要反转的首位置
 */
public class Solution_0040_02 {

    public static String reverseStr(String s, int k) {

        char[] chars = s.toCharArray();

        int start = 0, j = 1;

        // 注意k和下标之间的对应关系
        for (int i = 0; i < chars.length; i++) {

            if(j == k) {
                // 反转 start和i之间的元素
                reverse(chars, start, i);
                // 此处直接更新下一次反转的起始位置
                start = i + k + 1;
            }

            // 更新J，
            if(j == 2*k) {
//                start = i + 1;
                j = 0;
            }

            j++;
        }

        // 注意最后，如果start依然在数组索引范围内，那么就说明此时的情况是 存在0-k个字符没有反转
        // 否则就是超出k个元素了，不需要反转
        if(start <= chars.length - 1) {
            reverse(chars, start, chars.length - 1);
        }

        return String.valueOf(chars);
    }

    // 反转
    public static void reverse(char[] chars, int start, int end) {

        char temp;
        while(start < end) {

            temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;

            start += 1;
            end -= 1;
        }
    }

    public static void main(String[] args) {
        System.out.println();

        String s = "abcdefg";
//        String s = "abcd";

        System.out.println(reverseStr(s, 2));
    }
}
