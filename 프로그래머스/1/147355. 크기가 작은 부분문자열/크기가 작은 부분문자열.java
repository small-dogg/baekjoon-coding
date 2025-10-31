class Solution {
    public int solution(String t, String p) {

        int result = 0;
        long parseP = Long.parseLong(p);

        int left = 0;
        int right = p.length();
        while (true) {
            if (t.length() < right) {
                return result;
            }

            if (parseP >= Long.parseLong(t.substring(left, right))) {
                result++;
            }
            left++;
            right++;
        }
    }
}