import java.util.*;
class Solution {
    private final int[][] mem = new int[101][101];
    public int solution(int m, int n, int[][] puddles) {
        for(int[] row : mem){
            Arrays.fill(row, -1);
        }
        
        boolean[][] isPuddle = new boolean[n + 1][m + 1];
        for (int[] puddle : puddles) {
            isPuddle[puddle[1]][puddle[0]] = true;
        }
        int answer = 0;
        return count(1, 1, m, n, isPuddle);
    }

    //현재 x,y 와 최대 x,y, 웅덩이
    private int count(int x, int y, int w, int h, boolean[][] isPuddle) {
        //종료조건 : 물웅덩이거나, 끝지점이거나, 위치에 도달
        if (x > w || y > h) return 0;
        if (isPuddle[y][x]) return 0;

        if (mem[x][y] != -1) return mem[x][y];
        if (x == w && y == h) return 1;

        int total = count(x + 1, y, w, h, isPuddle)
                + count(x, y + 1, w, h, isPuddle);

        return mem[x][y] = total % 1_000_000_007;
    }

    
}