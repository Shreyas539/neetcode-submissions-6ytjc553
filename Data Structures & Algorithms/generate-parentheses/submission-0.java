class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<>();
        backtrack(n,n,n,"",res);
        return res;
    }
    private void backtrack(int n,int open,int close,String cur,ArrayList<String> res){
        if(open==0 && close==0){
            res.add(cur);
        }

        if(open>0){
            backtrack(n,open-1,close,cur+"(",res);
        }
        if(close>open){
            backtrack(n,open,close-1,cur+")",res);
        }
    }
}
