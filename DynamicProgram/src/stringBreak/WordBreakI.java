package stringBreak;
import java.util.*;

public class WordBreakI {
	boolean[] res;
	public boolean wordBreak(String s, List<String> wordDict) {
		// TODO Auto-generated constructor stub
		if(s.length()==0 || s == null) return true;
		if(wordDict == null || wordDict.size()<1)return false;
		Set<String> dict = new HashSet<String>(wordDict);
		//System.out.print(dict.toString());
		res = new boolean[s.length()];
		res[s.length()-1]=true;
		for (int i = 0; i <= s.length()-1; i++){
	        res[i] = false;
	    }
		this.dpFunction(s, dict);
		return res[0];
	}
	public boolean dpFunction(String s, Set<String> dict){
		if(s.length()==0 || s == null) return true;
		//System.out.print(Arrays.toString(res)+" "+s.length()+"\n");
		for(int i = s.length()-1; i>=0 ; i--){
			if(dict.contains(s.substring(i))){
				
				//if(s.length()==3)System.out.println(res[i]);
				if(i==0) {res[0]=true; return true;}
				if(res[i]){
					break;
				}else if(dpFunction(s.substring(0, i), dict)){
					res[i]=true;
					break;
				}
					
					
			}
		}
		return res[0];
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "leetcode";
		//String[] dict = {"leet", "code"};
		s="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		String[] dict={"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
		WordBreakI t = new WordBreakI();
		boolean res = t.wordBreak(s, Arrays.asList(dict));
		System.out.println(res);
	}

}
