package com.company;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Programa 
{
	private double v1 = 0;
	private double v2 = 0;
	private char   op = ' ';
	private int resultado = 0;
	
	public static void main(String args[]) throws Exception
	{
	Pilha <String> p1 = new Pilha<String>(1000); //pilha de operadores 
	Pilha <String> p2 = new Pilha<String>(1000); //pilha de resultado
	Fila <String>  f1 = new Fila <String>(1000); //fila de sa�da
	String tokenAtual = new String();
	@SuppressWarnings("resource")
	Scanner scanner = new Scanner(System.in);
	String exp = scanner.nextLine();
	StringTokenizer quebrador = new StringTokenizer (exp, "+-*/^()", true);
	    while(quebrador.hasMoreTokens())
         {
               tokenAtual=quebrador.nextToken();
               if(!isNumeric(tokenAtual))
               {
            	   if(p1.vazia())
                  		p1.guarde(tokenAtual);
            	   else if(p1.getItem().equals("(") && tokenAtual.equals(")"))
            	        {
            		       f1.guarde(p1.getItem());
            	           p1.jogarItem();
            	           p1.guarde(tokenAtual);   
            	        }
            	        else if((p1.getItem().equals("^") || p1.getItem().equals("*") || p1.getItem().equals("/")) && ((tokenAtual.equals("*") || tokenAtual.equals("/") || tokenAtual.equals("+") || tokenAtual.equals("-") || tokenAtual.equals(")"))))
            	        	   {
            	        	   f1.guarde(p1.getItem());
                 	           p1.jogarItem();
                	           p1.guarde(tokenAtual);
                	           }
            	                       else if((p1.getItem().equals("+") || p1.getItem().equals("-")) && ((tokenAtual.equals("+") || tokenAtual.equals("-") || tokenAtual.equals(")")) )) 
            	                            {
                       	        	        f1.guarde(p1.getItem());
                            	            p1.jogarItem();
                           	                p1.guarde(tokenAtual);
                           	                }
            	                                 else
            	                                 {
            	                                	 p1.guarde(tokenAtual);
            	                                 }          
               }               
               else
            	   f1.guarde(tokenAtual);  
         }
    System.out.println(f1.toString());
    System.out.println(p1.toString());
	}
	
   public static boolean isNumeric(String X)
   {
	   try 
	   {
		Double.parseDouble(X);
		return true;
	   }
	   catch(Exception erro)
	   {return false;}
   }
   
   public static String conta(String X)
   {
	System.out.println(X);   
	return X;   
   }
}

