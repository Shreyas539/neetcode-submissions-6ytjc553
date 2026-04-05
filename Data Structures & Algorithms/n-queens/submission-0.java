class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for(char[] row:board){
            Arrays.fill(row,'.');
        }

        backtrack(0,board,res,n);
        return res;
    }

    private void backtrack(int row,char[][] board,List<List<String>> res,int n){
        if(row==n){
            res.add(construct(board));
        }

        for(int col=0;col<n;col++){
            if(isSafe(row,col,board,n)){
                board[row][col]='Q';
                backtrack(row+1,board,res,n);
                board[row][col]='.';
            }
        }
    }

    private boolean isSafe(int row,int col,char[][] board,int n){

        for(int i=0;i<n;i++){
            if(board[i][col]=='Q'){
                return false;
            }
        }

        for(int i=row-1,j=col-1;i>=0 && j>=0 ; i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }

        for(int i=row-1,j=col+1;i>=0 && j<n;i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }

        return true;
    }

    private List<String> construct(char[][] board){
        List<String> temp = new ArrayList<>();

        for(char[] row:board){
            temp.add(new String(row));
        }
        return temp;
    }
}
