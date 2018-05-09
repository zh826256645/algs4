package com.two.one;

import com.all.utils.StdIn;

/**
 * 归并排序(自顶向下)
 */
public class Merge extends BaseSort{

    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];    // 一次性分配空间
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        // 将数组a[lo..hi] 排序
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2; // 计算那中间值
//        System.out.println("lo: " + lo + "; mid: " + mid);

        sort(a, lo, mid);    // 将左半边排序
        sort(a, mid+1, hi);    // 将右半边排序
        merge(a, lo, mid, hi);    // 归并结果

    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        // 将 a[lo..mid] 和 a[mid+1..hi] 归并
        int i = lo, j = mid +1;

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                a[k] = aux[j++];
            else if (j > hi)
                a[k] = aux[i++];
            else if (less(aux[j], aux[i]))
                a[k] = aux[j++];
            else
                a[k] = aux[i++];
        }

    }
    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
