/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package footballmanager.gui.turnierverwaltunggui;

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
public class TurnierVerwaltungGUIController implements Initializable
{

  @FXML
  private Button btAdd, btSave, btDelete;
  
  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb)
  {
    btAdd.setOnAction(this::onAdd);
    btSave.setOnAction(this::onSave);
    btDelete.setOnAction(this::onDelete);
  }  
  
  private void onAdd(ActionEvent event)
  {
   
  }
  
  private void onSave(ActionEvent event)
  {

  }
  
  private void onDelete(ActionEvent event)
  {

  }
  
}
