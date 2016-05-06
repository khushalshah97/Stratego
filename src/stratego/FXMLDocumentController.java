/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stratego;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    
    
    Stratego game=new Stratego();
    ImageView[][] pieces=new ImageView[10][10];
    
    
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                pieces[i][j]=new ImageView();
                gpane.add(pieces[i][j],j,i);
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
