package sample;

import java.util.Random;

public class Controller {
    public static void main(String[] args) {
        int M = 10;
        int N = 10;
        Random randomNumberGenerator = new Random();
        // two dimensional array of Boolean value
       int [][] grid = new int [M][N];
        // populating the grid
        for (int i = 0; i <= M; i++) {
            {
                for (int j = 0; j <= N; j++) {
                    int randomBool = randomNumberGenerator.nextInt();
                    grid[i][j] = randomBool;
                }
            }
            //display the grid
            System.out.println("Original generation");
            for (int h = 0; h < M; h++) {
                for (int q = 0; q < N; q++) {
                    if (grid[h][q] == 0) {
                        System.out.println(".");
                    } else System.out.println("*");

                }
                System.out.println();
                nextGeneration(grid, M, N);

                // function to generate the next generation
            }
        }
    }

             public static void nextGeneration ( int grid[][], int M, int N){
                int[][] future = new int[M][N];
                // loop through every cell
                for (int l = 1; l < M - 1; l++) {
                    for (int m = 1; m < N - 1; m++) {
                        // to find out the number of alive cell
                        int aliveNeighbours = 0;
                        for (int i = -1; i <= 1; i++) {
                            for (int j = -1; j <= 1; j++) {
                                aliveNeighbours += grid[l + i][m + i];
                                /* the cell needs to be subtract from
                                its neighbours as it was counted before
                                 */
                                aliveNeighbours -= grid[l][m];
                                /* the rule life are implement here
                                cell is alone and dies
                                 */
                                if ((grid[l][m] == 1) && (aliveNeighbours < 2)) {
                                    future[l][m] = 0;
                                }
                                // cell dies due to over population

                                else if ((grid[l][m] == 1) && (aliveNeighbours > 3))
                                    future[l][m] = 0;
                                    // a new cell is born
                                else if ((grid[l][m] == 0) && (aliveNeighbours == 3))
                                    future[l][m] = 1;
                                    // remain the same
                                else
                                    future[l][m] = grid[l][m];


                            }

                        }
                    }

                }


                System.out.println("Update cells");
                for (int i = 0; i < M; i++) {
                    for (int j = 0; j < N; j++) {
                        if (future[i][j] == 0)
                            System.out.println(".");
                        else
                            System.out.println("*");
                    }
                    System.out.println();
                }

            }
        }


