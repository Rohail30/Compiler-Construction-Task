package com.company;//package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("----------------Name: Rohail Rathore----------------");
        System.out.println("----------------Reg#: 2012362-----------------------");
        System.out.println();

        // write your code here
        String[] lex = new String[165];
        String[] tokName = new String[165];
        String[] attValue = new String[165];

        Scanner input = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter Your Java Code Here");

        String javaCode = input.nextLine() + " ";  // Read user input

        int lexCount = 0;

        //Input: <> < << > >> = == ++ >
        for (int i = 0; i < javaCode.length(); i++) {
            if (i + 1 < javaCode.length()) {
                if (javaCode.charAt(i) == '<' && javaCode.charAt(i + 1) != ' ') {
                    if (javaCode.charAt(i + 1) == '=' && javaCode.charAt(i + 2) == ' ') {
                        lex[lexCount] = "<=";
                        tokName[lexCount] = "Relop";
                        attValue[lexCount] = "LE";
                        i = i + 2;
                        lexCount++;
                    } else if (javaCode.charAt(i + 1) == '>' && javaCode.charAt(i + 2) == ' ') {
                        lex[lexCount] = "<>";
                        tokName[lexCount] = "Relop";
                        attValue[lexCount] = "NE";
                        i = i + 2;
                        lexCount++;
                    } else {
                        String others = "";
                        while (javaCode.charAt(i + 1) != ' ') {
                            others = others + javaCode.charAt(i);
                            i++;
                        }
                        lex[lexCount] = others + javaCode.charAt(i) + " Unrecognized Lexeme";
                        tokName[lexCount] = "Error";
                        attValue[lexCount] = "Error";
                        lexCount++;
                        i++;
                        others = "";
                    }
                } else if (javaCode.charAt(i) == '>' && javaCode.charAt(i + 1) != ' ') {
                    if (javaCode.charAt(i + 1) == '=' && javaCode.charAt(i + 2) == ' ') {
                        lex[lexCount] = ">=";
                        tokName[lexCount] = "Relop";
                        attValue[lexCount] = "GE";
                        i = i + 2;
                        lexCount++;
                    } else {
                        String others = "";
                        while (javaCode.charAt(i + 1) != ' ') {
                            others = others + javaCode.charAt(i);
                            i++;
                        }
                        lex[lexCount] = others + javaCode.charAt(i) + " Unrecognized Lexeme";
                        tokName[lexCount] = "Error";
                        attValue[lexCount] = "Error";
                        lexCount++;
                        i++;
                        others = "";

                    }
                } else if (javaCode.charAt(i) == '=' && javaCode.charAt(i + 1) != ' ') {
                    if (javaCode.charAt(i) == '=' && javaCode.charAt(i + 2) == ' ') {
                        lex[lexCount] = "==";
                        tokName[lexCount] = "Relop";
                        attValue[lexCount] = "EQ";
                        i = i + 2;
                        lexCount++;
                    } else {
                        String others = "";
                        while (javaCode.charAt(i + 1) != ' ') {
                            others = others + javaCode.charAt(i);
                            i++;
                        }
                        lex[lexCount] = others + javaCode.charAt(i) + " Unrecognized Lexeme";
                        tokName[lexCount] = "Error";
                        attValue[lexCount] = "Error";
                        lexCount++;
                        i++;
                        others = "";

                    }
                } else if (javaCode.charAt(i) == '<' || javaCode.charAt(i) == '>') {
                    if (javaCode.charAt(i) == '<') {
                        lex[lexCount] = "<";
                        tokName[lexCount] = "Relop";
                        attValue[lexCount] = "LT";
                        i = i + 1;
                        lexCount++;
                    } else {
                        lex[lexCount] = ">";
                        tokName[lexCount] = "Relop";
                        attValue[lexCount] = "GT";
                        i = i + 1;
                        lexCount++;
                    }
                } else {
                    String others = "";
                    if(javaCode.charAt(i)!=' ') {
                        while (javaCode.charAt(i + 1) != ' ') {
                            others = others + javaCode.charAt(i);
                            i++;
                        }
                        lex[lexCount] = others + javaCode.charAt(i) + " Unrecognized Lexeme";
                        tokName[lexCount] = "Error";
                        attValue[lexCount] = "Error";
                        lexCount++;
                        i++;
                        others = "";
                    }
                }
            }
        }

        String lx = "Lexeme";
        String tn = "Token Name";
        String av = "Attribute Value";
        System.out.printf("%-35s | %-15s | %-15s\n",lx,tn,av);
        System.out.println();
        for (int l = 0; l < lexCount; l++) {
            System.out.printf("%-35s | %-15s | %-15s\n", lex[l],tokName[l],attValue[l]);
        }
    }
}




