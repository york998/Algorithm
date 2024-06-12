package findPath;

public class UniquePathI {

	public int uniquePath(int m, int n) {
		// TODO Auto-generated constructor stub
		 if(m == 1 || n == 1)
	            return 1;
	        m--;
	        n--;
	        if(m < n) {              // Swap, so that m is the bigger number
	            m = m + n;
	            n = m - n;
	            m = m - n;
	        }
	        long res = 1;
	        int j = 1;
	        for(int i = m+1; i <= m+n; i++, j++){       // Instead of taking factorial, keep on multiply & divide
	            res *= i;
	            res /= j;
	        }
	            
	        return (int)res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniquePathI t = new UniquePathI();
		int a = t.uniquePath(9, 1);
		System.out.println(a);

	}

}
