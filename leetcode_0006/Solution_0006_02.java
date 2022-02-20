import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author : hianian
 * @Time : 2022/2/20 11:09
 * @File : Solution_0006_02.java
 *
 * 递归法比较直观，这里修改为非递归的形式。
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

        List<String> result = new ArrayList<>();

        char[] chars = digits.toCharArray();

        int size;

        for (int i = 0; i < digits.length(); i++) {

            // 遍历该元素前先获取result中的组合个数，用于后续重新组合
            size = result.size();

            for (int j = 0; j < map.get(chars[i]).length; j++) {

                if(size == 0){
                    result.add(map.get(chars[i])[j]);
                } else {
                    for (int k = 0; k < size; k++) {
                        // 修改原有的组合
                        if(k + j * size < size){
                            result.set(k + j * size, result.get(k) + map.get(chars[i])[j]);
                        } else{
                            // 添加新的组合
                            // 注意，因为已经修改了原有的组合，所以后续组合的时候，需要取到原有的组合，
                            // 而新的组合其实就是添加了一个字符，所以获取原有的组合就是去掉一个字符，即result.get(j).length() - 1)
                            // 然后再将 遍历字符对应的数组 和 原有组合 进行组合
                            result.add(result.get(k).substring(0, result.get(k).length() - 1) + map.get(chars[i])[j]);
                        }
                    }
                }
            }
        }


        return result;
    }

    public static void main(String[] args) {
//        String digits = "23";
//        String digits = "3";
        String digits = "";

        List<String> result = letterCombinations(digits);

        for (String s : result) {
            System.out.println(s);
        }
    }

}
