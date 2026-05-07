class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int maxRight = -1;
        int[] res = new int[n];
        for(int i=n-1;i>=0;i--){
            res[i] = maxRight;
            maxRight = Math.max(maxRight,arr[i]);
        }

        return res;
    }
}