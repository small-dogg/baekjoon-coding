
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int val = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < cnt; i++) {
            int num = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && stack.peek() < num) {
                stack.pop();
                val++;
            }

            if (num != cnt + 1) {
                stack.push(num);
            } else {
                val++;
            }
        }

        while (!stack.isEmpty() && (stack.peek() == val + 1)) {
            stack.pop();
            val++;
        }

        if (cnt == val) {
            System.out.println("Nice");
        } else {
            System.out.println("Sad");
        }
    }
}