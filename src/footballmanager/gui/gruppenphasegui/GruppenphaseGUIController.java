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
  private Button btGruppenphaseSim, btIs, btGay;
  
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
    tvGroupB.setItems(inv.getGruppe2());
    tvGroupC.setItems(inv.getGruppe3());
    tvGroupD.setItems(inv.getGruppe4());
    tvGroupE.setItems(inv.getGruppe5());
    tvGroupF.setItems(inv.getGruppe6());
    tvGroupG.setItems(inv.getGruppe7());
    tvGroupH.setItems(inv.getGruppe8());
    
    
    btGruppenphaseSim.setOnAction(this::onGruppenphaseSim);
    btIs.setOnAction(this::onIs);
    btGay.setOnAction(this::onGay);
  } 
}
