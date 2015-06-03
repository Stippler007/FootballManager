/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package footballmanager.gui.turnierladengui;

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
public class TurnierLadenGUIController implements Initializable
{
  
  @FXML
  private Button btLaden, btAbbrechen;

  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb)
  {
    btLaden.setOnAction(this::onLaden);
    btAbbrechen.setOnAction(this::onAbbrechen);
  }  
  
  private void onLaden(ActionEvent event)
  {
   
  }
  
  private void onAbbrechen(ActionEvent event)
  {

  }
}
