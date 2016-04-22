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
public class Piece {   
    private int owner;
    private int value;
    
    public Piece(){
        value=0;
        owner=-1;
    }
    
    public Piece(int num, int player){//constructor sends the player's number and the value of the piece 
        value=num;
        owner=player;
        
    }        
            
    public int getOwner(){
        return owner;
    }
            
    public int getValue(){
        return value;
    }
    
    public void makeVoid(){
        owner=-1;//maybe not necessary?
        value=0;
    }
    
    public String getPath(){
        
    }
    
}
