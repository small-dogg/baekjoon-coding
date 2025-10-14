import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(br.readLine());

        for (int i = 0; i < length; i++) {
            Stack<Character> stack = new Stack<>();
            char[] charArray = br.readLine().toCharArray();
            try {
                for (int j = 0; j < charArray.length; j++) {

                    if (charArray[j] == '(') {
                        stack.push(charArray[j]);
                    } else if (charArray[j] == ')') {
                        stack.pop();
                    }
                }
                if (stack.isEmpty()) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } catch (EmptyStackException ese) {
                System.out.println("NO");
            }
        }
    }
}
