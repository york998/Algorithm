package array;

import java.util.*;
import java.util.regex.Pattern;

public class Contacts {

	public Contacts() {
		// TODO Auto-generated constructor stub
	}
	List<String> nameList;
    int offset;
    public static void main(String[] args) {              
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Contacts t = new Contacts();
        t.nameList = new ArrayList<String>();
        t.offset = 0;
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            
            if(op.equals("add")){
               t.addName(contact);
            }else{
               int res = t.findName(contact);
               System.out.print(res+"\n"); 
            }
        }
        System.out.println();
    }
    
    void addName(String con){
        nameList.add(con);
        offset++;
        Collections.sort(nameList);
    }
    
    int findName(String con){ 
        String pattern = con+".*";
        int res=0;
        for(int i = 0; i<offset; i++){
           if( Pattern.matches(pattern, nameList.get(i))){
            res++;
           }
           if(con.charAt(0) > nameList.get(i).charAt(0)){
               break;
           }
        //    System.out.print(pattern+"  "+nameList[i]+"\n"); 
        }
      return res;
    }

}
