package tests;

import entity.MyBST;

public class MyBSTest {
    public static void start(){
        MyBST<Integer, String> tree = new MyBST<>();

        System.out.println("----------------------------");
        System.out.println("Binary Search Tree Testing");
        System.out.println("----------------------------");

        // Insertion test
        System.out.println("\nInsertion Test:");
        tree.put(50, "Fifty");
        tree.put(30, "Thirty");
        tree.put(70, "Seventy");
        tree.put(20, "Twenty");
        tree.put(40, "Forty");
        tree.put(60, "Sixty");
        tree.put(80, "Eighty");

        printTreeInfo(tree);

        // Deletion tests
        System.out.println("\nDeletion Tests:");
        System.out.println("Case 1: Delete leaf (20)");
        tree.delete(20);
        printInOrder(tree);

        System.out.println("\nCase 2: Delete node with one child (30)");
        tree.delete(30);
        printInOrder(tree);

        System.out.println("\nCase 3: Delete node with two children (50)");
        tree.delete(50);
        printInOrder(tree);

        // Iterator test
        System.out.println("\nIterator Test:");
        printInOrder(tree);
    }

    private static void printTreeInfo(MyBST<Integer, String> tree) {
        System.out.println("Size: " + tree.getSize());
        System.out.println("Get 40: " + tree.get(40));
        System.out.println("Get 99: " + tree.get(99));
    }

    private static void printInOrder(MyBST<Integer, String> tree) {
        System.out.println("Printing tree elements in-order:");
        for (MyBST.MyNode entry : tree) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}

