package it.unive.dais.po1.exercise1;
/**
 * This class represents a tic tac toe board
 *
 * @since 1.0
 */
public class TicTacToeBoard {


    private Mark board[][] = new Mark[3][3];



    /**
     * Puts a mark in a given cell
     *
     * @param c the mark to put in the board
     * @param x the x coordinate of the cell to be filled
     * @param y the y coordinate of the cell to be filled
     * @return true if the cell was empty, the game was not ended (e.g., no winner yet) and
     * it filled it, false otherwise
     */
    public boolean put(Mark c, int x, int y) {
        if(c == null){
            System.out.println("put c == null");
            return false;
        }
        if(board[x][y] == null)
        {
            board[x][y] = c;
            return true;
        }
        return false;
    }

    /**
     * Returns the mark of a cell, null if empty
     * @param x the x coordinate of the cell
     * @param y the y coordinate of the cell
     * @return the mark in the given cell, null if the cell is empty
     */
    public Mark getMark(int x, int y) {

            return board[x][y];

    }

    /**
     * Check the columns to see if the player has won
     * @return Return the winner mark or null
     */
    private Mark verticalC(){
        Mark c = null;
        for (int i = 0; i < 3; i++) {
            Mark x = board[i][0];
            Mark y = board[i][1];
            Mark z = board[i][2];
            if(x == y && x == z && x != null){

                c = board[i][2];
            }
        }
        return c;

    }

    /**
     * Check the lines to see if the player has won
     * @return Return the winner mark or null
     */
    private Mark orizzontalC(){
        Mark c = null;
        for (int i = 0; i < 3; i++) {
            Mark x = board[0][i];
            Mark y = board[1][i];
            Mark z = board[2][i];
            if(x == y && x == z && x != null){

                c = board[2][i];
            }
        }
        return c;

    }

    /**
     * Check the diagonals to see if the player has won
     * @return Return the winner mark or null
     */
    private Mark diagonalc(){
        Mark c = null;
            Mark x = board[0][0];
            Mark y = board[1][1];
            Mark z = board[2][2];
            if(x == y && x == z && x != null){

                c = board[2][2];
            }
            if(c == null){
                x = board[0][2];
                y = board[1][1];
                z = board[2][0];
                if(x == y && x == z && x != null){

                    c = board[2][0];
                }

            }

        return c;

    }


    /**
     * Returns the winner of the game
     *
     * @return the mark of the winner of the game, or null if there is not yet a winner
     */
    public Mark winner() {
        Mark win = null;
        win = verticalC();
        if(win != null){
            return win;
        }
        win = orizzontalC();
        if(win != null) {
            return win;
        }
        win = diagonalc();
        if(win != null){
            return win;
        }

        return null;
    }

    /**
     * Returns true if the board is full
     *
     * @return true iff the board is full
     */
    public boolean isFull() {
        boolean isFull1 = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(board[i][j] == null)
                    isFull1 = false;
            }
        }
        return isFull1;
    }
}