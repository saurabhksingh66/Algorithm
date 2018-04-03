package allSubString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class AllSubString {
	
	public void allSubString1(String s) {
		if(s == null || s.length()<1)
			return;
		auxAllSubString1(s,"");
	}
	
	private void auxAllSubString1(String s, String prefix) {
		if(s.length() == 0)
			return;
		for(int i = 0; i<s.length(); ++i) {
			System.out.println(prefix + s.charAt(i));
			auxAllSubString1(s.substring(i+1), prefix + s.charAt(i));
			if(prefix!="")
				break;
		}
		
	}
	
	public void allSubString2(String s) {
		if(s == null || s.length()<1)
			return;
		List<String> list = new ArrayList<String>();
		auxAllSubString2(s,"",list);
		for(String str: list)
			System.out.println(str);
	}
	
	private void auxAllSubString2(String s, String prefix, List<String> list) {
		if(s.length() == 0)
			return;
		for(int i = 0; i<s.length(); ++i) {
			list.add(prefix + s.charAt(i));
			auxAllSubString2(s.substring(i+1), prefix + s.charAt(i), list);
			if(prefix!="")
				break;
		}
		
	}
	
	public void allSubString3(String s) {
		if(s == null || s.length()<1)
			return;
		HashSet<String> set = new HashSet<String>();
		auxAllSubString3(s,"",set);
		for(String str: set)
			System.out.println(str);
	}
	
	private void auxAllSubString3(String s, String prefix, HashSet<String> set) {
		if(s.length() == 0)
			return;
		for(int i = 0; i<s.length(); ++i) {
			set.add(prefix + s.charAt(i));
			auxAllSubString3(s.substring(i+1), prefix + s.charAt(i), set);
			if(prefix!="")
				break;
		}
		
	}

	public static void main(String[] args) {
		String s = "ABA";
		AllSubString subStr = new AllSubString();
		subStr.allSubString2(s);
		System.out.println();
		System.out.println();
		subStr.allSubString3(s);
		
	}
}
