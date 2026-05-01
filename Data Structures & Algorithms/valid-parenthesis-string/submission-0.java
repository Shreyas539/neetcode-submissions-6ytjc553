class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> left = new Stack<>();
        Stack<Integer> stars = new Stack<>();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                left.push(i);
            }else if(s.charAt(i)=='*'){
                stars.push(i);
            }else {
                if(!left.isEmpty()){
                    left.pop();
                }else if(!stars.isEmpty()){
                    stars.isEmpty();
                }else{
                    return false;
                }
            }

        }

        while(!left.isEmpty() && !stars.isEmpty()){
            if(left.peek()<=stars.peek()){
                left.pop();
                stars.pop();
            }else{
                return false;
            }
        }

        return left.isEmpty();
    }
}
