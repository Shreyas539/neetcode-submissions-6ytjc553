class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int n = triplets.length;
                
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(Math.max(triplets[i][0],triplets[j][0])==target[0] &&
                Math.max(triplets[i][1],triplets[j][1])==target[1] &&
                Math.max(triplets[i][2],triplets[j][2])==target[2]
                ){
                    return true;
                }
            }
        }
        return false;
    }
}
