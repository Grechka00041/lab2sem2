package org.example.array;

import org.example.SafeScanner;

import java.util.Scanner;

public abstract class ArrayActions {
    public static void makeArray(Scanner scanner, int[] array){
        System.out.println("1 - ввести кол-во элементов для заполнения рандомными числами, \n 2 - ввести элементы массива");
        int reply = SafeScanner.scanInt(scanner);
        switch (reply){
            case 1:
                array = DynamicArray.createArrayRandom(scanner);
                DynamicArray.displayArray(array);
                break;
            case 2:
                array =  DynamicArray.createArrayNumbers(scanner);
                DynamicArray.displayArray(array);
                break;
            default:
                System.out.println("Выберите верное значение.");
        }
    }

    public static void swapElem(Scanner scanner, int[] array){
        System.out.println("Введите индексы элементов для обмена: ");
        int pos1 = SafeScanner.scanInt(scanner);
        int pos2 = SafeScanner.scanInt(scanner);
        if(array.length > Math.max(pos1, pos2)){
            DynamicArray.swap(array, pos1, pos2);
        }
        else{
            System.out.println("Данного индекса нет в массиве.");
        }
        System.out.print("Ваш массив теперь: ");
        DynamicArray.displayArray(array);
        scanner.nextLine();
    }

    public static void getElem(Scanner scanner, int[] array) {
        System.out.println("1 - получение числа из массива по индексу, \n 2 - по значению");
        int reply = SafeScanner.scanInt(scanner);
        long startTime, endTime;
        switch (reply){
            case 1:
                System.out.print("Введите индекс: ");
                int index = SafeScanner.scanInt(scanner);
                if(array.length > index){
                    startTime = System.nanoTime();
                    int res = array[index];
                    endTime = System.nanoTime();
                    System.out.println("\nВремя поиска в массиве по индексу - " + (endTime - startTime) + " наносекунд");
                    System.out.println("Ваше число: " + res);
                }
                else{
                    System.out.println("Данного индекса нет в массиве.");
                }
                break;
            case 2:
                System.out.print("Введите значение: ");
                int data = SafeScanner.scanInt(scanner);
                if(array.length > 0){
                    startTime = System.nanoTime();
                    int res = DynamicArray.findByData(array, data);
                    endTime = System.nanoTime();
                    System.out.println("\nВремя поиска в массиве по значению - " + (endTime - startTime) + " наносекунд");
                    if(res == -1){
                        System.out.println("Числа нет в массиве");
                    }
                    else{
                        System.out.println("Ваше число имеет индекс: " + res);
                    }
                }
                else{
                    System.out.println("Массив пустой.");
                }

                break;
            default:
                System.out.println("Выберите верное значение.");
        }
        scanner.nextLine();
    }

    public static void deleteElem(Scanner scanner, int[] array){
        System.out.println("1 - удаление числа из массива по индексу, \n 2 - по значению");
        int reply = SafeScanner.scanInt(scanner);
        long startTime, endTime;
        switch (reply){
            case 1:
                System.out.print("Введите индекс: ");
                int index = SafeScanner.scanInt(scanner);
                if(array.length > 0 && index < array.length){
                    startTime = System.nanoTime();
                    array = DynamicArray.deleteByIndex(array, index);
                    endTime = System.nanoTime();
                    System.out.println("\nВремя удаления из массива по индексу - " + (endTime - startTime) + " наносекунд");
                }
                else{
                    System.out.println("Данного индекса не существует в массиве.");
                }
                System.out.print("Ваш массив теперь: ");
                DynamicArray.displayArray(array);
                break;
            case 2:
                System.out.print("Введите число: ");
                int data = SafeScanner.scanInt(scanner);
                if(array.length > 0){
                    startTime = System.nanoTime();
                    array = DynamicArray.deleteByData(array, data);
                    endTime = System.nanoTime();
                    System.out.println("\nВремя удаления из массива по значению - " + (endTime - startTime) + " наносекунд");
                }
                else{
                    System.out.println("Массив пустой.");
                }
                System.out.print("Ваш массив теперь: ");
                DynamicArray.displayArray(array);
                break;
            default:
                System.out.println("Выберити верное значение.");
        }
        scanner.nextLine();
    }

    public static void changeElems(Scanner scanner, int[] array){
        System.out.print("Введите количество узлов для изменения: ");
        int count = SafeScanner.scanInt(scanner);
        if(count < 1 || count > array.length){
            System.out.println("Количество узлов должно быть больше 0 и меньше общего количества узлов");
        }
        else{
            DynamicArray.changeLinks(array, count);
        }
        DynamicArray.displayArray(array);
    }

    public static void addElem(Scanner scanner, int[] array){
        long startTime, endTime;
        System.out.print("Введите число для добавления: ");
        int data = SafeScanner.scanInt(scanner);
        System.out.print("Введите индекс в массиве для добавления: ");
        int index = SafeScanner.scanInt(scanner);
        if (index > array.length){
            System.out.println("Данного индекса нет в массиве.");
        }
        else{
            startTime = System.nanoTime();
            array = DynamicArray.add(array, data, index);
            endTime = System.nanoTime();
            System.out.println("\nВремя вставки в массив - " + (endTime - startTime) + " наносекунд");
        }
        System.out.print("Ваш массив теперь: ");
        DynamicArray.displayArray(array);
    }
}
