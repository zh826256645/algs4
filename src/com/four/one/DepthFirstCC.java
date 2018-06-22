package com.four.one;

import com.all.utils.In;
import com.one.three.Bag;

/**
 * 基于深度优先搜索找出途中的所有联通分量
 */
public class DepthFirstCC implements CC {

    private boolean[] marked;
    private int[] id;
    private int count;

    public DepthFirstCC (Graph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        for (int s = 0; s < G.V(); s++) {
            if (!marked[s]) {
                dfs(G, s);
                count++;
            }
        }
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w: G.adj(v)) {
            if (!marked[w])
                dfs(G, w);
        }
    }

    @Override
    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public int id(int v) {
        return id[v];
    }

    public static void main(String[] args) {
        Graph G = new Graph(new In(args[0]));
        CC cc = new DepthFirstCC(G);

        int M = cc.count();
        System.out.println(M + " components");

        Bag<Integer>[] components;
        components = (Bag<Integer>[]) new Bag[M];
        for (int i = 0; i < M; i++) {
            components[i] = new Bag<Integer>();
        }

        for (int v = 0; v < G.V(); v++) {
            components[cc.id(v)].add(v);
        }

        for (int i = 0; i < M; i++) {
            for (int v: components[i]) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }
}
