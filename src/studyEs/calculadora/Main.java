package com.projeto1;

public class Main {
    public static void main (String[] args) throws Exception {
        try
        {
            Fila<String> f1 = new Fila<String> (10);
            Fila<String> f2 = new Fila<String> (10);
            // Pilha<String> p1 = new Pilha<String> ();

            for (int i=0; i<10; i++)
            {
                f1.guarde ("PUCC"+i);
                f2.guarde ("PUCC"+i);
            }

            if (f1==f2)
                System.out.println ("Iguais");
            else
                System.out.println ("Diferentes"); // <<<<<<<<<

            Fila<String> f3 = f1;

            if (f1.equals(f2))
                System.out.println ("Iguais"); // <<<<<<<<<
            else
                System.out.println ("Diferentes");

            System.out.println (f1);
            // é a mesma coisa que chamar (f1.toString())
            // tratar o toString, pq se não ele vai printar o endereço da classe
        }
        catch (Exception erro)
        {} // pq sei q n vai acontecer excecao nenhuma
    }
}