// 풀이수준 : A
// 구현수준 : C
import java.util.ArrayList;
import java.util.List;

class Solution {
    private static final int[] SOLUTION_A = new int[]{1,2,3,4,5};
    private static final int[] SOLUTION_B = new int[]{2,1,2,3,2,4,2,5};
    private static final int[] SOLUTION_C = new int[]{3,3,1,1,2,2,4,4,5,5};
    public int[] solution(int[] answers) {
        int a = solutionA(answers);
        int b = solutionB(answers);
        int c = solutionC(answers);

        int max = Math.max(a, Math.max(b, c));
        List<Integer> result = new ArrayList<>();
        if(max == a) result.add(1);
        if(max == b) result.add(2);
        if(max == c) result.add(3);

        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
    public int solutionA(int[] answers) {
        int cnt = 0;
        for (int i = 0; i< answers.length; i++) {
            if(answers[i] == SOLUTION_A[i%5]) cnt++;
        }
        return cnt;
    }
    public int solutionB(int[] answers) {
        int cnt = 0;
        for (int i = 0; i< answers.length; i++) {
            if(answers[i] == SOLUTION_B[i%8]) cnt++;
        }
        return cnt;
    }
    public int solutionC(int[] answers) {
        int cnt = 0;
        for (int i = 0; i< answers.length; i++) {
            if(answers[i] == SOLUTION_C[i%10]) cnt++;
        }
        return cnt;
    }
}