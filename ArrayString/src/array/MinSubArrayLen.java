package array;

public class MinSubArrayLen {

	public int minSubArrayLen(int s, int[] nums) {
        int i=0;
        int j=0;
        int min=Integer.MAX_VALUE;
        int sum=0;
        if( nums==null || nums.length<1)return 0;
        while(j<nums.length && i<=j){
        	while(j<nums.length && sum<s){
        		sum+=nums[j];
        		j++;
        	}
        	while(sum>=s){
        			if(i==j){
        				min=1;
        				i++;
        				j++;
        				sum=0;
        			}else{
        				sum=sum-nums[i];
        				if(min>(j-i)) min=j-i;
        				i++;
        			}
        		}
        }
        if(min== Integer.MAX_VALUE)return 0;
        return min;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinSubArrayLen t = new MinSubArrayLen();
//		int s = 7;
//		//            0,1,2,3,4,5
//		int[] nums = {2,3,7,2,4,2};
		int s = 213;
		int[] nums ={12,28,83,4,25,26,25,2,25,25,25,12};
		System.out.println(t.minSubArrayLen(s, nums));
	}

}