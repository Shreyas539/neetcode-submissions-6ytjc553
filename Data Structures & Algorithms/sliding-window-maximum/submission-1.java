class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int l=0;
        int r=0;
        int[] ans = new int[nums.length-k+1];
        int idx=0;
        for(;r<nums.length;r++){
            if((r-l+1) ==k){
            ans[idx++] = findHigh(nums,l,r);
                l++;
            }
        }
        return ans;
    }

    private int findHigh(int[] nums,int l,int r){
        int max=Integer.MIN_VALUE;
        for(int left=l;left<=r;left++){
            max = Math.max(max,nums[left]);
        }
        return max;
    }
}
