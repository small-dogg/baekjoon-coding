import java.util.*;
//풀이 수준 :A
class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> partiMap = new HashMap<>();
        for (String s : participant) {
            partiMap.put(s, partiMap.getOrDefault(s, 0) + 1);
        }

        for (String s : completion) {
            partiMap.put(s, partiMap.get(s) - 1);
        }

        for (Map.Entry<String, Integer> entry : partiMap.entrySet()) {
            if (entry.getValue() != 0) return entry.getKey();
        }
        return "";
    }
}