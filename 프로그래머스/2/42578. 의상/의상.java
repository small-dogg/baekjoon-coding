import java.util.*;
//풀이수준 : A-
class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] cloth : clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
        }

        int result = 1;
        for (int i : map.values()) {
            result = result * (i + 1);
        }

        return result - 1;
    }
}