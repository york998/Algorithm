package array;

import java.util.Arrays;

public class SortColor {
	public void sortColors2(int[] list){
		int[] record={0,0,0};
		for(int x:list){
			if(x==0)record[0]++;
			if(x==1)record[1]++;
			if(x==2)record[2]++;
		}
		int j=0;
		for(int i=0; i<record.length; i++){
			while(record[i] > 0) {
				list[j]=i;
				record[i]--;
				j++;
			}
		}
	}
	public void sortColors1(int[] list){
		if(list==null || list.length<=1)return;
		int fst=0;
		int lst=list.length-1;
		while(fst<lst){
			while(fst<list.length && list[fst] == 0) fst++;
			while(list[lst] != 0) lst--;
//			System.out.println(fst+"  "+lst);
			if(fst<=lst){
				int tmp=list[lst];
				list[lst]=list[fst];
				list[fst]=tmp;
			}
		}
		lst=list.length-1;
		while(fst<lst){
			while(list[fst] == 1) fst++;
			while(list[lst] != 1) lst--;
			if(fst<=lst){
				int tmp=list[lst];
				list[lst]=list[fst];
				list[fst]=tmp;
			}
		}
		System.out.println(Arrays.toString(list));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortColor t = new SortColor();
		int[] list={0,0,1,0,2,1,0};
		t.sortColors2(list);
		System.out.println(Arrays.toString(list));

	}

}
