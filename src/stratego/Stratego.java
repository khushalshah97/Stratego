/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stratego;

/**
 *
 * @author shah1762
 */
public class Stratego {//6 bombs 11, 1 10, 1 9, 2 8, 3 7, 4 6, 4 5, 4 4, 5 3, 8 2, 1 1, 1 0; 8 lakes; 12 open  .
    private Piece[][] board = new Piece[10][10];
    private Piece selected;
    private int selRow, selCol;
    private int pTurn;
    
    public Stratego() {
        int quantity=0;
        int value=0;
        int player=1;
        
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                board[i][j]=new Piece(value,player,i,j);
                quantity++;
                switch(quantity){                    
                    case 1: case 2: case 10: case 15: case 19: case 23: case 27: case 30: case 32: case 33: case 34:
                    case 61: case 62: case 70: case 75: case 79: case 83: case 87: case 90: case 92: case 93: case 94:    
                        value++;
                        break;
                    case 40: case 44: case 48: case 54: case 58:
                        value=-1;
                        player=-1;
                        break;
                    case 42: case 46: case 52: case 56:
                        value=-2;
                        break;
                    case 60:
                        value=0;
                        player=0;
                        break;
                    
                }
            }
        }        
    }
    public void move(int row, int col) {
        if (board[row][col].getOwner() == pTurn || selected != null){
            selected = board[row][col];
            selRow = row;
            selCol = col;
        }   
        else if (isAdjacentToSelected(row, col)) {
            
        }
    }
    public Piece getPiece(int i, int j){
        return board[i][j];
    }
    public boolean isAdjacentToSelected(int row, int col) {
        return (selRow == row && (selCol == col - 1 || selCol == col + 1)) || (selCol == col && (selRow == row - 1 || selRow == row + 1));
    }
    public void scrimmage(int row, int col) {
        Piece winner = null;
        Piece def = board[row][col];
        int defVal = def.getValue();
        int attVal = selected.getValue();
        if (attVal == 1) {
            if (defVal == 10)
                winner = selected;
        }
        else if (attVal == 3) {
            if (defVal == 11)
                winner = selected;
        }
        else if (attVal > defVal)
            winner = selected;
        else if (defVal > attVal)
            winner = def;
        if (winner == null) {
            board[row][col].makeVoid();
            board[selRow][selCol].makeVoid();
        }
        else {
            board[row][col] = winner;
            board[selRow][selCol].makeVoid();
        }
    }
}
