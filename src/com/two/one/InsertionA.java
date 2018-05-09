package com.two.one;

import com.all.utils.StdIn;

/**
 * 插入排序的优化
 * 1.在内循环中将较大的元素都向右移动
 */
public class InsertionA extends BaseSort{

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            Comparable temp = a[i];

            int j = i;
            for (; j > 0 && less(temp, a[j-1]); j--) {
                a[j] = a[j-1];
            }

            a[j] = temp;
        }
    }

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
