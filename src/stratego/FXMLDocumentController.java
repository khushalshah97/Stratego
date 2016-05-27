/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stratego;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

/**
 *
 * @author shah1762
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label, directions;
    @FXML
    private GridPane gpane;
    @FXML
    private Button buttonStart, buttonSetup;
    
    @FXML
    private void handleSetup(ActionEvent event) {
        if (game.getIsSetup()) {
            if (game.getTurn() == 0){
                label.setText("Fire nation it is now your turn to set up the pieces. Click the two pieces you would like to swap. \nWhen you are done, click the Done button");
                game.changeTurn();
            }    
            else{
                game.changeTurn();
                game.setIsSetup(false);
                label.setText("Setup is over.\nWater nation, it is your turn to move. \nSelect the piece you would like to move, and then click the spot you would like to move to ");
                directions.setText("Select the piece you would like to move, and then click the spot you would like to move to. \nIf you select the same piece again, then you desselect it\nIf an enemy piece is adjacent, then you may attack it\nIf the enemy piece is stronger than yours, then you die, if it is weaker, you take its place.\nIf both pieces are the same strength than they both die.\nYou may not travel across the element restrictions:fire and water");
            }
            setImages();
        }
    }
    @FXML
    private void handleStart(ActionEvent event) {
        game=new Stratego();
        game.setIsSetup(true);
        gpane.setGridLinesVisible(false);
        gpane.setVisible(false);
        buttonStart.setVisible(false);
        buttonSetup.setVisible(true);
        label.setText("You are in the setup phase.\nWhen it is your turn, click the piece you want to move, and then the piece you would like to swap it with. \nWater nation, it is your turn");
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                pieces[i][j]=null;
                pieces[i][j]=new ImageView();
                pieces[i][j].setFitHeight(75);
                pieces[i][j].setFitWidth(75);
                gpane.add(pieces[i][j],j,i);
            }
        }        
        setImages();
        gpane.setGridLinesVisible(true);
        gpane.setVisible(true);
        
        
       
    EventHandler z = new EventHandler<MouseEvent>() 
        {            
            @Override
            public void handle(MouseEvent t) 
            {                
                int column=GridPane.getColumnIndex(((ImageView) t.getSource()));
                System.out.println("Column: " +column);
                int row=GridPane.getRowIndex(((ImageView) t.getSource()));
                System.out.println("Row: " + row);          
                setImages();
                label.setText(game.move(row, column));
                buttonStart.setText("RESET GAME!");
                buttonStart.setVisible(true);
                setImages();
                pieces[row][column].setFitHeight(50);
                pieces[row][column].setFitWidth(50);
                //getSelectedLocation- to make the selected piece smaller when switched
                

                
                
            }    
        };
            for(int i=0; i<pieces.length; i++){
                for(int j=0; j<pieces[0].length;j++){
                    pieces[i][j].setOnMouseClicked(z);    
                }
        }
    }
    
    
    
    private void setImages(){
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                pieces[i][j].setImage(new Image(game.getPiece(i,j).getPath(game.nextTurn())));
                pieces[i][j].setFitHeight(75);
                pieces[i][j].setFitWidth(75);
            }
        }
    }
    
    Stratego game;
    private boolean isSelected=false;
    ImageView[][] pieces=new ImageView[10][10];   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
