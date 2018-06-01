package com.company.Inocente;

public class ProcessoDoTipo2 extends Thread {
    private boolean vivo = true;

    public void morra(){ this.vivo = false; }

    public void run(){
        char c = 'A';

        while(this.vivo){
            System.out.println(c);
            c = (char) ((int)c + 1);     //código do A que é 65
            if(c>'Z')
                c='A';
        }
    }
}
