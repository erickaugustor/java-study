package com.projeto1;

import java.lang.reflect.Method;

public class Fila <X> implements Cloneable{
    //herda de Cloneable
    //Cloneable é uma interface  ->  herdou .clone()

    //métodos de uma interface são abstratos
    //mas o que são abstratos? quem herdar tem que implementar
    //tem clone sem implementar
    //clone sem implementar
        //se não fizer clone, dá erro

    private Object[] item;
    private int      inicio =  0;
    private int      fim    = -1;
    private int      qtd    =  0;



    private  X meuClonedeX (X modelo){

        //fazer isso caso não seja clone:

        // return (X)modelo.clone();


        //nem testar se é clone


        //isso é pq isso é um inferno que eu deveria colocar em mtas lugares
        //método que eu fiz

        X ret = null;
        try{

            Class<?> classe =  modelo.getClass();
            Class<?>[] tipodoParametroFormal = null;
            Method metodo = classe.getMethod("clone", tipodoParametroFormal);
            Object[] parametroReal = null;
            ret = (X)metodo.invoke(modelo, parametroReal);          //invoke, tenho que clonar algo do tipo X, sei que X é uma classe que herda de Object, mas clone não está em object
                                                                    // sei que X tem clone, pq foi testado no clone, if(Conable) chama o método
                    // como é o demonio do try? declrar algo do tipo Class, guardar X dentro da Class, getMethod dá exception, por isso dentro do try, pegar na classe o clone
                    // parametro formal, varios metodos do mesmo nome com paramtros diferente, logo, clone com parametros do tipo formal
                    // como não tem paramtro, coloco null, pega então o metodo clone com esses parametros
                    // metodo para chamar outro, invoke invoca o clone
                    // this do clone e o this do invoke, logo, o this do invoke é o metodo, pq coloca metodo.invoke.
                    // quem é o this do clone? logo, passo como parametro o this que o modelo é o this.
                    // logo o invoke chama o clone sem passar parametro

        }catch (Exception erro){
            // ignorar erro
        }

        return ret;
    }




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

    /*
    *       Forma fácil de isolar o hífen
    *
    *       String uni = "PUC-CAMPINAS";
    *       char sep = uni.charAt(3);
    *
    *       Demoniaco:
    *
    *       String uni = "PUC-CAMPINAS";
    *       char sep;
    *
    *                                                                               // obj da classe class:
    *       Class<?> classe = uni.getClass();
    *       Integer parametro = 3;
    *       Class<?>[] parmFormal = new Class<?>[1];                                //1 pq charAt só tem 1 parametro
    *       parmFormal[0] = parametro.getClass();                                    //guardou integer
    *       Method metodo = classe.getMethod("charAt", paramFormal);
    *       Object[] paramtroReal = new Object [1];                                  // 1 pq ChartAt
    *       parametroReal [0] = parametro;                                          // coloca o 3
    *       sep = ((Character)metodo.invoke(uni, parametroReal)).charValue();
    *
    *
    */


    public void guarde (X x) throws Exception{
        if (x==null)
            throw new Exception ("Informacao ausente");

        if (this.qtd==this.item.length)
            throw new Exception ("Nao cabe");

        this.fim++;
        if (this.fim==this.item.length)
            this.fim = 0;

        if(this.item[this.fim] instanceof Cloneable) {
            //this.item[this.fim] = x.clone();

            /*
            Class<?> classe = x.getClass();
            Class<?>[] parmFormal = null;                                  // null pq clone n tem parametros
            Method metodo = classe.getMethod("clone");
            Object[] parametroReal = null;                                  // 1 pq ChartAt
            this.item[this.fim] = (X)metodo.invoke(x, parametroReal);
            // não é necessario, o convencimento para X
            */

            this.item[this.fim] = meuClonedeX(x);

        }else
            this.item[this.fim] = x;

        //encapsulamento, não deixa ngm de fora acessar/retornar

        this.qtd++;
    }

    public X getUmItem () throws Exception{
        if (this.qtd==0)
            throw new Exception ("Vazio");

        if(this.item[this.inicio] instanceof Cloneable)
            return meuClonedeX((X)this.item[this.inicio]);              //classe generica, clonar algo do tipo misterioso
        else                                                            //SE NÃO FOR GENERICA, COLOCAR AQELA LINHA ALI DA LINHA DE CIMA .CLONE()
            return (X)this.item[this.inicio];
            // a anta terá acesso a algo que não é ponteiro
            // mas a anta não conseguirá alternar

        // voltar para anta, então tem que por clone
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

    // construtor não conta! :(

    // 1 chamar o clone, sempre que vc armazenar algo que vem da anta, ou que vai pra anta
    // sempre que altera atributo



    // REALIZEI OS CLONES ACIMA
    // toda essa confusão vem de clonar algo do tipo X



    // Classe genérica para estrutura de dados!!!!!!!!!!!!!!!!!!!!!!

    public Fila (Fila<X> modelo) throws Exception {
        if (modelo == null) {
            throw new Exception("Modelo ausente");
        }

        this.qtd = modelo.qtd;
        this.inicio = modelo.inicio;
        this.fim = modelo.fim;
        this.item = new Object[modelo.item.length];

        for (int i = 0; i < modelo.item.length; i++) {
            this.item[i] = modelo.item[i];
        }

    }

    public Object clone() {

        Fila<X> ret = null;

        try {
            ret = new Fila<X>(this);

            /*
            * O mesmo seria fazer
            *
            * Fila<X> ret = null;
            * try{
            *   ret = new Fila<X>(this.item.length);
            * }catch(Excepetion erro){
            *   //sei que o tamanho já ta pronta, que no caso é o tamanho do this, então já está validado pelo construtor que construiu a fila
            * }
            *
            *
            *
            *
            * */
        } catch (Exception erro) {
            // sei que não ha erro pq o construtor de copia tem excessao, e o this nunca é nulo, em método nenhum
        }

        return ret;
    }



}

