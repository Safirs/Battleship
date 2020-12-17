package com.company;

import java.util.Scanner;

public class Background {
    public static int rows = 11;
    public static int colums = 11;
    public static String[][] grid = new String[rows][colums];
    private static String[] ships = {"CARRIER", "BATTLE SHIP", "CRUISER", "SUBMARINE", "DESTROYER"};
    private static int[] shipLenght = {5, 4, 3, 2, 1};
    private static int x1, x2, y1, y2;
    private static String placement;

    public static void makeGrid() {
        System.out.println();
        System.out.println("                OCEAN MAP                 ");
        System.out.println();
        System.out.print("    ");
        for (int i = 1; i < colums; i++) {
            System.out.print(i + "   ");
        }
        System.out.println();
        System.out.print("  +---+---+---+---+---+---+---+---+---+---+");
        System.out.println();
        for (int i = 1; i < grid.length; i++) {
            if (i == 10) {
                System.out.print(i);
            } else {
                System.out.print(" " + (i));
            }
            for (int j = 1; j < grid.length; j++) {
                grid[i][j] = " ";
                if (j == 10) {
                    System.out.print("| " + grid[i][j] + " |");
                } else {
                    System.out.print("| " + grid[i][j] + " ");
                }
            }
            System.out.println();
            System.out.print("  +---+---+---+---+---+---+---+---+---+---+");
            System.out.println();
        }
    }

    // Lietotájam jáievada sákuma pozícijas x , y koordinátes
    // Jápárliecinás, ka tádas koordinátes jau neeksisté
    // Vai vinas ir rámja ietvaros?
    // un vai nav párak tuvu kádam kugim
    // Vai ir atbilstoš garums?


    public static void userShipPlacement() {
        System.out.println("Lets place the ships on to the ocean map");;
        for (int i = 0; i < ships.length; i++) {
            for (int j = 0; j < shipLenght[shipLenght.length - 1 - i]; j++){
                System.out.println(ships[i] + ": lenght " + shipLenght[i]);
                startCoordinate();
                endCoordinate(shipLenght[i]);
                placeShip();
                printMap();
            }
        }
        }

    private static void printMap() {
        System.out.println();
        System.out.println("                OCEAN MAP                 ");
        System.out.println();
        System.out.print("    ");
        for (int i = 1; i < colums; i++) {
            System.out.print(i + "   ");
        }
        System.out.println();
        System.out.print("  +---+---+---+---+---+---+---+---+---+---+");
        System.out.println();
        for (int i = 1; i < grid.length; i++) {
            if (i == 10) {
                System.out.print(i);
            } else {
                System.out.print(" " + (i));
            }
            for (int j = 1; j < grid.length; j++) {
                if (j == 10) {
                    if ((grid[j][i]).equals("8")){
                        System.out.print("|   |");
                    }
                    else{
                        System.out.print("| " + grid[j][i] + " |");
                    }
                } else {
                    if ((grid[j][i]).equals("8")){
                        System.out.print("|   ");
                    }
                    else {
                        System.out.print("| " + grid[j][i] + " ");
                    }
                }
            }
            System.out.println();
            System.out.print("  +---+---+---+---+---+---+---+---+---+---+");
            System.out.println();
        }
    }

    private static void placeShip() {
        int from, to;
        if (x1 == x2){
            if (y1 > y2){
                from = y2;
                to = y1;
                }
            else {
                from = y1;
                to = y2;
            }
            for (int i = 0; i < to; i++){
                grid[x1][from + i] = "X";
                if(x1 < grid.length) {
                    grid[x1 + 1][from + i] = "8";
                }
                if (x1 > 0){
                    grid[x1 - 1][from + i] = "8";
                }
            }
            if (from > 0) {
                grid[x1][from - 1] = "8";
                if (y1 > 0) {
                    grid[x1 - 1][from - 1] = "8";
                }
                if(y1 < grid.length) {
                    grid[x1 + 1][from - 1] = "8";
                }
            }
            if (to < grid.length) {
                grid[x1][to + 1] = "8";
                if (y1 > 0) {
                    grid[x1 - 1][to + 1] = "8";
                }
                if (y1 < grid.length) {
                    grid[x1 + 1][to + 1] = "8";
                }
            }
        }
        else {
            if (x1 > x2){
                from = x2;
                to = x1;
            }
            else {
                from = x1;
                to = x2;
            }
            for (int i = 0; i < to; i++){
                grid[from + i][y1] = "X";
                if(y1 < grid.length) {
                    grid[from + i][y1 + 1] = "8";
                }
                if (y1 > 0){
                    grid[from +i][y1 - 1] = "8";
                }
            }
            if (from > 0) {
                grid[from - 1][y1] = "8";
                if (y1 > 0) {
                    grid[from - 1][y1 - 1] = "8";
                }
                if (y1 < grid.length) {
                    grid[from - 1][y1 + 1] = "8";
                }
            }
            if (to < grid.length) {
                grid[to + 1][y1] = "8";
                if(y1 > 0) {
                    grid[to + 1][y1 - 1] = "8";
                }
                if (y1 < 0) {
                    grid[to + 1][y1 - 1] = "8";
                }
            }
            }
            }

    private static void endCoordinate(int lenghtOfShip) {
        while (true) {
            System.out.println("End x and y coardinates: ");
            Scanner input = new Scanner(System.in);
            x2 = input.nextInt();
            y2 = input.nextInt();
            System.out.println();
            if (x2 > 0 && y2 > 0 && x2 <= grid.length && y2 <= grid.length) {
                if (x2 == x1 || y2 == y1) {
                    if (y1 == y2 && Math.abs(x2 - x1) != (lenghtOfShip - 1)){
                        System.out.println("ERORR - doesn't match the specified lenght! Lenght : " + lenghtOfShip);
                    }
                    else if ( x1 == x2 && Math.abs(y2 - y1) != (lenghtOfShip -1)){
                        System.out.println("ERORR - doesn't match the specified lenght! Lenght : " + lenghtOfShip);
                    }
                    else if (!(grid[x2][y2]).equals(" ")) {
                        if ((grid[x2][y2]).equals("8")){
                            System.out.println("ERORR - Too close to ship already placed on the map!");
                        }
                        else {
                            System.out.println("ERORR - ship is already placed there!");
                        }
                    }
                    else {
                        grid[x2][y2] = "X";
                        break;
                    }
                }
                else {
                    System.out.println("ERORR - Ship must be placed horizontally or vertically!");
                }
            }
            else {
                System.out.println("ERORR - coordinate input out of bounds!");
            }
        }
    }


    private static void startCoordinate() {
        while (true) {
            System.out.println("Start x and y coardinates: ");
            Scanner input = new Scanner(System.in);
            x1 = input.nextInt();
            y1 = input.nextInt();
            System.out.println();
            if (x1 > 0 && y1 > 0 && x1 <= grid.length && y1 <= grid.length) {
                if (!(grid[x1][y1]).equals(" "))  {
                    if ((grid[x1][y1]).equals("8")) {
                        System.out.println("ERORR - ship is already placed there!");
                    }
                    else {
                        System.out.println("ERORR - Too close to ship already placed on the map!");
                    }
                }
                else {
                    grid[x1][y1] = "X";
                    break;
                }
            }
            else {
                System.out.println("ERORR - coardinate input out of bounds!");
            }
        }
    }
}
