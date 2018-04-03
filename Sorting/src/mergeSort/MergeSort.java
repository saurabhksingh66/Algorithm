package mergeSort;

import quickSort.QuickSort;

public class MergeSort {

	public void mergeSort(int[] in) {
		if (in == null || in.length < 1)
			return;
		int[] temp = new int[in.length];
		auxMergeSort(in, 0, in.length - 1, temp);
	}

	private void auxMergeSort(int[] in, int l, int r, int[] temp) {
		if (l >= r)
			return;
		int mid = (l + r) / 2;
		auxMergeSort(in, l, mid, temp);
		auxMergeSort(in, mid + 1, r, temp);
		merge(in, l, mid, r, temp);

	}

	private void merge(int[] in, int l, int mid, int r, int[] temp) {
		if (l == r)
			return;
		int i = l, j = mid + 1, k = l;
		while (i <= mid && j <= r) {
			if (in[i] > in[j])
				temp[k++] = in[j++];
			else
				temp[k++] = in[i++];
		}
		while (i <= mid)
			temp[k++] = in[i++];
		while (j <= r)
			temp[k++] = in[j++];
		for (int m = l; m <= r; ++m)
			in[m] = temp[m];
	}

	public static void main(String[] args) {
		MergeSort mergeSort = new MergeSort();
		int[] in = {7, 3, 2, 1, 6, 5, 9, 4};
		for (int e : in)
			System.out.print(e + " ");
		System.out.println();
		mergeSort.mergeSort(in);
		for (int e : in)
			System.out.print(e + " ");
	}
}
