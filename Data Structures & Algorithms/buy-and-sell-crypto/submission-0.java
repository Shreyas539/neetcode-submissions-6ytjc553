class Solution {
    public int maxProfit(int[] prices) {
        int ans=0;
        int minP=Integer.MAX_VALUE;;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<minP){
                minP=prices[i];
            }
            ans = Math.max(prices[i]-minP,ans);
        }
        return ans;
    }
}
