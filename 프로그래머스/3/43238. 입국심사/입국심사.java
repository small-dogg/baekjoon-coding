import java.util.*;
//풀이수준 : B (이해가 많이 된편)
class Solution {
    public long solution(int n, int[] times) {
        //시간 범위 설정 -> mid 시간에 처리 가능한 인원 계산 -> 가능/불가능에 따라 범위 축소 -> 최소 시간

        //제일 오래걸리는 심사관이 모든 인원을 해결할때 걸리는 시간이 right임.
        long left = 1;
        long right = (long) Arrays.stream(times).max().orElse(0) * n;

        //최대값으로 초기화
        long answer = right;

        while (left <= right) {
            //overFlow를 방지하는 중간값 계산
            long mid = left + (right - left) / 2;

            if (canFinish(mid, times, n)) { //시간범위안에 있음
                answer = mid; // 일단 후보
                right = mid - 1; // 중간지점 빼고 그 바로 밑에 값을 right로 재선정
            } else {//시간 부족
                left = mid + 1;
            }
        }
        
        return answer;
    }

    //중간 시간 범위에서 모든 사람을 심사할 수 있는지 검증
    //각 심사관마다 중간 시간을 나누고 모두 더하면 중간시간대까지 모든 심사관이 처리한 사람 수를 구할 수 있다.
    private boolean canFinish(long mid, int[] times, int n) {
        long sum = 0;
        for (long time : times) {
            sum += mid / time;
            if (sum >= n) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        new Solution().solution(6, new int[]{7, 10});
    }
}