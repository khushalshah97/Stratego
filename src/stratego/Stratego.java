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
public class Stratego {//6 bombs, 1 10, 1 9, 2 8, 3 7, 4 6, 4 5, 4 4, 5 3, 8 2, 1 1, 1 Flag.
    Piece[][] board = new Piece[10][10];
    public Stratego(){
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                
            }
        }
        
    }
    public Piece getPiece(int i, int j){
        return board[i][j];
    }
}
