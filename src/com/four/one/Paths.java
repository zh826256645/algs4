package com.four.one;

/**
 * 路径 api
 * 用于解决单点路径问题：给定一幅图和一个起点s，回答“从s到给定目的顶点v是否存在一条路径？如果有，找出这条路径。”等类似的问题
 */
public interface Paths {
    boolean hasPathTo(int v);           // 是否存在从s到v的路径
    Iterable<Integer> pathTo(int v);    // s到v的路径，如果不存在则返回null
}
