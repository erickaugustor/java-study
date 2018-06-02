package com.company;

public class Data implements Comparable<Data>, Cloneable {

    private int dia, mes, ano;

    public Data(int dia, int mes, int ano) throws Exception{
        this.setAno(ano);
        this.setMes(mes);
        this.setDia(dia);
    }

    public void setDia(int dia) throws Exception {
        if(dia < 1 || dia > 31)
            throw new Exception("Dia invalido");
        if ((this.mes == 4 || this.mes == 6 || this.mes == 9 || this.mes == 11) && dia > 30)
            throw new Exception("Dia inválido");
        if(this.mes == 2 && !(this.ano % 4 == 0  || (this.ano % 100 != 0 && this.ano % 400 == 0)) && this.dia > 28)
            throw new Exception("Dia inválido");

        this.dia = dia;
    }
}
