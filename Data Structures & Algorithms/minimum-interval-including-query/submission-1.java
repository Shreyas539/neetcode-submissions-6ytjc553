class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int n = intervals.length;
        int j=0;
        int[] dp = new int[queries.length];
        for(int q:queries){
            int minLen=Integer.MAX_VALUE;

            for(int[] interval:intervals){
                if(interval[0]<=q && q <=interval[1]){
                    int len = interval[1]-interval[0]+1;
                    
                    
                    minLen=Math.min(minLen,len);
                    
                    
                }
            }
            dp[j]=minLen== Integer.MAX_VALUE ? -1 : minLen;
            j++;
        }

        return dp;
    }
}
