package tree;

public class CheckBST {

	 boolean checkBST(Node root) {
	       if(root==null)return true;
	       int[] tmp ;
	       tmp=checkBST1(root);
	       if(tmp[0] != -1 && tmp[1] != -1){
	           return true;
	       }
	       return false;
	    }


	 int[] checkBST1(Node root){
	    int[] leftRight= {-1,-1};
	   
	    if(root.left==null && root.right == null){
	        leftRight[0] = root.data;
	        leftRight[1] = root.data;
	        return leftRight;
	    }
	    if(root.left==null){
	        if(root.right.data > root.data)
	        {
	            int[] tmp ;
	            tmp=checkBST1(root.right);
	            if(tmp[0] != -1 && tmp[1] != -1 && tmp[0] >= root.data){
	                leftRight[0]=root.data;
	                leftRight[1]=tmp[1];

	            }
	        }
	       return leftRight;
	    }
	    if(root.right==null){

	        if(root.left.data < root.data)
	        {
	            int[] tmp ;
	            tmp=checkBST1(root.left);
	            if(tmp[0] != -1 && tmp[1] != -1 && tmp[1] <= root.data){
	                leftRight[1]=root.data;
	                leftRight[0]=tmp[0];
	            }
	        }
	        return leftRight;
	    }
	    if(root.right.data > root.data && root.left.data < root.data){
	        int[] tmp1;
	        int[] tmp2;
	        tmp1=checkBST1(root.left);
	        tmp2=checkBST1(root.right);
	        if(tmp1[0] != -1 && tmp1[1] != -1 && tmp2[0] != -1 && tmp2[1] != -1 && 
	           tmp1[1] < root.data && tmp2[0] > root.data){
	            leftRight[1]=tmp2[1];
	            leftRight[0]=tmp1[0];
	        }
	   /*    
	        System.out.println(root.data*100000+root.left.data*1000+root.right.data);
	        System.out.println("dsfs"+Arrays.toString(leftRight));
	        if(leftRight[0] != -1 && leftRight[1] != -1){
	            System.out.println(true);
	       }else{
	             System.out.println(false);
	        }
	  */    
	      
	        return leftRight; 
	    }
	    return leftRight;
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
