package org.example;

import org.example.list.DoubleLinkedList;

import java.util.Scanner;

import static org.example.Menu.doMenu;
import static org.example.Menu.printMenu;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DoubleLinkedList list = new DoubleLinkedList();
        int[] array = {};

        printMenu();
        doMenu(scanner, list, array);

        scanner.close();
    }
}