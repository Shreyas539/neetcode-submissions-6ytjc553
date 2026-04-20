class Solution {
    public boolean isMatch(String s, String p) {
         int n = s.length(), m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;

        // handle patterns like a*, a*b*, a*b*c* that can match empty string
        for (int j = 2; j <= m; j++) {
            if (p.charAt(j - 1) == '*' && dp[0][j - 2]) {
                dp[0][j] = true;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);

                if (pc == '.' || pc == sc) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    // zero occurrence
                    dp[i][j] = dp[i][j - 2];
                    // one or more occurrence
                    char prev = p.charAt(j - 2);
                    if (prev == '.' || prev == sc) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }

        return dp[n][m];
    }
}
