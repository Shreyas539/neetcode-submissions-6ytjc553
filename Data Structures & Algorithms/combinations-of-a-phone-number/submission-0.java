class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Integer,String> mp = new HashMap<>();
        mp.put(2,"abc");
        mp.put(3,"def");
        mp.put(4,"ghi");
        mp.put(5,"jkl");
        mp.put(6,"mno");
        mp.put(7,"pqrs");
        mp.put(8,"tuv");
        mp.put(9,"wxyz");

         List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;

        backtrack(0, mp, digits, new StringBuilder(), res);
        return res;

    }
    private void backtrack(int start, HashMap<Integer, String> mp, String digits,
                           StringBuilder cur, List<String> res) {
        if (start == digits.length()) {
            res.add(cur.toString());
            return;
        }

        int digit = digits.charAt(start) - '0';
        String letters = mp.get(digit);

        for (char c : letters.toCharArray()) {
            cur.append(c);
            backtrack(start + 1, mp, digits, cur, res);
            cur.deleteCharAt(cur.length() - 1); // backtrack
        }
    }
}
