package com.company;

public class Calculo {

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

    protected static double somar(double a, double b){
        return(a+b);
    }

    protected static double subtrair(double a, double b){
        return(a-b);
    }

    protected static double dividir(double a, double b){
        return(a/b);
    }

    protected static double multiplicar(double a, double b){
        return(a*b);
    }

    protected static double exponenciacao(double a, double b){
        return(Math.pow(a, b));
    }

}
