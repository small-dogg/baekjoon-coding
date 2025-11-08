import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            q.add(i);
        }

        List<Integer> result = new ArrayList<>();
        int days = 0;
        int count = 0;
        while (!q.isEmpty()) {
            //index 번째의 작업 검사
            int idx = q.poll();
            //소요기간 획득
            int expiration = (int) Math.ceil((double) (100 - progresses[idx]) / speeds[idx]);
            if (expiration > days) {
                if (days != 0) {
                    result.add(count);
                    count = 0;
                }
                days = expiration;
            }
            count++;

        }
        
        result.add(count);

        return result.stream().mapToInt(a -> a).toArray();
    }
}