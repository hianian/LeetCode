/**
 * @Author : hianian
 * @Time : 2022/2/19 18:20
 * @File : Solution_0005.java
 *
 * 这道题看起来比较复杂，但是仔细阅读之后，实际上是求解最大值：
 *      这个最大值指的是: min(height[i], height[j]) * (j - i)
 *
 * 可以先暴力破解一下：
 */
public class Solution_0005 {

    public static int maxArea(int[] height) {

        int result = 0;
        int h;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                h = Math.min(height[i], height[j]);
                result = Math.max(result, h * (j - i));
            }
        }
        return result;
    }
    public static void main(String[] args) {
//        int[] height = {1,8,6,2,5,4,8,3,7};
        int[] height = {1, 1};
        System.out.println(maxArea(height));
    }
}
