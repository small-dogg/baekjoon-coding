class Solution {
    public int solution(int n) {
        int nOneCount =Integer.bitCount(n);
        int cnt=n+1;
        while(true){
            if(nOneCount==Integer.bitCount(cnt)){
                return cnt;
            }
            cnt++;
        }
    }
}