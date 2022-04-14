/**
 * @Author : hianian
 * @Time : 2022/4/13 19:59
 * @File : Solution_0042.java
 *
 * 这道题似乎是匹配字符串，先找到和第二个字符串第一个字符相同的位置，然后判断后续的字符是否相同，不同则继续遍历第一个子串。
 */
public class Solution_0042 {

    public static int strStr(String haystack, String needle) {

        if(needle.length() == 0)
            return 0;

        int result = -1;
        boolean flag;

        char[] chars = haystack.toCharArray();
        char[] chars1 = needle.toCharArray();

        for (int i = 0; i < chars.length; i++) {

            if(chars[i] == chars1[0]) {
                flag = true;

                // 长度不够，肯定不满足要求
                if(i + 1 + chars1.length - 1 > chars.length) {
                    flag = false;
                    break;
                }

                for (int j = 0; j < chars1.length; j++) {
                    if(chars[i + j] != chars1[j]) {
                        flag = false;
                        break;
                    }
                }

                if(flag) return i;

            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println();

//        String haystack = "hello";
//        String needle = "ll";

//        String haystack = "aaaaa";
//        String needle = "bba";

        String haystack = "";
        String needle = "";

        System.out.println(strStr(haystack, needle));
    }
}
