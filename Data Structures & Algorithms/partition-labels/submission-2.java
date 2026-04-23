class Solution {
    public List<Integer> partitionLabels(String s) {
         int n = s.length();
        int[] lastIndex = new int[26];
        
        // Step 1: Record the last occurrence of each character
        for (int i = 0; i < n; i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        
        List<Integer> result = new ArrayList<>();
        int partitionEnd = 0;
        int partitionSize = 0;
        
        // Step 2: Greedy partitioning
        for (int i = 0; i < n; i++) {
            partitionEnd = Math.max(partitionEnd, lastIndex[s.charAt(i) - 'a']);
            partitionSize++;
            
            // When we reach the partition end, finalize this partition
            if (i == partitionEnd) {
                result.add(partitionSize);
                partitionSize = 0;
            }
        }
        
        return result;
    }
}
