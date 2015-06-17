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
  private Button btGruppenphaseSim;
  
  @FXML
  private TableView tvGroupA, tvGroupB, tvGroupC, tvGroupD, tvGroupE, tvGroupF, tvGroupG, tvGroupH;
  
  private GameHandler inv;
  
  
  public GruppenphaseGUIController(List<Team> teams)
  {
    inv=new GameHandler(teams);
    
  }
  
  private void onGruppenphaseSim(ActionEvent event)
  {
    System.out.println("btGruppenphaseSim wurde betätigt.");
    inv.playAllGames();
  }
  
  @Override
  public void initialize(URL url, ResourceBundle rb)
  {
    tvGroupA.setItems(inv.getGruppen().get(0));
    tvGroupB.setItems(inv.getGruppen().get(1));
    tvGroupC.setItems(inv.getGruppen().get(2));
    tvGroupD.setItems(inv.getGruppen().get(3));
    tvGroupE.setItems(inv.getGruppen().get(4));
    tvGroupF.setItems(inv.getGruppen().get(5));
    tvGroupG.setItems(inv.getGruppen().get(6));
    tvGroupH.setItems(inv.getGruppen().get(7));
    
    
    btGruppenphaseSim.setOnAction(this::onGruppenphaseSim);
  } 
}
