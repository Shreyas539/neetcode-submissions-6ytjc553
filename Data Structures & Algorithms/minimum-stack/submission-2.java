class MinStack {

    private Stack<Integer>stack;
    private Stack<Integer> minStk;

    public MinStack() {
        stack = new Stack<>();
        minStk = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);

        if(minStk.isEmpty() || val<=minStk.peek()){
            minStk.push(val);
        }
    }
    
    public void pop() {
        if(stack.peek().equals(minStk.peek())){
            minStk.pop();
        }
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        // if(!minStk.isEmpty()){
            return minStk.peek();
        // }
    }
}
