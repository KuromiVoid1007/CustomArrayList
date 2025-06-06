package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();

        list.add(5);
        list.add(3);
        list.add(10);
        list.add(1, 7);

        System.out.println(list);

        list.sort();
        System.out.println(list);

        list.remove(2);
        System.out.println(list);

        list.clear();
        System.out.println(list);
    }
}