class Solution {
    public int[] findOrder(int nc, int[][] pq) {
        List<List<Integer>> gp = new ArrayList<>();
        for(int i=0;i<nc;i++){
            gp.add(new ArrayList<>());
        }

        for(int[] pre:pq){
            gp.get(pre[1]).add(pre[0]);
        }

        int[] vis = new int[nc];
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<nc;i++){
            if(!dfs(gp,vis,i,st)){
                return new int[0];
            }
        }
        int[] order = new int[nc];
        int idx=0;
        while(!st.isEmpty()){
            order[idx++]=st.pop();
        }
        return order;
    }

    private boolean dfs(List<List<Integer>> gp,int[] vis,int node,Stack<Integer> st){
        if(vis[node]==1) return false;
        if(vis[node]==2) return true;


        vis[node]=1;
        for(int next:gp.get(node)){
            if(!dfs(gp,vis,next,st)) return false;
        }

        vis[node]=2;
        st.push(node);
        return true;
    }
}
