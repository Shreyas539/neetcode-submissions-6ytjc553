class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(s,0,res,new ArrayList<>());
        return res;
    }
    private void backtrack(String s,int start,List<List<String>> res,ArrayList<String> cur){
        if(start==s.length()){
            res.add(new ArrayList<>(cur));
            // return;
        }
        for(int end=start+1;end<=s.length();end++){
            String temp = s.substring(start,end);
            if(isPalindrome(temp)){
                cur.add(temp);
                backtrack(s,end,res,cur);
                cur.remove(cur.size()-1);
            }
        }
    }

    private boolean isPalindrome(String str){
        int l=0;
        int r = str.length()-1;

        while(l<r){
            if(str.charAt(l++)!=str.charAt(r--)){
                return false;
            }
        }
        return true;
    }
}
