class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] vis = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);

        pq.offer(new int[]{grid[0][0],0,0});
int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int ans=0;
        while(!pq.isEmpty()){
            
            int[] cur = pq.poll();
            int elev = cur[0],r=cur[1],c=cur[2];

            ans=Math.max(ans,elev);

            if(r==n-1 && c==n-1) return ans;
            if(vis[r][c]) continue;
            vis[r][c]=true;

            for(int[] d:dirs){
                int nr=r+d[0],nc=c+d[1];
                if(nr>=0 && nr<n && nc>=0 && nc<n && !vis[nr][nc]){
                    pq.offer(new int[]{grid[nr][nc],nr,nc});
                }
            }

        }
            return -1;
    }
}
