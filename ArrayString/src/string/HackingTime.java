package string;
import java.util.*;
public class HackingTime {
	static int[] key;
	int offset;
	
	HackingTime(){
		offset=0;
	}
	int[] findKey (String s) {
		int[] res= new int[s.length()];
		String refer="-Your friend, Alice";
		int j=0;
		for(int i=0; i<s.length(); i++) {
			char cur = s.charAt(i);
			char tru = refer.charAt(i);
			if(cur<='Z' && cur>='A' || cur<='z' && cur>='a') {
				if(cur>=tru) {
					res[j]=cur-tru;
					j++;
				}else {
					if(cur<='Z' && cur>='A'){
						res[j]=cur-'a'+1+'z'-tru;
					}else if(cur<='z' && cur>='a'){
						res[j]=cur-'a'+1+'z'-tru;
					}
					j++;
				}
			}
			continue;
		}
		if(j<res.length) {
			res[j]=111;
		}
		return res;
	}
		
	char[] decode(String s, int[] key)
	{
		char[] res = new char[s.length()];
		int offset=0;
		for(int i=0; i<s.length(); i++) 
		{
			char cur = s.charAt(i);
			if(cur<='z' && cur>='a') {
				if(key[offset]>cur-'a') 
				{
					res[i] = (char) ('z'-key[offset]+(cur-'a'+1));
				}else {
					res[i] = (char) ((char) cur - key[offset]);
				}
				offset++;
				if(offset>=key.length) {
					offset=0;
				}
			}else if(cur<='Z' && cur>='A') 
			{
				if(key[offset]>cur-'A') 
				{
					res[i] = (char) ('Z'-key[offset]+(cur-'A'+1));
				}else {
					res[i] = (char) ((char) cur - key[offset]);
				}
				offset++;
				if(offset>=key.length) {
					offset=0;
				}
				
			}else {
				res[i]=cur;
			}
		}		
		return res;
	}
	
	String decrypt(String s){
		char [] res = new char[s.length()];
		for(int i=0; i<s.length(); i++) 
		{
			char cur = s.charAt(i);
			if(cur<='z' && cur>='a') {
				if(key[offset]+cur>'z') 
				{
					res[i] = (char) ('a'+key[offset]-('z'-cur)-1);
				}else {
					res[i] = (char) ((char) cur + key[offset]);
				}
				offset++;
				if(offset>=key.length) {
					offset=0;
				}
			}else if(cur<='Z' && cur>='A') 
			{
				if(key[offset]+cur>'Z') 
				{
					res[i] = (char) ('A'+key[offset]-('Z'-cur)-1);
				}else {
					res[i] = (char) ((char) cur + key[offset]);
				}
				offset++;
				if(offset>=key.length) {
					offset=0;
				}
				
			}else {
				res[i]=cur;
			}
		}
		String n = new String(res);
		return n;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s, S;
		int[] r;
		char[] b;
		s="-Atvt hrqgse, Cnikg";
		S="Otjfvknou kskgnl, K mbxg iurtsvcnb ksgq hoz atv. Vje xcxtyqrl vt ujg smewfv vrmcxvtg rwqr ju vhm ytsf elwepuqyez. -Atvt hrqgse, Cnikg";
		HackingTime t = new HackingTime();
		r=t.findKey(s); 
		key=Arrays.copyOfRange(r, 6, 13);
		System.out.println(Arrays.toString(key));
		b=t.decode(S, key);		
		String n = new String(b);
		System.out.println(n);
		System.out.println(t.decrypt(n).equals(S));
	}

}
