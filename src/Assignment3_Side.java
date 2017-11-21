// 2016-16322 Hwang inseong
public class Assignment3_Side {
	private int[][] side;
	public Assignment3_Side(int size, int value) {
		side = new int[size][size];
		for(int i = 0; i < size; i++)
			for(int j = 0; j < size; j++)
				side[i][j] = value;
	}

	public int[][] get() {
		return side;
	}

	public int[] getCol(int loc){
		int[] v = new int[side.length];
		for (int i=0; i<side.length;i++){
			v[i] = side[i][loc-1];
		}
		return v;
	}

	public int[] getRow(int loc){
		return side[loc-1];
	}

	public void reset(String rc, int loc, int[] v){
		if (rc.toLowerCase().equals("c")){
			for(int i=0; i<side.length; i++){
				side[i][loc-1] = v[i];
			}
		}
		else{
			side[loc-1] = v;
		}
	}

}