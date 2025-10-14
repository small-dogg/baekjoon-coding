import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] ints = new int[26];

        char[] charArray1 = br.readLine().toCharArray();
        char[] charArray2 = br.readLine().toCharArray();

        for (char c : charArray1) {
            ints[c - 'a']++;
        }
        for (char c : charArray2) {
            ints[c - 'a']--;
        }

        System.out.println(
                Arrays.stream(ints)
                        .map(Math::abs)
                        .sum()
        );

    }
}