package com.company;

public class Tabela {

    private static boolean[][] operadores = new boolean[7][7];

    static {
        for(int i=0; i<7; i++){
            for(int j=0; j<7; j++){
                if(i == 0){
                    operadores[i][j] = j == 6;
                }else if(i>0 && i<4){
                    operadores[i][j] = j > 1;
                }else if(i>3 && i<6){
                    operadores[i][j] = j > 5;
                }else{
                   operadores[i][j] = false;
                }
            }
        }
    }

    protected boolean valorDaOperacao(Character operadorUm, Character operadorDois) throws Exception{
        int X = 7, Y = 7;
        Character[] operandos = {'(', '^', '*', '/', '+', '-', ')'};

        for(int i=0; i<7; i++){
            if(operadorUm == operandos[i])
                X = i;
            if(operadorDois == operandos[i])
                Y = i;
        }

        if(X == 7 || Y ==7)
            throw new Exception("A operação está errada.");

        return this.operadores[X][Y];
    }

}
