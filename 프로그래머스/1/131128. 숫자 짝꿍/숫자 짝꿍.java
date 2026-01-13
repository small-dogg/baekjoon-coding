import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(String X, String Y) {
        List<String> list = new ArrayList<>();

        Map<String, Integer> xMap = new HashMap<>();
        Map<String, Integer> yMap = new HashMap<>();

        for (String c : X.split("")) {
            xMap.put(c, xMap.getOrDefault(c, 0) + 1);
        }
        for (String c : Y.split("")) {
            yMap.put(c, yMap.getOrDefault(c, 0) + 1);
        }

        for (String c : xMap.keySet()) {
            if (!yMap.containsKey(c)) continue;
            int min = Math.min(xMap.get(c), yMap.get(c));
            for (int i = 0; i < min; i++) {
                list.add(c);
            }
        }

        String collect = list.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining());

        if (collect.isEmpty()) return "-1";
        else if (collect.replaceAll("0", "").isEmpty()) return "0";
        return collect;
    }
}