class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        HashMap<Integer,int[]> mp = new HashMap<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    // mp.put((int)Math.random(),new int[]{i,j});
                    mp.put(i+j,new int[]{i,j});
                }
            }
        }

        for(Map.Entry<Integer,int[]> e : mp.entrySet() ){
            System.out.println("key = "+e.getKey());
        }

        for(Map.Entry<Integer,int[]> e : mp.entrySet() ){
            int r = e.getValue()[0],c = e.getValue()[1];

            for(int i=0;i<n;i++){
                matrix[r][i]=0;
            }

            

                for(int i=0;i<m;i++){
                    matrix[i][c]=0;
                }
            
        }
    }
}
