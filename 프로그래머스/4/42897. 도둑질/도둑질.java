class Solution {
    public int solution(int[] money) {
        //점화식 세울때,
        //내가 i를 털면 i-1은 못털어
        //i를 터냐 안터냐로 나눠 점화식을 세워야함.
        //i를 털었을때와 안털었을때의 Math.max를 정의해주면 됨.
        //dp[i-1], dp[i-2] + money[i];
        return Math.max(
                steal(money, 0, money.length - 2),
                steal(money, 1, money.length - 1)
        );

    }

    private int steal(int[] money, int start, int end) {
        //집이 한집만 있으니깐 그집만 털면됨
        if (start == end) return money[start];
        //집이 두집만 있으니깐 두집중 큰 집만 털면됨
        if (end - start == 1) return Math.max(money[start], money[end]);

        //DP 배열 초기화
        int n = end - start + 1;
        int[] dp = new int[n];

        dp[0] = money[start];
        dp[1] = Math.max(money[start], money[start + 1]);
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + money[start + i]);
        }

        return dp[n - 1];
    }
}