import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i : ingredient) {
            sb.append(i);

            if (sb.length() > 3 && sb.substring(sb.length() - 4, sb.length()).equals("1231")) {
                cnt++;
                sb.delete(sb.length() - 4, sb.length());
            }
        }

        return cnt;
    }
}