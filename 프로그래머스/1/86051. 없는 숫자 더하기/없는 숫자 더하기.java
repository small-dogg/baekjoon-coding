import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int result = 0;
        
        Set<Integer> set = new HashSet<>();
        for (int i : numbers) {
            set.add(i);
        }

        for (int i = 0; i < 10; i++) {
            if(!set.contains(i)) result += i;
        }
        
        return result;
    }
}