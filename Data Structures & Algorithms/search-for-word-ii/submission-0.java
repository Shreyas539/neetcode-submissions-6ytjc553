class Solution {
    private class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();

        TrieNode root= buildTrie(words); 

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                dfs(board,root,i,j,res);
            }
        }   
        return res;
    }

    private void dfs(char[][] board,TrieNode node,int row,int col,List<String> res){
        char c = board[row][col];

        if(c=='#' || node.children[c-'a']==null){
            return ;
        }

        node = node.children[c-'a'];

        if(node.word!=null){
            res.add(node.word);
            node.word=null;
        }

        board[row][col]='#';
        if(row>0) dfs(board,node,row-1,col,res);
        if(col>0) dfs(board,node,row,col-1,res);
        if(row<board.length-1) dfs(board,node,row+1,col,res);
        if(col<board[0].length-1) dfs(board,node,row,col+1,res);
        board[row][col]=c;
    }

    private TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();

        for(String word:words){
            TrieNode node = root;

            for(char c:word.toCharArray()){
                int idx = c-'a';
                if(node.children[idx]==null){
                    node.children[idx]=new TrieNode();
                }
                node = node.children[idx];
            }
            node.word = word;
        }
        return root;
    }
}
