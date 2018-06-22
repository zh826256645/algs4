package com.four.one;

/**
 * 连通分量
 */
public interface CC {
    boolean connected(int v, int w);    // v 和 w 连通吗
    int count();    // 连通分量数
    int id(int v);    // v 所在的联通分量的标识符(0 ~ count()-1)
}
