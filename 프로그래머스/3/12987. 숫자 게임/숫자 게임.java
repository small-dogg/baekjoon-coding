import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {

        Arrays.sort(A);
        Arrays.sort(B);

        int cnt = 0;

        int idx = B.length - 1;
        for (int i = A.length-1; i >= 0; i--) {
            if(B[idx]>A[i]) {
                cnt++;
                idx--;
            }

        }

        return cnt;
    }
}