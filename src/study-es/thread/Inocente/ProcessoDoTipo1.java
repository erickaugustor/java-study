package com.company.Inocente;

public class ProcessoDoTipo1 extends Thread {

    private boolean vivo = true;

    public void morra(){ this.vivo = false; }

    public void run(){
        int i = 1;

        while(this.vivo){
            System.out.println(i);
            i++;
            if(i>25)
                i=1;
        }
    }
}
