package entity;

import entity.interfaces.IMyHashTable;

public class MyHashTable<K,V> implements IMyHashTable<K,V> {
    private HashNode<K, V>[] chainArr; // its array of hash nodes
    private int M = 11; // its capacity
    private int size; // size is number of key-value pairs

    /**
     * Internal class representing a node in the hash table.
     */
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

    /**
     * Default constructor to initialize hash table with default capacity.
     */
    public MyHashTable() {
        chainArr = new HashNode[M];
        size = 0;
    }

    /**
     * Constructor to initialize hash table with custom capacity.
     * @param M the initial capacity
     */
    public MyHashTable(int M) {
        this.M = M;
        chainArr = new HashNode[M];
        size = 0;
    }

    /**
     * Hash function to compute index for a given key.
     * @param key the key to hash
     * @return the hash index
     */
    private int hash(K key) {
        return Math.abs(key.hashCode() % M);
    }

    /**
     * Inserts a new key-value pair into the hash table.
     * If the key already exists, updates its value.
     * @param key the key to insert
     * @param value the value associated with the key
     */
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

    /**
     * Retrieves the value associated with a given key.
     * @param key the key to search for
     * @return the value if found, otherwise null
     */
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

    /**
     * Removes the key-value pair associated with a given key.
     * @param key the key to remove
     * @return the removed value, or null if key was not found
     */
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

    /**
     * Checks if a given value exists in the hash table.
     * @param value the value to search for
     * @return true if value exists, otherwise false
     */
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

    /**
     * Retrieves the key associated with a given value.
     * @param value the value to search for
     * @return the key if found, otherwise null
     */
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
    /**
     * Returns the size in the hash table.
     * @return the size
     */
    public int size() {
        return size;
    }

    /**
     * Checks if the hash table is empty.
     * @return true if table is empty, otherwise false
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the current capacity of the hash table.
     * @return the capacity
     */
    public int getM() {
        return M;
    }

    /**
     * Checks if the key is null.
     * @param key the key to check
     * @throws NullPointerException if key is null
     */
    private void checkKey(K key) {
        if(key == null) {
            throw new NullPointerException("key is null");
        }
    }

    /**
     * Checks if the value is null.
     * @param value the value to check
     * @throws NullPointerException if value is null
     */
    private void checkValue(V value) {
        if(value == null) {
            throw new NullPointerException("value is null");
        }
    }

}
