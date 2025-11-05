import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] memo = new int[m + 1][n + 1];
        boolean[][] isPuddle = new boolean[m + 1][n + 1];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        for (int[] puddle : puddles) {
            isPuddle[puddle[0]][puddle[1]] = true;
        }

        //오른쪽 아래로만 이동
        return canArrived(1, 1, m, n, isPuddle, memo);
    }

    private int canArrived(int x, int y, int m, int n, boolean[][] isPuddle, int[][] memo) {
        if (x > m || y > n) return 0;
        if(isPuddle[x][y]) return 0;
        
        if (memo[x][y] != -1) return memo[x][y];
        if (x == m && y == n) return 1;

        int total = canArrived(x + 1, y, m, n, isPuddle, memo) + canArrived(x, y + 1, m, n, isPuddle, memo);
        return memo[x][y] = total % 1_000_000_007;
    }
}