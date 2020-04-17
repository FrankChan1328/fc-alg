package fc.sort;

/**
 * 冒泡排序
 */
public class BubbleSort {
	public static void main(String[] args) {
		int a[] = { 10, 22, 1, 3, 1, 45, 23 };
		bubbleSort(a);
		System.out.println(a);
	}

	public static void bubbleSort(int[] source) {
		for (int i = source.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (source[j] > source[j + 1])
					swap(source, j, j + 1); // 相邻交换
			}
			System.out.println(source);
			// 在这里，如果将本次排序结果输出的话，能看到，
			// 每次，数组里就会有一个最大的被找到，并排到后面 ，每次都有一个“气泡“冒出”；
		}
	}

	public static void swap(int[] source, int x, int y) {
		int temp = source[x];
		source[x] = source[y];
		source[y] = temp;
	}
}
