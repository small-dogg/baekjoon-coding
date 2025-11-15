import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] result = new int[queries.length];

        int[][] map = new int[rows][columns];
        int idx = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = idx;
                idx++;
            }
        }

        //회전시킨 배열
        int resultIndex = 0;
        for (int[] query : queries) {
            int y1 = query[0] - 1;
            int x1 = query[1] - 1;
            int y2 = query[2] - 1;
            int x2 = query[3] - 1;


            int prev = map[y1][x1]; //이전 위치
            int minVal = prev;
            // 우로 이동
            for (int i = x1 + 1; i <= x2; i++) {
                int temp = map[y1][i];
                map[y1][i] = prev;
                prev = temp;
                minVal = Math.min(minVal,prev);
            }

            // 아래로 이동
            for (int i = y1 + 1; i <= y2; i++) {
                int temp = map[i][x2];
                map[i][x2] = prev;
                prev = temp;
                minVal = Math.min(minVal, prev);
            }

            // 좌로 이동
            for (int i = x2 - 1; i >= x1; i--) {
                int temp = map[y2][i];
                map[y2][i] = prev;
                prev = temp;
                minVal = Math.min(minVal, prev);
            }

            // 위로 이동
            for (int i = y2 - 1; i >= y1; i--) {
                int temp = map[i][x1];
                map[i][x1] = prev;
                prev = temp;
                minVal = Math.min(minVal, prev);
            }

            result[resultIndex++] = minVal;
        }
        return result;
    }
}