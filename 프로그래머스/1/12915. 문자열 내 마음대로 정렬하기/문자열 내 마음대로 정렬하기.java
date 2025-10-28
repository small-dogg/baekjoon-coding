import java.util.Arrays;

// 풀이수준 : A
class Solution {
    public String[] solution(String[] strings, int n) {
        return Arrays.stream(strings)
                .sorted((s1,s2) -> {
                    if(s1.charAt(n)-s2.charAt(n) == 0) {
                        return s1.compareTo(s2);
                    }
                    return s1.charAt(n)-s2.charAt(n);
                })
                .toArray(String[]::new);              

    }
}