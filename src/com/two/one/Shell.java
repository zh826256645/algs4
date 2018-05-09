package com.two.one;

import com.all.utils.StdIn;

/**
 * 希尔排序
 * 1.使数组中任意间隔位 h 的元素都是有序的，这样的数组被称为 h 有序数组
 * 2.实质还是插入排序
 * 3.该算法使用递增序列，其中递增序列只是其中一种方案（序列1/2 (3k-1)，从 N/3 开始递减至1）
 */
public class Shell extends BaseSort{

    public static void sort(Comparable[] a) {
        // 将 a[] 按 升序排列
        int N = a.length;
        int h = 1;
        while (h < N/3) h = 3 * h + 1;

//        System.out.print("h: " + h + "; now a: ");
//        for (Comparable u: a) {
//            System.out.print(u + " ");
//        }
//        System.out.println();

        while (h >= 1) {
            // 将数组变为 h 有序
            for (int i = h; i < N; i++) {
                // 将 a[i] 插入到 a[i-h], a[i-2*h], a[i-3*h]... 之中
                for (int j = i; j >= h && less(a[j], a[j-h]); j -= h) {
                    exch(a, j, j-h);
//                    System.out.print("j: " + j + "; j-h: " + (j- h) + "; now a: ");
//                    for (Comparable u: a) {
//                        System.out.print(u + " ");
//                    }
//                    System.out.println();
                }
            }
            h = h / 3;

//            System.out.println("now h: " + h);
        }
    }

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
