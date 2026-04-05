class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        int longest =0;

        for(int num:nums){
            set.add(num);
        }

        for(int num:set){

            if(!set.contains(num-1)){
                int curNum = num;
                int curStreak = 1;

                while(set.contains(curNum+1)){
                    curNum++;
                    curStreak++;
                }

                longest = Math.max(longest,curStreak);
            }
        }
        return longest;
    }
}
