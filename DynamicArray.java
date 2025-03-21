package org.example.array;

import org.example.SafeScanner;

import java.util.Random;
import java.util.Scanner;

public abstract class DynamicArray {
    public static void displayArray(int[] array){
        for(int num:array){
            System.out.print(num + " ");
        }
    }
    public static int[] createArrayRandom(Scanner scanner){
        long startTime, endTime;
        System.out.print("Введите количество элементов в массиве: ");
        int n = SafeScanner.scanInt(scanner);
        scanner.nextLine();
        Random rand = new Random();
        startTime = System.nanoTime();
        int[] array = new int[n];
        for(int i=0; i< n;i++){
            array[i] = rand.nextInt(100);
        }
        endTime = System.nanoTime();
        System.out.println("\nВремя создания массива - " + (endTime - startTime) + " наносекунд");
        return array;
    }
    public static int[] createArrayNumbers(Scanner scanner) {
        int num;
        long startTime, endTime;
        int[] array = new int[0];
        System.out.print("Введите элементы массива: ");
        startTime = System.nanoTime();
        int[] newArray = null;
        while (scanner.hasNextInt()) {
            num = scanner.nextInt();
            newArray = new int[array.length + 1];
            System.arraycopy(array, 0, newArray, 0, array.length);
            newArray[newArray.length - 1] = num;
            array = newArray;
        }
        endTime = System.nanoTime();
        System.out.println("\nВремя создания массива - " + (endTime - startTime) + " наносекунд");
        scanner.nextLine();
        return newArray;
    }
    public static void swap(int[] array, int pos1, int pos2){
        int temp = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = temp;
    }
    public static int findByData(int[] array, int data) {
        for(int i = 0; i < array.length; i++){
            if(array[i] == data){
                return i;
            }
        }
        return -1;
    }
    public static int[] deleteByIndex(int[] array, int index){
        int[] newArray = new int[array.length - 1];
        for(int i = array.length - 1; i > index; i--){
            newArray[i-1] = array[i];
        }
        for(int j = 0; j < index; j++){
            newArray[j] = array[j];
        }
        return newArray;
    }
    public static int[] deleteByData(int[] array, int data){
        int index = findByData(array, data);
        return deleteByIndex(array, index);
    }
    public static int[] add(int[] array, int data, int index){
        int[] newArray = new int[array.length + 1];
        for(int i = array.length; i > index; i--){
            newArray[i] = array[i-1];
        }
        newArray[index] = data;
        for(int j = 0; j < index; j++){
            newArray[j] = array[j];
        }

        return newArray;
    }
    public static void changeLinks(int[] array, int k){
        Random random = new Random();
        int index;
        int[] numOfLinks = new int[k];
        for(int i = 0; i < k;i++){
            numOfLinks[i] = random.nextInt(array.length-1);
        }
        for(int i = 0; i < k; i++){
            index = numOfLinks[i];
            array[index] = random.nextInt(100);
        }
    }
}
