import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//그래프(DFS/BFS) : 2178 - 미로 탐색
//백트래킹 + 그래프 탐색(혼합) : 14502 - 연구소

//DFS로 풀려했다. 안된다. 왜 BFS를 써야하는가를 몰랐다.
public class Main {

    private static final int[] dx = new int[]{-1, 1, 0, 0};
    private static final int[] dy = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            int j = 0;
            for (char c : br.readLine().toCharArray()) {
                arr[i][j++] = c - '0';
            }
        }

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int[][] dist = new int[n][m];
        visited[0][0] = true;
        dist[0][0] = 1;
        q.offer(new int[]{0, 0});

        while (!q.isEmpty()) {
            int[] now = q.poll();

            // 도착지(n-1, m-1)에 도착하면 탐색 종료
            int y = now[0];
            int x = now[1];

            if (y == n - 1 && x == m - 1) {
                System.out.println(dist[y][x]);
                break;
            }

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny >= 0 && ny < n && nx >= 0 && nx < m
                        && arr[ny][nx] != 0
                        && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    dist[ny][nx] = dist[y][x] + 1;
                    q.offer(new int[]{ny, nx});
                }
            }
        }
    }
}
