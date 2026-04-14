class Solution {
    public int maxProfit(int[] prices) {
         if (prices == null || prices.length == 0) return 0;

        int n = prices.length;
        int hold = -prices[0]; // holding a coin after day 0
        int sold = 0;          // profit after selling
        int rest = 0;          // profit after resting

        for (int i = 1; i < n; i++) {
            int prevHold = hold;
            int prevSold = sold;
            int prevRest = rest;

            hold = Math.max(prevHold, prevRest - prices[i]);
            sold = prevHold + prices[i];
            rest = Math.max(prevRest, prevSold);
        }

        return Math.max(sold, rest);
    }
}
