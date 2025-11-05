import java.util.*;

class Solution {
    public int solution(int[][] triangle) {

        //삼각형의 높이는 최대 500
        int[][] memo = new int[501][501];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }

        return getMaxSum(0, 0, triangle, memo);
    }

    private int getMaxSum(int y, int x, int[][] triangle, int[][] memo) {
        if (y == triangle.length - 1) {
            return triangle[y][x];
        }

        if (memo[y][x] != -1) return memo[y][x];

        int down = getMaxSum(y + 1, x, triangle, memo);
        int downRight = getMaxSum(y + 1, x + 1, triangle, memo);

        return memo[y][x] = triangle[y][x] + Math.max(down, downRight);
    }
}