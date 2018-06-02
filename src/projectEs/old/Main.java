package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            //Getting the expression
            Scanner scanner = new Scanner(System.in);
            Expressao expressao = new Expressao(scanner.nextLine());

            System.out.println(expressao.getResultado());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
