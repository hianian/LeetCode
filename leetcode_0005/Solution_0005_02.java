/**
 * @Author : hianian
 * @Time : 2022/2/19 18:32
 * @File : Solution_0005_02.java
 *
 * 暴力破解需要 O(n^2) 的时间复杂度，那么如何降低时间复杂度呢？
 *      简单地说，就是减少不必要的比较。（可以想象，其实暴力破解就是两个指针在最左侧，然后逐步移动每个指针）
 *
 * 参考精选题解。考虑一下双指针的做法：
 *      首先两个指针在数组的两端，移动指针相当于移动水箱的两边。那么怎么移动才会减少不必要的比较呢？
 *      首先，此时水箱的底边（y - x）的距离是最大的，那么无论怎么移动，底边它都会变小，现在要做的就是使得 高 变大。
 *
 *      而 面积 为 min(height[x], height[y]) * (y - x)
 *
 *      所以，必须 使得 min(height[x], height[y]) 可能增大，因为这样，最终结果才有可能变大
 *
 *      而 min(height[x], height[y]) 的值取决于较小的边，那么如果我们改变较大的边，此时较大的边要么增大，要么减小。
 *      但是，即使再增大，较小的边没有变，所以min()值保持不变，仍然是较小的边；如果较大的边减小的话，就更不用说了，min()的值
 *      可能减小，也可能不变。  所以，改变较大的边，水箱面积保持不变或减小，肯定不会增大。（即包含了不必要的移动，所以这些移动是浪费的）
 *
 *      那么如果移动较小的边呢？也是有两种情况，该边要么增大，要么减小。如果该边增大的话，此时min()值肯定增大，如果减小的话，
 *      min()值肯定减小。  所以，改变较小的边，水箱面积有可能增大，也有可能减小。（既有不必要的移动，也有必要的移动）
 *
 *      所以，双指针应该移动较小的边。
 */
public class Solution_0005_02 {

    public static int maxArea(int[] height) {

        int result = 0, temp;
        int left = 0;
        int right = height.length - 1;

        while(left < right){

            temp = Math.min(height[left], height[right]) * (right - left);
            result = Math.max(result, temp);

            if(height[left] < height[right]){
                left ++;
            } else {
                right --;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
//        int[] height = {1, 1};
        System.out.println(maxArea(height));
    }
}
