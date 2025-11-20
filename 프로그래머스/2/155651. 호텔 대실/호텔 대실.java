import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        Map<Integer, Integer> minMap = new HashMap<>();
        for (String[] strings : book_time) {
            int start = getMin(strings[0]);
            int end = getMin(strings[1]) + 9;

            for (int i = start; i <= end; i ++) {
                minMap.put(i, minMap.getOrDefault(i, 0) + 1);
            }
        }

        return minMap.values().stream().mapToInt(a->a).max().orElse(0);
    }

    private int getMin(String hhMm) {
        String[] split = hhMm.split(":");
        int hh = Integer.parseInt(split[0])*60;
        int mm = Integer.parseInt(split[1]);
        return hh + mm;
    }
}