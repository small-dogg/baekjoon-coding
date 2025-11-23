class Solution {
    static int[] memo;
    public int solution(int n) {
        memo = new int[n+1];
        
        return fibo(n);
    }
    
    private int fibo(int n){
        if(n<4) return n;
        
        if(memo[n] != 0) return memo[n];
        
        memo[n] = (fibo(n-2) + fibo(n-1))%1_000_000_007;
        
        return memo[n];
    }
}

