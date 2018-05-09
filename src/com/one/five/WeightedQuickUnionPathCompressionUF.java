package com.one.five;

import com.all.utils.StdIn;

public class WeightedQuickUnionPathCompressionUF extends UF {

    private int[] sz;

    private int visitTreeElementCount = 0;

    WeightedQuickUnionPathCompressionUF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) id[i] = i;

        sz = new int[N];
        for (int i = 0; i < N; i++) sz[i] = 1;
    }

    @Override
    int find(int p) {
        int root = p;
        while (root != id[root]) {
            root = id[root];
            visitTreeElementCount ++;
        }

        while (p != root) {
            int newId = id[p];
            id[p] = root;
            p = newId;
        }
        return root;
    }

    @Override
    void union(int p, int q) {
        int i = id[p];
        int j = id[q];

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
        WeightedQuickUnionPathCompressionUF qf = new WeightedQuickUnionPathCompressionUF(N);
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
