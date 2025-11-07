import java.util.*;
class Solution {
    private final int[][] maxMem = new int[202][202];
    private final int[][] minMem = new int[202][202];

    public int solution(String[] arr) {
        for (int i = 0; i < maxMem.length; i++) {
            Arrays.fill(maxMem[i], Integer.MIN_VALUE);
            Arrays.fill(minMem[i], Integer.MIN_VALUE);
        }
        return max(0, arr.length, arr);
    }

    private int max(int start, int end, String[] arr) {
        //메모이제이션 검사
        if (maxMem[start][end] != Integer.MIN_VALUE) return maxMem[start][end];

        //더이상 계산할 수 있는 길이가 아니기 때문에, 좌측을 반환
        if (end - start == 1) return Integer.parseInt(arr[start]);
        int max = Integer.MIN_VALUE;
        //연산자의 위치만큼 반복
        for (int i = start + 1; i < end; i += 2) {
            //좌측 피연산자 계산
            int left = max(start, i, arr);
            int v;
//            (i를 기준으로 우측 피연산자 계산)
            if (arr[i].equals("+")) {
                //양수기 떄문에 우측 피연산자가 클수록 좋음
                int right = max(i + 1, end, arr);
                v = left + right;
            } else {
                //음수기 떄문에 우측 피연산자가 작을수록 좋음
                int right = min(i + 1, end, arr);
                v = left - right;
            }
            max = Math.max(max, v);
        }
        return maxMem[start][end] = max;
    }

    private int min(int start, int end, String[] arr) {
        if (minMem[start][end] != Integer.MIN_VALUE) return minMem[start][end];

        if (end - start == 1) return Integer.parseInt(arr[start]);
        int min = Integer.MAX_VALUE;
        for (int i = start + 1; i < end; i += 2) {
            int left = min(start, i, arr);
            int v;
            if (arr[i].equals("+")) {
                int right = min(i + 1, end, arr);
                v = left + right;
            } else {
                int right = max(i + 1, end, arr);
                v = left - right;
            }
            min = Math.min(min, v);
        }
        return minMem[start][end] = min;
    }
}