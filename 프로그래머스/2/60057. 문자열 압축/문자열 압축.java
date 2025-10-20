import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(String s) {
        int min = Integer.MAX_VALUE;
        for (int length = 1; length <= s.length(); length++) {
            //문자열 압축 후 가장 짧은 길이 선택
            min = Math.min(min, compress(s, length));
        }
        return min;
    }

    private List<String> split(String source, int length) {
        List<String> tokens = new ArrayList<>();
        //source를 length만큼씩 잘라 tokens 리스트에 추가
        for (int startIndex = 0; startIndex < source.length(); startIndex += length) {
            int endIndex = startIndex + length;
            if (endIndex > source.length()) endIndex = source.length();
            tokens.add(source.substring(startIndex, endIndex));
        }
        return tokens;
    }

    private int compress(String source, int length) {
        StringBuilder sb = new StringBuilder();

        int count = 0;
        String last = "";
        for (String token : split(source, length)) {
            // 압축 문자열 구성
            if (token.equals(last)) {
                //동일 토큰 count++
                count++;
            } else {
                //새로운 토큰 처리
                if (count > 1) sb.append(count);
                sb.append(last);
                last = token;
                count = 1;
            }
        }
        if (count >1) sb.append(count);
        sb.append(last);
        return sb.length();
    }
}