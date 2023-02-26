package com.amigos;
import java.util.*;

public class Main {
    public static void makeChoice(String decision) {
        if (decision.equals("1")) {
            System.out.println("chose 1");
            char str[] = "101".toCharArray();//get from user
            boolean hasOverflow = true;
            System.out.println(checkOverflow(str,hasOverflow));//remove
            if(checkOverflow(str,hasOverflow)){
                System.out.println("testing condition");//remove
                outPutOverflow(str);
            }else{
            twosComplement(str);
            }
        } else if (decision.equals("2")) {
            System.out.println("chose 2");
            //char str[] = "10010".toCharArray();
        } else {
            System.out.println("chose other");
        }
    }

    //creating states and transitions
    static StringBuilder outputString = new StringBuilder();//correct?
    static StringBuilder overflowString = new StringBuilder();//correct?

    static int state = 0;

    //for start state A
    static void startState(char c) {
        if (c =='0') {
            state = 0;
            outputString.append("0");
            //overflowString.append("1");
        } else if (c == '1') {
            state = 1;
            outputString.append("1");
        } else {
            state = -1; //put an exception for -1 state
        }
    }

    //for state B
    static void stateB(char c) {

        if (c == '0') {
            state = 1;
            outputString.append("1");
        } else if (c == '1') {
            state = 1;
            outputString.append("0");
        } else {
            state = -1; //put an exception for -1 state
        }
    }
    //checking for overflow
    static boolean checkOverflow(char str[],boolean hasOverflow){
        int i;
        int len = str.length;
        for(i=0;i<=len-1;i++){

            if(str[i]=='1'){

                hasOverflow = false;
                break;

            }else{
                hasOverflow = true;
            }
        } return hasOverflow;

    }
    static void outPutOverflow(char str[]){
        overflowString.append('1');
        overflowString.append(str);
        System.out.println(overflowString);
    }

    //logic for checking each part of input
    static void twosComplement(char str[]) { //return sth?
        int len = str.length;
        int ind = len-1;
        int i;
        System.out.println("length of string is "+len);
        System.out.println("at index "+ ind+" "+str[len-1]);


        for (i = len-1; i >=0; i--) {
            System.out.println(i);
            if (state == 0) {
                startState(str[i]);
            } else if (state == 1) {
                stateB(str[i]);    
            } else {
                System.out.println("wrong input");//put exception or remove
            }
        }
        System.out.println(outputString.reverse());

    }



    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("To get two's complement enter 1\nTo check if string ends " +
                "with 001 enter 2\nEnter choice: ");//-->create a pickAction static method?
	String choice = sc.nextLine();
	makeChoice(choice);

}

}
