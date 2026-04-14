class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> memo = new HashMap<>();
        return dfs(0, 0, nums, target ,memo);

    }
    private int dfs(int i, int sum, int[] nums, int target,Map<String, Integer>  memo) {
        if (i == nums.length) {
            return sum == target ? 1 : 0;
        }
        String key = i + "," + sum;
        if (memo.containsKey(key)) return memo.get(key);

        int add = dfs(i+1, sum + nums[i], nums, target,memo);
        int subtract = dfs(i+1, sum - nums[i], nums, target,memo);

        int ways = add + subtract;
        memo.put(key, ways);
        return ways;
    }
}
