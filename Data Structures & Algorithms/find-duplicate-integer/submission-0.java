class Solution {
    public int findDuplicate(int[] nums) {
        for(int i:nums){
            if(nums[i-1]<0){
                return i;
            }
           nums[i-1]*=-1;
        }
        return 0;
    }
}
