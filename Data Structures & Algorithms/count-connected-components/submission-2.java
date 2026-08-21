class Solution {
    int[] parent;
    int count ;
    public int countComponents(int n, int[][] edges) {
        count = n;
        parent = new int[n];

        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        for(int[] edge:edges ){
            union(edge[0],edge[1]);
        }
        return count;
    }
    
    private void union(int a,int b){
        int rootA = find(a);
        int rootB = find(b);
       
        if(rootA!=rootB){
            count--;
        }
        parent[rootB] = rootA;

    }

    private int find(int x){
        if(parent[x]==x){
            return x;
        }
        return parent[x] = find(parent[x]);
    }
}
