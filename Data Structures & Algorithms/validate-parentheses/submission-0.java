class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();

        for(char ch : s.toCharArray()){
            if(stk.isEmpty()){
                stk.push(ch);
            }else if((stk.peek()=='[' && ch==']') || (stk.peek()=='{' && ch=='}') || (stk.peek()=='(' && ch==')')){
                stk.pop();
            }

        }

        return stk.isEmpty() ? true : false;
    }
}
