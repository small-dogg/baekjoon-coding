import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        int start = 0;
        while (size-- > 0) {

            int value = Integer.parseInt(br.readLine());

            if(value > start) {
                for(int i = start + 1; i <= value; i++) {
                    stack.push(i);
                    sb.append("+").append("\n");
                }
                start = value;
            } else if (stack.peek() != value) {
                System.out.println("NO");
                System.exit(0);
            }
            
            stack.pop();
            sb.append("-").append("\n");
        }

        System.out.println(sb);
    }
}