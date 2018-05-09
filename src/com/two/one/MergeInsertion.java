package com.two.one;

import com.all.utils.StdIn;

/**
 * 在归并排序时添加插入排序
 */
public class MergeInsertion extends BaseSort{

    private static Comparable[] aux;

    private static final int NUM = 12;

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a,0, a.length - 1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
//        if (hi <= lo) return;

//        System.out.println("lo: " + lo + "; hi: "+ hi);
        if (hi - lo <= NUM) {
            insertion(a, lo, hi);
            return;
        }

        int mid = lo + (hi - lo) / 2;

        sort(a, lo, mid);    // 左归并
        sort(a, mid + 1, hi);    // 右归并
        merge(a, lo, mid, hi);    // 归并结果
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

    public static void insertion(Comparable[] a, int lo, int hi) {

        for (int i = lo + 1; i <= hi; i++) {
            int j = i;
            Comparable temp = a[i];
            for (; j > lo && less(temp, a[j-1]) ; j-- ) {
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
