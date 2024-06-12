package stringBreak;

import java.util.*;

public class WordBreakII {

	public List<String> wordBreakII(String s, List<String> wordDict) {
		// TODO Auto-generated constructor stub
		List<String> res = new ArrayList<String>();
		boolean[] record = new boolean[s.length()+1];
		HashSet<String> dict = new HashSet<String>(wordDict);
		int maxWord = wordDict.get(0).length();
		for(String x: wordDict){
			if(x.length()>maxWord){
				maxWord=x.length();
			}
		}
		for(int i=1; i<maxWord; i++){
			if(dict.contains(s.substring(0, i))){
				if(record[i] || wordBreakII(s.substring(i), wordDict).size()!=0){
					record[i]=true;
				}
			}
			if(record[0]){
				recover(s, record);
			}
		}
		return res;
	}
	
	public void recover(String s, boolean[] record){
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[] s = new boolean[9];
		System.out.print(Arrays.toString(s));
	}

}
