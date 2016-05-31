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
    public Piece(){ //constructs a Piece representing a blank space
        owner = -1;
        value = -1;
    }
    public Piece(Piece another) { //contructs a Piece which is a copy of another Piece
        copyPiece(another);
    }      
    public void copyPiece(Piece another){ //sets all fields in this equal to another Piece
        this.owner = another.owner;
        this.value = another.value;
        this.location = another.location;
        this.isFlag = another.isFlag;
        this.element=another.element;
    }
    public int getOwner(){ //returns the owner of the Piece
        return owner;
    }
            
    public int getValue(){ //returns the value of the Piece
        return value;
    }
    
    public String getElement(){ //returns the element of the Piece, water or fire
        return element;
    }
    
    public void makeVoid(){ //makes the Piece a blank space
        owner= -1;
        value= -1;
    }
    public String getLocation(){ //returns the location of the piece
        return location;
    }
    
    public String getPath(int nextTurn){ //returns the location of the image representing the Piece in resources, which is
        if(owner==nextTurn) //a "piece back" when not belonging the player whose turn it is
            return "resources/"+colors[owner]+".jpg";
        if(isFlag)
            return "resources/flag"+owner+".png";
        if(value==-2)
            return "resources/"+element+".jpg";
        return "resources/"+Integer.toString(value)+".jpg";
    }
    public Piece getBigger(Piece another) { //returns the Piece with the bigger value, or, if both are the same, a blank space
        if (this.getValue() > another.getValue())
            return this;
        else if (this.getValue() < another.getValue())
            return another;
        else 
            return new Piece();
    }
}
