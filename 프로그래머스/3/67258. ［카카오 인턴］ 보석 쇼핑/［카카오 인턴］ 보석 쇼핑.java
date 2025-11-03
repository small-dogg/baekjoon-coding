import java.util.*;
//풀이수준 : B+ (슬라이디 윈도우 투포인터)
class Solution {
    public int[] solution(String[] gems) {

        Set<String> set = new HashSet<>(Arrays.asList(gems));
        int gemTotal = set.size();

        //슬라이딩 윈도우 투포인터
        int left = 0;
        int right = 0;

        int ansLeft = 0;
        int ansRight = gems.length - 1;
        int minLen = gems.length; // 최대 길이로 초기화

        Map<String, Integer> windows = new HashMap<>();
        while (true) {
            // 모든 보석이 들어온 상태면 left를 줄여
            if (windows.size() == gemTotal) {
                // 정답 후보 갱신
                int nowLen = right - left; // right는 "다음에 넣을 위치" 니깐 -left;
                if (nowLen < minLen) {
                    minLen = nowLen;
                    ansLeft = left;
                    ansRight = right - 1;
                }

                //왼쪽 길이 줄이기
                String leftGem = gems[left];
                windows.put(leftGem, windows.get(leftGem)-1);
                if (windows.get(leftGem) == 0) {
                    windows.remove(leftGem);
                }
                left++;
            } else {
                // 오른쪽으로 눌려 더 담아
                if (right == gems.length) {
                    break;
                }

                String rightGem = gems[right];
                windows.put(rightGem, windows.getOrDefault(rightGem, 0) + 1);
                right++;
            }
        }

        return new int[]{ansLeft + 1, ansRight + 1};
    }
}