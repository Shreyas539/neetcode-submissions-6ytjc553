class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<>();
        backtrack(n,0,0,new StringBuilder(),res);
        return res;
    }
    private void backtrack(int n, int open, int close, StringBuilder cur, List<String> res) {
        if (cur.length() == 2 * n) {
            res.add(cur.toString());
            return;
        }

        // Add "(" if we still have opens left
        if (open < n) {
            cur.append("(");
            backtrack(n, open + 1, close, cur, res);
            cur.deleteCharAt(cur.length() - 1); // backtrack
        }

        // Add ")" if we have more closes available than opens
        if (close < open) {
            cur.append(")");
            backtrack(n, open, close + 1, cur, res);
            cur.deleteCharAt(cur.length() - 1); // backtrack
        }
    }
}
