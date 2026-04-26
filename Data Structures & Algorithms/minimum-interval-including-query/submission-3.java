class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int n = intervals.length;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0]-b[0]);
        int[] res = new int[queries.length];

        int[][] queryWithIdx = new int[queries.length][2];

        for(int x=0;x<queries.length;x++){
            queryWithIdx[x][0]=queries[x];
            queryWithIdx[x][1]=x;
        }

        Arrays.sort(queryWithIdx,(a,b)->a[0]-b[0]);

        int i=0;
        int idxForRes = 0;
        for(int[] query:queryWithIdx){
            int q = query[0], qidx = query[1];
            while(i<n && intervals[i][0]<=q){
                int len = intervals[i][1]-intervals[i][0]+1;

                pq.offer(new int[]{len,intervals[i][1]});
                i++;
            }

            while(!pq.isEmpty() && pq.peek()[1]<q){
                pq.poll();
            }

            res[qidx] = pq.isEmpty() ? -1 : pq.peek()[0];
        }

        return res;
    }
}
