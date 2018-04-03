/*
 * find an algorithm to generate all n-length sequence using array of characters.
 */

package allSeq;

import java.util.ArrayList;
import java.util.Arrays;

public class AllSeq {
	
	public void generateSeq(char[] in, int n) {
		if(in == null || in.length <1)
			return;
		ArrayList<Character> list = new ArrayList<Character>();
		auxGenerateSeq(in,list,n);
	}
	
	private void auxGenerateSeq(char[] in, ArrayList<Character> list, int n){
		if(n == 0){
			System.out.println(Arrays.toString(list.toArray()));
			return;
		}
		
		for(int i = 0; i<in.length; ++i){
			list.add(in[i]);
			auxGenerateSeq(in,list,n-1);
			list.remove(list.size()-1);
		}
	}
	
	public static void main(String[] args) {
		String s = "AB";
		char[] in = s.toCharArray();
		AllSeq seq = new AllSeq();
		seq.generateSeq(in, 4);
	}
}
