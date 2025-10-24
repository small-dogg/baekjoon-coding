// 풀이수준 : B
import java.util.ArrayList;
import java.util.List;

class Solution {
    private static final char[] AEIOU = new char[]{'A', 'E', 'I', 'O', 'U'};

    public int solution(String word) {
        List<String> words = new ArrayList<>();
        generate("", words);

        return words.indexOf(word);
    }

    private void generate(String word, List<String> list) {
        // 종료조건
        if (word.length() > 5) return;

        list.add(word);
        for (char c : AEIOU) {
            generate(word + c, list);
        }
    }
}