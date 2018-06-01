package com.company;

import java.lang.reflect.Method;



public class Pilha <X> implements Cloneable
{
	
	private int qtd    = 0;
	private int topo    =-1;
	private     Object[] item;
	
	@SuppressWarnings("unchecked")
	private X meuCloneDeX(Object item2)
	{
		X ret=null;
		try
		{
			Class<?>classe=item2.getClass();
			Class<?>[]tipoDoParametroFormal=null;
			Method metodo=classe.getMethod("clone",tipoDoParametroFormal);
			Object parametroReal=null;
			ret=(X)metodo.invoke(item2,parametroReal);
		}
		catch(Exception erro)
		{}
		return ret;
	}
	
    Pilha (int capacidade) throws Exception
    {
    	if(capacidade<=0)
    	{
    		Exception erro;
    		erro = new Exception ("capacidade invalida");
    		throw erro;
    	}
    	this.item= new String[capacidade];
    }

    void guarde(X x) throws Exception
    {
    	if (x==null)
            throw new Exception ("Informacao ausente");

        if (this.qtd==this.item.length)
            throw new Exception ("Nao cabe");
        this.topo++;
        if (x instanceof Cloneable)
            this.item[this.topo] = meuCloneDeX (x);
        else
            this.item[this.topo] = x;

        this.qtd++;
    	 
    }
    
    @SuppressWarnings("unchecked")
	public X getItem() throws Exception
    {
    	if (this.qtd==0)
    		throw  new Exception ("Vazio");
    	if (this.item[this.topo] instanceof Cloneable)
            return meuCloneDeX(this.item[this.topo]);
        else
            return (X)this.item[this.topo];
    		
    }
    void jogarItem() throws Exception
    {
    	if(this.qtd==0)
    		throw new Exception("vazio");
    	this.item[this.topo]=null;
    	this.topo++;
    	if(this.topo==this.item.length)
    		this.topo=0;
    		this.qtd--;
    }
    
    public boolean vazia ()
    {
        return qtd==0;
    }
    
    public int getQtd()
    {
    	return this.qtd;
    }
    
    //M�TODOS OBRIGAT�RIOS
    //EQUALS
    public boolean equals (Object obj)
    {
        if (this==obj)
            return true;

        if (obj==null)
            return false;

        if (this.getClass() != obj.getClass())
            return false;

        @SuppressWarnings("unchecked")
		Pilha<X> f = (Pilha<X>)obj;
        if (this.qtd != f.qtd)
            return false;

        int atualThis=this.topo,
            atualp   =f  .topo,
            qtd      =this.topo;
       

        while (qtd>0)
        {
         if(!this.item[atualThis].equals(f.item[atualp]))
        	 return false;
        	 qtd--;
        	 atualThis++;
        	 if(atualThis==this.item.length)
        		 atualThis=0;
        	 atualp++;
        	 if(atualp==f.item.length)
        		 atualp=0;
        }
        return true;
    }

//M�TODO toString
public String toString ()
{
    String ret="";

    int atual = this.topo,
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
//HASHCODE
    @SuppressWarnings("deprecation")
	public int hashCode ()
    {
        int ret = 666; // so nao pode ser zero

        ret = 7*ret + new Integer(this.topo).hashCode();
        ret = 7*ret + new Integer(this.qtd   ).hashCode();

        int atual = this.topo,
            qtd   = this.qtd;

        while (qtd>0)
        {
                ret = 7*ret + this.item[atual].hashCode();

            qtd--;

            atual++;
            if (atual == this.item.length)
                atual = 0;
        }

        return ret;
    }
    
    //M�TODOS NEM SEMPRE OBRIGAT�RIOS
    
    //CLONE E CONSTRUTOR DE C�PIA

    public Pilha (Pilha <X> modelo) throws Exception
    {
        if (modelo==null)
            throw new Exception ("Modelo ausente");

        this.qtd    = modelo.qtd;
        this.topo   = modelo.topo;
        this.item   = new Object [modelo.item.length];

        for (int i=0; i<modelo.item.length; i++)
            this.item[i] = modelo.item[i];
    }

	public Object clone ()
    {
        Pilha <X> ret = null;

        try
        {
            ret = new Pilha<X> (this);
        }
        catch (Exception erro)
        {}

        return ret;
    }


}
