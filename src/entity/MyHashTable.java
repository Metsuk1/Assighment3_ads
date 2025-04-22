package entity;

import entity.interfaces.IMyHashTable;

public class MyHashTable<K,V> implements IMyHashTable<K,V> {

    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }

    private HashNode<K, V>[] buckets;
    private int M = 11;
    private int size;


    public MyHashTable() {}

    public MyHashTable(int default_size) {}







    @Override
    public int hash(K key) {
        return 0;
    }

    @Override
    public void put(K key, V value) {

    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public boolean contains(V value) {
        return false;
    }

    @Override
    public K getKey(V value) {
        return null;
    }


}
