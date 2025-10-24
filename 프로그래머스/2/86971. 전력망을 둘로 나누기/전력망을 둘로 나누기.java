import java.util.ArrayList;
import java.util.List;

// 풀이점수 : D
class Solution {
    public int solution(int n, int[][] wires) {
        //인접리스트 구성
        List<Integer>[] g = new ArrayList[n + 1];
        // Integer 리스트 배열 초기화
        for (int i = 0; i <= n; i++) {
            g[i] = new ArrayList<>();
        }
        //정방향과 역방향 모두 인접리스트에 추가한다.
        for (int[] wire : wires) {
            int u = wire[0];
            int v = wire[1];
            g[u].add(v);
            g[v].add(u);
        }

        //1과 나머지로 분리될 worst 케이스
        int answer = n - 1;

        // 모든 간선 (u,v)에 대해 그 간선을 끊었다고 가정하고 진행
        for (int[] w : wires) {
            int u = w[0];
            int v = w[1];

            boolean[] visited = new boolean[n + 1];

            int sizeA = dfs(u, visited, g, u, v);
            int sizeB = n - sizeA;
            answer = Math.min(answer, Math.abs(sizeA - sizeB));

        }

        return answer;
    }

    private int dfs(int cur, boolean[] visited, List<Integer>[] g, int u, int v) {
        visited[cur] = true;
        int cnt = 1;

        for (Integer nxt : g[cur]) {
            if((cur == u && nxt == v) || (cur == v && nxt == u)) continue;
            if(!visited[nxt]) cnt += dfs(nxt, visited, g, u, v);
        }

        return cnt;
    }
}