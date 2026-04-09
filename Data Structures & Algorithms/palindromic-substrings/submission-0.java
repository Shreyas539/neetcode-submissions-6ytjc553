class Solution {
    public int countSubstrings(String s) {
        int cnt=0;

        for(int i=0;i<s.length();i++){
            cnt+=expandAroundCenter(s,i,i);
            cnt+=expandAroundCenter(s,i,i+1);
        }

        return cnt;
    }
    private int expandAroundCenter(String s,int left,int right){
        int count=0;
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            count++;
            left--;
            right++;
        }
        return count;
    }
}
