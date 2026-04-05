class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length !=n-1) return false;

        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        visited[0]=true;
        int cnt=1;
        q.offer(0);
        
        while(!q.isEmpty()){
            int node = q.poll();

            for(int nbr:graph.get(node)){
                if(!visited[nbr]){
                    visited[nbr]=true;
                    q.offer(nbr);
                    cnt++;
                }
            }
        }

        return cnt==n;
    }
}
