class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();

        for(String ch:tokens){
            if(ch.equals("+")){
                s.push(s.pop()+s.pop());
            }else if(ch.equals("-")){
                int b = s.pop();
                int a = s.pop();
                s.push(a-b);
            }else if(ch.equals("*")){
                s.push(s.pop()*s.pop());
            }else if(ch.equals("/")){
                 int b = s.pop();
                int a = s.pop();
                s.push(a/b);
            }
            else{
                s.push(Integer.parseInt(ch));
            }
        }

        return s.peek();
    }
}
