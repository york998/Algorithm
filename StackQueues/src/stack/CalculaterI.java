package stack;

import java.util.Stack;

public class CalculaterI {
	
	public int calculate(String s){
		if(s==null || s.length()<1)return 0;
		int res=0;
		Stack<String> stk = new Stack<String>(); 
		s.replaceAll(" ", "");
		for(int i = 0; i<s.length(); i++){
			
			if(s.charAt(i)=='+' || s.charAt(i)=='('||s.charAt(i)=='-'){
				stk.push(s.charAt(i)+"");
			}
			
			StringBuilder num= new StringBuilder();
			while(i<s.length() && s.charAt(i)>='0' && s.charAt(i)<='9' ){
				num.append(s.charAt(i));
				i++;	
			}
			
			if(num.length()!=0){
				i--;
	//			stk.push(Integer.parseInt(num.toString()));
				stk.push(num.toString());
				num.setLength(0);;
			}
			if(s.charAt(i)==')' || i==s.length()-1){
				
				while(!stk.isEmpty() &&  !stk.peek().equals("(")){
					
					String a=stk.peek();
					stk.pop();
//					System.out.print(stk.peek());
					if(!stk.isEmpty() && stk.peek().equals("-")){
						res=res-Integer.valueOf(a);
						stk.pop();
					}else{
//						System.out.print(stk.peek());
						if(stk.isEmpty()){
							res = res+ Integer.valueOf(a);
						}else{
							res = res+ Integer.valueOf(a);
							
							if(stk.peek().equals("(")){
								stk.pop();
								if(!stk.isEmpty() && i== s.length()-1 ){
									stk.push(Integer.toString(res));
									res=0;
									continue;
								}else{
									stk.push(Integer.toString(res));
									res=0;
									break;
								}
								
							}
							stk.pop(); 
						}
					}
				}
							
			}
			
		}
		if(!stk.isEmpty()) res=Integer.valueOf(stk.peek());
		return res;
	}
	
	public static void main(String[] args) {
		CalculaterI t = new CalculaterI();
//		String s="(7)-(0)+(4)";
		String s="(6)-(8)-(7)+(1+(6))";
//		try{
			int x=t.calculate(s);
//		}catch(Exception e){
//			e.getMessage();
//		}
		
		System.out.println(x);
		 
	}
}
