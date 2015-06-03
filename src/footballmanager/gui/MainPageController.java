/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package footballmanager.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Philip
 */
public class MainPageController implements Initializable {

    @FXML
    private Button btNeuesTurnier, btLoad, btTeamVerwaltung;
    
    @FXML
    private Pane pBackGround;
    
    public void onNeuesTurnier(ActionEvent evt)
    {
        
    }
    
    public void onLoad(ActionEvent evt)
    {
        
    }
    
    public void onTeamVerwaltung(ActionEvent evt)
    {
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btNeuesTurnier.setOnAction(this::onNeuesTurnier);
        btLoad.setOnAction(this::onLoad);
        btTeamVerwaltung.setOnAction(this::onTeamVerwaltung);
        
        pBackGround.setBackground(Background.EMPTY);
        
        
    }    
    
}
