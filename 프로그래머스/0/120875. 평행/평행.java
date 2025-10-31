import java.util.*;

class Solution {
    public int solution(int[][] dots) {
        if (isParallel(dots[0][0], dots[0][1], dots[1][0], dots[1][1], dots[2][0], dots[2][1], dots[3][0], dots[3][1])) return 1;
        if (isParallel(dots[0][0], dots[0][1], dots[2][0], dots[2][1], dots[1][0], dots[1][1], dots[3][0], dots[3][1])) return 1;
        if (isParallel(dots[0][0], dots[0][1], dots[3][0], dots[3][1], dots[1][0], dots[1][1], dots[2][0], dots[2][1])) return 1;
        return 0;
    }

    private boolean isParallel(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        return (y2 - y1) * (x4 - x3) == (y4 - y3) * (x2 - x1);
    }
}