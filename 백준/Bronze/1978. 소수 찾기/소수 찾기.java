import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");

        int count = 0;
        for (String string : s) {
            if (isPrime(Integer.parseInt(string))) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static boolean isPrime(int a) {
        if (a < 2) return false;
        for (int i = 2; i < a; i++) {
            if (a % i == 0) return false;
        }

        return true;
    }

}
