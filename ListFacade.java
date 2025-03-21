package org.example.list;

import java.util.Scanner;

import static org.example.list.ListActions.*;


public class ListFacade {
    DoubleLinkedList list;
    Scanner scanner;

    public ListFacade(DoubleLinkedList list, Scanner scanner){
        this.list = list;
        this.scanner = scanner;
    }

    public void create(){
            makeList(scanner, list);
    }

    public void add(){
        addElem(scanner, list);
    }

    public void delete(){
        deleteElem(scanner, list);
    }

    public void swap(){
        swapElem(scanner, list);
    }

    public void change(){
        changeLinks(scanner, list);
    }

    public void get(){
        getElem(scanner, list);
    }
}
