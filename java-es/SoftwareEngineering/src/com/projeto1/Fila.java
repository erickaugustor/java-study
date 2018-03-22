package com.projeto1;

public class Fila <X>{
    private Object[] item;
    private int      inicio =  0;
    private int      fim    = -1;
    private int      qtd    =  0;

    public Fila (int capacidade) throws Exception{
        // construtor
        // joga erro

        if (capacidade<=0)
        {
            Exception erro;
            erro = new Exception ("Capacidade invalida");
            throw erro;
        }

        // inicia
        this.item = new Object [capacidade];
    }

    public void guarde (X x) throws Exception{
        if (x==null)
            throw new Exception ("Informacao ausente");

        if (this.qtd==this.item.length)
            throw new Exception ("Nao cabe");

        this.fim++;
        if (this.fim==this.item.length)
            this.fim = 0;

        if(this.item[this.fim] instanceof Cloneable)
            this.item[this.fim] = x.clone();
        else
            this.item[this.fim] = x;

        //encapsulamento, não deixa ngm de fora acessar/retornar

        this.qtd++;
    }

    public X getUmItem () throws Exception{
        if (this.qtd==0)
            throw new Exception ("Vazio");

        if(this.item[this.inicio] instanceof Cloneable)
            return (X)this.item[this.inicio].clone();
        else
            return (X)this.item[this.inicio];
    }

    public void jogueForaUmItem () throws Exception
    {
        if (this.qtd==0)
            throw new Exception ("Vazio");

        this.item[this.inicio] = null;

        this.inicio++;
        if (this.inicio==this.item.length)
            this.inicio=0;

        this.qtd--;
    }



    public boolean cheia (){
        return this.qtd==this.item.length;
    }

    public boolean vazia (){
        return this.qtd==0;
    }

    public int getQuantosElementos (){
        return this.qtd;
    }




    // métodos herdados de object
    // == compara os ponteiros
    // equals compara os valores


    // métodos obrigatórios

    public boolean equals (Object obj){
        // parametro é um objeto, override
        // quando chamar, passa algo

        if (this==obj)
            return true;

        if (obj==null)
            return false;

        //if (!(obj instanceof Fila<String>))
        if (this.getClass() != obj.getClass())
            return false;
        // como saber de onde vem o método?
        // this
        // this é o 'chamante'

        // a classe do this é diferente do que vc passou como objeto


        Fila<X> f = (Fila<X>)obj;
        // sei que obj é fila
        // obj ta apontando pra um lugar que é uma fila, então eu vou forçar a ser fila
        // ponteiro f, usando como fila

        //f.qdt poderia ser ((Fila<X>)obj).qtd

        if (this.qtd != f.qtd)
            return false;

        int atualThis=this.inicio,
                atualF   =f   .inicio,
                qtd      =this.qtd;

        while (qtd>0)
        {
            if (!this.item[atualThis].equals (
                    f   .item[atualF   ]))
                return false;

            qtd--;

            atualThis++;
            if (atualThis==this.item.length)
                atualThis=0;

            atualF++;
            if (atualF==f.item.length)
                atualF=0;
        }

        return true;
    }


    public String toString (){

        // printar de forma bonita, o que vc quer que o usuario veja

        String ret="";

        int atual = this.inicio,
                qtd   = this.qtd;

        while (qtd>0)
        {
            ret += this.item[atual];
            qtd--;

            if (qtd>0)
                ret += "|";

            atual++;
            if (atual==this.item.length)
                atual=0;
        }

        return ret;
    }


    public int hashCode (){
        int ret = 666;
        // valor qualquer != 0

        ret = 7 * ret + new Integer(this.inicio).hashCode();
        ret = 7 * ret + new Integer(this.fim)   .hashCode();
        ret = 7 * ret + new Integer(this.qtd)   .hashCode();

        // soma com o que temos de atributo
        // nossos atributos são primitivos
        // como fazer isso? fazer isso com tipos primitivos

        // multiplica por numero primo qualquer, no caso 7

        int atual = this.inicio, qtd = this.qtd;

        while(qtd > 0){

            if(this.item[atual] != null)
                ret = 7 * ret + this.item[atual].hashCode();

            // testar se não é nulo, pq o hash não pode ser calculado
            // obs: na classe, a inserir não aceita nulo

            qtd--;
            atual++;

            if(atual == this.item.length)
                atual =0;
        }


        return ret;
    }


    // métodos não obrigatórios
    // clone e construtor de cópia

    // quando sua classe tem alguma coisa que altera os valores do atributo
    // quando isso acontecer, é necessário o clone




}

