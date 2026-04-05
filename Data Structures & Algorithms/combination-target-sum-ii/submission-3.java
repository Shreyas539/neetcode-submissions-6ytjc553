class Solution {
    public List<List<Integer>> combinationSum2(int[] c, int t) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(c);
        backtrack(c,t,0,new ArrayList<>(),res);
        return res;
    }
    private void backtrack(int[] c,int t,int start,List<Integer> cur,List<List<Integer>> res){
        if(t==0) res.add(new ArrayList<>(cur));

        if(t<0) return;
    
        for(int i=start;i<c.length;i++){
            if(i>start && c[i]==c[i-1]) continue;
            cur.add(c[i]);
            backtrack(c,t-c[i],i+1,cur,res);
            cur.remove(cur.size()-1);
        }
    }
}
