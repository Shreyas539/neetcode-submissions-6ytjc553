class Solution {
    public int[] twoSum(int[] nums, int t) {
        HashMap<Integer,Integer> m = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int complement = t - nums[i];
            if(m.containsKey(complement)){
                int j = m.get(complement);

                if(j<i) {
                    return new int[]{j,i};
                }else{
                    return new int[]{i,j};
                }
            }
            m.put(nums[i],i);
        }
        return new int[]{-1, -1};
    }
}
