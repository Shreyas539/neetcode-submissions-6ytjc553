class Solution {
    public int characterReplacement(String s, int k) {
        int l=0;
        int nor = 0;
        int maxlen =0;

        for(int r=0;r<s.length();r++){
            char rc = s.charAt(r);

            if(rc!=s.charAt(l)){
                if(nor<k){
                    nor++;

                }else{
                    l=r;
                    nor=0;
                }
            }

            maxlen = Math.max(maxlen,r-l+1);
        }
        return maxlen;
    }
}
