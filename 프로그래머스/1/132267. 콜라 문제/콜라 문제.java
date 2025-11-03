class Solution {
    public int solution(int a, int b, int n) {
        int result = 0;
        int now = n;
        while (now >= a) {
            result += now / a * b;
            now = (now / a * b) + now % a;
        }
        return result;
    }
}