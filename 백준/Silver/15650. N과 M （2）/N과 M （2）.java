import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //n과 m이 주어졌을때, 1부터 n까지 자연수중에 중복없이 m개를 고른 수열
        //중복없는 조합
        comb(n, m, 1, new ArrayList<>());
    }

    private static void comb(int n, int m, int start, List<Integer> now) {
        if (now.size() == m) {
            for (int x : now) System.out.print(x + " ");
            System.out.println();
            return;
        }
        // 가지치기(Optional): i의 상한을 줄여서 불필요한 탐색 제거
        for (int i = start; i <= n - (m - now.size()) + 1; i++) {
            now.add(i);
            comb(n, m, i + 1, now); // 다음은 i보다 큰 수만
            now.remove(now.size() - 1);
        }
    }
}
