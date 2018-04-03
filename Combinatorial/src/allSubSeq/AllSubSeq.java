package allSubSeq;

import java.util.Arrays;
import java.util.HashSet;

public class AllSubSeq {

	public void allSubSeq1(char[] in) {
		if (in == null || in.length < 1)
			return;
		auxAllSubSeq1(in, "", 0);
	}

	private void auxAllSubSeq1(char[] in, String prefix, int depth) {
		if (depth == in.length) {
			System.out.println(prefix);
			return;
		}
		for (int j = 0; j <= 1; ++j) {
			prefix = (j == 0 ? prefix : prefix + in[depth]);
			//System.out.println(prefix +  " j = " + j);
			auxAllSubSeq1(in, prefix, depth + 1);
		}
	}
	
	//_______________________________________________________________________________________

	public void allSubSeq2(char[] in) {
		if (in == null || in.length < 1)
			return;
		auxAllSubSeq2(in, "", 0);
	}
	
	private void auxAllSubSeq2(char[] in, String prefix, int depth) {
		if (depth == in.length) {
			System.out.println(prefix);
			return;
		}
		auxAllSubSeq2(in, prefix, depth + 1);
		auxAllSubSeq2(in, prefix + in[depth], depth + 1);
	}
	
	public void allSubSeq3(String s) {
		auxAllSubSeq3(s,"", 0);
	}
	
	//_____________________________________________________________________________________

	private void auxAllSubSeq3(String s, String prefix, int start) {
		if(s.length() == 0)
			return;
		for(int i = 0; i<s.length(); ++i) {
			auxAllSubSeq3(s.substring(i+1), prefix + s.charAt(i), start);
			System.out.println(prefix + s.charAt(i));
		}
		
	}
	
	//______________________________________________________________________________________
	
	public void allSubSeq4(String s) {
		HashSet<String> set = new HashSet<String>();
		auxAllSubSeq4(s,"", 0,set);
		for(String str:set)
			System.out.println(str);
	}

	private void auxAllSubSeq4(String s, String prefix, int start, HashSet<String> set) {
		if(s.length() == 0)
			return;
		for(int i = 0; i<s.length(); ++i) {
			auxAllSubSeq4(s.substring(i+1), prefix + s.charAt(i), start,set);
			set.add(prefix + s.charAt(i));
		}
		
	}
	
	//______________________________________________________________________________________
	
	public static void main(String[] args) {
		String s = "ABA";
		char[] in = s.toCharArray();
		AllSubSeq seq = new AllSubSeq();
		seq.allSubSeq2(in);
		System.out.println();
		System.out.println();
		seq.allSubSeq3(s);
	}
}
