class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        int l=0;
        int r=0;

        int[] freq = new int[26];

        for(char ch:s1.toCharArray()){
            freq[ch-'a']++;
        }

        for(r=0;r<s2.length();r++){
            char ch = s2.charAt(r);

            freq[ch-'a']--;

            while((r-l+1)>s1.length()){
                freq[s2.charAt(l)-'a']++;
                l++;
            }

            if(allZero(freq)){
                return true;
            }
        }
        return false;
    }

    public boolean allZero(int[] freq){
        for(int num:freq){
            if(num!=0){
                return false;
            }
        }
        return true;
    }
}
