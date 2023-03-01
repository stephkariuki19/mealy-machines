package com.amigos;
import java.util.*;

public class Main {
    //method to check if input is valid
    public static int checkChoice (String decision) throws WrongChoiceException{
        int chosen =0;
        if(decision.equals("1")){
          chosen=1;
        }
        else if(decision.equals("2")){
            chosen=2;
        }else{
            throw new WrongChoiceException("Entered invalid input");
        }
        return chosen;
    }
    //maps user input to correct function
    public static void makeChoice(String decision) {

        if (decision.equals("1")) {//-------------------------> for first part of program
            System.out.println("chose 1");
            System.out.println("Enter string: ");
            Scanner complementInput = new Scanner(System.in);
            String compinput = complementInput.nextLine();
            char str[] = compinput.toCharArray();//get from user
            //boolean hasOverflow = true;
            if(checkOverflow(str)){
                outPutOverflow(str);
            }else{
            twosComplement(str);
            }
        } else if (decision.equals("2")) {//--------------------> for second part of program
            System.out.println("chose 2");
            System.out.println("Enter string: ");
            Scanner comparisonInput = new Scanner(System.in);
            String comparisoninput = comparisonInput.nextLine();
            char str[] = comparisoninput.toCharArray();
            checkString(str);
            checkEndOfString(comparisonString);
        } else {
            System.out.println("wrong input");
        }

    }

    //creating states and transitions for complement program
    static StringBuilder complementString = new StringBuilder();//correct?
    static StringBuilder overflowString = new StringBuilder();//correct?


    static int state = 0;

    //for start state A
    static void startState(char c) {
        if (c =='0') {
            state = 0;
            complementString.append("0");
            //overflowString.append("1");
        } else if (c == '1') {
            state = 1;
            complementString.append("1");
        } else {
            state = -1; //put an exception for -1 state
        }
    }

    //for state B
    static void stateB(char c) {

        if (c == '0') {
            state = 1;
            complementString.append("1");
        } else if (c == '1') {
            state = 1;
            complementString.append("0");
        } else {
            state = -1; //put an exception for -1 state
        }
    }
    //checking for overflow
    static boolean checkOverflow(char str[]){
        boolean hasOverflow = true;
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
    static void twosComplement(char str[]) {
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
                System.out.println("wrong input");
            }
        }
        System.out.println(complementString.reverse());

    }
//second program,checking if string ends with 001
    //for state A
static StringBuilder comparisonString = new StringBuilder();
    static int mealyState =0;
    static void mealyStartState(char c){
        if (c=='0'){
            mealyState = 1;
            comparisonString.append("b");
        }else if(c=='1'){
            mealyState =0;
            comparisonString.append("b");
        }else{
            mealyState =-1;//put exception
        }
    }

    //for stateB
    static void stateOne(char c){
        if (c=='0'){
            mealyState = 2;
            comparisonString.append("b");
        }else if(c=='1'){
            mealyState =0;
            comparisonString.append("b");
        }else{
            mealyState =-1;//put exception
        }

    }

    //for stateC
    static void stateTwo(char c){
        if (c=='0'){
            mealyState = 2;
            comparisonString.append("b");
        }else if(c=='1'){
            mealyState =3;
            comparisonString.append("a");
        }else{
            mealyState =-1;//put exception
        }

    }

    //for state D
    static void stateThree(char c){
        if (c=='0'){
            mealyState = 1;
            comparisonString.append("b");
        }else if(c=='1'){
            mealyState =0;
            comparisonString.append("b");
        }else{
            mealyState =-1;//put exception
        }

    }
    //method to check if string ends with 001
    static void checkString(char str[]){
        int len = str.length;
        int i;
        for(i =0;i<=len-1;i++){
            if(mealyState==0){
                mealyStartState(str[i]);
            }else if(mealyState==1){
                stateOne(str[i]);
            }else if(mealyState==2){
                stateTwo(str[i]);
            }else if(mealyState==3){
                stateThree(str[i]);
            }
        }

    }
    //checks if end of string is a or b
    static void checkEndOfString(StringBuilder output){
        int len = output.length();
        int lastIndex = len-1;//can use a character or string
        if(output.charAt(lastIndex)=='a'){
            System.out.println("Does String end with 001?");
            System.out.println(output);
            System.out.println("TRUE");
        }else if(output.charAt(lastIndex)=='b'){
            System.out.println("Does String end with 001?");
            System.out.println(output);
            System.out.println("FALSE");
        }//can have exception for otherwise

    }


    public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);
	System.out.println("To get two's complement enter 1\nTo check if string ends " +
                "with 001 enter 2\nEnter choice: ");//-->create a pickAction static method?
        // Scanner sc = new Scanner(System.in);
	String choice = sc.nextLine();
	makeChoice(choice);
	//checkChoice(choice);
        try{
            checkChoice(choice);
        } catch (Exception e){
            System.out.println("Problem occurred: "+e);
        }}

}
