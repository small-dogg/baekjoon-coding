class Solution {
    public int solution(int n, int[][] results) {
//        A 선수가 B선수를 이겼다는 건 방향 점보가 있다는 의미 (방향 그래프로 문제를 풀이해볼지 고민)
        //선수 수가 100명 이하(?) - 인접 행렬 방식으로 풀이 가능

        //그래프 구성
        boolean[][] graph = new boolean[n][n];
        for (int[] edge : results) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            graph[u][v] = true;
        }

        int count = 0;
        for (int u = 0; u < n; u++) {
            int win = countF(u, graph, new boolean[n]) - 1;
            int lose = countB(u, graph, new boolean[n]) - 1;
            if (win + lose + 1 == n) count++;
        }

        return count;
    }

    //화살표 방향으로 진행하며 만나는 정점 개수 세기
    private int countF(int u, boolean[][] graph, boolean[] isVisited) {
        int count = 1;

        for (int v = 0; v < graph[u].length; v++) {
            //이긴적이 없거나, 이미 방문했으면(이미 이긴대상인걸 알고 있으면) 스킵
            if (!graph[u][v] || isVisited[v]) continue;
            isVisited[v] = true;
            //진애들이 이긴애들도 합산
            count += countF(v, graph, isVisited);
        }

        return count;
    }

    //진 경기 수 세기
    private int countB(int u, boolean[][] graph, boolean[] isVisited) {
        int count = 1;

        for (int v = 0; v < graph[u].length; v++) {
            if (!graph[v][u] || isVisited[v]) continue;
            isVisited[v] = true;
            count += countB(v, graph, isVisited);
        }

        return count;
    }
}