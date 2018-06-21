package com.four.one;

import com.all.utils.In;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 广度优先搜索
 */
public class BreadthFirstPaths implements Paths{

    private boolean[] marked;    // 到达该顶点的最短路径已知吗？
    private int[] edgeTo;    // 到达该顶点的已知路径上的最后一个顶点
    private final int s;    //起点

    public BreadthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G, s);
    }

    private void bfs(Graph G, int s) {
        Queue<Integer> queue = new LinkedList<>();
        marked[s] = true;    // 标记起点
        queue.offer(s);    // 将它加入队列
        while (!queue.isEmpty()) {
            int v = queue.poll();    // 从队列中删去下一个顶点
            for (int w: G.adj(v)) {
                if (!marked[w]) {    // 对于每个未被标记的相邻顶点
                    edgeTo[w] = v;    // 保持最短路径的最后一条边
                    marked[w] = true;    // 标记它，因为最短路径已知
                    queue.offer(w);    // 并将它添加到队列中
                }
            }
        }
    }


    @Override
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    @Override
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Deque<Integer> path = new ArrayDeque<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }

    public static void main(String[] args) {
        Graph G = new Graph(new In(args[0]));
        int s = Integer.parseInt(args[1]);
        Paths search = new BreadthFirstPaths(G, s);
        for (int v = 0; v < G.V(); v++) {
            System.out.print(s + " to " + v + ":　");
            if (search.hasPathTo(v)) {
                for (int x : search.pathTo(v)) {
                    if (x == s) System.out.print(x);
                    else System.out.print("-" + x);
                }
            }
            System.out.println();
        }
    }
}
