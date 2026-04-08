class Solution {
    public int rob(int[] nums) {
        
        int n = nums.length;
        int[] skipF = new int[n-1];
        int[] skipL = new int[n-1];

        if (n == 1) return nums[0];
        if(n==2) return Math.max(nums[0],nums[1]);

        for(int i=0;i<n-1;i++){
            skipF[i]=nums[i+1];
            skipL[i]=nums[i];
        }

        int skipF_ans = helper(skipF);
        int skipL_ans = helper(skipL);
        return Math.max(skipF_ans,skipL_ans);
    }
    private int helper(int[] arr){
        int n = arr.length;
         if (n == 0) return 0;
        if (n == 1) return arr[0];
        int[] dp = new int[n];

        dp[0]=arr[0];
        dp[1]=Math.max(arr[0],arr[1]);

        for(int i=2;i<n;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+arr[i]);
        }
        return dp[n-1];
    }
}
