package palindromicPartition;

public class PalindromicPartition {

	public void palindromicPartition(String s) {
		if (s == null || s.length() < 1)
			return;
		auxPalPartition1(s, "");
	}

	private void auxPalPartition1(String s, String prefix) {
		if (s.length() == 0) {
			System.out.println(prefix);
			return;
		}

		for (int i = 0; i < s.length(); ++i) {
			String temp = s.substring(0, i + 1);
			if (isPalindrome(temp, 0, temp.length() - 1))
				auxPalPartition1(s.substring(i + 1), prefix + " + " + temp);
		}

	}

	private boolean isPalindrome(String temp, int i, int j) {
		while(i < j) {
			if(temp.charAt(i) != temp.charAt(j))
				return false;
			++i;
			--j;
		}
		return true;
	}
	public static void main(String[] args) {
		PalindromicPartition pp = new PalindromicPartition();
		String s = "ABABA";
		pp.palindromicPartition(s);
	}
}
