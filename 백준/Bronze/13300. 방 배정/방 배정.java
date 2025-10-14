import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(stringTokenizer.nextToken());
        int max = Integer.parseInt(stringTokenizer.nextToken());

        int result = 0;
        int[][] ints = new int[6][2];

        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());

            ints[grade-1][gender]++;
        }

        for (int i=0; i < ints.length; i++) {
            for (int j=0; j < ints[i].length; j++) {
                int i1 = ints[i][j] / max;
                int i2 = ints[i][j] % max == 0 ? 0 : 1;
                result += i1+i2;
            }
        }

        System.out.println(result);
    }
}
