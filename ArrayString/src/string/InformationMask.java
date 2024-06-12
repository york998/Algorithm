package string;

import java.util.Arrays;

public class InformationMask {
	
	String maskingEmail(String s){
		String res = new String();
		int stp=s.lastIndexOf('@');
		int i=2;
		char fst=0 ,lst=0;
		
		while(i<stp){
			if(s.charAt(i) != ' '){
				fst=s.charAt(i);
				break;
			}else{
				i++;
			}
		}
		if(i==stp){
			System.out.println("worning email");
			return "worning email";
		}
		i=stp-1;
		while(i>2){
			if(s.charAt(i) != ' '){
				lst=s.charAt(i);
				break;
			}else{
				i--;
			}
		}
		if(i==2){
			System.out.println("worning email");
			return "worning email";
		}
		res="E:"+fst+"*****"+lst+s.substring(stp);
		return res;	
	}
	
	String maskingPhone(String s){
		StringBuilder res = new StringBuilder();
		res.append("P:");
		int lst=s.length()-4;
		for(int i=2; i<lst; i++){
			char cur = s.charAt(i);
			if(cur ==' ' || cur == '-' || cur =='(' || cur==')'){
				res.append('-');
			}else if(cur=='+'){
				res.append('+');
			}else{
				res.append('*');
			}
		}
		res.append(s.substring(lst));
		return res.toString();
	}
	
	String[] inputData(String[] s){
		String[] res = new String[s.length];
		String cur;
		int j=0;
		for(int i=0; i<s.length; i++){
			cur = s[i];
			if(cur.charAt(0)=='E')
			{
				res[j]=this.maskingEmail(cur);
			}else if(cur.charAt(0)=='P')
			{
				res[j]=this.maskingPhone(cur);
			}else
			{
				continue;
			}
			j++;
		}
		return res;
	}
	public static void main(String arg[]){
		
		InformationMask t = new InformationMask();
		String[] S={"E: djksjksdjfl@dkd.com", "P:+12 123 456 789 "};
		t.inputData(S);
		System.out.println(Arrays.toString(t.inputData(S)));
	}

}
