package stack;
import java.util.*;

public class MinStack {
	private Stack<Integer> stk;
	private Stack<Integer> minStk;
	public MinStack(){
		stk = new Stack<Integer>();
		minStk = new Stack<Integer>();
	}
	
	public int top() {
		return stk.peek();
	}
	public void pop(){
		stk.pop();
		minStk.pop();
	}
	public void push(Integer x){
		if(x==null)return;
		stk.push(x);
		if(minStk.isEmpty() || x<minStk.peek()){
			minStk.push(x);
		}else {
			minStk.push(minStk.peek());
		}
	}
	
	 public int getMin() {
	        return minStk.peek();
	}
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStack t = new MinStack();
		
		t.push(-2);
		t.push(0);
		t.push(-3);
		
		System.out.println(t.top());
		
	}

}
