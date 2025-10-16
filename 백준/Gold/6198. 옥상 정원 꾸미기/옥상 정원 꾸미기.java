import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        long result = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int height = Integer.parseInt(br.readLine());

            while (!stack.isEmpty()) {
                if(stack.peek() <= height) {
                    stack.pop();
                }else break;
            }
            result += stack.size();

            stack.push(height);
        }

        System.out.println(result);
    }
}