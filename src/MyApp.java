import tests.IMyTestingClass;
import tests.MyBSTest;
import tests.MyHashTableTest;

import java.util.Scanner;

public class MyApp {
    public static void main(String[] args) {
        start();
    }

    private static void start(){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("\n--------------");
            System.out.println("1.Test my Binary Search Tree");
            System.out.println("2.Test my HashTable");
            System.out.println("3.Test my Testing class");
            System.out.println("4. Exit");

            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    MyBSTest.start();
                    break;
                case 2:
                    MyHashTableTest.start();
                    break;
                case 3:
                    IMyTestingClass.start();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}