package com.company.Inocente;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Tecle ENTER para começar e tecle ENTER de novo para PARAR");

        BufferedReader teclado = new BufferedReader( new InputStreamReader( System.in ));


        try{
            teclado.readLine();
            //ele é capaz de lançar erro
            //se ela digita algo, ele evapora, pq não uso seu retorno
        }catch(IOException erro){

        }

        ProcessoDoTipo1 a = new ProcessoDoTipo1();
        a.start();  //esse método é de Thread
        //posso criar outra thread

        ProcessoDoTipo2 b = new ProcessoDoTipo2();
        b.start();

        try{
            teclado.readLine();
            //a main trava no read line, trava o processo da main
        }catch (IOException erro){

        }
        a.morra();
        b.morra();
    }
}
