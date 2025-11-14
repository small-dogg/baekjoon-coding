class Solution {
    public int solution(String name) {
        int answer = 0;

        //알파벳 변경 비용
        for (char c : name.toCharArray()) {
            // c-'A' : A부터 c까지의 거리
            // c - 'A' +
            answer += Math.min(c - 'A', 26 - (c - 'A'));
        }

        int length = name.length();
        int move = length - 1;

        for (int i = 0; i < length; i++) {
            int j = i + 1;
            //뒤올 대상이 A일경우, A의 길이 측정
            while (j < length && name.charAt(j) == 'A') j++;

            //우측으로 갔자가 좌측으로 이동
            int case1 = i * 2 + (length - j);

            //좌측으로갔다가 오른쪽으로 이동
            int case2 = (length - j) * 2 + i;

            move = Math.min(move, Math.min(case1, case2));
        }

        return answer + move;
    }
}