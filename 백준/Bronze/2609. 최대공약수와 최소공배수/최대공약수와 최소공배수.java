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

        lcm(a, b);
    }

    private static int gcd(int a, int b) {
        //유클리드 호제법 : 큰수를 작은수로 나눈 나머지를 이용해 문제를 점점 더 작은 문제로 줄여나간다.
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    private static void lcm(int a, int b) {
        int gcd = gcd(a, b);
        System.out.println(gcd);
        System.out.println(a * b / gcd);
    }
}
