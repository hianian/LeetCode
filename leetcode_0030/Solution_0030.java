import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author : hianian
 * @Time : 2022/4/6 20:15
 * @File : Solution_0030.java
 *
 * 这道题暂时没什么思路，先用暴力法做一下
 */
public class Solution_0030 {

    public static int getMax(List<Integer> nums) {

        int maxNum = nums.get(0);

        for(int i: nums) {

            if(i > maxNum) maxNum = i;
        }

        return maxNum;
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {

        // 如果k大于等于数组长度，那么就直接取数组最大值
        if(k >= nums.length) k = nums.length;

        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length - k + 1; i++) {

            List<Integer> temp = new ArrayList<>();
            for(int j = i; j < i + k; j++) {
                temp.add(nums[j]);
            }

            result[i] = getMax(temp);

        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println();

//        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] nums = {1};

        int[] result = maxSlidingWindow(nums, 3);

        for(int i: result) {
            System.out.println(i);
        }
    }
}
