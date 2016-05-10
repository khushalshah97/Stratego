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
    Piece[][] board = new Piece[10][10];
    public Stratego(){
        int quantity=0;
        int value=0;
        int player=2;
        
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                board[i][j]=new Piece(value,player);
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
                        player=1;
                        break;
                    
                }
            }
        }
        
    }
    public Piece getPiece(int i, int j){
        return board[i][j];
    }
}
