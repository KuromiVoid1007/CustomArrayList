package org.example;

import java.util.Comparator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        MyArrayList<String> fruits = new MyArrayList<>();

        fruits.add("Orange");
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Grape");
        fruits.add("Pineapple");

        Utils.quickSort(fruits, Comparator.comparingInt(String::length));
        System.out.println(fruits);

    }
}
