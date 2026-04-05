class Solution {
    public void solve(char[][] board) {
        int m = board.length,n=board[0].length;
        // left
        for(int i=0;i<m;i++){
            if(board[i][0]=='O'){
                dfs(board,i,0,n,m);
            }
        }
        // top
        for(int i=0;i<n;i++){
            if(board[0][i]=='O'){
                dfs(board,0,i,n,m);
            }
        }
        // bottom
        for(int i=0;i<n;i++){
            if(board[m-1][i]=='O'){
                dfs(board,m-1,i,n,m);
            }
        }
        // right
        for(int i=0;i<m;i++){
            if(board[i][n-1]=='O'){
                dfs(board,i,n-1,n,m);
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }else if(board[i][j]=='#'){
                    board[i][j]='O';
                }
            }
        }
    }
    private void dfs(char[][] board,int i,int j,int n,int m){
        if(i<0 ||j<0 || i>=m || j>=n || board[i][j]!='O'){
            return;
        }
        board[i][j]='#';
        dfs(board,i-1,j,n,m);
        dfs(board,i,j-1,n,m);
        dfs(board,i+1,j,n,m);
        dfs(board,i,j+1,n,m);
    }
}
