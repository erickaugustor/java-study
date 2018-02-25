package com.company;

public class Fila {
    String[] item = new String [10];
                                                 //String item[]; da um nome ao vetor
                                                 //new String [10]; cria um vetor

    int ultimo = -1;

    void guarde(String x){
        ultimo ++;                               //acumulando um valor, ele não está atualizando, logo, não é set
        item[ultimo] = x;	                     //set é para atualizar
                                                 //incrementa
                                                 //adiciona no valor
    }

    String getUmItem(){
        return item[0];                          //get para buscar algo
                                                 //is para buscar boolean
    }

    void jogueForaUmItem(){
                                                 //joga fora o zero, e pega o 1 e coloca no zero

        for(int i = 0; i<ultimo; i++){
            item[i] = item[i+1];
                                                //chega no penultimo
        }

        item[ultimo] = null;
        ultimo--;
    }
}
