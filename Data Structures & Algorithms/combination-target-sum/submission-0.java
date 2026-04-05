class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        backtrack(nums,target,new ArrayList<>(),0,res);
        return res;
    }

    private void backtrack(int[] nums,int target,List<Integer> cur,int start,List<List<Integer>> res){
        if(target==0){
            res.add(new ArrayList<>(cur));
        }
        if(target<0)return;
        for(int i=start;i<nums.length;i++){
            cur.add(nums[i]);
            backtrack(nums,target-nums[i],cur,i,res);
            cur.remove(cur.size()-1);
        }
    }
}
