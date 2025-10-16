import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

class Top {
    int num;
    int height;

    public Top(int num, int height) {
        this.num = num;
        this.height = height;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Stack<Top> stack = new Stack<>();
        int cnt = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= cnt; i++) {
            int height = Integer.parseInt(st.nextToken());

            if (stack.isEmpty()) {
                sb.append("0").append(" ");
                stack.push(new Top(i, height));
            } else {
                while (true) {
                    if (stack.isEmpty()) {
                        sb.append("0").append(" ");
                        stack.push(new Top(i, height));
                        break;
                    }

                    Top top = stack.peek();

                    if (top.height > height) {
                        sb.append(top.num).append(" ");
                        stack.push(new Top(i, height));
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
        }

        bw.write(String.valueOf(sb)+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}