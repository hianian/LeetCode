/**
 * @Author : hianian
 * @Time : 2022/4/9 10:30
 * @File : Solution_0033.java
 *
 * 这道题没啥可说的，首尾双指针向中间遍历即可。
 */
public class Solution_0033 {

    public static void reverseString(char[] s) {

        int left = 0, right = s.length - 1;
        char temp;

        while(left < right) {

            temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left ++;
            right --;
        }
    }

    public static void main(String[] args) {
        System.out.println();

//        char[] s = {'h', 'e', 'l', 'l', 'o'};
        char[] s = {'H', 'a', 'n', 'n', 'a', 'h'};
        reverseString(s);

        for(char c: s) {
            System.out.println(c);
        }
    }
}
