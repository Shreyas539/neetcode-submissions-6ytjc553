class Solution {
    public int orangesRotting(int[][] grid) {
        int freshcnt=0;
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }else if(grid[i][j]==1){
                    freshcnt++;
                }
            }
        }

        if(freshcnt==0) return -1;
        int min=-1;

        while(!q.isEmpty()){
            int size = q.size();
            min++;
            for(int s=0;s<size;s++){
                int[] cell = q.poll();
                int r = cell[0];
                int c = cell[1];

                for(int[] d:dir){
                    int nr = r+d[0];
                    int nc = c+d[1];

                    if(nr<0 || nc<0 || nr>=m || nc>=n || grid[nr][nc]!=1){
                        continue;
                    }
                    grid[nr][nc]=2;
                    freshcnt--;
                    q.offer(new int[]{nr,nc});
                }
            }

        }

        return freshcnt == 0 ? min : -1;
    }
}
