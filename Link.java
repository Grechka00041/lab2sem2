package org.example.list;

public class Link {
    int data;
    Link previous;
    Link next;

    public Link(int data){
        this.data = data;
    }

    public Link getPrevious() {
        return previous;
    }

    public int getData() {
        return data;
    }

    public Link getNext() {
        return next;
    }

    public void setData(int data) {
        this.data = data;
    }
}
