package com.two.four;

import com.two.one.BaseSort;

/**
 * 基于二叉堆的优先队列
 */
public class MaxPQ<Key extends  Comparable<Key>> extends BaseSort implements PQ{

    // 基于堆的完全二叉树
    private Key[] pq;
    private int N = 0;

    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN+1];
    }

    @Override
    public void Insert(Comparable v) {

        pq[++N] = (Key)v;
        swim(N);
    }

    @Override
    public Comparable max() {
        return null;
    }

    @Override
    public Comparable delMax() {
        // 从根节点得到最大元素
        Key max = pq[1];
        // 将其和最后一个结点交换
        exch(1, N--);
        pq[N+1] = null;
        sink(1);
        return max;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return N;
    }

    // 上浮操作
    public void swim(int k) {
        while (k > 1 && less(k/2, k)) {
            exch(k/2, k);
            k = k/2;
        }
    }

    // 下沉操作
    public void sink(int k) {
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && less(j, j+1)) j++;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    public void exch(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }
}
