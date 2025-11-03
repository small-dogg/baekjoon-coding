import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int rows = Integer.parseInt(st.nextToken()); // N
        int cols = Integer.parseInt(st.nextToken()); // M

        int startRow = Integer.parseInt(st.nextToken()); // x (row)
        int startCol = Integer.parseInt(st.nextToken()); // y (col)
        int commandCount = Integer.parseInt(st.nextToken());

        int diceY = startRow; // row
        int diceX = startCol; // col
        int[][] map = new int[rows][cols];

        //Map 만들기
        for (int[] row : map) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < row.length; i++) {
                row[i] = Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        int[] dice = new int[6];
        for (int i = 0; i < commandCount; i++) {
            int loc = Integer.parseInt(st.nextToken());
            int nx = diceX + dx[loc-1];
            int ny = diceY + dy[loc-1];

            if (ny < 0 || ny >= rows || nx < 0 || nx >= cols) continue;
            diceX = nx;
            diceY = ny;

            roll(loc, dice);
            if(map[diceY][diceX] == 0){
                map[diceY][diceX] = dice[3];
            }else {
                dice[3] = map[diceY][diceX];
                map[diceY][diceX] = 0;
            }

            sb.append(dice[2]).append("\n");
            //주사위 굴리면서 주사위 표면 점수 만들기
        }

        System.out.println(sb);
    }

    static void roll(int dir, int[] dice) {
        // 0 : 앞, 1: 뒤, 2: 위: 3:아래, 4:왼쪽, 5:오른쪽
        int front = dice[0], back = dice[1], up= dice[2], down = dice[3], left = dice[4], right = dice[5];
        switch (dir) {
            //동
            case 1 : {
                dice[3] = right;
                dice[5] = up;
                dice[2] = left;
                dice[4] = down;
                break;
            }
            case 2 : {
                dice[2] = right;
                dice[4] = up;
                dice[3] = left;
                dice[5] = down;
                break;
            }
            case 3 : {
                dice[2] = back;
                dice[0] = up;
                dice[3] = front;
                dice[1] = down;
                break;
            }
            case 4 : {
                dice[3] = back;
                dice[1] = up;
                dice[2] = front;
                dice[0] = down;
                break;
            }
        }
    }
}
