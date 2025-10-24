// 풀이수준 : A-
class Solution {
    public int[] solution(String s) {
        String val = s;

        int changeCnt = 0;
        int totalZeroCnt = 0;
        while (true) {
            int zeroCnt = 0;

            StringBuilder sb = new StringBuilder();
            //0개수 세기 및 1 나열하기
            for (char c : val.toCharArray()) {
                if (c == '0') {
                    zeroCnt++;
                } else {
                    sb.append(c);
                }
            }

            totalZeroCnt += zeroCnt;
            if (sb.toString().equals("1")) {
                changeCnt++;
                break;
            } else {
                val = Integer.toString(sb.length(), 2);
                changeCnt++;
            }
        }

        return new int[]{changeCnt, totalZeroCnt};
    }
}