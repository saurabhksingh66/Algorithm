package moveZeros;

import java.util.Arrays;

public class MoveZerosTest {
	public static void main(String[] args) {
		MoveZeros zero = new MoveZeros();
		int[] nums = {4,0,45,15,0,0,16,0,18,0};
		System.out.println(Arrays.toString(nums));
		System.out.println(Arrays.toString(zero.moveZeros2(nums)));
	}
}
