import java.lang.reflect.Method;

public class Fila <X> implements Cloneable {
    private Object[] item;
    private int inicio = 0;
    private int fim = -1;
    private int qtd = 0;

    public Fila(int capacidade) throws Exception{
        // validar

        this.item = new Object[capacidade];

    }

    public boolean equals (Object obj){
        if(this == obj);
        if(obj == null);
        if(this.getClass() != obj.getClass());

        Fila<X> f = (Fila<X>) obj;




    }


    Class<?> classe = modelo.getClass();
    Class<?> [] tipodoParamtroFormal = null;
    Method metodo = classe.getMethod("clone", tipodoParamtroFormal);
    Object[] parametroReal = null;
    ret = (X)metodo.invoke(modelo, parametroReal);

}
