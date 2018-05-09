package com.two.one;

import com.all.utils.StdIn;

/**
 * 选择排序
 * 1.找到数组中最小的那个元素
 * 2.将它和数组的第一个元素交换
 * 3.再次在剩下的元素中找到最小的元素，与数组的第二个元素交换位置，如此往复
 * 4.在不断地选择剩余元素之中的最小者
 */
public class Selection extends BaseSort{

    public static void sort(Comparable[] a) {
        // 将 a[] 按升序排列
        int N = a.length;
        for (int i = 0; i < N; i++) {
            // 将 a[i] 和 a[i+1..N] 中最小的元素交换
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min);
        }
    }

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
