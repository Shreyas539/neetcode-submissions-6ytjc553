class Solution {
    public int[] countBits(int n) {
        
        int[] bits = new int[n+1];

        for(int i=1;i<=n;i++){
            
            bits[i] = bits[i>>1] + (i % 2 == 0 ? 0 : 1);
        }

        return bits;


    }
}
