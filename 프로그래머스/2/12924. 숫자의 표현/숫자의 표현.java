class Solution {
    public int solution(int n) {
        int start = 1;
        int end = 1;
        int count = 0;
        int sum = 1;
        while (start <= n && end <= n) {
            if(sum < n){
                sum += ++end;
            }else if(sum > n){
                sum -= start++;
            }else{
                count++;
                sum -= start++;
            }
        }

        return count;
    }
}