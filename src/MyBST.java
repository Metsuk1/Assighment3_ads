public class MyBST<K extends Comparable<K>, V> {
    private MyNode<K, V> root;

    private class MyNode<K, V> {
        private V value;
        private K key;
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

    public MyNode<K, V> put(K key, V value) {
        return insert(key, value);
    }


    private MyNode<K, V> insert(K key, V value) {
        if (root == null) {
            root = new MyNode(key, value);
        } else if (key.compareTo(root.key) > 0) {
            root.left = new MyNode(key, value);
        } else if (key.compareTo(root.key) < 0) {
            root.right = new MyNode(key, value);
        }

        return root;
    }
}
