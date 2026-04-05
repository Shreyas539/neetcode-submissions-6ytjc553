class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ans=0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
               if(grid[i][j]==1){
                 int temp = dfs(grid,i,j);
                ans = Math.max(temp,ans);
               }
            }
        }
        return ans;
    }

    private int dfs(int[][] grid,int i,int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]!=1){
            return 0;
        }
            int area = 1;
            grid[i][j]=0;
        area+=dfs(grid,i-1,j);
        area+=dfs(grid,i,j-1);
        area+=dfs(grid,i+1,j);
        area+=dfs(grid,i,j+1);

        return area;
    }
}
