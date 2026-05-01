class Solution {
    public int minCostConnectPoints(int[][] points) {
        
        int n = points.length;
        boolean[] vis = new boolean[n];
        int edgesUsed = 0;
        int cost=0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{0,0});

        while(edgesUsed<n){
            int[] cur = pq.poll();
            int wt = cur[0], u=cur[1];

            if(vis[u]) continue;
            vis[u]=true;
            cost+=wt;
            edgesUsed++;

            for(int v=u;v<n;v++){
                if(!vis[v]){
                
                    int dist = Math.abs(points[u][0]-points[v][0])+
                    Math.abs(points[u][1]-points[v][1]);
                    pq.offer(new int[]{dist,v});
                }
            }
        }
        return cost;
    }
}
