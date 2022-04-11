/**
 * @Author : hianian
 * @Time : 2022/4/9 9:31
 * @File : Solution_0032.java
 *
 * 这道题似乎还以前做过，采用双指针法，从两侧向中间遍历，左指针遇到val停下，右指针遇到非val停下，二者交换。继续遍历。
 * 最终左右指针相遇或者做指针大于右指针停下。
 * 注意，最终左指针和返回结果没有必然联系。
 */
public class Solution_0032 {

    public static int removeElement(int[] nums, int val) {

        int left = 0, right = nums.length - 1, sum = nums.length;

        while(left < right) {

            // 注意边界条件，不能超过边界
            while(left < nums.length && nums[left] != val) {
                left += 1;
            }

            while(right >= 0 && nums[right] == val) {
                right -= 1;
            }

            // 交换数据
            if(left < right) {
                nums[left] = nums[left] + nums[right];
                nums[right] = nums[left] - nums[right];
                nums[left] = nums[left] - nums[right];
            } else {
                break;
            }
        }

        // 最终遍历获取最终结果
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == val) {
                sum = i;
                break;
            }
        }

        return sum;
    }

    public static void main(String[] args) {

//        int[] nums = {3, 2, 2, 3};
//        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
//        int[] nums = {2};
        int[] nums = {3, 3};

        int sum = removeElement(nums, 3);

        for (int i = 0; i < sum; i++) {
            System.out.println(nums[i]);
        }
    }
}
