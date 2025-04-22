package entity;

import entity.interfaces.IMyBST;

public class MyBST<K extends Comparable<K>, V> implements IMyBST<K, V> {
    private MyNode<K, V> root;

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
    }


    @Override
    public void put(K key, V value) {

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

}
