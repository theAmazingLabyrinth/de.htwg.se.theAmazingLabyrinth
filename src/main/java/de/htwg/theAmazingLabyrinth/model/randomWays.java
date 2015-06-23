package de.htwg.theAmazingLabyrinth.model;

public class randomWays{
    private int[] ways = new int[4];
    private int token = 0;

    public randomWays(int token) {
        ways[0] =(int)(Math.random() * 2);
        this.token = token;
        createRandomToken();
    }

    private void createRandomToken(){
        if (token >= 0 && token <3) {
            switch (token) {
                case 0: {
                    createIToken();
                    break;
                }
                case 1: {
                    createLToken();
                    break;
                }
                case 2: {
                    createTToken();
                    break;
                }
            }
        } else {System.out.println("Fehler in der switch - verzweigung in der Klasse randomWays in der Methode createRandomToken");
                System.out.println("zahl nicht >= 0 und < 3!");}
    }

    public int[] getWays() {
        return ways;
    }

    private int[] createIToken(){
             if (ways[0] == 0) {
                 ways[1] = 1;
                 ways[2] = 0;
                 ways[3] = 1;
             } else {
                 ways[1] = 0;
                 ways[2] = 1;
                 ways[3] = 0;
             }
        return ways;
    }

    private int[] createLToken() {
            ways[1] = (int) (Math.random() * 2);
            if (ways[0] == 0 && ways[1] == 0) {
                ways[2] = 1;
                ways[3] = 1;
            } else if (ways[0] == 0 && ways[1] == 1) {
                ways[2] = 1;
                ways[3] = 0;
            } else if (ways[0] == 1 && ways[1] == 0) {
                ways[2] = 0;
                ways[3] = 1;
            } else {
                ways[2] = 0;
                ways[3] = 0;
            }
            return ways;
    }

    private int[] createTToken(){
            if (ways[0] == 1) {
                ways[1] = (int) (Math.random() * 2);
                if (ways[1] == 1) {
                    ways[2] = (int) (Math.random() * 2);
                    if (ways[2] == 0) {
                        ways[3] = 1;
                    } else {
                        ways[3] = 0;
                    }
                    return ways;
                }
                ways[2] = 1;
                ways[3] = 1;
                return ways;
            }
            ways[1] = 1;
            ways[2] = 1;
            ways[3] = 1;
            return ways;
    }



}