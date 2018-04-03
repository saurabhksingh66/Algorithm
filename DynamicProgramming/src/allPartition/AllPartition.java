package allPartition;

public class AllPartition {
	
	public void allPartition1(String s) {
		if(s == null || s.length() < 1)
			return;
		auxAllPartition1(s, "");
	}

	private void auxAllPartition1(String s, String prefix) {
		if(s.length() == 0) {
			System.out.println(prefix);
			return;
		}
		
		for(int i = 0; i < s.length(); ++i) {
			String temp = s.substring(0, i + 1);
			auxAllPartition1(s.substring(i + 1), prefix + " + " + temp);
		}
	}
	public static void main(String[] args) {
		String s = "ABC";
		AllPartition ap = new AllPartition();
		ap.allPartition1(s);
	}
}
