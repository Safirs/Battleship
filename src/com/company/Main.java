package com.company;

public class Main {

    public static void main(String[] args) {

        // write your code here
        System.out.println("Welcome to the BattleShip!");
        System.out.println();
        System.out.println("Lets introduce you to THE GAME!");
        System.out.println("The idea of Battleship is to try and sink all of the other player's ships before" +
                " they sink all of yours ." +
                " All of the other player's ships are somewhere on his/her board." +
                " You try and hit them by calling out the coordinates of one of the squares on the board." +
                " The other player also tries to hit your ships by calling out coordinates." +
                " Neither you nor the other player can see the other's board so you must try to guess where they are.  " +
                "Each board in the physical game has two grids:  " +
                "the lower (horizontal) section for the player's ships and the upper part (vertical during play) for recording the player's guesses.");
        System.out.println("Let's START");
        System.out.println("Good Luck!:)");

        }
    public static class Background {
        public static void makeGrid() {
            for (int i = 0; i < 12; i++) {
                if (i < 1) {
                    for (int j = 0; j < 15; j++) {
                        System.out.print("__");
                    }
                    System.out.println();
                }
                for (int j = 0; j < 11; j++) {
                    System.out.print("|");
                    if (j < 10) {
                        System.out.print("__");
                    }
                }
                System.out.println();
            }
        }
    }
}



