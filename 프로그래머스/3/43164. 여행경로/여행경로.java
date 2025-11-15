import java.util.*;

public class Solution {
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        //ticket은 {출발지,목적지} 배열
        //먼저 인접리스트를 만들고, 정렬 (하려했으나, 필요없는듯)

        //출발지, 도착지 기준으로 정렬
        Arrays.sort(tickets, (a, b) -> {
            if (!a[0].equals(b[0])) return a[0].compareTo(b[0]);
            return a[1].compareTo(b[1]);
        });

        //티켓 수 만큼 방문 배열 선얼
        boolean[] visited = new boolean[tickets.length];
        List<String> result = new ArrayList<>();

        List<String> now = new ArrayList<>();
        now.add("ICN");
        dfs("ICN", visited, tickets, 0, now, result);

        return result.toArray(String[]::new);
    }

    //현재 위치, 방문배열, 티켓, 방문횟수, 결과
    private void dfs(String now, boolean[] visited, String[][] tickets, int usedCount, List<String> nowList, List<String> result) {
        //종료조건 : 더이상 나아갈 곳이 없거나, 사용된 티켓이 티켓수 만큼 사용되었을때
        if (usedCount == tickets.length) {
            if(result.isEmpty()) result.addAll(nowList);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            //방문하지 않은 곳이면
            if (!visited[i] && tickets[i][0].equals(now)) {
                String next = tickets[i][1];

                visited[i] = true;
                nowList.add(next);
                dfs(next, visited, tickets, usedCount + 1, nowList, result);
                nowList.remove(nowList.size() - 1);
                visited[i] = false;
            }
        }

    }
}
