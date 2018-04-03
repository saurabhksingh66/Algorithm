package quickSort;

public class QuickSort {

	public void quickSort(int[] in) {
		if (in == null || in.length < 1)
			return;
		System.out.println("Start");
		auxQuickSort(in, 0, in.length - 1);
	}

	private void auxQuickSort(int[] in, int l, int r) {

		if (l >= r)
			return;
		int p = partition(in, l, r);
		auxQuickSort(in, 0, p - 1);
		auxQuickSort(in, p + 1, r);
	}

	private int partition(int[] in, int l, int r) {
		int pivot = in[l];
		int lastMin = l, current = l + 1;
		int temp = 0;

		while (current <= r) {
			if (in[current] < pivot) {
				temp = in[++lastMin];
				in[lastMin] = in[current];
				in[current++] = temp;
			} else
				current++;
		}
		in[l] = in[lastMin];
		in[lastMin] = pivot;

		return lastMin;
	}

	public static void main(String[] args) {
		QuickSort quickSort = new QuickSort();
		int[] in = { 7, 3, 2, 1, 6, 5, 9, 4 };
		for(int e: in)
			System.out.print(e + " ");
		System.out.println();
		quickSort.quickSort(in);
		for(int e: in)
			System.out.print(e + " ");
	}
}
