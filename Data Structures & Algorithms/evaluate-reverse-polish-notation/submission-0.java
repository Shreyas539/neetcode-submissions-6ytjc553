class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();

        for(String ch:tokens){
            if(ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/")){
                if(ch.equals("+")){

                int op2 = s.pop();
                int op1 = s.pop();
                int res = op1 + op2;
                s.push(res);
                }else if(ch.equals("-")){
                    int op2 = s.pop();
                int op1 = s.pop();
                int res = op1 - op2;
                s.push(res);
                }else if(ch.equals("*")){
                    int op2 = s.pop();
                int op1 = s.pop();
                int res = op1 * op2;
                s.push(res);
                }else if(ch.equals("/")){
                    int op2 = s.pop();
                int op1 = s.pop();
                int res = op1 / op2;
                s.push(res);
                }
            }else{
                s.push(Integer.parseInt(ch));
            }
        }

        return s.peek();
    }
}
