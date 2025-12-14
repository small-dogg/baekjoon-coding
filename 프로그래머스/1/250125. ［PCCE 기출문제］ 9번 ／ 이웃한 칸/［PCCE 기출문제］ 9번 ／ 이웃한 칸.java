import java.util.*;

class Solution {

    private final static int[] dx = {-1, 1, 0, 0};
    private final static int[] dy = {0, 0, -1, 1};

    public int solution(String[][] board, int h, int w) {
        int result = 0;

        String color = board[h][w];
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + h;
            int ny = dy[i] + w;

            if(nx <0 || nx > board.length -1 ||  ny < 0 || ny > board[0].length -1) continue;

            if(color.equals(board[nx][ny])) result++;
        }
        return result;
    }

}