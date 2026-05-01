class Solution {
    public int characterReplacement(String s, int k) {
        int l=0;
        int r=0;
        int[] freq = new int[26];
        int maxFreq=0;
        int maxLen=0;

        for(r=0;r<s.length();r++){
            char ch = s.charAt(r);
            freq[ch-'A']++;

            maxFreq = Math.max(maxFreq,freq[ch-'A']);

            while((r-l+1)-maxFreq>k){
                l++;
                freq[ch-'A']--;
            }

            maxLen = Math.max(maxLen,r-l+1);
        }
        return maxLen;
    }
}
