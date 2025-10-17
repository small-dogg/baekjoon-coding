import java.io.*;

public class Main {

    static int maxScore = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] males = new String[n];
        String[] females = new String[n];

        boolean[] used = new boolean[n];
        String[] perm = new String[n];

        for (int i = 0; i < n; i++) {
            males[i] = br.readLine();
        }
        for (int i = 0; i < n; i++) {
            females[i] = br.readLine();
        }

        generatePermutations(males, females, used, perm,0);

        System.out.println(maxScore);
    }

    static void generatePermutations(String[] A, String[] B, boolean[] used, String[] perm, int depth) {
        if (depth == B.length) {
            int score = calculateTotalDifference(A, perm);
            if (score > maxScore) {
                maxScore = score;
            }
            return;
        }

        for (int i = 0; i < B.length; i++) {
            if (!used[i]) {
                used[i] = true;
                perm[depth] = B[i];
                generatePermutations(A, B, used, perm, depth + 1);
                used[i] = false;
            }
        }
    }

    static int differenceScore(String mbti1, String mbti2) {
        int diffCount = 0;
        for (int i = 0; i < mbti1.length(); i++) {
            if (mbti1.charAt(i) != mbti2.charAt(i)) {
                diffCount++;
            }
        }
        return diffCount;
    }

    static int calculateTotalDifference(String[] A, String[] perm) {
        int total = 0;
        for (int i = 0; i < A.length; i++) {
            total += differenceScore(A[i], perm[i]);
        }
        return total;
    }
}