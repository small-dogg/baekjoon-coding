import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> gears = new ArrayList<>();
        //1. 4개의 톱니배열 만들기
        for (int i = 0; i < 4; i++) {
            String s = br.readLine().trim();
            List<Integer> gear = new ArrayList<>(8);
            for (char c : s.toCharArray()) gear.add(c - '0');
            gears.add(gear);
        }

        //2. 명령 처리 흐름
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int target = Integer.parseInt(st.nextToken()) - 1;
            int direction = Integer.parseInt(st.nextToken());

            int[] dir = new int[4];
            dir[target] = direction;


            //좌측 회전 방향 정의
            int left = target - 1;
            int nowDirection = direction;
            while (left >= 0) {
                if (!gears.get(left + 1).get(6).equals(gears.get(left).get(2))) {
                    dir[left] = nowDirection = -nowDirection;
                    left -= 1;
                } else {
                    break;
                }
            }

            //우측 회전 방향 정의
            int right = target + 1;
            nowDirection = direction;
            while (right < 4) {
                if (!gears.get(right - 1).get(2).equals(gears.get(right).get(6))) {
                    dir[right] = nowDirection = -nowDirection;
                    right += 1;
                } else {
                    break;
                }
            }

            //톱니바퀴 회전처리
            for (int j = 0; j < dir.length; j++) {
                if (dir[j] == 1) rotateRight(gears.get(j));
                else if (dir[j] == -1) rotateLeft(gears.get(j));
            }
        }

        int score = 0;
        for (int i = 0; i < 4; i++) {
            if (gears.get(i).get(0) == 1) score += (int) Math.pow(2, i); // 1,2,4,8 가중치
        }
        System.out.println(score);
    }

    private static void rotateRight(List<Integer> g) {
        Integer last = g.remove(7);
        g.add(0, last);
    }

    private static void rotateLeft(List<Integer> g) {
        Integer first = g.remove(0);
        g.add(first);
    }
}
