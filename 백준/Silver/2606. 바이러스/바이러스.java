import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int comCnt = Integer.parseInt(br.readLine()); // 100이하의 양의 정수
        int n = Integer.parseInt(br.readLine());

        //감염 여부 배열
        boolean[][] arr = new boolean[comCnt + 1][comCnt + 1];

        //양방향 체크
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = true;
            arr[b][a] = true;
        }

        int cnt = 0;
        boolean[] visited = new boolean[comCnt + 1];
        dfs(1, visited, arr);

        for (boolean b : visited) {
            if(b) cnt++;
        }

        System.out.println(cnt-1);
    }

    private static void dfs(int now, boolean[] visited, boolean[][] arr) {
        visited[now] = true;

        for (int i = 1; i < arr[now].length; i++) {
            if (arr[now][i] && !visited[i]) {
                dfs(i, visited, arr);
            }
        }
    }
}
