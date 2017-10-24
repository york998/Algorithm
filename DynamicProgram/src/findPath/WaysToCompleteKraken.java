package findPath;

public class WaysToCompleteKraken {

	public int path(int m, int n) {
		// TODO Auto-generated constructor stub
		Integer[][] map = new Integer[m][n];
		for(int i = 0; i<m; i++){
			map[i][0]=1;
		}
		for(int i = 0; i<n; i++){
			map[0][i]=1;
		}
		for(int i = 1; i<m; i++){
			for(int j = 1; j<n; j++){
				map[i][j] = map[i-1][j]+map[i][j-1]+map[i-1][j-1];
			}
		}
		return map[m-1][n-1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m=9, n=5;
		WaysToCompleteKraken t = new WaysToCompleteKraken();
		int r = t.path(9, 9);
		System.out.println(r);
		
	}

}
