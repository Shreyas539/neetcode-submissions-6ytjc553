class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> gp = new ArrayList<>();
        for(int i=0;i<n;i++){
            gp.add(new ArrayList<>());
        }

        for(int[] edge:edges){
            gp.get(edge[0]).add(edge[1]);
            gp.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int ans=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                ans++;
                bfs(i,gp,visited);
            }
        }
        return ans;
    }
    private void bfs(int node,List<List<Integer>> gp,boolean[] visited){
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);

        while(!q.isEmpty()){
            int cur = q.poll();
            for(int nbr:gp.get(cur)){
                if(!visited[nbr]){
                    visited[nbr]=true;
                    q.offer(nbr);
                }
            }
        }
    }
}
