import java.util.*;

class Solution {
     private Map<String, Integer> termsMap;

    public int[] solution(String today, String[] terms, String[] privacies) {
        //고객의 약관 1~n번으로 분류되는 개인정보 n개
        int todayDays = getDays(today);

        termsMap = new HashMap<>();
        for (String term : terms) {
            String[] s = term.split(" ");
            termsMap.put(s[0], Integer.valueOf(s[1]));
        }

        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String[] s = privacies[i].split(" ");
            int s1 = getDays(s[0]) + termsMap.get(s[1]) * 28;
            if (s1 <= todayDays) {
                resultList.add(i + 1);
            }
        }

        return resultList.stream().mapToInt(a -> a).toArray();
    }

    private int getDays(String date) {
        String[] split = date.split("\\.");
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int day = Integer.parseInt(split[2]);

        return (year * 12*28 + month * 28 + day);
    }
}