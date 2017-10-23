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
			char tur = refer.charAt(i);
			if(cur<'Z' && cur>'A' || cur<'z' && cur>'a') {
//				if(cur>tur) {
					res[j]=cur-refer.charAt(i);
					j++;
//				}else {
					
//				}
				
			}
			continue;
		}
		if(j<res.length) {
			res[j]=111;
		}
		return res;
	}
	
	int nextKey() {
		
		if(offset>=key.length) {
			offset=-1;
		}
		return ++offset;
	}
	
	char[] decode(String s, int[] key)
	{
		char[] res = new char[s.length()];
		int offset=0;
		for(int i=0; i<s.length(); i++) 
		{
			char cur = s.charAt(i);
			if(cur<'z' && cur>'a') {
				if(cur-key[offset]<'a') 
				{
					res[i] = (char) ('z'-key[offset]-(cur-'a'));
				}else {
					res[i] = (char) ((char) cur - key[offset]);
				}
					
			}else if(cur<'Z' && cur>'A') 
			{
				if(cur-key[offset]<'A') 
				{
					res[i] = (char) ('z'-key[offset]-(cur-'A'));	
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s, S;
		int[] r;
		char[] b;
		s="-Atvt hrqgse, Cnikg";
		S="Otjfvknou kskgnl, K mbxg iurtsvcnb ksgq hoz atv. Vje xcxtyqrl vt ujg smewfv vrmcxvtg rwqr ju vhm ytsf elwepuqyez. -Atvt hrqgse, Cnikg";
		HackingTime t = new HackingTime();
		r=t.findKey(s); 
		key=Arrays.copyOfRange(r, 0, 8);
		System.out.println(Arrays.toString(key));
		b=t.decode(S, key);		
		String n = new String(b);
		System.out.println(n);
	}

}
