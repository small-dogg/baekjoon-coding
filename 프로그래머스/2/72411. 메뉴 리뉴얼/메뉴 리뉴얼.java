import java.util.*;
//풀이수준 : C
class Solution {
    public String[] solution(String[] orders, int[] course) {
        // 1) 각 주문 문자열을 정렬 (동일 조합 식별을 위해)
        String[] sorted = Arrays.stream(orders)
                .map(s -> {
                    char[] arr = s.toCharArray();
                    Arrays.sort(arr);
                    return new String(arr);
                })
                .toArray(String[]::new);

        // 2) 조합 빈도 카운트
        Map<String, Integer> freq = new HashMap<>();
        for (String order : sorted) {
            for (int size : course) {
                if (order.length() < size) continue; // 길이가 모자라면 스킵
                combination(order, 0, size, new StringBuilder(), freq);
            }
        }

        // 3) 코스 크기별 최대 빈도 조합만 수집 (최소 2회 이상)
        List<String> result = new ArrayList<>();
        for (int size : course) {
            int max = 0;
            List<String> bucket = new ArrayList<>();
            for (Map.Entry<String, Integer> e : freq.entrySet()) {
                String key = e.getKey();
                int cnt = e.getValue();
                if (key.length() != size || cnt < 2) continue;
                if (cnt > max) {
                    max = cnt;
                    bucket.clear();
                    bucket.add(key);
                } else if (cnt == max) {
                    bucket.add(key);
                }
            }
            result.addAll(bucket);
        }

        // 4) 사전순 정렬 후 반환
        Collections.sort(result);
        return result.toArray(new String[0]);
    }


    // 조합 생성: order에서 targetSize개를 뽑아 freq 카운팅
    private void combination(String order, int start, int targetSize,
                             StringBuilder cur, Map<String, Integer> freq) {
        if (cur.length() == targetSize) {
            String key = cur.toString();
            freq.put(key, freq.getOrDefault(key, 0) + 1);
            return;
        }
        // 가지치기(선택): 남은 글자로 목표 길이를 채울 수 없으면 중단
        int remainNeeded = targetSize - cur.length();
        for (int i = start; i <= order.length() - remainNeeded; i++) {
            cur.append(order.charAt(i));
            combination(order, i + 1, targetSize, cur, freq);
            cur.deleteCharAt(cur.length() - 1); // 백트래킹
        }
    }
}