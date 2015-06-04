/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package footballmanager.gui.gruppenphasegui;

import footballmanager.bl.GameHandler;
import footballmanager.bl.Team;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Tobi
 */
public class GruppenphaseGUIController implements Initializable
{

  @FXML
  private Button btGerd, btIs, btGay;
  
  @FXML
  private TableView tvGroupA;
  
  private GameHandler inv;
  
  
  public GruppenphaseGUIController(List<Team> teams)
  {
    inv=new GameHandler(teams);
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
  
  @Override
  public void initialize(URL url, ResourceBundle rb)
  {
    tvGroupA.setItems(inv.getGruppe1());
    
    btGerd.setOnAction(this::onGerd);
    btIs.setOnAction(this::onIs);
    btGay.setOnAction(this::onGay);
  } 
}
