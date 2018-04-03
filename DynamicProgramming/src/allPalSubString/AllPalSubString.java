package allPalSubString;

import java.util.HashSet;
import java.util.Set;

public class AllPalSubString {
	
	public void AllPalSubStr1(String s) {
		if(s == null || s.length()<1)
			return;
		auxAllPalSubStr1(s,"");
	}

	private void auxAllPalSubStr1(String s, String prefix) {
		if(s.length() == 0)
			return;
		for(int i = 0; i<s.length(); ++i) {
			String temp = prefix + s.charAt(i);
			if(isPalindrome(temp,0,temp.length()-1))
				System.out.println(temp);
			auxAllPalSubStr1(s.substring(i+1),temp);
			if(prefix!="")
				break;
		}
		
	}

	private boolean isPalindrome(String str, int i, int j) {
		while(i<=j) {
			if(str.charAt(i)!= str.charAt(j))
				return false;
			++i;
			--j;
		}
		return true;
	}
	
	public void AllPalSubStr2(String s) {
		if(s == null || s.length()<1)
			return;
		Set<String> set = new HashSet<String>();
		auxAllPalSubStr2(s,"",set);
		for(String str:set)
			System.out.println(str);
	}

	private void auxAllPalSubStr2(String s, String prefix, Set<String> set) {
		if(s.length() == 0)
			return;
		for(int i = 0; i<s.length(); ++i) {
			String temp = prefix + s.charAt(i);
			if(isPalindrome(temp,0,temp.length()-1))
				set.add(temp);
			auxAllPalSubStr2(s.substring(i+1),temp,set);
			if(prefix!="")
				break;
		}
		
	}
	
	public static void main(String[] args) {
		AllPalSubString lps = new AllPalSubString();
		String s = "abcbada";
		lps.AllPalSubStr1(s);
		System.out.println();
		System.out.println();
		lps.AllPalSubStr2(s);
	}
}
