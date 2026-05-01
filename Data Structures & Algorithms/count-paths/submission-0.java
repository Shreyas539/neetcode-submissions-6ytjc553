class Solution {
    public int uniquePaths(int m, int n) {
        // If we are at the first row or first column, there's only 1 way to get there (straight line)
    if (m == 1 || n == 1) {
        return 1;
    }
    // Total paths = paths from above + paths from the left
    return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
    }
}
