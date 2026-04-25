class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);

        int res=0;
        int prevEnd = intervals[0][1];
        for(int i=1;i<n;i++){
            if(intervals[i][0]<prevEnd){
                prevEnd = Math.min(prevEnd,intervals[i][1]);
                res++;
            }else{
                prevEnd = intervals[i][1];
            }
        }

        return res;
    }
}
