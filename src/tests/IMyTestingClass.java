package tests;

//this class needs to test my testing class in package entity

import entity.MyHashTable;
import entity.MyTestingClass;
import entity.Student;

import java.util.Random;

public class IMyTestingClass {
    public static void start(){
        MyHashTable<MyTestingClass, Student> hashTable = new MyHashTable<>();
        Random random = new Random();
        System.out.println("---------------------------------------------");
        System.out.println("Uniform Distribution Test");
        System.out.println("---------------------------------------------");
        System.out.println();

        // generate and insert 10000 elements
        for (int i = 0; i < 10000; i++) {
            int id = random.nextInt(10000);
            String name = "name" + random.nextInt(10000);
            MyTestingClass key = new MyTestingClass(id,name);
            Student val = new Student("student" + i,random.nextInt(30) + 18);

            hashTable.put(key, val);
        }

        printBucketSize(hashTable);
    }

    private static void printBucketSize(MyHashTable<MyTestingClass, Student> hashTable){
        System.out.println("-------------------------------------");
        System.out.println("Bucket size");
        System.out.println("-------------------------------------");

        for (int i = 0; i < hashTable.getM(); i++) {
            System.out.println("Bucket [" + i + "] contains " + hashTable.getBucketSize(i) + " elements.");
        }
    }

}
