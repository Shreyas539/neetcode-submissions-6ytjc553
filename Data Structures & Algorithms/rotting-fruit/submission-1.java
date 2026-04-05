class Solution {
    public int orangesRotting(int[][] grid) {
        
        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int freshCount = 0;

        int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}};

        // Add rotten fruits and count fresh
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j, 0}); // store minute = 0
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        int minutes = 0;
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0], c = cell[1], minute = cell[2];
            minutes = Math.max(minutes, minute);

            for (int[] d : dir) {
                int nr = r + d[0], nc = c + d[1];
                if (nr < 0 || nc < 0 || nr >= m || nc >= n || grid[nr][nc] != 1) continue;
                grid[nr][nc] = 2;
                freshCount--;
                q.offer(new int[]{nr, nc, minute + 1});
            }
        }

        return freshCount == 0 ? minutes : -1;
    }
}
