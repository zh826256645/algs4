package com.one.five;

import com.all.utils.StdIn;

/**
 * 加权 quick-union 算法
 */
public class WeightedQuickUnionUF extends UF{

    // 各个根节点所对应的分量的大小
    private int[] sz;

    private int visitTreeElementCount = 0;

    WeightedQuickUnionUF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) id[i] = i;

        sz = new int[N];
        for (int i = 0; i < N; i++) sz[i] = 1;
    }

    @Override
    int find(int p) {
        // 跟随链接找到根节点
        while (p != id[p]) {p = id[p]; visitTreeElementCount++;}
        return p;
    }

    @Override
    void union(int p, int q) {
        int i = find(p);
        int j = find(q);

        // 将小树的根节点连接到大树的跟节点
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }

        count --;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        WeightedQuickUnionUF qf = new WeightedQuickUnionUF(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (qf.connected(p, q)) continue;

            qf.union(p, q);
            System.out.println(p + " " + q);
        }
        System.out.println("count: " + qf.count);
        System.out.println("visitTreeElementCount: " + qf.visitTreeElementCount);
    }
}
