package com.projeto1;

/*
public class Pilha <X>{

    private Object[] pilha;
    int qtd, alturaMaxima, fim;

    public void Pilha(int alturaMaxima) throws  Exception {
        if(alturaMaxima <=0 )
            throw new Exception("Size must be positive");

        this.alturaMaxima = alturaMaxima;
        this.pilha = new Object[alturaMaxima];
        this.fim = -1;
        this.qtd = 0;
    }


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



    public boolean isFull() {
        return this.size == this.maxLength;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int getLength() {
        return this.size;
    }

    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (this.getClass() != obj.getClass())
            return false;


        Fila q = (Fila<X>)obj;

        if (this.qtd != q.qtd)
            return false;

        int positionThis = this.begin;
        int positionQ    = q.begin;
        int quantity     = this.size;

        while (quantity > 0) {
            if (!this.queue[positionThis].equals(q.queue[positionQ]))
        }

        return true;

    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (this.getClass() != obj.getClass())
            return false;


        Pilha s = (Pilha<X>)obj;

        if (this.qtd != s.qtd)
            return false;

        int position = this.fim;
        int quantity = this.qtd;

        while (quantity > 0) {
            if (!this.pilha[position].equals(s.pilha[position]))
                return false;

            position--;
            quantity--;
        }

        return true;
    }

    public String toString() {
        String str = "";

        for (int i = 0; i < this.qtd; i++) {
            str += this.pilha[i] + " ";
        }

        return str;
    }


}

*/