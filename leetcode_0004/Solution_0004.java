/**
 * @Author : hianian
 * @Time : 2022/2/19 15:13
 * @File : Solution_0004.java
 *
 * 1. 最长回文子串，首先判断是不是回文串，再判断是不是最长的；
 * 2. 重点是如何判断回文串，至于最长不最长，直接比较即可；
 * 3. 回文子串是对称的，所以这时候有两种方法，
 *      i. 由两边向中心遍历，比较。（此时我们需要限定一下两边，即先找到子串，再判断子串是不是回文串，这种由大到小，会造成很多无用的判断）
 *      ii，由中心向两侧遍历，比较。（此时无需找到子串，因为遍历的过程就会找到子串，并且由小到大判断比较合适，所以采用这种方法）
 */
public class Solution_0004 {

    public static int[] getSubString(char[] chars, int leftCenter, int rightCenter){

        // 根据中心，向外扩散，
        while(leftCenter >= 0 && rightCenter < chars.length){

            // 如果两个元素不相等，说明已经不是回文串了
            if(chars[leftCenter] != chars[rightCenter]){
                break;
            }

            // 分别向左向右遍历
            leftCenter --;
            rightCenter ++;
        }

        // 注意，跳出循环说明条件不满足，而上一个条件是满足的回文串
        return new int[]{leftCenter + 1, rightCenter - 1};
    }

    public static String longestPalindrome(String s) {

        char[] chars = s.toCharArray();
        int[] oddResult, evenResult;
        int left = 0, right = 0;
        int tempLeft, tempRight;

        for (int i = 0; i < s.length() - 1; i++) {
            // 遍历字符串，每个遍历元素都作为子串中心，向外遍历
            // 注意，字符串的长度有奇数和偶数之分，奇数和偶数判断是否是回文串的具体方法细节有区别
            // 奇数的字符串，中心只有一个；偶数的字符串，中心有两个

            // 奇数字符串
            oddResult = getSubString(chars, i, i);

            // 偶数字符串
            evenResult = getSubString(chars, i, i + 1);

            // 判断奇数和偶数字符串哪个长
            if(oddResult[1] - oddResult[0] >= evenResult[1] - evenResult[0]){
                tempLeft = oddResult[0];
                tempRight = oddResult[1];
            } else {
                tempLeft = evenResult[0];
                tempRight = evenResult[1];
            }

            // 判断得到的子串和之前的答案哪个长
            if(tempRight - tempLeft > right - left){
                right = tempRight;
                left = tempLeft;
            }

        }

        // 返回子串
        return s.substring(left, right + 1);
    }

    public static void main(String[] args) {

//        String s = "babad";
        String s = "cbbd";

        System.out.println(longestPalindrome(s));
    }
}
