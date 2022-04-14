import java.util.Stack;

/**
 * @Author : hianian
 * @Time : 2022/4/13 16:11
 * @File : Solution_0040.java
 *
 * 这道题先试着用快慢指针加栈来做一下，快指针每次移动两个位置，慢指针每次移动一个位置。
 * 二者从开始处开始移动，慢指针每遍历一个字符就将其入栈，直到快指针暂停到2k位置，此时慢指针达到了k位置
 *
 * 接着出栈，拼接字符串（反转前k个），慢指针继续遍历，直达达到快指针的位置，期间不入栈，只进行拼接。
 *
 * 继续重复上述步骤
 *
 *      如果快指针结束遍历，且未到达k位置，那么慢指针继续遍历并入栈，
 *      如果快指针结束遍历，超过k位置，那么慢指针继续遍历至k位置并入栈，之后遍历不入栈
 *
 * 上述只是一种思路，实际上并不需要快指针，只需要慢指针遍历，当当前个数为前k个时，就入栈，k+1至2k时，出栈并拼接
 *
 * 下面是具体的实现，其实并没有用到双指针，仅仅是一个指针。时间和空间复杂度均为O(n)
 */
public class Solution_0040 {

    public static String reverseStr(String s, int k) {

        Stack<Character> stack = new Stack<>();

        char[] chars = s.toCharArray();

        StringBuilder sb = new StringBuilder();
        int index = 0;

        for(char c: chars) {
            index += 1;

            // 前k个字符入栈
            if(index <= k) {
                stack.push(c);

            } else if(index <= 2*k) {
                // 此时为k-2k之间
                // 将栈中的字符出栈，拼接字符串，并拼接k-2k之间的字符。

                while(!stack.isEmpty()) {
                    // 只在k+1个字符时出栈，其余均为空
                    sb.append(stack.pop());
                }

                sb.append(c);

                // 归零，相当于下一次的字符在新的0-k之间
                if(index == 2*k) index = 0;

            }
        }

        // 最后，对于 最后一段<k的字符串，栈中保存了字符
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println();

//        String s = "abcdefg";
        String s = "abcd";

        System.out.println(reverseStr(s, 2));
    }
}
