/**
 * @Author : hianian
 * @Time : 2022/4/9 10:59
 * @File : Solution_0034.java
 *
 * 这道题先遍历做一下
 */
public class Solution_0034 {

    public static String replaceSpace(String s) {

        StringBuilder sb = new StringBuilder();

        char[] chars = s.toCharArray();

        for(char c: chars) {
            if(c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println();

        String s = "We are happy.";

        String result = replaceSpace(s);

        System.out.println(result);
    }
}
