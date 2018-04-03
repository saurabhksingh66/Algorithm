package spiralPrint;

import java.util.Arrays;
import java.util.Random;

public class SpiralPrint {

	public void spiralPrint(int[][] in) {
		if (in == null || in.length < 1)
			return;
		int count = 0;
		int m = in.length , n = in[0].length;
		int i=0, j =0;
		int M =m, N = n;
		int c = 0;
		while(true){
			
			c = N -1;
			while(c>=0){
				System.out.println("i = " + i + "  j = " + j);
				System.out.print(in[i][j] + " ");
				count++;
				if(count==m*n) break;
				++j;
				--c;
			}
			N--;
			++i;
			--j;
			
			c = M-1;
			while(c>0){
				System.out.println("i = " + i + "  j = " + j);
				System.out.print(in[i][j] + " ");
				count++;
				if(count==m*n) break;
				++i;
				--c;
				
			}
			M--;
			--j;
			--i;
			
			c = N -1;
			while(c>=0){
				System.out.print(in[i][j] + " ");
				count++;
				if(count==m*n) break;
				--j;
				--c;
			}
			--i;
			++j;
			N--;
			
			c = M-1;
			while(c>=0){
				System.out.print(in[i][j] + " ");
				count++;
				if(count==m*n) break;
				--i;
				--c;
			}
			M--;
			++j;
			//++i;
		}
	}
	public static void main(String[] args) {
		SpiralPrint spiral = new SpiralPrint();
		int[][] in = new int[4][3];
		Random r = new Random();
		for(int i = 0; i<in.length; ++i){
			for(int j = 0 ; j<in[0].length; ++j)
				in[i][j] = r.nextInt(19)+1;
		}
		System.out.println(Arrays.deepToString(in));
		System.out.println();
		System.out.println();
		spiral.spiralPrint(in);
	}
}
