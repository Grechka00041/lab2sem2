package org.example.list;

import org.example.SafeScanner;

import java.util.Random;
import java.util.Scanner;

public abstract class ListActions {
    public static void makeList(Scanner scanner, DoubleLinkedList list){
        System.out.println("1 - ввести кол-во элементов для заполнения рандомными числами, \n 2 - ввести элементы списка");
        int reply = SafeScanner.scanInt(scanner);
        long startTime, endTime;
        switch (reply){
            case 1:
                System.out.print("Введите сколько элементов в списке нужно создать: ");
                int numOfElements = SafeScanner.scanInt(scanner);
                Random random = new Random();
                startTime = System.nanoTime();
                for (int i = 0; i < numOfElements; i++) {
                    list.insertLast(random.nextInt(100));
                }
                endTime = System.nanoTime();
                System.out.println("\nВремя создания массива - " + (endTime - startTime) + " наносекунд");
                System.out.print("Ваш список: ");
                list.displayList();
                break;
            case 2:
                System.out.print("Введите элементы в список(значения считываются до первого не полносью числового значения): ");
                startTime = System.nanoTime();
                while (scanner.hasNextInt()) {
                    int num = scanner.nextInt();
                    list.insertLast(num);
                }
                endTime = System.nanoTime();
                System.out.println("\nВремя создания массива - " + (endTime - startTime) + " наносекунд");
                System.out.print("Ваш список: ");
                scanner.nextLine();
                list.displayList();
                break;
            default:
                System.out.println("Выберите верное значение.");
        }
        scanner.nextLine();
    }

    public static void swapElem(Scanner scanner, DoubleLinkedList list){
        System.out.print("Введите значения элементов для обмена: ");
        int num1 = SafeScanner.scanInt(scanner);
        int num2 = SafeScanner.scanInt(scanner);
        list.swap(num1, num2);
        System.out.print("Ваш список теперь: ");
        list.displayList();
        System.out.println('\n');
    }

    public static void getElem(Scanner scanner, DoubleLinkedList list) {
        Link link;
        System.out.print("Получить по индексу - 1, по значению - 2: ");
        int reply = SafeScanner.scanInt(scanner);
        switch (reply) {
            case 1:
                System.out.print("Введите нужный индекс: ");
                int num = SafeScanner.scanInt(scanner);
                long startTime = System.nanoTime();
                link = list.findByIndex(num);
                long endTime = System.nanoTime();
                if (link == null) {
                    System.out.println("В списке нет данного элемента");
                } else {
                    System.out.println("Значение элемента по индексу: " + link.getData());
                }
                System.out.println("\nВремя создания массива - " + (endTime - startTime) + " наносекунд");
                break;
            case 2:
                System.out.print("Введите нужное значение: ");
                num = SafeScanner.scanInt(scanner);
                startTime = System.nanoTime();
                link = list.findByData(num);
                endTime = System.nanoTime();
                if (link == null) {
                    System.out.println("В списке нет данного элемента");
                } else {
                    System.out.print("Индекс элемента с данным значением: " + list.findIndex(link));
                }
                System.out.println("\nВремя создания массива - " + (endTime - startTime) + " наносекунд");
                break;
            default:
                System.out.println("Выберити верное значение.");
        }
    }

    public static void deleteElem(Scanner scanner, DoubleLinkedList list){
        System.out.print("Удаление по значению - 1, по индексу - 2: ");
        int reply = SafeScanner.scanInt(scanner);
        long startTime, endTime;
        int num;
        switch (reply){
            case 1:
                System.out.print("Введите нужное значение: ");
                num = SafeScanner.scanInt(scanner);
                startTime = System.nanoTime();
                list.deleteByData(num);
                endTime = System.nanoTime();
                System.out.print("Ваш список теперь: ");
                list.displayList();
                System.out.println('\n');
                System.out.println("\nВремя создания массива - " + (endTime - startTime) + " наносекунд");
                break;
            case 2:
                System.out.print("Введите нужный индекс: ");
                num = SafeScanner.scanInt(scanner);
                startTime = System.nanoTime();
                list.deleteByIndex(num);
                endTime = System.nanoTime();
                System.out.print("Ваш список теперь: ");
                list.displayList();
                System.out.println('\n');
                System.out.println("\nВремя создания массива - " + (endTime - startTime) + " наносекунд");
                break;
            default:
                System.out.println("Выберити верное значение.");
        }
    }

    public static void changeLinks(Scanner scanner, DoubleLinkedList list){
        System.out.print("Введите количество узлов для изменения: ");
        int count = SafeScanner.scanInt(scanner);
        if(count < 1 || count > list.findLength(list)){
            System.out.println("Количество узлов должно быть больше 0 и меньше общего количества узлов");
        }
        else{
            list.changeLinks(list, count);
        }
        list.displayList();
    }

    public static void addElem(Scanner scanner, DoubleLinkedList list){
        System.out.print("Введите число для добавления в список: ");
        int data = SafeScanner.scanInt(scanner);
        System.out.print("Вставить в начало - 1, в конец - 2: ");
        int answer = SafeScanner.scanInt(scanner);
        long startTime, endTime;
        switch (answer){
            case 1:
                startTime = System.nanoTime();
                list.insertFirst(data);
                endTime = System.nanoTime();
                System.out.println("Ваш список теперь: ");
                list.displayList();
                System.out.println("\nВремя создания массива - " + (endTime - startTime) + " наносекунд");
                break;
            case 2:
                startTime = System.nanoTime();
                list.insertLast(data);
                endTime = System.nanoTime();
                System.out.println("Ваш список теперь: ");
                list.displayList();
                System.out.println("\nВремя создания массива - " + (endTime - startTime) + " наносекунд");
                break;
            default:
                System.out.println("Выберити верное значение.");
        }
    }
}
