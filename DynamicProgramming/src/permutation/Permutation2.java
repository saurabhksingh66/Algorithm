package permutation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Permutation2 {

	public static void permutation(String s) {

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); ++i) {
			if (map.containsKey(s.charAt(i)))
				map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
			else
				map.put(s.charAt(i), 1);
		}
		char[] string = new char[map.size()];
		int[] count = new int[map.size()];
		int index = 0;
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			string[index] = entry.getKey();
			count[index] = entry.getValue();
			index++;
		}
		char result[] = new char[s.length()];
		auxPermutation(string, count, result, 0);
	}

	private static void auxPermutation(char[] string, int[] count,
			char[] result, int level) {
		if (level == result.length) {
			System.out.println(Arrays.toString(result));
			return;
		}
		for (int i = 0; i < string.length; ++i) {
			if (count[i] != 0) {
				result[level] = string[i];
				count[i]--;
				auxPermutation(string, count, result, level + 1);
				count[i]++;
			}
		}
	}

	public static void main(String[] args) {
		int[] in = { 1, 2, 1 ,1};
		String s = "1211";
		Permutation2.permutation(s);

	}
}
