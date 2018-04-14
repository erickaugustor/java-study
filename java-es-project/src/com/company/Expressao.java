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
        if(ehOperacao(exp) || expressaoMatematica.matches("[0-9]")){
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

            if(pedacoDaOperacao.charAt(0) == '('){
                pilhaDeOperacao.guarde(pedacoDaOperacao);

            }else if(pedacoDaOperacao.charAt(0) == ')'){
                do{
                    filaDeCalculo.guarde(pilhaDeOperacao.getUmItem());
                    pilhaDeOperacao.jogueForaUm();

                    if(pilhaDeOperacao.estaVazia())
                        throw new Exception("Você colocou um fecha errado!");
                }while(pilhaDeOperacao.getUmItem().charAt(0) != '(' && pilhaDeOperacao.estaVazia());

            }else if(ehNumero(pedacoDaOperacao)){
                filaDeCalculo.guarde(pedacoDaOperacao);

            }else if(ehOperacao(pedacoDaOperacao.charAt(0))){
                if(!(pilhaDeOperacao.estaVazia())){
                    while(!(pilhaDeOperacao.estaVazia()) && tabela.valorDaOperacao(pedacoDaOperacao.charAt(0), pilhaDeOperacao.getUmItem().charAt(0))){
                        filaDeCalculo.guarde(pilhaDeOperacao.getUmItem());
                    }
                    pilhaDeOperacao.guarde(pedacoDaOperacao);
                }else {
                    pilhaDeOperacao.guarde(pedacoDaOperacao);
                }
            }else{
                throw new Exception("Algo está errado!");
            }

        }while(quebrador.hasMoreTokens());

        while(!(pilhaDeOperacao.estaVazia())){
            filaDeCalculo.guarde(pilhaDeOperacao.getUmItem());
            pilhaDeOperacao.jogueForaUm();
        }

    }

    private boolean ehNumero(String pedaco){
        double numero;

        try{
            Double.parseDouble(pedaco);
        }catch(NumberFormatException erro){
            return false;
        }

        return true;
    }

    private boolean ehOperacao(Character operador){
        if(operador.equals('*')
                || operador.equals('/')
                || operador.equals('-')
                || operador.equals('+')
                || operador.equals('^')
                || operador.equals(')')
                || operador.equals('('))
            return true;
        return false;
    }

}
