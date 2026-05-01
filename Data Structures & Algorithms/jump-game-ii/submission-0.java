class Solution {
    public int jump(int[] nums) {
        int jmps=0;
        int n = nums.length;
        int[] dp = new int[n];

        for(int i=0;i<n;i++){
            
            dp[i]=Math.max(nums[i],nums[i]+i);
        }

        for(int num:dp){
            System.out.print(num+" ");
        }
        return dp[0];
    }
}
