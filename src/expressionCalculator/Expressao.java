package com.company;

import com.company.auxiliares.Auxiliares;
import com.company.estruturas.Fila;
import com.company.estruturas.Pilha;

import java.util.StringTokenizer;

public class Expressao extends Auxiliares {

    private String expressao, resultado;

    public Expressao(String expressaoUsuario) throws Exception {
        this.expressao = transformarExpressao(expressaoUsuario);
        realizarExpressao(this.expressao);
    }

    private String transformarExpressao(String expressaoUsuario) throws Exception {
        String expressaoTransformada = expressaoUsuario.replaceAll("\\s+", "");

        if (expressaoTransformada.length() == 0)
            throw new Exception("A informação colocada está vazia.");

        for (int i = 0; i < expressaoTransformada.length(); i++) {
            validarExpressao(expressaoTransformada.charAt(i));
        }

        if(expressaoTransformada.length() == 1){
            if(ehNumero(expressaoTransformada))
                throw new Exception("Você só digitou um número!");
            if(ehOperador(expressaoTransformada.charAt(0)))
                throw new Exception("Você digitou apenas um operador!");

        }

        return expressaoTransformada;
    }

    private boolean validarExpressao(Character exp) throws Exception {
        String expressaoAritmetica = exp.toString();
        if (ehSimboloValido(exp) || expressaoAritmetica.matches("[0-9]")) {
            return true;
        } else {
            throw new Exception("Algum dado não faz parte de uma expressão matemática!");
        }
    }

    private void realizarExpressao(String expressao) throws Exception {
        StringTokenizer quebrador = new StringTokenizer(expressao, "+-*/^()", true);

        Pilha<String> pilhaDeOperacao = new Pilha<String>(expressao.length());
        Fila<String> filaDeCalculo = new Fila<String>(expressao.length());
        Tabela tabela = new Tabela();

        char operacao;
        double valorUm, valorDois;
        int flag = 0, flagOperador = 0;


        String pedacoDaOperacao;

        do {
            pedacoDaOperacao = quebrador.nextToken();

            if (ehAbre(pedacoDaOperacao.charAt(0))) {
                flagOperador = 0;
                pilhaDeOperacao.guarde(pedacoDaOperacao);

            } else if (ehFecha(pedacoDaOperacao.charAt(0))) {

                flagOperador = 0;

                do {
                    if (pilhaDeOperacao.estaVazia())
                        throw new Exception("Você colocou um fecha errado!");

                        filaDeCalculo.guarde(pilhaDeOperacao.getUmItem());
                        pilhaDeOperacao.jogueForaUm();

                    if (pilhaDeOperacao.estaVazia())
                        throw new Exception("Você colocou um abre errado!");

                } while (!ehAbre(pilhaDeOperacao.getUmItem().charAt(0)));

                pilhaDeOperacao.jogueForaUm();

            } else if (ehNumero(pedacoDaOperacao)) {
                flagOperador = 0;
                filaDeCalculo.guarde(pedacoDaOperacao);
                flag++;
                if(flag<1)
                    throw new Exception("Não é uma expressão aritmética!\nNão há informações suficientes para o cálculo!");

            } else if (ehOperador(pedacoDaOperacao.charAt(0))) {
                flagOperador++;
                flag++;
                if(flag<2)
                    throw new Exception("Não é uma expressão aritmética!\nNão há informações suficientes para o cálculo!");

                if (!(pilhaDeOperacao.estaVazia())) {

                    while (!pilhaDeOperacao.estaVazia() && tabela.valorDaOperacao(pedacoDaOperacao.charAt(0), pilhaDeOperacao.getUmItem().charAt(0))) {
                        filaDeCalculo.guarde(pilhaDeOperacao.getUmItem());
                        pilhaDeOperacao.jogueForaUm();
                    }
                    pilhaDeOperacao.guarde(pedacoDaOperacao);


                } else {
                    pilhaDeOperacao.guarde(pedacoDaOperacao);
                }
            } else {
                throw new Exception("Algo está errado!");
            }

            if(flagOperador == 2) throw new Exception("Operadores juntos!");

        } while (quebrador.hasMoreTokens());

        while (!pilhaDeOperacao.estaVazia()) {
            if (ehAbre(pilhaDeOperacao.getUmItem().charAt(0)))
                throw new Exception("Operação inválida!");
            filaDeCalculo.guarde(pilhaDeOperacao.getUmItem());
            pilhaDeOperacao.jogueForaUm();
        }

        pilhaDeOperacao = new Pilha<String>(filaDeCalculo.getQuantosElementos());

        do {
            while (!(ehOperador(filaDeCalculo.getUmItem().charAt(0)))) {
                pilhaDeOperacao.guarde(filaDeCalculo.getUmItem());
                filaDeCalculo.jogueForaUmItem();
            }

            if(ehOperador(filaDeCalculo.getUmItem().charAt(0))){
                try {
                    operacao = filaDeCalculo.getUmItem().charAt(0);
                    filaDeCalculo.jogueForaUmItem();

                    valorDois = Double.parseDouble(pilhaDeOperacao.getUmItem());
                    pilhaDeOperacao.jogueForaUm();

                    valorUm = Double.parseDouble(pilhaDeOperacao.getUmItem());
                    pilhaDeOperacao.jogueForaUm();

                    pilhaDeOperacao.guarde(String.valueOf(calcular(valorUm, operacao, valorDois)));
                }catch(Exception err){
                    System.err.print("Não é possível realizar o calculo! \n");
                }
            }
        } while (!(filaDeCalculo.vazia()));

        this.resultado = pilhaDeOperacao.getUmItem();
    }

    public String getResultado() {
        return this.resultado;
    }

    /*  MÉTODOS OBRIGATÓRIOS */

    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (this.getClass() != obj.getClass())
            return false;

        Expressao exp = (Expressao) obj;

        if ((this.expressao != exp.expressao) || (this.resultado != exp.resultado))
            return false;

        return true;
    }

    public String toString() {
        String ret = "";

        String expressao = this.expressao, qtd = this.resultado;
        ret = "Expressão desejada: " + expressao + ", resultado:  " + resultado;

        return ret;
    }

    public Expressao(Expressao modelo) throws Exception{
        if(modelo == null){
            throw new Exception("Modelo ausente");
        }

        this.expressao = modelo.expressao;
        this.resultado = modelo.resultado;
    }

}