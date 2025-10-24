class Solution {
    
    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    
    public int[][] solution(int n) {
        int[][] arr = new int[n][n];
        boolean[][] visited = new boolean[n][n];


        int x = 0;
        int y = 0;

        int d = 0;

        for (int i = 1; i <= n * n; i++) {
            arr[y][x] = i;
            visited[y][x] = true;

            //다음 x,y
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[ny][nx]) {
                d = (d + 1) % 4;
                //바뀐방향으로 다음 x,y
                nx = x + dx[d];
                ny = y + dy[d];
            }

            x = nx;
            y = ny;
        }
        return arr;
    }
}