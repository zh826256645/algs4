package com.two.four;


import java.util.Iterator;

public class IndexMinPQ<Key extends Comparable<Key>> implements Iterable<Integer>{

    // N 的最大值，目前苏子
    private int maxN;

    // 数组中的元素个数
    private int n;

    private int[] pq;

    private int[] qp;

    private Key[] keys;

    public IndexMinPQ() {}

    public IndexMinPQ(int maxN) {
        if (maxN < 0) throw new IllegalArgumentException();
        this.maxN = maxN;
        n = 0;
        keys = (Key[]) new Comparable[maxN + 1];
        pq = new int[maxN + 1];
        qp = new int[maxN + 1];
        for (int i = 0; i < maxN; i++){
            qp[i] = -1;
        }
    }

    // 插入一个元素，将它和索引相关联
    public void Insert(int i, Key key) {
        if (i < 0 || i > maxN) throw new IllegalArgumentException();
        if (contains(i)) throw new IllegalArgumentException();
        n++;
        qp[i] = n;
        pq[n] = i;
        keys[i] = key;
    }

    // 将索引为 k 的元素设为 Key
    public void change(int k, Key Key) {

    }

    // 是否存在索引位 k 的元素
    public boolean contains(int k) {
        return false;
    }

    // 删除索引 k 及其相关联的元素
    public void delete(int k) {

    }

    // 返回最小的元素
    public Key min() {
        return null;
    }

    // 返回最小元素的索引
    public int minIndex() {
        return 0;
    }

    // 删除最小元素并返回它的索引
    public Key delMin() {
        return null;
    }

    // 优先队列是否为空
    public boolean isEmpty() {
        return n == 0;
    }

    // 优先队列的元素数量
    public int size() {
        return n;
    }

    private void swim(int k) {
        while (k > 1 && greater(k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && greater(j, j+1)) j++;
            if (!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    private boolean greater(int i, int j) {
        return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
    }

    private void exch(int i, int j) {
        int swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }
}
