package string;

import java.math.BigInteger;
import java.util.Arrays;

public class MultiplyStrings {

	public String multiplyStrings(String num1, String num2) {
		// TODO Auto-generated constructor stub
		int l1 = num1.length();
		int l2 = num2.length();
		StringBuilder res = new StringBuilder();
		if(l1==0)return num2;
		if(l2==0)return num1;
		int[] sum= new int[l1+l2];
		for(int i=l1-1; i>=0; i--){
			for(int j=l2-1; j>=0; j--){
				sum[i+j+1] += (num1.charAt(i)-'0') *(num2.charAt(j)-'0');
			}
		}
		int c=0;
		for(int i = sum.length-1; i>0; i--){
			sum[i]+=c;
			c=sum[i]/10;
			sum[i]=sum[i]%10;
			res.insert(0,sum[i]);
		}
		if(c!=0 || sum[0]!=0){sum[0]+=c; res.insert(0,sum[0]);}
		return res.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MultiplyStrings t = new MultiplyStrings();
		String num1="3890540432759805404932897192850432";
		String num2="9083249832794723974982379";
		BigInteger b1= new BigInteger(num1);
		BigInteger b2= new BigInteger(num2);
		
		System.out.print(t.multiplyStrings(num1, num2)+"\n");
		System.out.print(b1.multiply(b2)+"\n");
		System.out.print(t.multiplyStrings(num1, num2).equals(b1.multiply(b2).toString()));
		
	}

}
