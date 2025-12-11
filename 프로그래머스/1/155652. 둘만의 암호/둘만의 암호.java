import java.util.*;

class Solution {

    public String solution(String s, String skip, int index) {
        Set<Character> set = new HashSet<>();
        for (char c : skip.toCharArray()) {
            set.add(c);
        }

        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            for (int i = 0; i < index; i++) {
                c++;
                if (c > 'z') c -= 26;
                if (set.contains(c)) i--;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}