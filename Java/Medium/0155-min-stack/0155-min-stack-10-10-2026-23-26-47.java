class MinStack {
Stack<Integer> st;
Stack<Integer> stmin;
int min;
    public MinStack() {
        st = new Stack<>();
        stmin = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int value) {
        st.push(value);
         if(stmin.isEmpty() || stmin.peek()>=value){
            stmin.push(value); 
         }
    }
    
    public void pop() {
        if(!stmin.isEmpty() && st.peek().equals(stmin.peek())){
            stmin.pop();
        }
        st.pop();
        
       
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return stmin.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */