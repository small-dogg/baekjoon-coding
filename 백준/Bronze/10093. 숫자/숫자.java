import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        if (a > b) {
            long temp = a;
            a = b;
            b = temp;
        }

        System.out.println(Math.max(b - a - 1,0));
        StringJoiner sj = new StringJoiner(" ");
        for (long i = a + 1; i < b; i++) {
            sj.add(i + "");
        }

        System.out.println(sj);
    }
}
