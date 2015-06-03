/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package footballmanager.gui.gruppenphasegui;

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
public class GruppenphaseGUIController implements Initializable
{

  @FXML
  private Button btGerd, btIs, btGay;
  
  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb)
  {
    btGerd.setOnAction(this::onGerd);
    btIs.setOnAction(this::onIs);
    btGay.setOnAction(this::onGay);
  }  
  
  private void onGerd(ActionEvent event)
  {
   
  }
  
  private void onIs(ActionEvent event)
  {

  }
  
  private void onGay(ActionEvent event)
  {

  }
  
}
