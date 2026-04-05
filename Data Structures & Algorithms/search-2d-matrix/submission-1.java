class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l=0;
        int m = matrix.length;
        int n = matrix[0].length;
        int h=m * n -1;

        while(l<=h){
            int mid = l + (h-l)/2;
            int row = mid/n;
            int col = mid%n;

            int val = matrix[row][col];

            if(val == target){
                return true;
            }else if(val<target){
                l=mid+1;
            }else{
                h=mid-1;
            }
        }
        return false;
    }
}
