import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 3; i++) {
            String s = br.readLine();
            int cnt = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '0') {
                    cnt++;
                }
            }

            System.out.println(
                    switch (cnt) {
                        case 1 -> "A";
                        case 2 -> "B";
                        case 3 -> "C";
                        case 4 -> "D";
                        case 0 -> "E";
                        default -> throw new IllegalStateException("Unexpected value: " + cnt);
                    }
            );
        }
    }
}