import java.util.*;

class Solution {
    private static final int[] memo = new int[100_001];
    public int solution(int n) {
        Arrays.fill(memo, -1);
        
        for (int i = 0; i <= n; i++){
            fibo(n);    
        }
        
        return fibo(n);
    }
    
    private int fibo(int n) {
        if(memo[n] != -1) return memo[n];
        if(n == 0 || n == 1) return n;
        
        return memo[n] = (fibo(n - 1) + fibo(n - 2)) % 1234567;
    }
}