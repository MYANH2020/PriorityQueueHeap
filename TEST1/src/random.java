import org.omg.CORBA.SetOverrideType;

import java.util.Random;

public class random {
    public static void main(String[] args) {
        // 2D array of int value
        Random randomNumberGenerator = new Random();
        int SIZE = 5;
        char LIVE = '#';
        char DEAD = ' ';
        int[][] grid = new int[SIZE][SIZE];
        System.out.println("The original board");
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                int randomIntNum = randomNumberGenerator.ints(0, 2).findFirst().getAsInt();
                grid[i][j] = randomIntNum;
                System.out.print(grid[i][j] + " ");
                if (j == SIZE - 1) {
                    System.out.println();
                }
            }
        }
        // display the grid
        System.out.println("The original generation");
        for (int l = 0; l < SIZE; l++) {
            for (int k = 0; k < SIZE; k++) {
                if (grid[l][k] == 0 || grid[l][k] == 3) {
                    System.out.print("#");
                } else System.out.print("[]");

                if (k == SIZE - 1) {
                    System.out.println();
                }


            }
        }


    }
}


