package fc.qs;

public class QuickSort {
	public static void QuickSort(int R[], int low, int high) {
		int pivotpos;
		if (low < high) {
			pivotpos = Partition(R, low, high);
			QuickSort(R, low, pivotpos - 1);
			QuickSort(R, pivotpos + 1, high);
		}
	}

	public static int Partition(int R[], int low, int high) {
		int pivot = R[low];
		int i = low, j = high;
		while (i < j) {
			while (i < j && R[j] > pivot)
				j--;
			if (i < j)
				R[i++] = R[j]; // 当在右侧发现小于pivot的数，就把它换到左边去。
			while (i < j && R[i] < pivot)
				i++;
			if (i < j)
				R[j--] = R[i]; // 当在左侧发现大于pivot的数，就把它换到右边去。
		}
		R[i] = pivot;
		return i;
	}

	public static void main(String[] args) {
		int[] a = { 4, 2, 1, 6, 3, 6, 0, -5, 1, 1 };
		QuickSort(a, 0, a.length - 1);
		for (int i = 0; i < a.length; i++) {
			System.out.printf("%d ", a[i]);
		}
	}
}
