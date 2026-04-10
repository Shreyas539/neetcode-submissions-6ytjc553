class Solution {
    public int maxProduct(int[] nums) {
      int res = nums[0];
        int curMin = 1, curMax = 1;

        for (int n : nums) {
            if (n == 0) {
                curMin = 1;
                curMax = 1;
                res = Math.max(res, 0); // handle zero case
                continue;
            }

            int tmp = curMax * n;
            curMax = Math.max(n, Math.max(tmp, n * curMin));
            curMin = Math.min(n, Math.min(tmp, n * curMin));

            res = Math.max(res, curMax);
        }

        return res;  
    }
}
