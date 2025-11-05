import java.util.*;
//다시풀어보기.
class Solution {
    public int solution(int[] elements) {
        //1. 배열 이어붙히기 (배열을 이어붙힐 생각을 못했음)
        int n = elements.length;
        int[] extend = new int[n * 2];
        for (int i = 0; i < elements.length; i++) {
            extend[i] = elements[i];
            extend[i + elements.length] = elements[i];
        }

        //2. 부분합
        int[] prefix = new int[extend.length + 1];
        for (int i = 1; i < extend.length; i++) {
            prefix[i] = prefix[i - 1] + extend[i - 1];
        }

        Set<Integer> sums = new HashSet<>();

        for (int len = 1; len <= n; len++) {    // 부분 수열 길이
            for (int start = 0; start < n; start++) {   // 시작 위치
                int end = start + len;                 // 끝 인덱스 (exclusive)
                int sum = prefix[end] - prefix[start]; // 구간합
                sums.add(sum);
            }
        }


        return sums.size();
    }
}