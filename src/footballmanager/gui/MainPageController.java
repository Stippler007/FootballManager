/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package footballmanager.gui;

import footballmanager.gui.gruppenphasegui.GruppenphaseGUIController;
import footballmanager.gui.neuesturniergui.NeuesTurnierGUIController;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

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
      try
      {
        Stage dlg=new Stage();
        
        dlg.initModality(Modality.APPLICATION_MODAL);
        final URL url = getClass().getResource("neuesturniergui"+File.separator+"NeuesTurnierGUI.fxml");
        final FXMLLoader loader=new FXMLLoader(url);
        final NeuesTurnierGUIController c = new NeuesTurnierGUIController();
        loader.setController(c);
        Scene scene = new Scene(loader.load());
        dlg.setScene(scene);
        dlg.showAndWait();
        
        
      } catch (IOException ex)
      {
        Logger.getLogger(MainPageController.class.getName()).log(Level.SEVERE, null, ex);
      }
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
