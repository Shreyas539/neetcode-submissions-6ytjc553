class Solution {
    private int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}};
        int m ;
        int n ;

    public int longestIncreasingPath(int[][] matrix) {
         m = matrix.length;
         n = matrix[0].length;

        int[][] dp = new int[m][n];

        int len=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                len = Math.max(len,dfs(i,j,matrix,dp));
            }
        }

        return len;
    }

    private int dfs(int r,int c,int[][] matrix,int[][] dp){

        if(dp[r][c]!=0) return dp[r][c];
        int best=1;

        for(int[] d:dir){
            int nr = r+d[0];
            int nc = c+d[1];

            if(nr>=0 && nr<n && nc>=0 && nc<n && matrix[nr][nc]>matrix[r][c]){
                best = Math.max(best,1+dfs(nr,nc,matrix,dp));
            }
        }
        dp[r][c]=best;
        return best;
    }
}
