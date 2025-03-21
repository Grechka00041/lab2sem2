package org.example;

import org.example.array.ArrayFacade;
import org.example.list.DoubleLinkedList;
import org.example.list.ListFacade;

import java.util.Scanner;

public abstract class Menu {
    public static void printMenu(){
        System.out.println("Выберите действие:");
        System.out.println("1. Создать двусвязный список");
        System.out.println("2. Вставка элемента в список");
        System.out.println("3. Удаление элемента из списка");
        System.out.println("4. Обмен элементов в списке");
        System.out.println("5. Изменение k узлов списка");
        System.out.println("6. Получение элемента из списка\n");
        System.out.println("7. Создать динамический массив");
        System.out.println("8. Вставка элемента в массив");
        System.out.println("9. Удаление элемента из массива");
        System.out.println("10. Обмен элементов в массиве");
        System.out.println("11. Изменение k элементов массива");
        System.out.println("12. Получение элемента из массива\n");
        System.out.println("13. Выход");
    }
    public static void doMenu(Scanner scanner, DoubleLinkedList list, int[] array) {
        ListFacade listFacade = new ListFacade(list, scanner);
        ArrayFacade arrayFacade = new ArrayFacade(array, scanner);
        int choice;
        do {
            System.out.print("Выберите действие: ");
            choice = SafeScanner.scanInt(scanner);
            switch (choice) {
                case 1:
                    listFacade.create();
                    break;
                case 2:
                    listFacade.add();
                    break;
                case 3:
                    listFacade.delete();
                    break;
                case 4:
                    listFacade.swap();
                    break;
                case 5:
                    listFacade.change();
                    break;
                case 6:
                    listFacade.get();
                    break;

                case 7:
                    arrayFacade.create();
                    break;
                case 8:
                    arrayFacade.add();
                    break;
                case 9:
                    arrayFacade.delete();
                    break;
                case 10:
                    arrayFacade.swap();
                    break;
                case 11:
                    arrayFacade.change();
                    break;
                case 12:
                    arrayFacade.get();
                    break;
                case 13:
                    break;
                default:
                    System.out.println("Пожалуйста выберите число из предложенных вариантов.");
            }
        } while (choice != 13);
    }
}
