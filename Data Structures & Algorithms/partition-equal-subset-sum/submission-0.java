class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        // if(n/2!=0){
        //     return false;
        // }

        int tsum = 0;
        for(int num:nums){
            tsum+=num;
        }

        if(tsum%2!=0) return false;

        int reqSum = tsum/2;
        int tempSum=0;
       
        return canFindSum(nums,0,reqSum);
    }

    public static boolean canFindSum(int[] arr, int index, int target) {
        // 1. Success: We reached our target
        if (target == 0) return true;
        
        // 2. Failure: No more numbers to pick, or target went negative
        if (index >= arr.length || target < 0) return false;

        // 3. Make the two choices:
        // Choice 1: Include the current number (subtract from target)
        // Choice 2: Skip the current number (target stays same)
        return canFindSum(arr, index + 1, target - arr[index]) || 
               canFindSum(arr, index + 1, target);
    }
}
