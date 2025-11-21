import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        memo = new int[a + 1];
        System.out.println(fibo(a));
    }

    private static int fibo(int a) {
        if (a < 2) return a;
        if (memo[a] != 0) return memo[a];
        return memo[a] = fibo(a - 2) + fibo(a - 1);
    }
}
