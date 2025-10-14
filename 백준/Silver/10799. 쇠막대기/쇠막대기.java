import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        int result = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] charArray = br.readLine().toCharArray();

        char before = 0;
        Stack<Character> stack = new Stack<>();
        for (char c : charArray) {
            if (c == '(') {
                stack.push(c);
            } else {
                stack.pop();
                if (before == '(') {
                    int size = stack.size();
                    result += size;
                } else {
                    result++;
                }
            }
            before = c;
        }
        System.out.println(result);
    }
}
