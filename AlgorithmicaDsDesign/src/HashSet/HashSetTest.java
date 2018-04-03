package HashSet;

import java.util.Random;

public class HashSetTest {

	public static void Test(ISet set, int n) {
		Random r = new Random();
		for (int i = 0; i < n; ++i) {
			int tmp = r.nextInt(n) +1;
			// System.out.println(tmp);
			set.add(tmp);
		}
		System.out.println("size = "+set.size());
		set.display();
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		Test(new HashSet(), n);
	}

}