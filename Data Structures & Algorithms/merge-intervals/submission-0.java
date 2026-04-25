class Solution {
    public int[][] merge(int[][] intervals) {
        
        int n = intervals.length;
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
       

        for(int i=1;i<n;i++){
            int[] last = res.getLast();
            if(intervals[i][0]<=last[1]){
                last[0]=Math.min(last[0],intervals[i][0]);
                last[1]=Math.max(last[1],intervals[i][1]);
            }else{
                res.add(intervals[i]);
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
