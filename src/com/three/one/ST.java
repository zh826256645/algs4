package com.three.one;

/**
 * 符号表的接口
 * @param <Key>
 * @param <Value>
 */

public interface ST<Key extends Comparable<Key>, Value>{

    // 将键值对存入表中（若值为空则将键 key 从表中删除）
    public void put (Key key, Value val);

    // 获取键 key 对应的值（若键 key 不存在则返回 null）
    public void get(Key key);

    // 从表中删去键 key (及其对于的值)
    public void delete(Key key);

    // 键 key 在表中是否有对应的值
    public boolean contains(Key key);

    // 表是否为空
    public boolean isEmpty();

    // 表中的键值对数量
    public int size();

    // 表中的所有键值的集合
    public Iterable<Key> keys();
}
