package entity;

import entity.interfaces.IMyBST;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Binary Search Tree
 * @param <K> it's the key
 * @param <V> it's the value
 */
public class MyBST<K extends Comparable<K>, V> implements IMyBST<K, V>,Iterable<MyBST<K,V>.MyNode<K,V>>{
    private MyNode<K, V> root;
    private int size;

    public class MyNode<K, V> {
        private K key;
        private V value;
        private MyNode<K, V> left;
        private MyNode<K, V> right;

        public MyNode(K key,V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    public MyBST() {
        root = null;
        size = 0;
    }

    /**
     * this method needs to insert element  into  the tree
     * O(log n) time complexity.
     * @param key it the key of value
     * @param value it's value tp be inserted
     */
    @Override
    public void put(K key, V value) {
        checkKey(key);
        insert(key, value); // call supporting method for putting element
    }

    /**
     * This method searches for a value by its key.
     * @param key the key to search for
     * @return the value associated with the key, or null if not found
     */
    @Override
    public V get(K key) {
        checkKey(key);
        return getting(key);//call supporting method
    }

    /**
     * This method deletes an element by its key.
     * O(log n) time complexity.
     * @param key the key of the element to delete
     */
    @Override
    public void delete(K key) {
        checkKey(key);
        deleting(key);//call supporting delete method
    }


    /**
     * Return iterator
     * @return the in order iterator
     */
    @Override
    public Iterator<MyNode<K, V>> iterator() {
        return new MyBSTIterator();
    }

    /**
     * implementation of in order iterator by use stack
     */
    private class MyBSTIterator implements Iterator<MyNode<K, V>> {
        private Stack<MyNode<K, V>> stack;

        public MyBSTIterator() {
            stack = new Stack<>();
            moveLeft(root);
        }

        private void moveLeft(MyNode<K, V> current) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public MyNode<K, V> next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Stack is empty");
            }

            MyNode<K, V> current = stack.pop();
            if (current.right != null) {
                moveLeft(current.right);
            }

            return current;
        }
    }

    /**
     * Returns size of the BST.
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * Helper method that handles inserting a node into the tree.
     * O(log n) time complexity.
     * @param key the key of the new node
     * @param value the value of the new node
     */
    private void insert(K key, V value) {
        if(root == null) {
            // if the root is null, we initialize it
            root = new MyNode(key, value);
            size++;

            return;
        }

        MyNode<K, V> current = root;
        while(current != null) {
            int compare = key.compareTo(current.key); // мы сравнивпем ключ которыйй мы ищем с ключаом текущего узла

            // if a node with that key already exists we just update its value
            if(compare == 0) {
                current.value = value;

                return;
            }

            if(compare < 0) {
                if(current.left == null) {
                    current.left = new MyNode<>(key, value);
                    size++;

                    return;
                }
                current = current.left;
            }else{
                if(current.right == null) {
                current.right = new MyNode<>(key, value);
                size++;

                return;
            }
            current = current.right;
            }
        }
    }

    /**
     * Helper method that retrieves a value associated with a key.
     * @param key the key to search for
     * @return the value associated with the key, or null if not found
     */
    private V getting(K key){
        MyNode<K,V>current = root;

        while(current != null) {
            int compare = key.compareTo(current.key);

            if(compare > 0) {
                current = current.right;
            }
            else if(compare < 0) {
                current = current.left;
            }else{

                return current.value; // key founded and returned
            }
        }

        return null; // if key is not founded
    }

    /**
     * This method checks if a key is null.
     * Throws IllegalArgumentException if the key is null.
     * @param key the key to check
     */
    private void checkKey(K key) {
        if (key == null){
            throw new IllegalArgumentException("Key cannot be null");
        }
    }

    /**
     * This method finds the node with the minimum key in the subtree.
     * @param node the root of the subtree
     * @return the node with the minimum key
     */
    private MyNode<K,V> findMin(MyNode<K,V> node) {
        while(node.left != null) {
            node = node.left;
        }

        return node;//return the minimum element in the tree
    }

    /**
     * This method finds the node with the maximum key in the subtree.
     * @param node the root of the subtree
     * @return the node with the maximum key
     */
    private MyNode<K,V> findMax(MyNode<K,V> node) {
        while(node.right != null) {
            node = node.right;
        }

        return node; // return the max element in the tree
    }

    /**
     * This method deletes a node by its key from the tree.
     * @param key the key of the node to delete
     */
    private void deleting(K key) {
        MyNode<K, V> current = root;
        MyNode<K,V> parent = null;
        boolean isLeftChild = false;

        // we find deleting node and its parent
        while(current != null && !current.key.equals(key)) {
            parent = current;
            if(key.compareTo(current.key) < 0 ){
                current = current.left;
                isLeftChild = true;
            }else{
                current = current.right;
                isLeftChild = false;
            }

        }

        if(current == null) {return;}//if a node is not founded

        // if no child  or  only one child
        if(current.left == null) {
            replaceNode(parent,current,current.right,isLeftChild);
        }
        else if(current.right == null) {
            replaceNode(parent,current,current.left,isLeftChild);
        }
        //if we have 2 child
        else{
            MyNode<K,V> minParent = current;
            MyNode<K,V>minNode = current.right;

            while(minNode.left != null) {
                minParent = minNode;
                minNode = minNode.left;
            }

            current.key = minNode.key;
            current.value = minNode.value;

            if(minParent == current) {
                minParent.right = minNode.right;
            }else{
                minParent.left = minNode.right;
            }
        }

        size--;
    }

    /**
     * Helper method to replace one node with another in the tree.
     * @param parent the parent of the node to be replaced
     * @param node the node to be replaced
     * @param child the new child node
     * @param isLeftChild true if the node is a left child, false if right
     */
    private void replaceNode(MyNode<K,V> parent,MyNode<K,V> node,MyNode<K,V> child,boolean isLeftChild) {
        if(parent == null) {
            root = child;
        }else if(isLeftChild) {
            parent.left = child;
        } else {
            parent.right = child;
        }
    }
}
