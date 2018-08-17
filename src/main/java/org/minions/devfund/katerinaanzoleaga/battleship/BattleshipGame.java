package org.minions.devfund.katerinaanzoleaga.battleship;

import java.util.Scanner;

public class BattleshipGame {
    public static Ocean ocean = new Ocean();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System. in);
        int row, columnt;
        ocean.placeAllShipsRandomly();
        ocean.print();
        while (!ocean.isGameOver()) {
            System.out.println("Try 5 shots (format: 1, 1; 0, 3; 7, 3; 9, 11; 12, 17): ");
            String input = scanner. nextLine();
            String[] shots = input.split(";");
            for (String shot : shots) {
                String[] tuple = shot.split(",");
                row = Integer.valueOf(tuple[0].trim());
                columnt = Integer.valueOf(tuple[1].trim());
                ocean.shootAt(row,columnt);
                ocean.print();
                System.out.println("Fires shot: " + ocean.getShotsFired());
                System.out.println("Hits count: " + ocean.getHitCount());
                System.out.println("Ships sunk: " + ocean.getShipsSunk());
            }
        }
    }
}

