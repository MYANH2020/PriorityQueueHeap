package package2;

public class GameOfLifeBoard {
    private char [][] board;
    private char [][] nextBoard;
    public static final char LIVE = '#';
    public static final char DEAD = '^';
    private final int M = 10, N = 10;
    public boolean GameOfLifeBoard(){
        board = new char[M][N];
        for(int i = 0; i<M; i++){
            for (int j = 0; j<N; j++){
                board[i][j] = DEAD;
            }
        }
        nextBoard = new char [M][N];
        // put the original board
        board [1][1] = LIVE;
        board [2][2] = LIVE;
        board [2][3] = LIVE;
        board [3][1] = LIVE;
        board [3][2] = LIVE;
        /**
         * check if a cell is live in the next generation of the game
         * return true if the cell is live in the next generation otherwise false
         */
        public boolean isCellLivingInNextGeneration(int numlivingNeighbors ,char cellCurrentlyLiving){
            if (cellCurrentlyLiving == LIVE){
                if(numlivingNeighbors == 3 || numlivingNeighbors == 2){
                    return true;
                }
                else if (numlivingNeighbors ==3){
                    return true;
                }
                return false;
            }
            public void generateNextStep(){
                for(int k = 0; k<M; k++){
                    for ( int m = 0; m<N; m++){
                        nextBoard[k][m] = isCellLivingInNextGeneration(getNeighborCount(k,m),board[k][m]);
                    }
                }

            // copy nextboard to board
            for (int i = 0; i < M; i++){
                for( int j =0; j< N; j++){
                    board[i][j] = nextBoard[i][j];
                }
            }
        }
         /**
          * check whether a specific cell is alive or dead
          */
    private boolean isCellAlive(int cellRow, int cellColumn) {
        if ( cellRow<M && cellRow >=0&& cellColumn<N && cellColumn>=0){
            if(board[cellRow][cellColumn]== LIVE);
            return true;
        }
        return false;
    }
    public int getNeighborCount( int rown, int col){

            }
}
