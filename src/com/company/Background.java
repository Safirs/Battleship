package com.company;

public class Background {
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
