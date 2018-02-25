package com.company;

public class Main {

    public static void main(String[] args) {
        Fila f;                                    //criou um nome
        f = new Fila();                            //criou uma instancia
                                                   //atribuiu f o nome

        f.guarde("PUC");
        f.guarde("FAS");
        f.guarde("ES");

        System.out.println( f.getUmItem() );       //printa PUC, no caso dele, no meu caso, ES (ultimo)
        f.jogueForaUmItem();
    }
}
