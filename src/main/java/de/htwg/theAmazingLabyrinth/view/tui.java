package de.htwg.theAmazingLabyrinth.view;


import de.htwg.theAmazingLabyrinth.controller.controller;
import de.htwg.theAmazingLabyrinth.model.player;
import de.htwg.theAmazingLabyrinth.model.token;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class tui {
    //private Logger logger  = Logger.getLogger("de. htwg.theAmazingLabyrinth.view.tui");
    private static String[] tokenfield = new String[9];
    private static List<String[]>  desk = new LinkedList<String[]>();

    public static void main(String[] args){
        //set up logging through log4j
        //ProbertyConfigurator.configure("log4j.properties")

        int[] a = {0,1,1,1};
        token Token = new token("test",a, 5);
        System.out.println(Token.getEnd());
        createToken(Token);
        System.out.println("tui");
        System.out.println("test: ");

        for(int i = 1; i <= 9; i++){
            System.out.print(tokenfield[i-1]);
            if(i%3 == 0)System.out.println();
        }

        System.out.println();
        printTUI();

    }

    public static void printTUI(){
        //logger.info(newLine + controller.getGridString());
        //logger.info(newLine + controller.getStatus());
        createDesk(7);
    }

    /*create the desk*/
    private static void createDesk(int desklength){
        Map<Integer, token> token;
        Map<Integer, player> player;
        token Token = new token("L - Token", 1, 0);
        controller Controller = new controller(4,desklength, Token);
        token = Controller.getToken();
        player = Controller.getPlayer();
        int counter = 0;
        int e = 0;
        int w = 0;
        for(int i = 0; i < token.size(); i++) {
            createToken(token.get(i));
            desk.add(i, tokenfield);

            String[] tmp = desk.get(i);
            while(e < 3){
                while(w < 3){
                    System.out.print(tmp[counter]);
                    counter++;
                    w++;
                }
                e++;
                w = 0;
                System.out.println();
            }
        }
/*
        String[] ar = new String[21];
        String[] tmp;
        int arCounter = 0;
        for(int i = 0; i < desklength; i++){
            tmp = desk.get(i);
            ar[arCounter] = tmp[0];
            ar[arCounter+1] = tmp[1];
            ar[arCounter+2] = tmp[2];
            arCounter +=3;
        }
        for(int c = 0; c < ar.length; c++) {
            System.out.print(ar[c]);
        }*/

        int counterToken = 8;
        String[] tmp = desk.get(1);
        for(int i  = 0; i < 3; i++){
            for(int j = 0; j  < 3; j++){
                System.out.print(tmp[counterToken]);
                counterToken--;
            }
            System.out.println();
        }

    }

    /*create one Token*/
    private static void createToken(token Token){
        tokenfield[0] = "X";
        tokenfield[2] = "X";
        tokenfield[6] = "X";
        tokenfield[8] = "X";

        int[] words = new int[4];
        for (int i = 0; i < 4 ; i++) {
            words[i] = Token.getWay(i);
        }
        transformIntIntoString(words);
        String mark = getMarkofToken(Token);
        tokenfield[4] = mark;
    }

    /*transform the Int - Value of a token into a String - Value*/
    private static void transformIntIntoString(int[] words){
        String[] s = new String[4];
        for(int i = 0; i<words.length; i++){
            if(words[i] == 0){
                s[i] = "X";
            } else if(words[i] == 1){
                s[i] = " ";
            }
        }
        tokenfield[1] = s[0];   //0
        tokenfield[5] = s[1];   //1
        tokenfield[7] = s[2];   //2
        tokenfield[3] = s[3];   //3
    }

    /*get the Mark of a Token as a String - Value*/
    private static String getMarkofToken(token Token){
        int tmp = Token.getEnd();
        if(tmp <= 4){
            return " ";
        }
        String[] names = {"1","2","3","4","5","6","7","8","9","!","§", "%","&",
                          "/","]",")","=","*","+","#","?","@","€","-",";",":","<"};
        for(int i = 5; i < 28; i++){
            if(tmp == i){
                return names[i-5];
            }
        }
        return null;
    }
}
