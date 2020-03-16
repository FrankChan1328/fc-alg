package fc.bs;

/**
 * 二分排序指的是，折半插入排序。
 * 当直接插入排序进行到某一趟时，对于r[i]来讲，前边 i-1 该记录已经按关键字有序排列。此时不用直接插入排序的方法，而改为二分折半查找，找出r[i]应插入的位置，然后插入。这种方法就是折半插入排序（二分排序）。
 * 二分排序中，关键字的比较次数由于采用了折半查找而减少，数量级为O(nlogn)，但是元素的移动次数仍为O(n2)。故折半插入排序时间复杂度为O(n2)。
 * 折半插入排序方法是稳定的。
 */
public class BinarySort {
    public static void main(String [] args){
        int[] a = { 4, 2, 1, 6, 3, 6, 0, -5, 1, 1 };
        binarySort(a);
        System.out.println(a);
    }
    
    public static void binarySort(int a[]){
        int i, j;
        int low, high, mid;
        int num;
        for (i = 1; i < a.length; i++) {
            num = a[i];
            low = 0;
            high = i - 1;
            
            // 二分法查找插入位置
            while (low <= high) {
                mid = (low + high) / 2; // 已排序好的中间位置
                if (a[mid] > num)
                    high = mid - 1; // 插入元素应当在左区间
                else
                    low = mid + 1; // 插入元素应当在右区间
            }
            // 每次查找完毕后，low总比high大1，a[low]总是存放第一个比 num 大的数，
            // 因此，应当从a[low]开始每个元素右移一位，并将num存入 a[low] 中，
            // 这样就保证 a[0...i]是排好序的。
            
            for (j = i - 1; j >= low; j--) //后移排序码大于a[i]的记录
                a[j + 1] = a[j];
            a[low] = num; // 插入
        }
    }
}
