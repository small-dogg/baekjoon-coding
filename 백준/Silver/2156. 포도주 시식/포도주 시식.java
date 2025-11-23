import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[] dp = new int[size];
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        if(size == 1){
            System.out.println(arr[0]);
            return;
        }
        if(size == 2){
            System.out.println(arr[0]+arr[1]);
            return;
        }
        
        dp[0] = arr[0];
        dp[1] = arr[0] + arr[1];
        dp[2] = Math.max(
                arr[0] + arr[2], Math.max(
                        arr[1] + arr[2],
                        dp[1]));

        for (int i = 3; i < size; i++) {
            dp[i] = Math.max(
                    dp[i - 1],//안마시기
                    Math.max(dp[i - 2] + arr[i],//전전dp랑 현재잔 마시기
                            dp[i - 3] + arr[i - 1] + arr[i]//전전전dp랑 이전잔, 현재잔 마시기(2v2)
                    ));
        }

        System.out.println(dp[size-1]);
    }
}
