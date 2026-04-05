class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> s = new HashSet<>();

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char ch = board[i][j];
                if(ch=='.') continue;
                if(!s.add(ch+"at row"+i) || !s.add(ch+"at col"+j) || !s.add(ch+"at box"+i/3+"-"+j/3)){
                    return false;
                }
            }
        }

        return true;
    }
}
