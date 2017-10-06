package array;

import java.util.*;

public class MinimumWindowSubstringI {

	public String minWindow(String S, String T) {
		// TODO Auto-generated constructor stub
		if(S.length()<T.length())return "";
		HashMap<Character, Integer> sub= new HashMap<>();
		HashMap<Character, Integer> model= new HashMap<>();
		
		String res = "";
		int local = Integer.MAX_VALUE;
		for(int i= 0; i<T.length(); i++) {
			sub.put(T.charAt(i), 0);
			if(model.containsKey(T.charAt(i))) {
				model.put(T.charAt(i),model.get(T.charAt(i))+1);
			}else {
				model.put(T.charAt(i),1);
			}
			 
		}
		HashMap<Character, Integer>  copymodel= (HashMap<Character, Integer>) model.clone();
		HashMap<Character, Integer>  copysub =(HashMap<Character, Integer>) sub.clone();
		//window of substring must include T
		int i=0, j=0;
		while(i<S.length())
		{
			while(!model.equals(copysub)&& j<S.length()) 
			{
				if(model.containsKey(S.charAt(j))) 
				{
					if(model.get(S.charAt(j))>0) {
						model.put(S.charAt(j), model.get(S.charAt(j))-1);
					
					}else {
						sub.put(S.charAt(j), sub.get(S.charAt(j))+1);
					}
					
				}
				j++;
			}
			
			//remove elements until not satisfied
			while(!model.containsValue(1) && i<S.length())
			{
				if(sub.containsKey(S.charAt(i))) 
				{
					sub.put(S.charAt(i),sub.get(S.charAt(i))-1 );
					if(sub.containsValue(-1))
					{
						model.put(S.charAt(i), 1);
						sub.put(S.charAt(i),0 );
						if(local>(j-i+1)) 
						{
							local=(j-i+1);
							res=S.substring(i,j);
						}
						
					}
					break;
				}
				i++;
			}
			
			i++;
		}
		return res;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumWindowSubstringI t = new MinimumWindowSubstringI();
		String S = "cabefgecdaecf";
		String T = "cae";
		System.out.println(t.minWindow(S, T));
		
		

	}

}
