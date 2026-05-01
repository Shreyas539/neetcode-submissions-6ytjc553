class WordDictionary {
    private class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isEod = false;
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;

        for(char c:word.toCharArray()){
            int idx = c-'a';
            if(node.children[idx]==null){
                node.children[idx]=new TrieNode();
            }
            node = node.children[idx];
        }

        node.isEod = true;
    }

    public boolean search(String word) {
        return dfs(word,0,root);
    }

    private boolean dfs(String word,int start,TrieNode node){
        if(node==null) return false;

        if(start==word.length()) return true;

        char c = word.charAt(start);

        if(c=='.'){
            for(TrieNode child:node.children){
                if(child!=null && dfs(word,start+1,child)){
                   return true;
                }
            }
            return false;
        }else{
            return dfs(word,start+1,node.children[c-'a']);
        }
    }
}
