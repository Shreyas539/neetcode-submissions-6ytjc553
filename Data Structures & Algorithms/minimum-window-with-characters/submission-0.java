class Solution {
    public String minWindow(String s, String t) {
        int[] ms = new int[256];
        int[] mt = new int[256];

        for(char ch:t.toCharArray()){
            mt[ch]++;
        }

        int left = 0, minLen = Integer.MAX_VALUE, minStart = 0;
        int right =0;

        for(;right<s.length();right++){
            ms[s.charAt(right)]++;

            while(contains(ms,mt)){
                if(right-left+1 < minLen){
                    minLen = right-left+1;
                    minStart = left;
                }
                ms[s.charAt(left++)]--;
            }
        }

        return minLen==Integer.MAX_VALUE ? "" : s.substring(minStart,minStart+minLen);

    }

    private boolean contains(int[] mapS,int[] mapT){
        for(int i=0;i<256;i++){
            if(mapT[i]>mapS[i]){
                return false;
            }
        }
        return true;
    }
}
