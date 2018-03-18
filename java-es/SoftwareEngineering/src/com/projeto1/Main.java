package com.projeto1;

public class Main {
    public static void main (String[] args) throws Exception {
        try
        {
            Fila<String> f1 = new Fila<String> (10);
            Fila<String> f2 = new Fila<String> (10);

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
        }
        catch (Exception erro)
        {} // pq sei q n vai acontecer excecao nenhuma
    }
}