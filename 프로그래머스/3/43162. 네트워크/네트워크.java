import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        //n 컴퓨터 수
        //computers : 양방향 인접리스트

        //bfs로 풀이(전체 순회해야함)

        //방문배열
        boolean[] visited = new boolean[n];

        int network = 0;
        Queue<Integer> q = new LinkedList<>();
        //각 컴퓨터마다 순회하며 bfs 시작점 획득
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                network++;
                q.offer(i);
                bfs(i, n, visited, computers);
            }
        }
        return network;
    }

    private void bfs(int start, int n, boolean[] visited, int[][] computers) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 0; i < n; i++) {
                if (!visited[i] && computers[now][i] == 1) {
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }
}