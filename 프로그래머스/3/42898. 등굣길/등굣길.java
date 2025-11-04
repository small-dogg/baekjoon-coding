import java.util.*;

//풀이수준 : B-, DP 메모이제이션
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] memo = new int[101][101];
        boolean[][] isPuddle = new boolean[n + 1][m + 1];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        for (int[] puddle : puddles) {
            isPuddle[puddle[1]][puddle[0]] = true;
        }

        return goToSchool(1, 1, isPuddle, m, n, memo);
    }

    private int goToSchool(int x, int y, boolean[][] isPuddle, int m, int n, int[][] memo) {
        if (y > n || x > m || isPuddle[y][x]) return 0;
        if (memo[x][y] != -1) return memo[x][y];
        if (x == m && y == n) return 1;
        memo[x][y] = goToSchool(x + 1, y, isPuddle, m, n, memo) + goToSchool(x, y + 1, isPuddle, m, n, memo);
        return memo[x][y] %= 1_000_000_007;
    }
}