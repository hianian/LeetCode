import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author : hianian
 * @Time : 2022/2/20 11:09
 * @File : Solution_0006_02.java
 *
 * 递归法比较直观，时间复杂度为 O(n^2)，而且内存开销比较大，这里修改为非递归的形式。
 */
public class Solution_0006_02 {

    public static Map<Character, String[]> map = new HashMap<>();

    static {
        map.put('2', new String[]{"a", "b", "c"});
        map.put('3', new String[]{"d", "e", "f"});
        map.put('4', new String[]{"g", "h", "i"});
        map.put('5', new String[]{"j", "k", "l"});
        map.put('6', new String[]{"m", "n", "o"});
        map.put('7', new String[]{"p", "q", "r", "s"});
        map.put('8', new String[]{"t", "u", "v"});
        map.put('9', new String[]{"w", "x", "y", "z"});
    }

    public static List<String> letterCombinations(String digits) {

        return new ArrayList<>();
    }

}
