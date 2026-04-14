class Solution {
    public int maxProfit(int[] arr) {
        int n =  arr.length;
        int[][] dp = new int[n + 2][2];

        for (int i = n - 1; i >= 0; i--) {

            // When we can buy
            dp[i][1] = Math.max(-arr[i] + dp[i + 1][0], dp[i + 1][1]);

            // When we can sell
            dp[i][0] = Math.max(arr[i] + dp[i + 2][1], dp[i + 1][0]);
        }

        return dp[0][1];
    }
}
