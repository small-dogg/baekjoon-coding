import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        boolean[] prime = getPrime(b);
        int sum = 0;
        int first = 0;
        for (int i = a; i <= b; i++) {
            if (prime[i]) {
                if (first == 0) {
                    first = i;
                }
                sum += i;
            }
        }
        if(sum==0) System.out.println(-1);
        else{
            System.out.println(sum);
            System.out.println(first);
        }
    }

    private static boolean[] getPrime(int b) {
        boolean[] prime = new boolean[b + 1];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;

        for (int i = 2; i < Math.sqrt(b); i++) {
            if (prime[i]) {
                for (int j = i * i; j <= b; j += i) {
                    prime[j] = false;
                }
            }
        }

        return prime;
    }

}
