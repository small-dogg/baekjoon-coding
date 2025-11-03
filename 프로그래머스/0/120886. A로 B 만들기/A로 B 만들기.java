import java.util.*;

class Solution {
    public int solution(String before, String after) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : before.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : after.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) - 1);
        }

        for (Integer value : map.values()) {
            if (value != 0) return 0;
        }
        return 1;
    }
}