package com.company;

import java.lang.reflect.Method;

public class Pilha<X> implements Cloneable {
    private Object[] pilha;
    private int posicaoTopo = -1;

    /* Construtor */
    public Pilha(int tamanho) throws Exception{
        if(tamanho <= 0){
            throw new Exception("Tamanho menor que zero! Tente um valor válido");
        }

        this.pilha = new Object[tamanho];
    }

    private X meuCloneDeX (X modelo){
        X ret = null;
        try{
            Class<?> classe = modelo.getClass();
            Class<?>[] tipoDoParametroFormal = null; // null pq nao tem parametros
            Method metodo = classe.getMethod("clone", tipoDoParametroFormal);
            Object[] parametroReal = null; // null pq nao tem parametros
            ret = (X)metodo.invoke(modelo, parametroReal);
        }catch (Exception erro){}
        return ret;
    }


    public void guarde (X x) throws Exception{
        if(x == null)
            throw new Exception("Sem informação!");

        // if((posicaoTopo + 1) == this.pilha.length)

        this.posicaoTopo++;

        if(x instanceof Cloneable){
            this.pilha[posicaoTopo] = meuCloneDeX(x);

        }else{
            this.pilha[posicaoTopo] = x;
        }

    }

    public X getUmItem() throws Exception{
        if(this.posicaoTopo == -1)
            throw new Exception("Pilha vazia!");

        if(this.pilha[this.posicaoTopo] instanceof Cloneable){
            return meuCloneDeX((X) this.pilha[this.posicaoTopo]);
        }else{
            return (X) this.pilha[this.posicaoTopo];
        }
    }

    public void jogueForaUm() throws Exception{
        if(this.posicaoTopo == -1)
            throw new Exception("Pilha vazia!");

        this.pilha[this.posicaoTopo] = null;

        this.posicaoTopo--;
    }

    public int getQuantosElementos(){
        return this.posicaoTopo+1;
    }

    public boolean estaVazia(){
        if(posicaoTopo<0)
            return true;
        return false;
    }

    public boolean estaCheia(){
        if(posicaoTopo == pilha.length-1)
            return true;
        return false;
    }


    /* MÉTODOS OBRIGATÓRIOS */

    public boolean equals (Object obj){
        if(this == obj)
            return true;

        if(obj == null)
            return false;

        if(this.getClass() != obj.getClass())
            return false;

        Pilha<X> p = (Pilha<X>)obj;

        if(this.posicaoTopo != p.posicaoTopo)
            return false;

        int posicaoThis = this.posicaoTopo;

        while(posicaoTopo >= 0){
            if(!this.pilha[posicaoThis].equals(p.pilha[posicaoTopo]))
                return false;

        }

        return true;
    }

    public String toString(){
        String ret = "";
        int pos = this.posicaoTopo;

        while(posicaoTopo > -1){
            ret += this.pilha[posicaoTopo];
            pos--;
        }

        return ret;
    }

    public int hashCode(){
        int ret = 666;

        ret = 7 * ret + new Integer(this.posicaoTopo).hashCode();

        int pos = this.posicaoTopo;

        while(pos > -1){
            ret = 7 * ret + this.pilha[pos].hashCode();

            pos--;
        }

        return ret;

    }

    public Pilha(Pilha<X> modelo) throws Exception{
        if(modelo == null){
            throw new Exception("Modelo ausente");
        }

        this.posicaoTopo = modelo.posicaoTopo;
        this.pilha = new Object[modelo.pilha.length];

        for(int i=0;  i < modelo.pilha.length; i++)
            this.pilha[i] = modelo.pilha[i];

    }

    public Object clone(){
        Pilha<X> ret = null;

        try{
            ret = new Pilha(this);
        }catch(Exception erro){

        }

        return ret;
    }

}
