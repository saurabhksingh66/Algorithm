package TST;

public class TestTrie {

	public static void main(String[] args) {
		ITrie trie = new TST();
		String[] testwords = { "pqr", "abc", "def", "ab", "xyz", "axy", "adf",
				"xab", "xdb" };
		for (int i = 0; i < testwords.length; ++i)
			trie.add(testwords[i]);
		//trie.print();
		trie.displayAll();
		System.out.println(trie.autoComplete("a"));
		System.out.println(trie.autoComplete("ab"));
		System.out.println(trie.autoComplete("x"));
		System.out.println(trie.autoComplete("y"));
		System.out.println(trie.contains("pqr"));
		System.out.println(trie.contains("pab"));
		System.out.println(trie.contains("ab"));

	}
}
