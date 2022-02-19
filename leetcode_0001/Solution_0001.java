import java.util.HashMap;
import java.util.Map;

/**
 * @Author : hianian
 * @Time : 2022/1/26 10:16
 * @File : Solution_01.java
 *
 * 1. 最简单的直接暴力循环即可；
 * 2. 数组中的两数之和为target，换句话说就是target减去数组中的某个数，差一定也是数组中的某个数
 *      可以利用HashMap，将数组中的一部分数存储在HashMap中，然后用target减去数组中的另一部分数，如果差出现在HashMap中，
 *      那么这两个数就是要找的结果。
 *
 *      但是存储哪部分数呢？可以在遍历的时候，计算差值，如果差值不在HashMap中，那么就说明当前数是第一个减数，第二个减数一定在后面，
 *      所以，如果不在里面，则将该数放入HashMap中；如果在里面，则找到两数。
 *
 *      循环一遍即可找到结果，另外HashMap中查找的时间复杂度为O(1)，遍历数组的时间复杂度为O(n)，所以总体的时间复杂度为O(n)。
 */
public class Solution_0001 {

    public static int[] twoSum(int[] nums, int target){

        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for(int index=0; index < nums.length ; index++){
            int temp = target - nums[index];
            if(map.containsKey(temp)){
                result[0] = map.get(temp);
                result[1] = index;
            } else{
                map.put(nums[index], index);
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] nums = {2,7,11,15};
//        int target = 9;

//        int[] nums = {3,2,4};
//        int target = 6;
        int[] nums = {3,3};
        int target = 6;

        int[] results = twoSum(nums, target);

        for(int item: results){
            System.out.print(item + " ");
        }
    }
}
