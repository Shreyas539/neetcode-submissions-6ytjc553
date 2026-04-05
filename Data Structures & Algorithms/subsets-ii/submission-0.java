class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums,0,res,new ArrayList<>());
        return res;
    }
    private void backtrack(int[] nums,int start,List<List<Integer>> res,List<Integer> cur){
        res.add(new ArrayList<>(cur));

        for(int i=start;i<nums.length;i++){
            if(i>start && nums[i]==nums[i-1])continue;

            cur.add(nums[i]);
            backtrack(nums,i+1,res,cur);
            cur.remove(cur.size()-1);
        }
    }
}
