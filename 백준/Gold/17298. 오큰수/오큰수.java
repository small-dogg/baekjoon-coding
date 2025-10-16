import java.io.*;
import java.util.*;

public class Main {
    //Monotonic Stack;단조스택
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int [] arr = new  int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n; i++) {
            while(!stack.empty() && arr[stack.peek()] < arr[i]){
                arr[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        while(!stack.empty()){
            arr[stack.pop()] = -1;
        }

        for(int i = 0; i < n; i++){
            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb);
    }
}