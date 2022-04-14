import java.util.Arrays;

/**
 * @Author : hianian
 * @Time : 2022/4/13 19:28
 * @File : Solution_0041_02.java
 *
 * 这道题似乎可以改进一下，不适用额外的空间开销
 *
 * 即先反转前一部分，再反转后一部分，最后将整体反转过来。
 */
public class Solution_0041_02 {

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

    public static String reverseLeftWords(String s, int n) {

        char[] chars = s.toCharArray();

        // 反转前一部分
        reverse(chars, 0, n-1);

        // 反转后一部分
        reverse(chars, n, chars.length - 1);

        // 整体反转一遍
        reverse(chars, 0, chars.length - 1);

        return String.valueOf(chars);

    }

    public static void main(String[] args) {


        //        String s = "abcdefg";
        String s = "lrloseumgh";

        s = reverseLeftWords(s, 6);
        System.out.println(s);
    }
}
