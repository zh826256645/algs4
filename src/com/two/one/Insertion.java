package com.two.one;

import com.all.utils.StdIn;

/**
 * 插入排序
 * 1.为了给要插入的元素腾出空间，我们需要将其余所有元素在插入之前都向右移动一位
 */
public class Insertion extends BaseSort{

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j-1);
            }
        }
    }

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
