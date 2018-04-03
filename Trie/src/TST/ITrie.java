package TST;

import java.util.List;

public interface ITrie {
	boolean add(String word);
	boolean remove(String word);
	boolean contains(String word);
	List<String> autoComplete(String prefix);
	void displayAll();
	void print();
}
