package com.company;

import java.util.Random;
import java.util.Scanner;

public class Background {
    public static int rows = 10;
    public static int colums = 10;
    public static String[][] grid = new String[rows][colums];
    public static String[][] gridComputer = new String[rows][colums];
    private static String[] ships = {"BATTLE SHIP", "CRUISER", "SUBMARINE", "DESTROYER"};
    private static int[] shipLenght = {4, 3, 2, 1};
    private static int x1, x2, y1, y2;
    private static String placement;
    private static Scanner input = new Scanner(System.in);
    private static int hitComputer, hitUser;


    public static void createEmptyArray(String [][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                grid[i][j] = " ";
            }
        }
    }

    public static void userShipPlacement() {
        createEmptyArray(grid);
        printMap();
        System.out.println("Lets place the ships on to the ocean map");;
        for (int i = 0; i < ships.length; i++) {
            for (int j = 0; j < shipLenght[shipLenght.length - 1 - i]; j++){
                System.out.println(ships[i] + ": lenght " + shipLenght[i]);
                startCoordinate();
                if (i < ships.length - 1) {
                    endCoordinate(shipLenght[i]);
                    placeShip(grid);
                }
                else{
                    placeForOneShip();
                }
                printMap();
            }
        }
        }

        public static void computerShipPlacement() {
            createEmptyArray(gridComputer);
            for (int i = 0; i < ships.length; i++) {
                for (int j = 0; j < shipLenght[shipLenght.length - 1 - i]; j++) {
                    coordinateRandom(shipLenght[i]);
                    if (i < ships.length - 1) {
                        placeShip(gridComputer);
                    }
                    else {
                        placeForOneShip();
                    }
                }
            }
        }

    private static void coordinateRandom(int shipLenght) {
        while(true) {
            int min = 1;
            int max = 2;
            int nrCase = (int) (Math.random() * ((max - min) + 1)) + min;
            int nrCase2 = (int) (Math.random() * ((max - min) + 1)) + min;
            switch (nrCase) {
                case 1:
                    // VERTICALLY
                    while (true) {
                        x1 = (int) (Math.random() * (10));
                        y1 = (int) (Math.random() * (10));
                        if (gridComputer[x1][y1].equals(" ")) {
                            break;
                        }
                    }
                    if (shipLenght > 1) {
                        x2 = x1;
                        if (y1 + shipLenght - 1 > gridComputer.length - 1 || !gridComputer[x2][y1 + shipLenght - 1].equals(" ")) {
                            nrCase2 = 2;
                        } else if (y1 - shipLenght + 1 < 0 || !gridComputer[x2][y1 - shipLenght + 1].equals(" ")) {
                            nrCase2 = 1;
                        }
                        switch (nrCase2) {
                            case 1:
                                y2 = y1 + shipLenght - 1;
                                break;
                            case 2:
                                y2 = y1 - shipLenght + 1;
                                break;
                        }
                        break;
                    }
                case 2:
                    //HORIZONATLLY
                    while (true) {
                        y1 = (int) (Math.random() * (10));
                        x1 = (int) (Math.random() * (10));
                        if (gridComputer[x1][y1].equals(" ")) {
                            break;
                        }
                    }
                    if (shipLenght > 1) {
                        y2 = y1;
                        if (x1 + shipLenght - 1 > gridComputer.length - 1 || !gridComputer[x1 + shipLenght - 1][y2].equals(" ")) {
                            nrCase2 = 2;
                        } else if (x1 - shipLenght + 1 < 0 || !gridComputer[x1 - shipLenght + 1][y2].equals(" ")) {
                            nrCase2 = 1;
                        }
                        switch (nrCase2) {
                            case 1:
                                x2 = x1 + shipLenght - 1;
                                break;
                            case 2:
                                x2 = x1 - shipLenght + 1;
                                break;
                        }
                        break;
                    }
            }
            if (shipLenght == 1){
                    gridComputer[x1][y1] = "X";
                    break;
            }
            else if (shipLenght > 1) {
                    if (placeForShip(shipLenght)) {
                        gridComputer[x1][y1] = "X";
                        gridComputer[x2][y2] = "X";
                        break;
                    }
                }
        }
    }

    private static void placeForOneShip() {
        if ( y1 < gridComputer.length -1){
            gridComputer[x1][y1 + 1] = "8";
            if (x1 > 0){
                gridComputer[x1 - 1][y1 + 1] = "8";
            }
            if (x1 < gridComputer.length - 1){
                gridComputer[x1 + 1][y1 + 1] = "8";
            }
        }
        if ( y1 > 0){
            gridComputer[x1][y1 - 1] = "8";
            if (x1 > 0){
                gridComputer[x1 - 1][y1 - 1] = "8";
            }
            if (x1 < gridComputer.length - 1){
                gridComputer[x1 + 1][y1 - 1] = "8";
            }
        }
        if (x1 > 0){
            gridComputer[x1 - 1][y1] = "8";
        }
        if (x1 <  gridComputer.length - 1){
            gridComputer[x1 + 1][y1] = "8";
        }
    }


    private static boolean placeForShip(int shipLenght) {
        int a = 0;
        int from, to;
        if (x1 == x2){
            if (y1 > y2){
                from = y2;
                to = y1;
            }
            else{
                from = y1;
                to = y2;
            }
            for (int i = from + 1; i < to; i++){
                if (gridComputer[x1][i].equals(" ")){
                    a++;
                }
            }
        }
        if (y1 == y2){
            if (x1 > x2){
                from = x2;
                to = x1;
            }
            else{
                from = x1;
                to = x2;
            }
            for (int i = from + 1; i < to; i++){
                if (gridComputer[i][y1].equals(" ")){
                    a++;
                }
            }
        }
        if (a == shipLenght - 2){
            return true;
        }
        return false;
    }

    public static void playGame(){
        System.out.println("LET'S START THE BATTLE");
        while(true) {
            userTurn();
            try{
                Thread.sleep(5000);
            }
            catch (InterruptedException e){
            }
            System.out.println();
            System.out.println();
           computerTurn();
            if (hitComputer == 20){
                System.out.println("GAME OVER - ENEMIE HAVE SHOT ALL YOUR SHIPS! \n IT'S A LOSE! ");
                break;
            }
            else if (hitUser == 20){
                System.out.println("CONGRATULATIONS, YOU HAVE SHOT ALL OF THE ENEMIES SHIPS! \n IT'S A WIN");
                break;
            }
        }
        }

    private static void computerTurn() {
        int x = (int)(Math.random() * 9);
        int y = (int)(Math.random() * 9);
        if (grid[x][y].equals("X")){
            grid[x][y] = "-";
            System.out.println("YOU JUST GOT HIT! (" + x + ", " + y + ")");
            hitComputer++;
            //if (shipSank()){
                //System.out.println("BAD LUCK! Enemie just sank your ship!");
            //}
        }
        else {
            System.out.println("OPPONENT HAD AN EMPTY SHOT! (" + x + ", " + y + ")");
            grid[x][y] = "*";
        }
        printMap();
    }


    private static void userTurn() {
        System.out.println("Enter (X,Y) coordinates where you are aiming: ");
        int x = input.nextInt() - 1;
        int y = input.nextInt() - 1;
        if (gridComputer[x][y].equals("X")){
            System.out.println("THE TARGET IS HIT!");
            gridComputer[x][y] = "S";
            hitUser++;
           // if (shipSank()){
               // System.out.println("WHOO - HOO! You just sank enemies ship!");
           // }
        }
        else {
            System.out.println("IT'S AN EMPTY SHOT!");
            gridComputer[x][y] = "*";
        }
        printEnemyGrid();
    }


    // METHOD FOR COMPUTER GRID PRINT OUT
    // IT PRINTS OUT ONLY THE XY WHERE USER SHOT

    private static void printEnemyGrid() {
        System.out.println("             OPPONENT'S MAP                 ");
        System.out.println();
        System.out.print("    ");
        for (int i = 1; i <= colums; i++) {
            System.out.print(i + "   ");
        }
        System.out.println();
        System.out.print("  +---+---+---+---+---+---+---+---+---+---+");
        System.out.println();
        for (int i = 0; i < gridComputer.length; i++) {
            if (i == 9) {
                System.out.print(i + 1);
            } else {
                System.out.print(" " + (i + 1));
            }
            for (int j = 0; j < gridComputer.length; j++) {
                if (j == 9) {
                    if (gridComputer[j][i].equals("S")) {
                        System.out.print("| X |"); /// PRINTS X NOT S JUST FOR THE SAKE OF NOT MAKING THINGS MORE MESSIER
                    }
                    else if (gridComputer[j][i].equals("*")){
                        System.out.print("| " + gridComputer[j][i] + " |");
                    }
                    else {
                        System.out.print("|   |");
                    }
                }
                else {
                    if (gridComputer[j][i].equals("S")) {
                        System.out.print("| X ");
                    }
                    else if (gridComputer[j][i].equals("*")){
                        System.out.print("| " + gridComputer[j][i] + " ");
                    }
                    else {
                        System.out.print("|   ");
                    }
                }
            }
            System.out.println();
            System.out.print("  +---+---+---+---+---+---+---+---+---+---+");
            System.out.println();
        }
    }

    private static void printMap() {
        System.out.println("                YOUR MAP                 ");
        System.out.println();
        System.out.print("    ");
        for (int i = 1; i <= colums; i++) {
            System.out.print(i + "   ");
        }
        System.out.println();
        System.out.print("  +---+---+---+---+---+---+---+---+---+---+");
        System.out.println();
        for (int i = 0; i < grid.length; i++) {
            if (i == 9) {
                System.out.print(i + 1);
            } else {
                System.out.print(" " + (i + 1));
            }
            for (int j = 0; j < grid.length; j++) {
                if (j == 9) {
                    if ((grid[j][i]).equals("8")){
                        System.out.print("|   |");
                   }
                   else{
                        System.out.print("| " + grid[j][i] + " |");
                    }
               }
                else {
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

    private static void placeShip(String [][] grid) {
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
            for (int i = from + 1; i < to; i++) {
                grid[x1][i] = "X";
            }
            for(int i = from; i <= to; i++){
                if(x1 < grid.length - 1) {
                    grid[x1 + 1][i] = "8";
                }
                if (x1 > 0){
                    grid[x1 - 1][i] = "8";
                }
            }
            if (from > 0) {
                grid[x1][from - 1] = "8";
                if (x1 > 0) {
                    grid[x1 - 1][from - 1] = "8";
                }
                if(x1 < grid.length - 1) {
                    grid[x1 + 1][from - 1] = "8";
                }
            }
            if (to < grid.length - 1) {
                grid[x1][to + 1] = "8";
                if (x1 > 0) {
                    grid[x1 - 1][to + 1] = "8";
                }
                if (x1 < grid.length - 1) {
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
            // FOR THE INBETWEEN SHIP
            for (int i = from +1; i < to; i++) {
                grid[i][y1] = "X";
            }
            // FOR RESERVING THE PLACES AROUND THE SHIP
            for (int i = from; i <= to; i++){
                if(y1 < grid.length - 1) {
                    grid[i][y1 + 1] = "8";
                }
                if (y1 > 0){
                    grid[i][y1 - 1] = "8";
                }
            }
            if (from > 0) {
                grid[from - 1][y1] = "8";
                if (y1 > 0) {
                    grid[from - 1][y1 - 1] = "8";
                }
                if (y1 < grid.length - 1) {
                    grid[from - 1][y1 + 1] = "8";
                }
            }
            if (to < grid.length - 1) {
                grid[to + 1][y1] = "8";
                if(y1 > 0) {
                    grid[to + 1][y1 - 1] = "8";
                }
                if (y1 < grid.length - 1) {
                    grid[to + 1][y1 + 1] = "8";
                }
            }
            }
            }

    private static void endCoordinate(int lenghtOfShip) {
        while (true) {
            System.out.println("End x and y coardinates: ");
            x2 = input.nextInt() - 1;
            y2 = input.nextInt() - 1;
            System.out.println();
            if (x2 >= 0 && y2 >= 0 && x2 < grid.length && y2 < grid.length) {
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
            x1 = input.nextInt() - 1;
            y1 = input.nextInt() - 1;
            System.out.println();
            if (x1 >= 0 && y1 >= 0 && x1 < grid.length && y1 < grid.length) {
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
