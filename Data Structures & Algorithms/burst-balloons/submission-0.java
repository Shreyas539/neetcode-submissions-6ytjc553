class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;

        int[] arr = new int[n+2];
        arr[0] = 1;
        arr[n+1]=1;

        for(int i=0;i<n;i++){
            arr[i+1] = nums[i];
        }

        int[][] dp = new int[n+2][n+2];

        return dfs(arr,dp,1,n);
    }

    private int dfs(int[] arr,int[][] dp,int left,int right){
        if(left>right) return 0;
        if(dp[left][right]!=0) return dp[left][right];

        int maxcoins=0;
        for(int i=left;i<=right;i++){
            int coins = arr[left-1] * arr[i] * arr[right+1];

            coins+= dfs(arr,dp,left,i-1) + dfs(arr,dp,i+1,right); 

            maxcoins = Math.max(coins,maxcoins);
        }

        dp[left][right] = maxcoins;

        return maxcoins;
    }
}
