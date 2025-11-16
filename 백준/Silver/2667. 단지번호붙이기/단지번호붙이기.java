import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        int[][] area = new int[size][size];
        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int j = 0;
            for (char c : st.nextToken().toCharArray()) {
                area[i][j] = c - '0';
                j++;
            }
        }

        List<Integer> areaSizeList = new ArrayList<>();
        boolean[][] visited = new boolean[size][size];

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < area.length; i++) {
            for (int j = 0; j < area[i].length; j++) {
                if (!visited[i][j] && area[i][j] == 1) {
                    visited[i][j] = true;
                    q.offer(new int[]{i, j});
                    int sum = bfs(q, size, visited, area);
                    areaSizeList.add(sum);
                }
            }
        }

        Collections.sort(areaSizeList);

        System.out.println(areaSizeList.size());
        for (Integer i : areaSizeList) {
            System.out.println(i);
        }
    }

    private static final int[] dx = new int[]{-1, 1, 0, 0};
    private static final int[] dy = new int[]{0, 0, -1, 1};

    private static int bfs(Queue<int[]> q, int size, boolean[][] visited, int[][] area) {

        int count = 0;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            count++;

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;

                if (nx < 0 || nx >= size || ny < 0 || ny >= size || visited[nx][ny] || area[nx][ny] == 0) continue;

                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }
        }

        return count;
    }
}
