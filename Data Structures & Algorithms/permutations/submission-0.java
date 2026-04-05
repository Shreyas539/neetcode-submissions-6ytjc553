class Solution {
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> cur = new ArrayList<>();
        backtrack(nums,used,res,cur);
        
        return res;
    }

    private void backtrack(int[] nums,boolean[] used,List<List<Integer>> res,ArrayList<Integer> cur){
        if(cur.size()==nums.length){
            res.add(new ArrayList<>(cur));
        }
            
        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            used[i]=true;
            cur.add(nums[i]);
            backtrack(nums,used,res,cur);

            used[i]=false;
            cur.remove(cur.size()-1);
        }
    }
}
