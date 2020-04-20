package fc.dfs;

/**
 * 给定整数 a1, a2, ... , an ，判断是否可以从中选出若干数，使他们的和恰好为k。
 * 举例：
 * n=4
 * a= {1,2,4,7}
 * k=13
 * 输出 yes(13 = 2 +4 +7)
 */
public class Dfs {
    
    static int n = 4;
    static int k = 13;
    static int a[] = { 1, 2, 4, 7 };

    public static void main(String[] args) {
        System.out.println(dfs(0, 0));
    }
    
    /**
     * 已经从前i 项得到了和sum，然后对于i 项之后的进行分支
     */
    public static boolean dfs(int i, int sum) {
        // 如果前n项都计算过，则返回sum 是否与k 相等
        if (i == n)
            return sum == k;

        // 不加上 a[i] 的情况
        if (dfs(i + 1, sum))
            return true;

        // 加上a[i] 的情况
        if (dfs(i + 1, sum + a[i]))
            return true;

        return false;
    }
}
