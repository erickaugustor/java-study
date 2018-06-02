package studyEs.thread.DominandoOMonstro;

import java.lang.reflect.Method;

public class Fila<X> implements Cloneable {

    private Object[] item;
    private int inicio = 0;
    private int fim = -1;
    private int qtd = 0;

    private X meuClonedeX(X modelo) {

        X ret = null;
        try {
            Class<?> classe = modelo.getClass();
            Class<?>[] tipodoParametroFormal = null;
            Method metodo = classe.getMethod("clone", tipodoParametroFormal);
            Object[] parametroReal = null;
            ret = (X) metodo.invoke(modelo, parametroReal);
        } catch (Exception erro) {

        }
        return ret;
    }

    public Fila(int capacidade) throws Exception {
        if (capacidade <= 0) {
            Exception erro;
            erro = new Exception("Capacidade invalida");
            throw erro;
        }
        this.item = new Object[capacidade];
    }

    public void guarde(X x) throws Exception {
        if (x == null)
            throw new Exception("Informacao ausente");

        if (this.qtd == this.item.length)
            throw new Exception("Nao cabe");

        this.fim++;
        if (this.fim == this.item.length)
            this.fim = 0;

        if (this.item[this.fim] instanceof Cloneable) {
            this.item[this.fim] = meuClonedeX(x);
        } else
            this.item[this.fim] = x;

        this.qtd++;
    }

    public X getUmItem() throws Exception {
        if (this.qtd == 0)
            throw new Exception("Vazio");

        if (this.item[this.inicio] instanceof Cloneable)
            return meuClonedeX((X) this.item[this.inicio]);
        else
            return (X) this.item[this.inicio];
    }

    public void jogueForaUmItem() throws Exception {
        if (this.qtd == 0)
            throw new Exception("Vazio");

        this.item[this.inicio] = null;

        this.inicio++;
        if (this.inicio == this.item.length)
            this.inicio = 0;

        this.qtd--;
    }

    public boolean cheia() {
        return this.qtd == this.item.length;
    }

    public boolean vazia() {
        return this.qtd == 0;
    }

    public int getQuantosElementos() {
        return this.qtd;
    }

    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (this.getClass() != obj.getClass())
            return false;

        Fila<X> f = (Fila<X>) obj;

        if (this.qtd != f.qtd)
            return false;

        int atualThis = this.inicio,
                atualF = f.inicio,
                qtd = this.qtd;

        while (qtd > 0) {
            if (!this.item[atualThis].equals(f.item[atualF]))
                return false;

            qtd--;

            atualThis++;
            if (atualThis == this.item.length)
                atualThis = 0;

            atualF++;
            if (atualF == f.item.length)
                atualF = 0;
        }

        return true;
    }


    public synchronized String toString() {
        String ret = "";

        int atual = this.inicio,
                qtd = this.qtd;

        while (qtd > 0) {
            ret += this.item[atual];
            qtd--;

            if (qtd > 0)
                ret += "|";

            atual++;
            if (atual == this.item.length)
                atual = 0;
        }

        return ret;
    }


    public synchronized int hashCode() {
        int ret = 666;

        ret = 7 * ret + new Integer(this.inicio).hashCode();
        ret = 7 * ret + new Integer(this.fim).hashCode();
        ret = 7 * ret + new Integer(this.qtd).hashCode();

        int atual = this.inicio, qtd = this.qtd;

        while (qtd > 0) {

            if (this.item[atual] != null)
                ret = 7 * ret + this.item[atual].hashCode();

            qtd--;
            atual++;

            if (atual == this.item.length)
                atual = 0;
        }

        return ret;
    }

    public Fila(Fila<X> modelo) throws Exception {
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

    public synchronized Object clone() {

        Fila<X> ret = null;

        try {
            ret = new Fila<X>(this);
        } catch (Exception erro) {
        }

        return ret;
    }
}