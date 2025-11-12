import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        //인접리스트 생성
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        //간선 기준으로 양방향 연결
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // 오름차순 정렬
        for (List<Integer> list : graph) Collections.sort(list);

        boolean[] visited = new boolean[N + 1];
        dfs(graph, visited, V);
        System.out.println();
        bfs(graph, V);
    }

    private static void dfs(List<List<Integer>> graph, boolean[] visited, int now) {
        //현재위치 방문처리
        visited[now] = true;
        System.out.print(now + " ");

        //인접 노드 순회
        for (int next : graph.get(now)) {
            if (!visited[next]) {
                dfs(graph, visited, next);
            }
        }
    }

    private static void bfs(List<List<Integer>> graph, int start) {
        boolean[] visited = new boolean[graph.size()];
        Queue<Integer> q = new ArrayDeque<>();

        visited[start] = true;
        q.offer(start);

        while (!q.isEmpty()) {
            int now = q.poll();
            System.out.print(now + " ");

            for (int next : graph.get(now)) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
    }
}
