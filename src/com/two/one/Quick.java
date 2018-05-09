package com.two.one;

import com.all.utils.StdIn;
import com.all.utils.StdRandom;

/**
 * 快速排序
 */
public class Quick extends BaseSort{

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);   //切分
        sort(a, lo, j-1);   // 将左半部分 a[lo .. j-1] 排序
        sort(a, j+1, hi);   // 将右半部分 a[j+1 .. hi] 排序
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        // 将数组切分为 a[lo..i-1], a[i], a[i+1..hi]
        int i = lo, j = hi+1;    // 左右扫描指针
        Comparable v = a[lo];
        while (true) {
            // 扫描左右，检查扫描是否结束并交换元素
            while (less(a[++i], v)) if (i == hi) break;
            while (less(v, a[--j])) if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);    // 将 v = a[j] 放入正确的位置
        return j;    // a[lo..j-1] <= a[j] <= a[j+1..hi] 达成
    }

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
