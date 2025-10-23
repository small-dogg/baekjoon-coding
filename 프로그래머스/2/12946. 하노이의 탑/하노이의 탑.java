import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] solution(int n) {
        //한번에 하나의 원판만 옮길 수 있다.
        //큰 원판이 작은 원판 위에 있어서는 안된다.
        //재귀로 풀어야한다고 생각하는 이유 : 원판 하나를 하나의 기둥에서 다른 기둥으로 옮기는 것을 반복하여 해결한다.

        /**
         * 상태
         * 원판 n개를 기둥 1에서 기둥 3으로 옮기는 과정
         * 옮기려는 원판의 개수 n
         * 원판이 현재 있는 기둥 : from
         * 옮겨갈 기둥 : to
         * 상태 - (n, from, to) : 원판 n개를 from에서 to로 옮기는 과정
         */

        /**
         * 종료조건
         * 원판 1개만 옮길 때.
         * (1, from, to) = [[from, to]]
         */

        /**
         * 점화식
         * (n, from, to) = (n-1, from, empty) + (1, from, to) + (n-1, empty, to)
         * 단, empty = 6 - from - to
         */

        return hanoi(n, 1, 3).toArray(new int[0][]);
    }
    
    private List<int[]> hanoi(int n, int from, int to) {
        // n == 1 일때, from에서 to로 이동만 하면 됨
        if(n == 1) return List.of(new int[]{from, to});

        // 점화식 구현
        int empty = 6 - from - to;
        List<int[]> result = new ArrayList<>();
        result.addAll(hanoi(n-1, from, empty));
        result.addAll(hanoi(1, from, to));
        result.addAll(hanoi(n-1, empty, to));
        return result;
    }
}