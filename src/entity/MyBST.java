package entity;

import entity.interfaces.IMyBST;

import java.util.Iterator;

public class MyBST<K extends Comparable<K>, V> implements IMyBST<K, V> {
    private MyNode<K, V> root;
    private int size;

    private class MyNode<K, V> {
        private K key;
        private V value;
        private MyNode<K, V> left;
        private MyNode<K, V> right;

        public MyNode(V value, K key) {
            this.value = value;
            this.key = key;
            left = null;
            right = null;
        }
    }

    public MyBST() {
        root = null;
        size = 0;
    }


    @Override
    public void put(K key, V value) {
//        if(root == null) {
//            root = new MyNode(key, value);
//        }
//
//        size++;

    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public void delete(K key) {

    }

    public Iterable<K> iterator() {
        return null;
    }

    //private class MyBSTIterator implements Iterator<K> {}



}
