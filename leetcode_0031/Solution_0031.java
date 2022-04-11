import java.util.*;

/**
 * @Author : hianian
 * @Time : 2022/4/8 19:38
 * @File : Solution_0031.java
 *
 * 这道题先暴力做一下
 *
 *      遍历数组，计算每类元素的数量。然后取前K个数量最多的元素
 */
public class Solution_0031 {

    public static int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[k];

        for(int i: nums) {

            if(map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }

        }

        // 对Map进行排序，参考其他博客，采用优先级队列存储元素进行排序。
        // 注意补充数据结构：优先级队列，堆
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        // 根据map的value值正序排，相当于一个小顶堆
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());
        for (Map.Entry<Integer, Integer> entry : entries) {
            queue.offer(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        for (int i = k - 1; i >= 0; i--) {
            result[i] = queue.poll().getKey();
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println();

        int[] nums = {1, 1, 1, 2, 3, 3};

        int[] result = topKFrequent(nums, 2);

        for(int i: result) {
            System.out.println(i);
        }
    }
}
