class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();

        for(char ch : s.toCharArray()){
            if(ch=='[' || ch=='{' || ch=='('){
                stk.push(ch);
            }else if(!stk.isEmpty() && ((stk.peek()=='[' && ch==']') || (stk.peek()=='{' && ch=='}') || (stk.peek()=='(' && ch==')'))){
                stk.pop();
            }else{
                return false;
            }

        }

        return stk.isEmpty() ? true : false;
    }
}
