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
    private int pTurn = 0;
    private boolean isSetup = true;
    private boolean done=false;
    
    public Stratego() {
        int quantity=0;
        int value=0;
        int player=1;
        int element=1;
        
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                board[i][j]=new Piece(value,player,element,i,j);
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
                    case 42: case 52: 
                        value=-2;
                        element=0;
                        break;
                    case 46: case 56:
                        value=-2;
                        element=1;
                        break;
                    case 60:
                        value=0;
                        player=0;
                        element=0;
                        break;
                    
                }
            }
        }        
    }
    public String move(int row, int col) {
        if (board[row][col].getOwner() == pTurn){
            if (isSetup && selected != null) {
                if (row == selRow && col == selCol) {
                    selected = null;
                    return "Your piece is deselected ";
                }
                Piece temp = new Piece(selected);
                board[selRow][selCol].copyPiece(board[row][col]);
                board[row][col].copyPiece(temp);
                selected = null;
                return "Setup Phase: swap succesful";
            }
            else if(board[row][col].getValue()==0||board[row][col].getValue()==11) {
                if (!isSetup) {
                    return "You can't move a bomb or a flag. Try again!";
                }
            }
            selected = board[row][col];
            selRow = row;
            selCol = col;
            return "Your piece has been selected, "+selected.getElement()+" nation";
        }
        else if (!isSetup && selected != null && isAdjacentToSelected(row, col) && board[row][col].getValue() != -2 && !((selected.getValue() == 0) || (selected.getValue() == 11))) {
            String x= scrimmage(row, col);
            selected=null;
            pTurn=nextTurn();
            return x;
        }
        return "Improper move, try again";
    }
    public Piece getPiece(int i, int j){
        return board[i][j];
    }
    public boolean isAdjacentToSelected(int row, int col) {
        return (selRow == row && (selCol == col - 1 || selCol == col + 1)) || (selCol == col && (selRow == row - 1 || selRow == row + 1));
    }
    public String scrimmage(int row, int col) {
        Piece winner = new Piece();
        Piece def = board[row][col];
        int defVal = def.getValue();
        int attVal = selected.getValue();
        switch (attVal) {
            case 1:
                if (defVal == 10) 
                    winner.copyPiece(selected);
            case 3:
                if (defVal == 11) 
                    winner.copyPiece(selected);
        }
        if (winner.getValue() == -1) 
            winner.copyPiece(selected.getBigger(def)); 
        String label= "Update to the commanders:\nThe "+def.getValue()+" from the "+def.getElement()+" nation, and the " + selected.getValue()+" from the "+selected.getElement()+" nation fought!!\nThe "+winner.getElement()+" nation has won this battle.";
        if(def.getValue()==-1){
            label="Update to the commanders:\nThe "+selected.getElement()+" nation has moved its piece!";
        }
        if(def.getValue()==0){
            done=true;
            label=def.getElement()+" nation's flag has been captured! \nThe game is over..."+selected.getElement()+ " nation, you have won. Click the button to restart the game";
        }
        board[row][col] = winner; 
        board[selRow][selCol].makeVoid();
        return label;
    }
    public int nextTurn() {
        if (pTurn == 0)
            return 1;
        else 
            return 0;
    }
    public int getTurn(){
        return pTurn;
    }
    public void changeTurn() {
        if (pTurn == 0)
            pTurn = 1;
        else 
            pTurn = 0;
    }
    public boolean getIsSetup() {
        return isSetup;
    }
    public void setIsSetup(boolean b) {
        isSetup = b;
    }
    public boolean isDone(){
        return done;
    }
    public String getSelectedLocation(){
        if(selected!=null){
            return selected.getLocation();
        }
        return 
    }
}
