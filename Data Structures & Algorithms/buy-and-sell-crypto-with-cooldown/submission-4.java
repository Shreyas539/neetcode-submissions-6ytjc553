class Solution {
    public int maxProfit(int[] arr) {
         if (arr == null || arr.length == 0) return 0;
        int n = arr.length;
         int[][] dp = new int[n][2];
        for (int[] row : dp) Arrays.fill(row, -1);
        return findProfit(0, 1, arr, dp);
    }

    int findProfit(int i, int buy, int[] arr, int[][] dp) {
        int n = arr.length;
    
        // Base case
        if (i >= n) return 0;
    
        // If already computed
        if (dp[i][buy] != -1) return dp[i][buy];
    
        // If we can buy
        if (buy == 1) {
            int take = -arr[i] + findProfit(i + 1, 0, arr, dp);
            int skip = findProfit(i + 1, 1, arr, dp);
            dp[i][buy] = Math.max(take, skip);
        }
    
        // If we can sell
        else {
            int sell = arr[i] + findProfit(i + 2, 1, arr, dp);
            int skip = findProfit(i + 1, 0, arr, dp);
            dp[i][buy] = Math.max(sell, skip);
        }
    
        return dp[i][buy];
    }
    
}
