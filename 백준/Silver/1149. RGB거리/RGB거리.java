import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        // 0: red, 1: green, 2: blue
        int[][] dp = new int[size][3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        dp[0][0] = Integer.parseInt(st.nextToken());
        dp[0][1] = Integer.parseInt(st.nextToken());
        dp[0][2] = Integer.parseInt(st.nextToken());

        for (int i = 1; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            dp[i][0] = r + Math.min(dp[i-1][1],dp[i-1][2]);
            dp[i][1] = g + Math.min(dp[i-1][0],dp[i-1][2]);
            dp[i][2] = b + Math.min(dp[i-1][0],dp[i-1][1]);
        }

        System.out.println(Math.min(dp[size - 1][0], Math.min(dp[size - 1][1], dp[size - 1][2])));;
    }
}
