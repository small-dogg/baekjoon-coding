import java.util.*;

public class Solution {

    public int solution(int n, int[][] edge) {
        int answer = 0;
        //인접행렬을 먼저 만들어
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] ints : edge) {
            int a = ints[0];
            int b = ints[1];
            graph[a].add(b);
            graph[b].add(a);
        }

        int[] dist = new int[n + 1];//노드까지의 거리
        Arrays.fill(dist, -1);//방문하지 않은 경우를 -1로 취급하여 초기화

        bfs(1, n, dist, graph);

        int max = Arrays.stream(dist).max().orElse(0);
        for (int i : dist) {
            if(i == max) answer++;
        }

        return answer;
    }

    private void bfs(int start, int n, int[] dist, List<Integer>[] graph) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        dist[start] = 0;

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int next : graph[now]) {
                if (dist[next] == -1) {
                    //다음 갈 곳의 거리를 정의
                    dist[next] = dist[now] + 1;
                    q.offer(next);
                }
            }
        }
    }
}
