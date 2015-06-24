/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package footballmanager.gui.kophasegui;

import footballmanager.bl.Team;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Michael
 */
public class KOPhaseGUIController implements Initializable {
  
  @FXML
  private Button btPlay;
  
  @FXML
  private Label lbAchtelfinale1,lbAchtelfinale2;
  
  private List<Team> teams;

  public KOPhaseGUIController(List<Team> teams)
  {
    this.teams=teams;
  }
  
  private void onPlay(ActionEvent event)
  {
    
  }
  
  @Override
  public void initialize(URL url, ResourceBundle rb) 
  {
      btPlay.setOnAction(this::onPlay);
      
      lbAchtelfinale1.setText(teams.get(0).getName());
      lbAchtelfinale2.setText(teams.get(1).getName());
  }    
    
}
