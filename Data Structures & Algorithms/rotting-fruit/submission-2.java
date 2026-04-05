class Solution {
    public int orangesRotting(int[][] grid) {
        
       int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int freshCount = 0;

        // Directions: up, left, down, right
        int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}};

        // Step 1: Add all rotten fruits to queue and count fresh fruits
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        if (freshCount == 0) return 0; // no fresh fruits

        int minutes = -1;

        // Step 2: BFS layer by layer
        while (!q.isEmpty()) {
            int size = q.size();
            minutes++;
            for (int s = 0; s < size; s++) {
                int[] cell = q.poll();
                int r = cell[0], c = cell[1];

                for (int[] d : dir) {
                    int nr = r + d[0], nc = c + d[1];
                    if (nr < 0 || nc < 0 || nr >= m || nc >= n || grid[nr][nc] != 1) {
                        continue;
                    }
                    grid[nr][nc] = 2; // rot the fresh fruit
                    freshCount--;
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        return freshCount == 0 ? minutes : -1;
    }
}
