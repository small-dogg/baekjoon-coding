import java.util.*;
//풀이수준 : B, 슬라이딩 윈도우 알고리즘 다시 이해필요.
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<String, Integer> map = new HashMap<>();
        int left = 0;
        int maxLen = 0;

        Map<Character, Integer> lastIndex = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            //윈도우 안에 이미 해당 문자가 존재
            if (lastIndex.containsKey(c)) {
                int prev = lastIndex.get(c);
                if (prev >= left) {
                    left = prev + 1;
                }
            }

            lastIndex.put(c, right);

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}