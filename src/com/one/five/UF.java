package com.one.five;

abstract class UF {
    /*
     * 动态连通性问题
     */
     int[] id;
     int count;

     UF() {
         super();
     }

     UF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i ++) {
            id[i] = i;
        }
    }

    // 连通分量的数量
    public int getCount() {
        return count;
    }

    // p 所在的分量的标识符
    abstract int find(int p);

    // 如果 p 和 q 同处于一个分量中，则返回 true
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    abstract void union(int p, int q);

    public int[] getId(){
        return id;
    }
}
