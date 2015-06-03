/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package footballmanager.gui.neuesturniergui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

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
   
  }
  
  private void onRandomTeams(ActionEvent event)
  {

  }
  
  private void onTeamPicker(ActionEvent event)
  {

  }
  
  private void onAbbrechen(ActionEvent event)
  {

  }
  
}
