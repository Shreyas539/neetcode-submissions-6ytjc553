class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> gp = new ArrayList<>();
        for(int i=0;i<=n;i++){
            gp.add(new ArrayList<>());
        }

        for(int[] edge:times){
            gp.get(edge[0]).add(new int[]{edge[1],edge[2]});
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.offer(new int[]{k,0});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int node = cur[0],time = cur[1];

            if(time>dist[node]) continue;

            for(int[] nbr:gp.get(node)){
                int next = nbr[0],wt=nbr[1];
                if(time+wt<dist[next]){
                    dist[next] = time+wt;
                    pq.offer(new int[]{next,dist[next]});
                }
            }
        }

        int max=0;
        for(int i=1;i<=n;i++) {
            if(dist[i]==Integer.MAX_VALUE)return -1;
            max = Math.max(max,dist[i]);
        }
        return max;


    }
}
