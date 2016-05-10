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
    private boolean isFlag=false;
    
    
    public Piece(int num, int player){//constructor sends the player's number and the value of the piece 
        if(num==0)
            isFlag=true;
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
        if(isFlag)
            return "resources/flag"+owner+".png";
        return "resources/"+ Integer.toString(value)+".jpg";
    }
    
}
