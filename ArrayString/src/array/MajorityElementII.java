package array;

import java.util.*;
import java.util.stream.Collectors;

public class MajorityElementII {

	public List<Integer> majorityElement(int[] nums) {
		List<Integer> res = new ArrayList<>();
		if(nums==null || nums.length<1) return res;
		//if(nums.length<3) return Arrays.stream(nums).boxed().collect(Collectors.toList());
		// the max number that can appear more than n/K times is k-1
		// in case of 3 the number will be 3-1
		// use off-set to find the high-frequency number
		Hashtable<Integer, Integer> local = new Hashtable<>();
		
		for(int i = 0; i<nums.length; i++) {
			if(local.containsKey(nums[i])){
				local.put(nums[i], local.get(nums[i])+1);				
			}else if(local.contains(0)||local.size()<2 ) {
				//System.out.println(local.keySet().toString());
				for(int x : local.keySet()) {
					
					if(local.get(x)==0)local.remove(x);
					
					break;
				}
				local.put(nums[i], 1);
				//System.out.println(local.keySet().toString());
			}else {
				for(int x : local.keySet()) {
					local.put(x, local.get(x)-1);
				}
			}
		}
		
		for(int x : local.keySet()) {
			local.put(x, 0);
		}
		
		
		for(int i = 0; i<nums.length; i++) {
			if(local.containsKey(nums[i])){
				local.put(nums[i], local.get(nums[i])+1);
			}
		}
		System.out.println(local.keySet().toString());
		for(int x : local.keySet()) {
			if(local.get(x)>(nums.length)/3) res.add(x);
			
		}
        return res ;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MajorityElementII t = new MajorityElementII(); 
		List<Integer> res = new ArrayList<>();
		int[] nums= {4,2,1,1};
		res=t.majorityElement(nums);
		System.out.println(res.toString());
	}

}

