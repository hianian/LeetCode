import java.util.HashMap;
import java.util.Map;

/**
 * @Author : hianian
 * @Time : 2022/2/15 11:22
 * @File : Solution_0003.java
 *
 * 计算无重复字符的最长子串：
 *      1. 首先考虑如何判断出现重复字符？
 *      2. 当出现重复字符的时候，比较当前子串的长度和前面保留的子串长度哪个最长？
 *      3. 如何记录当前子串？
 *
 * 对于1，可以用HashMap保存遍历的遍历的元素，判断当前遍历元素是否出现在HashMap中，即为判断是否出现重复字符
 * 对于2和3，记录当前子串的起始下标，当出现重复字符的时候，说明获得了一个子串，计算当前子串的长度，并判断当前子串是否比之前的长度大
 * 出现重复字符后，注意更新重复字符的下标值以及最新子串的起始下标（用于记录下一个子串的长度）
 *
 * 注意，更新新子串的起始下标，即原始Map中重复字符的下一个字符为起始字符。
 * 注意，不用等到出现重复字符的时候再计算
 */
public class Solution_0003 {

    public static int lengthOfLongestSubstring(String s) {

        // 将字符串转换成数组，便于后续根据下标访问
        char[] chars = s.toCharArray();

        // 保存 长度 和 计算长度的起始下标，初始化均为0.
        int answer = 0;
        int tempStart = 0;

        // 创建map，存储遍历过的元素，<元素, 最新的下标>。
        Map<Character, Integer> map = new HashMap<>();

        // 遍历字符串，只要没有重复的元素，就将其添加到map中；如果有重复的元素，则起始下标向后移动一位，并更新重复元素的最新下标。
        for (int i = 0; i < s.length(); i++) {

            if(map.containsKey(chars[i])){

                // 包含重复元素，说明此时获得了一个子串，比较当前子串的长度和之前的答案，取最大的值为答案。
                answer = Math.max(answer, i - tempStart);

                // 包含重复元素，当前子串结束，记录下一个重复子串的起始位置
                // 下一个子串的起始位置是 map保存的当前重复字符的下一个字符。

                // 但是Map是无序的，无法通过当前重复元素找到Map中的下一个字符。
                // 首先可以肯定的一点是：Map中保留的是不重复的字符，所以Map中保留的一定是字符串中相邻的元素
                // 我们可以通过当前字符获取到其在字符串中的下标，然后通过下标和字符串获取到下一个字符

                // 注意，要考虑 “abba”这种情况，当遍历a的时候，当时的子串是b，即起始下标是b，
                // 那么遍历a的时候，更新下标，实际上就不单纯是a的下一个元素了，
                // 应该是 a的下一个元素 和 当前起始下标的最大值。
                tempStart = Math.max(map.get(chars[i]) + 1, tempStart);

            }

            // 将元素添加到map中
            map.put(chars[i], i);

        }

        // 最后遍历完计算一遍长度，因为最后可能没有重复字符出现
        answer = Math.max(answer, s.length() - tempStart);

        return answer;
    }

    public static void main(String[] args) {
//        String s = "abcabcbb";
//        String s = "bbbbb";
//        String s = "pwwkew";
//        String s = "abcad";
        String s = "abba";

        int subLength = lengthOfLongestSubstring(s);
        System.out.println(subLength);

    }
}
