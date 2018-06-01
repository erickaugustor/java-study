package com.company.DominandoOMonstro;

public class ProcessoDoTipo2 extends Thread {

    public ProcessoDoTipo2 (Fila<String> x){
        this.f2 = x;
    }

    private boolean vivo = true;

    public void morra(){ this.vivo = false; }

    public void run(){
        while(this.vivo){
            boolean vazia;

            synchronized(this.f2) {
                vazia = this.f2.vazia();
                //na hra q fecha a chave, n existe mais, por isso por fora
            }

            //mudou estrutura compartilhada, CUIDADA
            if(this.f2.vazia())
                this.yield();
            else{
                synchronized() {
                    System.out.println(this.f2.getUmItem());
                    this.f2.jogueForaUmItem();
                }
            }
        }
    }
}
