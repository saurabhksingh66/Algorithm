package HashSet;

public class HashSet implements ISet {
	Node[] buckets;
	int size;
	private static final int THRESHOLD = 20;

	HashSet() {
		buckets = new Node[11];
		for (int i = 0; i < buckets.length; ++i) {
			buckets[i] = new Node();
		}
		size = 0;
	}

	public void reHash() {

		Node[] buckets_new = new Node[2*buckets.length];
		for(int i = 0; i < buckets_new.length; ++i)
			buckets_new[i] = new Node();

		Node tmp;
		for(int i = 0; i < buckets.length; ++i) {
			for(Node current = buckets[i].next; current != null; current = tmp) {
				int bind = current.data.hashCode() % buckets_new.length;
				tmp = current.next;
				current.next = buckets_new[bind].next;
				buckets_new[bind].next = current;
			}
		}		
buckets = buckets_new;

	}

	public boolean add(Integer e) {
		// check if element is already available in set
		if (contains(e))
			return false;
		// checking if rehash is required
		float avgSize = size / buckets.length;
		if (avgSize >= THRESHOLD)
			reHash();
		// add element at the start of bucket
		int bind = e.hashCode() % buckets.length;
		Node temp = new Node(e);
		temp.next = buckets[bind].next;
		buckets[bind].next = temp;
		++size;
		return true;
	}

	public boolean contains(Integer e) {
		int bind = e.hashCode() % buckets.length;
		for (Node current = buckets[bind].next; current != null; current = current.next) {
			if (current.data == e)
				return true;
		}
		return false;
	}

	public boolean remove(Integer e) {
		int bind = e.hashCode() % buckets.length;
		for (Node current = buckets[bind].next; current.next != null; current = current.next) {
			if (current.next.data == e) {
				current.next = current.next.next;
				--size;
				return true;
			}
		}
		return false;
	}
	
	public int size(){
		return size;
	}
	public void display(){
		for(int i = 0; i < buckets.length; ++i) {
			System.out.print("Bucket-" +i+":" );
			for(Node current = buckets[i].next; current != null; current = current.next) {
				System.out.print(current.data+" ");
			}
			System.out.println();
		}
	}
}
