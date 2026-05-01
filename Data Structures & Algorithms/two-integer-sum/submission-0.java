class Solution {
    public int[] twoSum(int[] nums, int t) {
        int i=0;
        int j=nums.length-1;
        Arrays.sort(nums);

        while(i<j){
            int sum = nums[i]+nums[j];
            if(sum==t){
                return new int[]{i, j};
            }else if(sum<t){
                i++;
            }else{
                j--;
            }
        }
        return new int[]{-1, -1};
    }
}
