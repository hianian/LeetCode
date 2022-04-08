/**
 * @Author : hianian
 * @Time : 2022/4/7 20:59
 * @File : Solution_003004.java
 *
 * 针对上述的改进，尝试一下，保留两个数（最大值和次大值）
 *
 * 因为方法2本来就是重复遍历了相邻窗口之间重复的部分，所以这里保留两个值（为了防止第一个滑动窗口的最大值是其第一个元素，
 * 而丢失了该窗口中后续元素的最大值）。
 *
 * 似乎这样做不行，因为无法判断次大值是重复部分的哪个位置。
 */
public class Solution_0030_04 {

    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] result = new int[nums.length - k + 1];
        int[] temp = new int[2];

        for (int i = 0; i < nums.length - k + 1; i++) {

        }

        return null;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
