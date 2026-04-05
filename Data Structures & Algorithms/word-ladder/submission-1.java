class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        
        if(!set.contains(endWord)) return 0;

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int steps=1;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){

            String word = q.poll();
            if(word.equals(endWord)) return steps;
            char[] chars = word.toCharArray();

            for(int j=0;j<chars.length;j++){
                char org=chars[j];
                for(char c = 'a';c<='z';c++){
                    if(c==org) continue;
                    chars[j]= c;
                    String newWord = new String(chars);
                    if(set.contains(newWord)){
                        q.offer(newWord);
                        set.remove(newWord);
                    }
                }
                chars[j]=org;
            }
            }
            steps++;
        }
        return 0;
    }
}
