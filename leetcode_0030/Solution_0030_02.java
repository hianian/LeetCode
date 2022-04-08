import java.util.ArrayList;
import java.util.List;

/**
 * @Author : hianian
 * @Time : 2022/4/7 19:47
 * @File : Solution_0031.java
 *
 * 显然暴力法会造成超时，那么该怎么修改呢？
 *
 * 首先getMax函数是没必要的。因为在形成滑动窗口的时候，就已经遍历一遍了，此时完全可以求出最大值。
 */
public class Solution_0030_02 {

    public static int[] maxSlidingWindow(int[] nums, int k) {

        // 如果k大于等于数组长度，那么就直接取数组最大值
        if(k >= nums.length) k = nums.length;

        int[] result = new int[nums.length - k + 1];

        int max;

        for (int i = 0; i < nums.length - k + 1; i++) {

            max = nums[i];
            for(int j = i; j < i + k; j++) {

                max = Math.max(nums[j], max);
            }

            result[i] = max;

        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println();

        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
//        int[] nums = {1};

        int[] result = maxSlidingWindow(nums, 3);

        for(int i: result) {
            System.out.println(i);
        }
    }
}
