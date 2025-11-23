import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());


        int max = 0;
        List<Integer> target = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int x = Integer.parseInt(br.readLine());
            target.add(x);
            max = Math.max(max, x);
        }
        int[] dp = new int[max + 1];

        dp[1] = 1;
        if (max >= 2) dp[2] = 2;
        if (max >= 3) dp[3] = 4;

        for (int i = 4; i <= max; i++) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }

        for (Integer x : target) {
            System.out.println(dp[x]);
        }
    }
}
