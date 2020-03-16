package fc.bs;

/**
 * 时间复杂度O(nlogn)，优于直接顺序查找O(n)
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] a = { -1, 2, 4, 6, 8, 8, 10, 15 };
        int pos = getPos(a, 8);
        System.out.println(pos);
    }

    public static int getPos(int a[], int x) {
        int low = 0, high = a.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2; // 取数组中间元素下标值
            if (x < a[mid])
                high = mid - 1; // 向左查找
            if (x > a[mid])
                low = mid + 1; // 向右查找
            if (x == a[mid])
                return mid;
        }
        return -1; // 未找到
    }
}
