class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans=0;
        int n = s.length();

        for(int i=0;i<n-1;i++){
            Set<Character> set = new HashSet<>();
            int j=0;
            for( j=i+1;j<n;j++){
                if(set.contains(s.charAt(j))){
                    break;
                }else{
                    set.add(s.charAt(j));
                }
            }

            int curWindow = j-i-1;

            ans  = Math.max(ans,curWindow);
        }
        return ans;
    }
}
