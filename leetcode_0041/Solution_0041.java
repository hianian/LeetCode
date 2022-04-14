/**
 * @Author : hianian
 * @Time : 2022/4/13 19:20
 * @File : Solution_0041.java
 *
 * 这道题没什么可说的，感觉重点在于如何减少时间和空间开销
 */
public class Solution_0041 {

    public static String reverseLeftWords(String s, int n) {

        char[] chars = s.toCharArray();

        StringBuilder sb = new StringBuilder();

        for (int i = n; i < chars.length; i++) {
            sb.append(chars[i]);
        }

        for (int i = 0; i < n; i++) {
            sb.append(chars[i]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println();

//        String s = "abcdefg";
        String s = "lrloseumgh";

        System.out.println(reverseLeftWords(s, 6));
    }
}
