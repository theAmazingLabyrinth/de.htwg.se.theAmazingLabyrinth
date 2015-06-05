package de.htwg.theAmazingLabyrinth.model;

public class RandomWayToken{
    private int[] ways;
    private WayState currentWays;

    public RandomWayToken(int token) {
        currentWays = createRandomToken(token);
        ways[0] =(int)(Math.random() * 2);
    }

    private createRandomToken(int token) {
        switch (token) {
            case 0:
                setWays(new createIToken());
                createToken();
                break;
            }
            case 1: {
                setWays(new createLToken());
                createToken();
                break;
            }
            case 2: {
                setWays(new createTToken());
                createToken();
                break;
            }
        }
    }

    private void setWay(WayState s) {
        currentWays = s;
    }

    private void createToken() {
        currentWays.createToken(this);
    }

    public int[] getWays() {
        return ways;
    }

    interface WayState {
        void createToken();
    }

    class createIToken implements WayState {
         public void createToken() {
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
    }

    class createLToken implements WayState {
        public void createToken() {
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
    }

    class createTToken implements WayState {
        public void createTToken() {
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
}