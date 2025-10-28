import java.util.Arrays;
import java.util.stream.Collectors;
// 풀이수준 : B
class Solution {
    public String solution(int[] numbers) {
        return Arrays.stream(numbers)
                .mapToObj(String::valueOf) //int 배열을 String 배열로 변환
                .sorted((s1, s2) -> {
                    //s1 과 s2를 이어붙혔을 때 더 큰 대상으로 의사결정
                    return Integer.parseInt(s2 + s1) - Integer.parseInt(s1 + s2);
                })
                .collect(Collectors.joining()) //문자열 이어 붙히기
                .replaceAll("^0+", "0"); //전방 배치된 0 모두 제거
    }
}