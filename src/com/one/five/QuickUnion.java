package com.one.five;

import com.all.utils.StdIn;

/**
 * quick-union 算法
 * 用链接的方式
 */
public class QuickUnion extends UF{

    QuickUnion(int N) {
        super(N);
    }

    @Override
    int find(int p) {
        // 找出分量
        while (p != id[p]) p = id[p];
        return p;
    }

    @Override
    void union(int p, int q) {
        // 将 p 和 q 的根节点统一
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;

        id[pRoot] = qRoot;

        count --;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        QuickUnion qf = new QuickUnion(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (qf.connected(p, q)) continue;

            qf.union(p, q);
            System.out.println(p + " " + q);
        }
        System.out.println("count: " + qf.count);
    }
}
