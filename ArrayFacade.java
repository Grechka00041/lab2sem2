package org.example.array;

import java.util.Scanner;

import static org.example.array.ArrayActions.*;


public class ArrayFacade {
    int[] array;
    Scanner scanner;

    public ArrayFacade(int[] array, Scanner scanner){
        this.array = array;
        this.scanner = scanner;
    }

    public void create(){
        makeArray(scanner, array);
    }

    public void add(){
        addElem(scanner, array);
    }

    public void delete(){
        deleteElem(scanner, array);
    }

    public void swap(){
        swapElem(scanner, array);
    }

    public void change(){
        changeElems(scanner, array);
    }

    public void get(){
        getElem(scanner, array);
    }
}
