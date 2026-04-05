class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char c:tasks){
            freq[c-'A']++;
        }

        int maxFreq = 0;
        for(int i:freq){
            maxFreq= Math.max(i,maxFreq);
        }
        int cntMax =0;
        for(int i:freq){
            if(i==maxFreq){
                cntMax++;
            }
        }

        int res = (maxFreq-1)*(n+1)+cntMax;

        return Math.max(res,tasks.length);
    }
}
