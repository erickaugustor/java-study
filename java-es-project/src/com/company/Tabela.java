package com.company;

public class Tabela {

    private static final boolean[][] operadores = new boolean[7][7];

    static {
        for(int i=0; i<7; i++){
            // linha
            for(int j=0; i<7; j++){
                //coluna
                if(i>=0 && i<=1){
                    operadores[i][j] = false;
                }else if(i>=2 && i<=3){
                    if(j>=1 && j<=3){
                        operadores[i][j] = true;
                    }else{
                        operadores[i][j] = false;
                    }
                }else if(i>=4 && i<=6){
                    if(j>=1 && j<=5){
                        operadores[i][j] = true;
                    }else{
                        operadores[i][j] = false;
                    }
                }else{
                    if(j!=6)
                        operadores[i][j] = true;
                    else
                        operadores[i][j] = false;
                }
            }
        }
    }

}
