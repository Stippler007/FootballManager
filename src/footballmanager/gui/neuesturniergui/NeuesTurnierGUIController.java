/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package footballmanager.gui.neuesturniergui;

import footballmanager.dal.DAL;
import footballmanager.gui.MainPageApp;
import footballmanager.gui.gruppenphasegui.GruppenphaseGUIController;
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
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Tobi
 */
public class NeuesTurnierGUIController implements Initializable
{

  @FXML
  private Button btTextdatei, btRandomTeams, btTeamPicker, btAbbrechen;
  
  
  /**
   * Initializes the controller class.
   */
  private Scene scene;

    public Scene getScene() {
      scene.getStylesheets().addAll(this.getClass().getResource("neuesturniergui.css").toExternalForm());  
      return scene;
    }
  
  

  @Override
  public void initialize(URL url, ResourceBundle rb)
  {
    btTextdatei.setOnAction(this::onTextdatei);
    btRandomTeams.setOnAction(this::onRandomTeams);
    btTeamPicker.setOnAction(this::onTeamPicker);
    btAbbrechen.setOnAction(this::onAbbrechen);
  }  
  
  private void onTextdatei(ActionEvent event)
  {
    FileChooser fc=new FileChooser();
    File f=fc.showOpenDialog(btTextdatei.getScene().getWindow());
    if(f!=null)
    {
      try {
      
      final URL url = MainPageApp.class.getResource("gruppenphasegui/GruppenphaseGUI.fxml");
      System.out.println(url.getPath()); 
      final FXMLLoader loader=new FXMLLoader(url);
      
      final GruppenphaseGUIController c = new GruppenphaseGUIController(DAL.getDal().getTeams(f.getAbsolutePath()));
      loader.setController(c);
      scene = new Scene(loader.load());
      ((Stage)btAbbrechen.getScene().getWindow()).close();

//    

      } 
      catch (IOException ex) {
        Logger.getLogger(NeuesTurnierGUIController.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }
  
  private void onRandomTeams(ActionEvent event)
  {

  }
  
  private void onTeamPicker(ActionEvent event)
  {
    
  }
  
  private void onAbbrechen(ActionEvent event)
  {
    ((Stage)btAbbrechen.getScene().getWindow()).close();
  }
  
}
