package com.company;

import java.awt.*;
import java.util.Scanner;

public class Battleship {
    public static void main(String[] args) {
        System.out.println();
            System.out.println("Welcome to BATTLESHIP!");
            System.out.println();
            System.out.println("Battleship is a classic two player game where players try to sink their opponent's navy ships. \n" +
                    "All of the other player's ships are somewhere on his/her board. \n" +
                    "You have to try to hit them by calling out the coordinates, " +
                    "the other player also tries to hit your ships by calling out coordinates.\n" +
                    "Every player will have 10 ships total - 1 x Battle ship, 2 x Cruiser, 3 x Submarine, 4 x Destroyer.\n" +
                    "The basic object of the game of Battleship is to hide your ship fleet\n" +
                    "somewhere on your ocean and by calling out basic coordinates, find your opponent's fleet before they find yours!");

            System.out.println();
            System.out.println("Let's START");
            System.out.println("Good Luck!:)");

      Background.computerShipPlacement();
      Background.userShipPlacement();
      Background.playGame();

    }

}
