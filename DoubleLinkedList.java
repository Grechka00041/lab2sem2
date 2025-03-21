package org.example.list;

import java.util.Random;

public class DoubleLinkedList{
    static Link first;
    Link last;

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(int data) {
        Link newLink = new Link(data);
        if (isEmpty()) {
            first = newLink;
        } else {
            first.previous = newLink;
            newLink.next = first;
            first = newLink;
        }
    }

    public void insertLast(int data) {
        Link newLink = new Link(data);
        if (isEmpty()) {
            first = newLink;
        } else {
            last.next = newLink;
            newLink.previous = last;
        }
        last = newLink;
    }

    public void displayList() {
        Link current = first;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    public Link findByData(int data) {
        Link current = first;
        if(!(current == null)){
            while (current.data != data) {
                if (current.next == null) {
                    return null;
                } else {
                    current = current.next;
                }
            }
        }
        else{
            return null;
        }
        return current;
    }

    public Link findByIndex(int index) {
        Link current = first;
        if(!(first == null)){
            for (int i = 0; i < index; i++) {
                if(current.next == null){
                    return null;
                }
                current = current.next;
            }
        }
        else{
            return null;
        }
        return current;
    }

    public void deleteByData(int data) {
        Link current = first;
        Link previous = first;
        if(first != null){
            while (current.data != data) {
                if (current.next == null) {
                    System.out.println("Элемент не был найден в списке");
                    return;
                } else {
                    previous = current;
                    current = current.next;
                }
            }
            if (current == first) {
                first = first.next;
            } else {
                previous.next = current.next;
            }
        }
        else{
            System.out.println("Список пуст, удаление не возможно. Пожалуйста сначала инициализируйте список.");
        }
    }

    public void deleteByIndex(int index) {
        Link current = first;
        Link previous = first;
        if (first != null){
            for (int i = 0; i < index; i++) {
                if (current.next == null) {
                    System.out.println("Элемент не был найден в списке");
                    return;
                } else {
                    previous = current;
                    current = current.next;
                }
            }
            if (current == first) {
                first = first.next;
            } else {
                previous.next = current.next;
            }
        }
        else{
            System.out.println("Список пуст, удаление не возможно. Пожалуйста сначала инициализируйте список.");
        }
    }

    public void swap(int num1, int num2){
        Link link1 = findByData(num1);
        Link link2 = findByData(num2);
        if(link1 == null || link2 == null){
            System.out.println("Одного из элементов нет в списке. Обмен не возможен.");
            return;
        }
        int temp = link1.getData();
        link1.setData(link2.getData());
        link2.setData(temp);

    }

    public int findIndex(Link link){
        Link current = first;
        int index = 0;
        while(!(link == current)){
            current = current.next;
            if(current.next == null){
                System.out.println("Данного элемента нет в списке.");
                return -1;
            }
            index++;
        }
        return index;
    }

    public int findLength(DoubleLinkedList list){
        int length = 0;
        Link current = first;
        while(current != null){
            length++;
            current = current.next;
        }
        return length;
    }
    public void changeLinks(DoubleLinkedList list, int k){
        Random random = new Random();
        int[] numOfLinks = new int[k];
        for(int i = 0; i < k;i++){
            numOfLinks[i] = random.nextInt(findLength(list));
        }
        for(int i = 0; i < k;i++){
            Link current = first;
            int index = 0;
            while(index != numOfLinks[i]){
                index++;
                current = current.next;
            }
            current.setData(random.nextInt(100));
        }
    }
}