class Solution {
    public List<Integer> partitionLabels(String s) {
         HashMap<Character, Integer> lastIdxOfCharacter = new HashMap<>();

        // Step 1: record last index of each character
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            lastIdxOfCharacter.put(ch, i);
        }

        int end = 0;
        int size = 0;
        List<Integer> res = new ArrayList<>();

        // Step 2: greedy partitioning
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            size++;
            end = Math.max(end, lastIdxOfCharacter.get(ch));

            if (i == end) {
                res.add(size);
                size = 0;
            }
        }

        return res;
    }
}
