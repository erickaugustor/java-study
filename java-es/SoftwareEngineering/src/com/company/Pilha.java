package com.company;

public class Pilha {
    String[] item = new String [10];
    int topo = -1;

    public void push(String x){
        topo++;
        item[topo] = x;
    }

    String getTopo(){
        return item[topo];
    }

    public void pop(){
        item[topo] = null;
        topo--;
    }
}
