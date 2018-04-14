package com.company;

import java.util.StringTokenizer;

public class Expressao extends Calculo{

    private String expressao;

    public Expressao(String expressaoUser) throws Exception{
        this.expressao = transformarExpressao(expressaoUser);
    }

    private String transformarExpressao(String expressaoUser) throws Exception {
        String expressaoTransformada = expressaoUser.replaceAll("\\s+", "");

        if (expressaoTransformada.length() == 0) throw new Exception("A informação colocada está vazia.");

        for (int i = 0; i < expressaoTransformada.length(); i++) {
            validarExpressao(expressaoTransformada.charAt(i));
        }

        return expressaoTransformada;
    }

    private boolean validarExpressao(Character exp) throws Exception{
        String expressaoMatematica = exp.toString();
        if(expressaoMatematica.equals('*')
                || expressaoMatematica.equals('/')
                || expressaoMatematica.equals('-')
                || expressaoMatematica.equals('+')
                || expressaoMatematica.equals('^')
                || expressaoMatematica.equals(')')
                || expressaoMatematica.equals('(')
                || expressaoMatematica.contains("^[0-9]")){
            return true;
        }else{
            throw new Exception("Algum dado não faz parte de uma expressão matemática!");
        }
    }

    private void quebrarString() throws Exception{
        StringTokenizer quebrador = new StringTokenizer(expressao, "+-*/^()", true);

        Pilha<String>   pilhaDeOperacao = new Pilha<String>(expressao.length());
        Fila<String>    filaDeCalculo   = new Fila<String>(expressao.length());
        Tabela tabela = new Tabela();

        String pedacoDaOperacao;

        do{
            pedacoDaOperacao = quebrador.nextToken();

        }while(quebrador.hasMoreTokens());


    }

}
