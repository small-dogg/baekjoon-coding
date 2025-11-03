import java.util.*;

class Solution {
    public String solution(String my_string) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c : my_string.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            sb.append(entry.getKey());
        }
        
        return sb.toString();
    }
}