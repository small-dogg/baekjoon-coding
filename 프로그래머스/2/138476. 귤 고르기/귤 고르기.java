import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : tangerine) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<Integer> collect = map.values().stream().sorted((a, b) -> b - a).collect(Collectors.toList());
        
        int result = 0;
        int sum = 0;
        for (Integer i : collect) {
            sum += i;
            result++;
            
            if(sum >= k) return result;
        }

        return -1;
    }
}