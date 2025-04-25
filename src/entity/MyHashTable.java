package entity;

import entity.interfaces.IMyHashTable;

public class MyHashTable<K,V> implements IMyHashTable<K,V> {
    private HashNode<K, V>[] chainArr; // its array of hash nodes
    private int M = 11; // its capacity
    private int size; // size is number of key-value pairs

    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }


        @Override
        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }


    public MyHashTable() {
        chainArr = new HashNode[M];
        size = 0;
    }

    public MyHashTable(int M) {
        this.M = M;
        chainArr = new HashNode[M];
        size = 0;
    }


    private int hash(K key) {
        return Math.abs(key.hashCode() % M);
    }

    @Override
    public void put(K key, V value) {
        checkKey(key);
        checkValue(value);
        int index = hash(key);
        HashNode<K, V> current = chainArr[index];

        while (current != null) {
            if (current.getKey().equals(key)) {
                current.setValue(value);

                return;
            }
            current = current.next;
        }

        //if key is not found
        HashNode<K, V> newNode = new HashNode<>(key, value);
        newNode.next = chainArr[index];
        chainArr[index] = newNode;
        size++;
    }

    @Override
    public V get(K key) {
        checkKey(key);
        int index = hash(key);
        HashNode<K, V> current = chainArr[index];

        while (current != null) {
            if(current.getKey().equals(key)) {
                return current.getValue();
            }
            current = current.next;
        }

        return null;
    }

    @Override
    public V remove(K key) {
        checkKey(key);
        int index = hash(key);
        HashNode<K, V> current = chainArr[index];
        HashNode<K, V> prev = null;

        while (current != null) {
            if (current.getKey().equals(key)) {
                if (prev == null) {
                    chainArr[index] = current.next;
                } else {
                    prev.next = current.next; //перепрыгиваем ерез узел в массиве
                }
                size--;

                return current.getValue();
            }
            prev = current;
            current = current.next;
        }

        return null; //if key is not founded
    }

    @Override
    public boolean contains(V value) {
        checkValue(value);
        for(int i = 0; i < M; i++) {
            HashNode<K  , V> current = chainArr[i];

            while(current != null) {
                if(current.getValue().equals(value)) {

                    return true;
                }
                current = current.next;
            }
        }

        return false;
    }

    @Override
    public K getKey(V value) {
        checkValue(value);
        for(int i = 0; i < M; i++) {
            HashNode<K, V> current = chainArr[i];

            while(current != null) {
                if(current.getValue().equals(value)) {

                    return current.key;
                }
                current = current.next;
            }
        }

        return null;
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getM() {
        return M;
    }

    private void checkKey(K key) {
        if(key == null) {
            throw new NullPointerException("key is null");
        }
    }

    private void checkValue(V value) {
        if(value == null) {
            throw new NullPointerException("value is null");
        }
    }

}
