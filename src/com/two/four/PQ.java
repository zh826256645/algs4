package com.two.four;

public interface PQ<Key extends Comparable<Key>> {

    // 想优先队列中插入一个元素
    public void Insert(Key v);

    // 返回最大的元素
    public Key max();

    // 删除并返回最大元素
    public Key delMax();

    // 返回队列是否为空
    public boolean isEmpty();

    // 返回优先队列中的元素个数
    public int size();

}
