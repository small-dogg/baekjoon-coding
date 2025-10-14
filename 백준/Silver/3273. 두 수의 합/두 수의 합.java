import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


//Two Pointer Alg.
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());
        int[] arr = new int[cnt];
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        for (int i = 0; i < cnt; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int sum = Integer.parseInt(br.readLine());

        System.out.println(getEqualSumCount(sum, arr));
    }

    private static int getEqualSumCount(int target, int[] numArr) {
        int result = 0;
        int lt = 0;
        int rt = numArr.length - 1;

        Arrays.sort(numArr);
        
        while (lt < rt) {
            int sum = numArr[rt] + numArr[lt];

            if (sum == target) result++;

            if (sum < target) lt++;
            else rt--;
        }

        return result;
    }
}
