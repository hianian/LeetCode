import java.util.ArrayDeque;

/**
 * @Author : hianian
 * @Time : 2022/4/7 19:57
 * @File : Solution_0030_03.java
 *
 * 没错，上面的改进仍然超时。
 *
 * 参考其他博客，方法如下所示：
 *
 * 实际上，在上面的改进中，仍然存在重复比较，最明显的就是相邻两个窗口之间的重复元素。
 * 此时可以采用单调队列来做。
 *      1. 一方面，保证队列的出口是最大值。
 *      2. 另一方面，保证队列是单调的。
 *
 * 这样，当达到滑动窗口的元素个数时，直接将队列出口元素弹出即可，此时获得的值肯定是最大值。
 * 但是队列中的数据怎么排放呢？每入队一个元素就要重新排列一遍吗？
 *
 * 显然不是的，首先
 *      1. 如果入队的元素比出口的元素小，那么就不入队。（那么这样怎么保证，万一最大值就是第一个滑动窗口的第一个元素，下一个滑动窗口前面几个元素的最大值怎么保存呢？）
 *      2. 所以，针对上述问题，窗口最少要存储两个元素，这样，肯定保留了相邻窗口之间重叠部分的最大值。
 *
 * 总体上说：
 *      1. 入队：如果即将要入队的元素大于入口的值，那么就将入口元素弹出，直到小于入口元素或队列为空。（保证了最大值）
 *      2. 出队：弹出出口元素即可（最大值）。
 *
 *  为了方便判断滑动窗口的范围，队列存储的元素是数组元素下标。
 */
public class Solution_0030_03 {

    public static int[] maxSlidingWindow(int[] nums, int k) {

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int idx = 0;
        for(int i = 0; i < n; i++) {
            // 根据题意，i为nums下标，是要在[i - k + 1, i] 中选到最大值，只需要保证两点
            // 1.队列头结点需要在[i - k + 1, i]范围内，不符合则要弹出
            while(!deque.isEmpty() && deque.peek() < i - k + 1){
                deque.poll();
            }
            // 2.既然是单调，就要保证每次放进去的数字要比末尾的都大，否则也弹出
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offer(i);

            // 因为单调，当i增长到符合第一个k范围的时候，每滑动一步都将队列头节点放入结果就行了
            // 注意，这里只需判断第一次即可。因为，当达到第一个滑动窗口的时候，弹出元素，遍历下一个元素，必定就是下一个窗口的最后一个元素。
            if(i >= k - 1){
                res[idx++] = nums[deque.peek()];
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
//        int[] nums = {1};

        int[] result = maxSlidingWindow(nums, 3);

        for(int i: result) {
            System.out.println(i);
        }
    }
}
