class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum=0;
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        for(int i=0;i<n-1;i++){
            int sum=nums[i];
            for(int j=i+1;j<n;j++){
                sum+=nums[j];
            }
            maxSum=Math.max(sum,maxSum);
        }

        return maxSum;
    }
}
