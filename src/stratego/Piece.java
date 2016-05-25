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
    private String[] colors={"waterNation", "fireNation"};
    private String[] elements={"water", "fire"};
    private String location;
    private String element;
    private boolean isFlag=false;
    
    
    public Piece(int num, int player, int element, int row, int column){//constructor sends the player's number and the value of the piece 
        if(num==0)
            isFlag=true;
        value=num;
        owner=player;       
        location= Integer.toString(row)+Integer.toString(column);
        this.element=elements[element];
    }        
    public Piece(){
        owner = -1;
        value = -1;
    }
    public Piece(Piece another) {
        this.owner = another.owner;
        this.value = another.value;
        this.location = another.location;
        this.isFlag = another.isFlag;
    }      
    public void copyPiece(Piece another){
        this.owner = another.owner;
        this.value = another.value;
        this.location = another.location;
        this.isFlag = another.isFlag;
    }
    public int getOwner(){
        return owner;
    }
            
    public int getValue(){
        return value;
    }
    
    public String getElement(){
        return element;
    }
    
    public void makeVoid(){
        owner= -1;//maybe not necessary?
        value= -1;
    }
    
    public String getPath(int nextTurn){
        if(owner==nextTurn)
            return "resources/"+colors[owner]+".jpg";
        if(isFlag)
            return "resources/flag"+owner+".png";
        if(value==-2)
            return "resources/"+element+".jpg";
        return "resources/"+Integer.toString(value)+".jpg";
    }
    public Piece getBigger(Piece another) {
        if (this.getValue() > another.getValue())
            return this;
        else if (this.getValue() < another.getValue())
            return another;
        else 
            return new Piece();
    }
}
