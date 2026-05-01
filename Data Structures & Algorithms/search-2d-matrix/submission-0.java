class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l=0;
        int m = matrix.length;
        int h=m * matrix[0].length -1;

        while(l<=h){
            int mid = l + (h-l)/2;
            int row = mid/m;
            int col = mid%m;

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
