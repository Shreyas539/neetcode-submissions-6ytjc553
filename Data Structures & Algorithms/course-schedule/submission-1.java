class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        List<List<Integer>> gp = new ArrayList<>();

        for(int i=0;i<n;i++){
            gp.add(new ArrayList<>());
        }

        for(int[] edge:prerequisites){
            int u = edge[1];
            int v = edge[0];

            gp.get(u).add(v);
            
        }

        for(int[] edge:prerequisites){
            if(dfs(edge[1],gp,new boolean[n])){
                return false;
            }
        }
        return true;
    }
    private boolean dfs(int node,List<List<Integer>> gp,boolean[] vis){
        vis[node] = true;

        for(int nei:gp.get(node)){
            if(!vis[nei]){
                return dfs(nei,gp,vis);
            }else{
                return true;
            }
        }
        return false;
    }
}
