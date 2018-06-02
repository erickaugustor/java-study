package com.company.auxiliares;

public class Auxiliares {
    protected static double calcular(double a, char operacao, double b) throws Exception{
        switch(operacao){
            case '+':
                return somar(a, b);
            case '-':
                return subtrair(a, b);
            case '*':
                return multiplicar(a, b);
            case '/':
                return dividir(a, b);
            case '^':
                return exponenciacao(a, b);
        }

        throw new Exception("A operação não é capaz de ser realizada!");
    }

    private static double somar(double a, double b){
        return(a+b);
    }

    private static double subtrair(double a, double b){
        return(a-b);
    }

    private static double dividir(double a, double b){
        return(a/b);
    }

    private static double multiplicar(double a, double b){
        return(a*b);
    }

    private static double exponenciacao(double a, double b){
        return(Math.pow(a, b));
    }

    protected boolean ehNumero(String pedaco) {
        double numero;

        try {
            Double.parseDouble(pedaco);
        } catch (NumberFormatException erro) {
            return false;
        }

        return true;
    }

    protected boolean ehSimboloValido(Character simbolo) {
        if (ehAbre(simbolo) || ehFecha(simbolo) || ehOperador(simbolo))
            return true;
        return false;
    }

    protected boolean ehAbre(Character abre) {
        if (abre.equals('('))
            return true;
        return false;
    }

    protected boolean ehFecha(Character abre) {
        if (abre.equals(')'))
            return true;
        return false;
    }

    protected boolean ehOperador(Character operador) {
        if (operador.equals('*')
                || operador.equals('/')
                || operador.equals('-')
                || operador.equals('+')
                || operador.equals('^'))
            return true;
        return false;
    }
}


