class Solution {
    public int solution(int n, int m, int[] section) {
        int count = 0;
        int next = 0;
        for (int i : section) {
            if (i > next) {
                next = i + m - 1;
                count++;
            }
        }

        return count;
    }
}