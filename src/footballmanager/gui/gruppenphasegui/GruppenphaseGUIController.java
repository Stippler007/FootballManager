/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package footballmanager.gui.gruppenphasegui;

import footballmanager.bl.GameHandler;
import footballmanager.bl.Team;
import footballmanager.dal.DAL;
import footballmanager.gui.MainPageApp;
import footballmanager.gui.kophasegui.KOPhaseGUIController;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

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
    
    inv.update();
    
    
    btGruppenphaseSim.setDisable(false);
    btGruppenphaseSim.setText("Zur KO Runde!");
    btGruppenphaseSim.setOnAction(this::onKoPhase);
  }
  public void onKoPhase(ActionEvent event)
  {
    try
    {
      final URL url = MainPageApp.class.getResource("kophasegui/KOPhaseGUI.fxml");
      System.out.println(url.getPath());
      final FXMLLoader loader=new FXMLLoader(url);
      
      final KOPhaseGUIController c = new KOPhaseGUIController(inv.getPrometedTeams());
      loader.setController(c);
      Scene scene = new Scene(loader.load());
      ((Stage)btGruppenphaseSim.getScene().getWindow()).setScene(scene);
    }
    catch (IOException ex)
    {
      Logger.getLogger(GruppenphaseGUIController.class.getName()).log(Level.SEVERE, null, ex);
    }
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
