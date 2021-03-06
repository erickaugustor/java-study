package com.company;

import java.lang.reflect.Method;
import java.util.StringTokenizer;

public class Expressao extends Calculo{

    private String expressao, resultado;

    public Expressao(String expressaoUser) throws Exception {
        this.expressao = transformarExpressao(expressaoUser);
        realizarExpressao(this.expressao);
    }

    private String transformarExpressao(String expressaoUser) throws Exception {
        String expressaoTransformada = expressaoUser.replaceAll("\\s+", "");

        if (expressaoTransformada.length() == 0) throw new Exception("A informação colocada está vazia.");

        for (int i = 0; i < expressaoTransformada.length(); i++) {
            validarExpressao(expressaoTransformada.charAt(i));
        }

        return expressaoTransformada;
    }

    private boolean validarExpressao(Character exp) throws Exception {
        String expressaoMatematica = exp.toString();
        if (ehSimboloValido(exp) || expressaoMatematica.matches("[0-9]")) {
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

        String pedacoDaOperacao;

        do {
            pedacoDaOperacao = quebrador.nextToken();

            if (ehAbre(pedacoDaOperacao.charAt(0))) {
                pilhaDeOperacao.guarde(pedacoDaOperacao);

            } else if (ehFecha(pedacoDaOperacao.charAt(0))) {
                do {
                    filaDeCalculo.guarde(pilhaDeOperacao.getUmItem());
                    pilhaDeOperacao.jogueForaUm();

                    if (pilhaDeOperacao.estaVazia())
                        throw new Exception("Você colocou um fecha errado!");

                } while (!ehAbre(pilhaDeOperacao.getUmItem().charAt(0)));
                pilhaDeOperacao.jogueForaUm();

            } else if (ehNumero(pedacoDaOperacao)) {
                filaDeCalculo.guarde(pedacoDaOperacao);

            } else if (ehOperador(pedacoDaOperacao.charAt(0))) {

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

        } while (quebrador.hasMoreTokens());

        while (!pilhaDeOperacao.estaVazia()) {
            if (ehAbre(pilhaDeOperacao.getUmItem().charAt(0)))
                throw new Exception("Operação inválida! :(");
            filaDeCalculo.guarde(pilhaDeOperacao.getUmItem());
            pilhaDeOperacao.jogueForaUm();
        }

        Pilha<String> pilhaResultado = new Pilha<String>(filaDeCalculo.getQuantosElementos());
        char operacao;
        double valorUm, valorDois;

        do {
            while (!(ehOperador(filaDeCalculo.getUmItem().charAt(0)))) {
                pilhaResultado.guarde(filaDeCalculo.getUmItem());
                filaDeCalculo.jogueForaUmItem();
            }

            //if(ehOperador(filaDeCalculo.getUmItem().charAt(0))){
            operacao = filaDeCalculo.getUmItem().charAt(0);
            filaDeCalculo.jogueForaUmItem();

            valorDois = Double.parseDouble(pilhaResultado.getUmItem());
            pilhaResultado.jogueForaUm();

            valorUm = Double.parseDouble(pilhaResultado.getUmItem());
            pilhaResultado.jogueForaUm();

            pilhaResultado.guarde(String.valueOf(calcular(valorUm, operacao, valorDois)));
            //}
        } while (!(filaDeCalculo.vazia()));

        this.resultado = pilhaResultado.getUmItem();

        pilhaDeOperacao = null;
        pilhaResultado = null;
        filaDeCalculo = null;
        tabela = null;
    }

    public String getResultado() {
        return this.resultado;
    }


    private boolean ehNumero(String pedaco) {
        double numero;

        try {
            Double.parseDouble(pedaco);
        } catch (NumberFormatException erro) {
            return false;
        }

        return true;
    }

    private boolean ehSimboloValido(Character simbolo) {
        if (ehAbre(simbolo) || ehFecha(simbolo) || ehOperador(simbolo))
            return true;
        return false;
    }

    private boolean ehAbre(Character abre) {
        if (abre.equals('('))
            return true;
        return false;
    }

    private boolean ehFecha(Character abre) {
        if (abre.equals(')'))
            return true;
        return false;
    }

    private boolean ehOperador(Character operador) {
        if (operador.equals('*')
                || operador.equals('/')
                || operador.equals('-')
                || operador.equals('+')
                || operador.equals('^'))
            return true;
        return false;
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