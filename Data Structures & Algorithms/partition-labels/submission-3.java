class Solution {
    public List<Integer> partitionLabels(String s) {
        
        HashMap<Character,Integer> lastIdxOfCharacter = new HashMap<>();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            lastIdxOfCharacter.put(ch,i);
        }

        int end=0;
        int size=0;
        List<Integer> res= new ArrayList<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            size++;
            end=Math.max(end,lastIdxOfCharacter.get(ch));

            if(end==i){
                res.add(size);
                size=0;
            }
        }

        return res;
    }
}
