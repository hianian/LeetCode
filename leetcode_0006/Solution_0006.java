import java.beans.PropertyEditorSupport;
import java.util.*;

/**
 * @Author : hianian
 * @Time : 2022/2/19 21:14
 * @File : Solution_0006.java
 *
 * 这道题从直观上说，就是排列组合问题，先用暴力法做一下（采用递归方法）：
 *      首先设置映射Map，将数字和对应的字符数组对应起来。
 *      然后遍历字符串，每次将新的字符对应的字符数组和保存的字符组合重新组合。
 *
 *          比如最开始ArrayList是空的，字符串是“234”，
 *          第一次遍历2，将2对应的 "a", "b", "c"加入到ArrayList中
 *          第二次遍历3，此时ArrayList中已经存在组合了，这是将3对应的 "d", "e", "f" 和已经存在的组合重新组合。
 *          第三次遍历4，重复上述步骤，直到遍历结束。
 */
public class Solution_0006 {

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

    public static List<String> getLetterList(List<String> result, String digits){

        // 递归结束
        if(digits.length() == 0){
            return result;
        }

        // 判断ArrayList中是否存在组合，没有的话，则直接将字符添加即可
        if(result.size() == 0){

            for (int i = 0; i < map.get(digits.charAt(0)).length; i++) {
                result.add(i, map.get(digits.charAt(0))[i]);
            }
        } else {

            // 存在组合，则需要重新组合
            int size = result.size();

            // 遍历字符串中第一个字符对应的字母数组
            for (int i = 0; i < map.get(digits.charAt(0)).length; i++) {
                for (int j = 0; j < size; j++) {
                    // 修改原有的组合
                    if(j + i * size < size){
                        result.set(j + i * size, result.get(j) + map.get(digits.charAt(0))[i]);
                    } else{
                        // 添加新的组合
                        // 注意，因为已经修改了原有的组合，所以后续组合的时候，需要取到原有的组合，
                        // 而新的组合其实就是添加了一个字符，所以获取原有的组合就是去掉一个字符，即result.get(j).length() - 1)
                        // 然后再将 遍历字符对应的数组 和 原有组合 进行组合
                        result.add(result.get(j).substring(0, result.get(j).length() - 1) + map.get(digits.charAt(0))[i]);
                    }
                }
            }
        }

        // 递归，将遍历后的字符去掉，遍历剩余的字符串。
        result = getLetterList(result, digits.substring(1));

        return result;
    }

    public static List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        return getLetterList(result, digits);
    }

    public static void main(String[] args) {

        String digits = "23";
//        String digits = "3";
//        String digits = "";

        List<String> result = letterCombinations(digits);

        for (String s : result) {
            System.out.println(s);
        }
    }
}
