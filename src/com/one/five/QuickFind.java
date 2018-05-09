package com.one.five;

import com.all.utils.*;

public class QuickFind extends UF{

    public QuickFind(int N) {
        super(N);
    }

    public int find(int p) {
        return this.id[p];
    }

    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);

        if (pId == qId) return;

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pId) id[i] = qId;

        }
        count--;
    }

    public static void main(String args[]) {
        int N = StdIn.readInt();

        QuickFind qf = new QuickFind(N);

        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (qf.connected(p, q)) continue;
            qf.union(p, q);
            System.out.println(p + " " + q);
        }
        System.out.println(qf.getCount() + "components");
        for (int a: qf.getId()) {
            System.out.print(a + " ");
        }
    }
}
