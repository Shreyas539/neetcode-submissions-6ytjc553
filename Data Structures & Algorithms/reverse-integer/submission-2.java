class Solution {
    public int reverse(int x) {
        boolean isNegative = false;
        
        int res =0 ;
        while(x!=0){
            int rem = x % 10;
if (res > Integer.MAX_VALUE/10  || res < Integer.MIN_VALUE ) {
                return 0;
            }
            res = res * 10 + rem; 
            // 4 * 10 + rem;
            x=x/10;
        }

       

        return  res;
    }
}
