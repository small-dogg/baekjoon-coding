class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int idx1 = 0;
        int idx2 = 0;
        for (String s : goal) {
            if(idx1 != -1 &&cards1[idx1].equals(s)){
                if (cards1.length - 1 > idx1) {
                    idx1++;
                }else {
                    idx1 = -1;
                }
            }else if(idx2 != -1 && cards2[idx2].equals(s)){
                if (cards2.length - 1 > idx2) {
                    idx2++;
                }else {
                    idx2 = -1;
                }
            }else {
                return "No";
            }
        }
        return "Yes";
    }
}