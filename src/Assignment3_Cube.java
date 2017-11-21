// 2016-16322 Hwang inseong
import java.io.*;
public class Assignment3_Cube {
	private Assignment3_Side[] side;
	private int size;

	public Assignment3_Cube(String filename) {
		side = new Assignment3_Side[6];
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));

			size = Integer.parseInt(br.readLine());
			for(int i = 0; i < 6; i++)
				side[i] = new Assignment3_Side(size, i+1);
			int n = Integer.parseInt(br.readLine());
			for (int i=0; i<n; i++){
				String[] s = br.readLine().split(" ");
				int sideNum = Integer.parseInt(s[0]);
				String rc = s[1];
				String direction = s[2];
				int loc = Integer.parseInt(s[3]);
				rotate(sideNum, rc, direction, loc);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private int[] reverse(int[] v){
		for (int i=0; i<v.length/2 ; i++){
			int tmp = v[i];
			v[i] = v[v.length-1-i];
			v[v.length-1-i] = tmp;
		}
		return v;
	}

	public int[][] report(int s) {
		return side[s-1].get();
	}

	private void rotate(int sideNum, String rc, String direction, int loc){
		int[][] v = new int[4][];
		if (rc.toLowerCase().equals("c") && 1<=sideNum && sideNum <= 4) {
			for (int i = 0; i< 4; i++){
				v[i] = side[i].getCol(loc);
			}
			int k = direction.toLowerCase().equals("u") ? -1 : 1;
			for (int i = 0; i < 4; i++) {
				side[i].reset(rc, loc, v[(i + k + 4) % 4]);
			}
		}
		else if (rc.toLowerCase().equals("r") && sideNum != 2 && sideNum != 4){
			int[] arr = {1,6,3,5};
			int k;
			if (sideNum == 3){
				loc = size - loc + 1;
				k = direction.toLowerCase().equals("l")? -1:1;
			}
			else {
				k = direction.toLowerCase().equals("r")? -1: 1;
			}
			for (int i = 0 ; i < 4; i++){
				if (i == 2)
						v[i] = side[arr[i] - 1].getRow(size - loc + 1);
				else
					v[i] = side[arr[i]-1].getRow(loc);
			}

			for (int i = 0; i<4; i++){
				if (i == 2) {
						side[arr[i] - 1].reset("r", size - loc + 1, reverse(v[(i + 4 + k) % 4]));
				}
				else {
					if (k == -1 && i == 3)
						side[arr[i]-1].reset("r", loc, reverse(v[(i + 4 + k) % 4]));
					else if (k == 1 && i == 1)
						side[arr[i]-1].reset("r", loc, reverse(v[(i + 4 + k) % 4]));
					else
						side[arr[i]-1].reset("r", loc, v[(i + 4 + k) % 4]);
				}
			}
		}

		else{
			int[] arr = {5,4,6,2};
			int k;
			String dir = direction.toLowerCase();
			if (sideNum == 4 || sideNum == 6) {
				loc = size - loc +1;
			}
			v[0] = side[arr[0]-1].getCol(loc);
			v[1] = side[arr[1]-1].getRow(size-loc+1);
			v[2] = side[arr[2]-1].getCol(size-loc+1);
			v[3] = side[arr[3]-1].getRow(loc);
			if ((sideNum==5 && dir.equals("d")) || (sideNum==4 && dir.equals("r") || (sideNum==6 && dir.equals("u")) || (sideNum==2 && dir.equals("l"))))
				k = -1;
			else
				k = 1;
			if (k == -1) {
				side[arr[0] - 1].reset("c", loc, reverse(v[(0 + k + 4) % 4]));
				side[arr[1] - 1].reset("r", size - loc + 1, v[(1 + k + 4) % 4]);
				side[arr[2] - 1].reset("c", size-loc+1, reverse(v[(2 + k + 4) % 4]));
				side[arr[3] - 1].reset("r", loc, v[(3 + k + 4) % 4]);
			}
			else{
				side[arr[0] - 1].reset("c", loc, v[(0 + k + 4) % 4]);
				side[arr[1] - 1].reset("r", size-loc+1, reverse(v[(1 + k + 4) % 4]));
				side[arr[2] - 1].reset("c", size-loc+1, v[(2 + k + 4) % 4]);
				side[arr[3] - 1].reset("r", loc, reverse(v[(3 + k + 4) % 4]));
			}
		}
	}
}