import java.util.*;

class Solution {
    private final static int[][] mem = new int[501][501];
    
    public int solution(int[][] triangle) {
        for(int[] arr : mem){
            Arrays.fill(arr, -1);
        }
        
        return max(0, 0, triangle);
    }
    
    private int max(int x, int y, int[][] triangle) {
        if(y == triangle.length) return 0;
        if(mem[x][y] != -1) return mem[x][y];
        
        return mem[x][y] = triangle[y][x] + Math.max(
            max(x, y+1, triangle),
            max(x+1, y+1, triangle)
        );
    }
}