import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);

        boolean[] prime = getPrime(b);
        for (int i = a; i <= b; i++) {
            if(prime[i]) System.out.println(i);
        }
    }

    private static boolean[] getPrime(int b) {
        boolean[] prime = new boolean[b + 1];
        Arrays.fill(prime, true);

        prime[0] = false;
        prime[1] = false;

        for (int i = 2; i <= Math.sqrt(b); i++) {
            if (prime[i]) {
                for (int j = i + i; j <= b; j += i) {
                    prime[j] = false;
                }
            }
        }

        return prime;
    }
}
