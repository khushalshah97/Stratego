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
    private Label label;
    @FXML
    private GridPane gpane;
    @FXML
    private Button buttonStart;
    
    @FXML
    private void handleStart(ActionEvent event) {
        game=new Stratego();
        
        gpane.setGridLinesVisible(false);
        gpane.setVisible(false);
        
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                pieces[i][j]=new ImageView();
                pieces[i][j].setFitHeight(75);
                pieces[i][j].setFitWidth(75);
                gpane.add(pieces[i][j],j,i);
            }
        }        
        setImages();
        gpane.setGridLinesVisible(true);
        gpane.setVisible(true);
        
        
       
    EventHandler z = new EventHandler<MouseEvent>() //when the mouse is clicked action event. HAND 1
        {            
            @Override
            public void handle(MouseEvent t) 
            {                
                int column=GridPane.getColumnIndex(((ImageView) t.getSource()));
                System.out.println("Column: " +column);
                int row=GridPane.getRowIndex(((ImageView) t.getSource()));
                System.out.println("Row: " + row);
                pieces[row][column].setFitHeight(50);
                pieces[row][column].setFitWidth(50);
                
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
                pieces[i][j].setImage(new Image(game.getPiece(i,j).getPath()));
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
