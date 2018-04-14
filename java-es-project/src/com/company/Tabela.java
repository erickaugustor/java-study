package com.company;

public class Tabela {

    private static final boolean[][] operadores = new boolean[7][7];

    static {
        for(int i=0; i<7; i++){
            // linha
            for(int j=0; i<7; j++){
                //coluna
                if(i<=1 && i>=0){
                    operadores[i][j] = false;
                }else if( i<=3 && i>=2){
                    if(j<=3 && j>=1){
                        operadores[i][j] = true;
                    }else{
                        operadores[i][j] = false;
                    }
                }else if(i<=6 && i>=4){
                    if(j<=5 && j>=1){
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
