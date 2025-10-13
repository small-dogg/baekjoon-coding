import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;


public class Main {
    public static void main(String[] args) throws IOException {

        int[] ints = new int[26];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] charArray = br.readLine().toCharArray();
        for (int c : charArray) {
            ints[c-97]++;
        }

        StringJoiner sj = new StringJoiner(" ");
        for (int c : ints){
            sj.add(c+"");
        }

        System.out.println(sj);
    }
}
