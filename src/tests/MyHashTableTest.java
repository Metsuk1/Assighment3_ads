package tests;

import entity.MyHashTable;

public class MyHashTableTest {
    public static void start(){
        MyHashTable<Integer, String> table = new MyHashTable<>();

        System.out.println("---------------------------------");
        System.out.println("My Hash Table Test");
        System.out.println("---------------------------------");
        System.out.println();

        // adding elements
        table.put(1, "Conor McGregor");
        table.put(12, "Khabibi Nurmagomedov");
        table.put(23, "Nate Diaz");

        // Testing get method
        System.out.println("Testing get method:");
        System.out.println("Value for key " + 1 + ": " + table.get(1));
        System.out.println("Value for key " + 12 + ": " + table.get(12));
        System.out.println("Value for key " + 23 + ": " + table.get(23));
        System.out.println();

        // Testing remove method
        System.out.println("Testing remove method:");
        System.out.println("Removing key " + 12);
        table.remove(12);
        System.out.println("Value for key " + 12 + " after removal: " + table.get(12)); // Should be null
        System.out.println();

        // Testing contains method
        System.out.println("Testing contains method:");
        System.out.println("Does table contain value Conor McGregor? " + table.contains("Conor McGregor"));
        System.out.println("Does table contain value Khabibi Nurmagomedov? " + table.contains("Khabibi Nurmagomedov"));
        System.out.println();

        // Testing getKey method
        System.out.println("Testing getKey method:");
        System.out.println("Key for value Conor McGregor: " + table.getKey("Conor McGregor"));
        System.out.println("Key for value Khabibi Nurmagomedov: " + table.getKey("Khabibi Nurmagomedov")); // should be null
        System.out.println();

        // Extra: Testing size, isEmpty and getBucketSize
        System.out.println("Extra tests:");
        System.out.println("Current size of table: " + table.size());
        System.out.println("Is table empty? " + table.isEmpty());

    }
}
