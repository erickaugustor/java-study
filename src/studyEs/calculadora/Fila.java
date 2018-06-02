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

        this.qtd++;//
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
            *   ret = new Fila<X>(this.tiem.length);
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


    /*
    *
    *  CompareTo
    *
    *  CompareTo, colocar no topo da classe, "implements Comparable"!
    *  Quando fazer? Quando tiver lidando com uma classe, e ver que tem sentido,
    *  tem cabimento, ordernar os objetos em crescente ou decrescente.
    *
    *  Tem cabimento? Implementar.
    *
    *  Ordenar os objetos de fila.
    *  ordenar por qtd é uma forma!
    *  se qtd não é menor, nem maior, é igual.
    *
    *  Se equals dá falso, ou resulta em < e >
    *  Se o equals dá true, o CompareTo resulta em =
    *
    *  Mas se o equals diz que é falso, pq os conteudos são diferentes, como funciona para o compareTo?
    *  CompareTo iria ver o qtd, por exemplo, assim daria erro, porque seriam possivel 4 resultados
    *  < > = e diferente mas com o qtd igual, assim, não é uma ordem
    *
    * */

    /*
    *
    *  Tipos primitivos e afins.
    *
    *  Classes que possuem seus tipos.
    *  8 Classes que são dos tipos ==> Wrapper = Embrulhar
    *  Classes embrulhadoras, elas capsulam dela um tipo primitivo.
    *
    *  Todas as classas Wrappers são Comporable.
    *  Char é Comparale, porque leva em conta o resultado da tabela UNICODE.
    *  String é Comparable, ordem lexográfica.
    *
    *
    *  Tirando essas classas, são raras as classes que tem Comparable.
       É super comum ter clone.
    *
    * */

    /*
    *       public class Data implements Comparable<Data>, Coneable   //Comparable recebe data como parametro
    *       {
    *           private int dia, mes, ano;
    *
    *           //construtor
    *
    *           public Data (int dia, int mes, int ano) throws Exception{
    *               // mesmo não jogar excessão, ainda quero que o usuário saiba do erro
    *               this.setAno(ano);
    *               this.setMes(mes);
    *               this.setDia(dia);
    *               // nessa ordem PELAMORDEDEUS
    *           }
    *
    *           //...
    *           //setters
    *
    *           public void setDia(int d) throws Exception {        //importante lançar erro
    *           {
    *               if (dia < 1 || dia > 31)
    *                   throw new Exception ("Dia invalido");
    *               if ((this.mes == 4 || this.mes == 6 || this.mes == 9 || this.mes == 11) && dia > 30)
    *                   throw new Exception ("Dia invalido");
    *               if(this.mes == 2 && !(this.ano % 4 == 0  || (this.ano % 100 != 0 && this.ano % 400 == 0)) && this.dia > 28)
    *                   throw new Exception ("Dia invalido");
    *
    *               this.dia = dia;         //Nome igual, tem que colocar o this pra referência certa
    *
    *           }
    *
    *           public void setMes(int mes) throws Exception{
    *               if(mes < 1 || mes > 12)
    *                   throw new Exception("Mes invalido");
    *
    *               this.mes = mes;
    *           }
    *
    *           public void setAno(int ano) throws Exception{
    *               this.ano = ano;
    *           }
    *
    *          public int getAno(){
    *               return this.ano;
    *               // Só estou retornando sem clone, porque estão retornando valores escalares, não são instancias de classas, não são ponteiros
    *               // Caso fosse retornado uma instancia, deveriamos chegar na documentação se a classe da Instancia é Cloneable e, neste caso,
    *               // deveriamos retornar uma cópia criada pelo método clone
    *               // Não sendo Coneable, pode-se retornar sem clonar mesmo.
    *          }
    *
    *
    *           // Como deve funcionar? Comparar this e d, para decidir na ordem crescente, quem vem antes,
    *           // quem vem depois, ou se são iguais.
    *
    *           // Caso se conclua que o this vem antes,    deve se retornar um valor negativo, qualquer um.
    *           // Caso se conclua que o this vem depois,   deve se retornar um valor positivo.
    *           // Caso se conclua que o this é igual,      deve se retornar zero.
    *
    *           public int compareTo(Data d)
    *           {
    *
    *               if(this.ano < d.ano)
    *                   return -666;
    *
    *               if(this.ano > d.ano)
    *                   return 666;
    *
    *               if(this.mes < d.mes)
    *                   return -666;
    *
    *               if(this.mes > d.mes)
    *                   return 666;
    *
    *               if(this.dia < d.dia)
    *                   return -666;
    *
    *               if(this.dia > d.dia)
    *                   return 666;
    *
    *               return 0;
    *
    *           }
    *       */

}


