class Solution {
    public int[] solution(String s) {
        int[] result = new int[s.length()];
        result[0] = -1;
        for (int i = 1; i < s.length(); i++) {
            int cnt = 0;
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    cnt = i-j;
                }
            }
            result[i] = cnt==0?-1:cnt;
        }

        return result;
    }
}