package EXAMPLE1;

import java.util.Random;

public class SOLUTION {
        public static void main(String[] args)
        {
            int M = 5;
            int N =5;
            Random randomNumberGenerator = new Random();

            // two dimensional array of int value
            System.out.println("The original board");
            int[][] grid = new int[M][N];
            // populating the grid
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    int randomNum = randomNumberGenerator.ints(0,2).findFirst().getAsInt();
                    grid[i][j] = randomNum;
                    System.out.print(grid[i][j] + " ");
                    if (j == M - 1) {
                        System.out.println();
                    }
                }
            }
            // Displaying the grid
            System.out.println("Original Generation");
            for (int i = 0; i < M; i++)
            {
                for (int j = 0; j < N; j++)
                {
                    if (grid[i][j] == 0)
                        System.out.print("[]");
                    else
                        System.out.print("#");
                }
                System.out.println();
            }
            System.out.println();
            nextGeneration(grid, M, N);
        }

        // Function to print next generation
        static void nextGeneration(int grid[][], int M, int N)
        {
            int[][] future = new int[M][N];

            // use for loop in each cell
            for (int l = 1; l < M - 1; l++)
            {
                for (int m = 1; m < N - 1; m++)
                {
                    // number of neighbor is alive
                    int aliveNeighbours = 0;
                    for (int i = -1; i <= 1; i++)
                        for (int j = -1; j <= 1; j++)
                            aliveNeighbours += grid[l + i][m + j];

                    // The cell needs to be subtracted from
                    // its neighbours as it was counted before
                    aliveNeighbours -= grid[l][m];

                    // the rule of life was implement

                    // Cell is lonely and dies
                    if ((grid[l][m] == 1) && (aliveNeighbours < 2))
                        future[l][m] = 0;

                        // Cell dies because of over population
                    else if ((grid[l][m] == 1) && (aliveNeighbours > 3))
                        future[l][m] = 0;

                        // A new born cell
                    else if ((grid[l][m] == 0) && (aliveNeighbours == 3))
                        future[l][m] = 1;

                        // Remains the same
                    else
                        future[l][m] = grid[l][m];
                }
            }

            System.out.println("Next Generation");
            for (int i = 0; i < M; i++)
            {
                for (int j = 0; j < N; j++)
                {
                    if (future[i][j] == 0)
                        System.out.print("[]");
                    else
                        System.out.print("#");
                }
                System.out.println();
            }
            // calculate the time
            long startTime = System.nanoTime();
            long endTime = System.nanoTime();
            double duration = (double)(endTime- startTime)/1000000;// divide by 1000000 to get millisecond
            System.out.println("duration is:"+duration);
        }
    }

