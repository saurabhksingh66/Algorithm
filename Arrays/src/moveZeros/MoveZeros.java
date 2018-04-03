package moveZeros;

public class MoveZeros {
	public int[] moveZeros(int[] nums) {
		if (nums == null)
			return null;
		int i = 0, j = 0, k = 0;
		while (j < nums.length) {
			while (nums[j] == 0) {
				++i;
				if (j == nums.length - 1)
					break;
				++j;
			}
			nums[k] = nums[j];
			++k;
			++j;
		}
		while (i != 0 && k < nums.length) {
			nums[k] = 0;
			++k;
			--i;
		}
		return nums;
	}

	public int[] moveZeros2(int[] nums) {
		if (nums == null)
			return nums;
		int index = 0;
		for (int i = 0; i < nums.length; ++i) {
			if (nums[i] != 0) {
				nums[index] = nums[i];
				++index;
			}
		}
		for(int i = index; i<nums.length;++i){
			nums[index] = 0;
			++index;
		}
		return nums;
	}

}
