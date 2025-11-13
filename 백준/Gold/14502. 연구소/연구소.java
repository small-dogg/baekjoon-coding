import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//백트래킹 + 그래프 탐색(혼합) : 14502 - 연구소

public class Main {

    private final static int[] dx = new int[]{-1, 1, 0, 0};
    private final static int[] dy = new int[]{0, 0, -1, 1};

    private static int[][] LAB;
    static int N;
    static int M;
    static int MAX_SAFE_AREA = 0;

    public static void main(String[] args) throws IOException {
        //3군데에 벽을 세웠을때, 바이러스 전파를 BFS또는 DFS로 시뮬레이션 후 안전영역의 최대값 구하기

        // 0 : 빈칸
        // 1 : 기존 벽
        // 2 : 바이러스

        // #1. 연구실 배열 획득
        generateLab();
        placeWall(0, 0);

        System.out.println(MAX_SAFE_AREA);
    }

    private static void placeWall(int startIdx, int count) {
        //벽 3개가 다 채워졌으면
        if (count == 3) {
            // lab 복사(바이러스가 퍼져 더렵혀진걸 다른데서 쓰면 안돼)
            int[][] copyLab = new int[N][M];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    copyLab[i][j] = LAB[i][j];
                }
            }
            // 바이러스 BFS
            bfs(copyLab);
            // 안정 영역 개수 세고 maxSafe 갱신
            int safeArea = 0;
            for (int[] ints : copyLab) {
                for (int anInt : ints) {
                    if (anInt == 0) safeArea++;
                }
            }
            MAX_SAFE_AREA = Math.max(MAX_SAFE_AREA, safeArea);
            return;
        }

        //각 배열 전체를 순회
        for (int idx = startIdx; idx < N * M; idx++) {
            int y = idx / M; // 행
            int x = idx % M; // 열

            //빈칸이면 벽세우기
            if (LAB[y][x] == 0) {
                LAB[y][x] = 1;
                placeWall(idx + 1, count + 1);
                LAB[y][x] = 0;//백트래킹
            }
        }
    }

    private static void bfs(int[][] copyLab) {
        Queue<int[]> q = new LinkedList<>();

        //바이러스 모두 큐에 넣기
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if(copyLab[y][x]==2) {
                    q.offer(new int[]{y, x});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int y = now[0];
            int x = now[1];

            for (int i = 0; i < 4; i++) {
                //이동방향 x,y
                int nx = dx[i] + x;
                int ny = dy[i] + y;

                if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
                    //만약 0이면 퍼뜨려
                    if (copyLab[ny][nx] == 0) {
                        copyLab[ny][nx] = 2;
                        q.offer(new int[]{ny, nx});
                    }
                }
            }
        }
    }

    private static void generateLab() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        for (int[] ints : arr) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < ints.length; i++) {
                ints[i] = Integer.parseInt(st.nextToken());
            }
        }
        LAB = arr;
    }
}
