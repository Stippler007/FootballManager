/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package footballmanager.bl;

import footballmanager.dal.DAL;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 *
 * @author Christian
 */
public class GameHandler
{
  private List<ObservableList<Team>> gruppen=FXCollections.observableArrayList();
  private ObservableList<Team> gruppe1=FXCollections.observableArrayList();
  private ObservableList<Team> gruppe2=FXCollections.observableArrayList();
  private ObservableList<Team> gruppe3=FXCollections.observableArrayList();
  private ObservableList<Team> gruppe4=FXCollections.observableArrayList();
  
  private ObservableList<Team> gruppe5=FXCollections.observableArrayList();
  private ObservableList<Team> gruppe6=FXCollections.observableArrayList();
  private ObservableList<Team> gruppe7=FXCollections.observableArrayList();
  private ObservableList<Team> gruppe8=FXCollections.observableArrayList();
  
  private List<Team> teams;
  private Game[][] games=new Game[8][12];
  /*
  team1 vs team2
  team3 vs team4
  
  team1 vs team4
  team2 vs team3
  
  
  team1 vs team2
  team3 vs team4
  
  team1 vs team4
  team2 vs team3
  */
  
  
  public GameHandler(List<Team> teams)
  {
    this.teams=teams;
    
    for (int i=0;i<4;i++)
    {
      gruppe1.add(teams.get(i));
      gruppe2.add(teams.get(i+4*1));
      gruppe3.add(teams.get(i+4*2));
      gruppe4.add(teams.get(i+4*3));
      
      gruppe5.add(teams.get(i+4*4));
      gruppe6.add(teams.get(i+4*5));
      gruppe7.add(teams.get(i+4*6));
      gruppe8.add(teams.get(i+4*7));
    }
    gruppen.add(gruppe1);
    gruppen.add(gruppe2);
    gruppen.add(gruppe3);
    gruppen.add(gruppe4);
    
    gruppen.add(gruppe5);
    gruppen.add(gruppe6);
    gruppen.add(gruppe7);
    gruppen.add(gruppe8);
  }
  public void updatePointsFromGroup(ObservableList<Team> teams,int gruppe)
  {
    for (int i = 0; i < teams.size(); i++)
    {
      for (int j = 0; j < games[gruppe].length; j++)
      {
        if(games[gruppe][j].getPoints(teams.get(i))!=-1)
        {
          teams.get(i).addpoints(games[gruppe][j].getPoints(teams.get(i)));
        }
      }
    }
  }
  public void shuffleTeams()
  {
    Collections.shuffle(teams);
  }
  
  public void playAllGames()
  {
    for (int i = 0; i < 7; i++)
    {
      playGroup(gruppen.get(i), i);
    }
  }
  /*
  team1 vs team2
  team3 vs team4
  team1 vs team4
  team2 vs team3
  team1 vs team3
  team2 vs team4
  */
  public void playGroup(ObservableList<Team> teams,int gruppe)
  {
    games[gruppe][0]=new Game(teams.get(0),teams.get(1));
    games[gruppe][1]=new Game(teams.get(2),teams.get(3));
    games[gruppe][2]=new Game(teams.get(0),teams.get(3));
    games[gruppe][3]=new Game(teams.get(1),teams.get(2));
    games[gruppe][4]=new Game(teams.get(0),teams.get(2));
    games[gruppe][5]=new Game(teams.get(1),teams.get(3));
    
    games[gruppe][6]=new Game(teams.get(0),teams.get(1));
    games[gruppe][7]=new Game(teams.get(2),teams.get(3));
    games[gruppe][8]=new Game(teams.get(0),teams.get(3));
    games[gruppe][9]=new Game(teams.get(1),teams.get(2));
    games[gruppe][10]=new Game(teams.get(0),teams.get(2));
    games[gruppe][11]=new Game(teams.get(1),teams.get(3));
    
    for (int i = 0; i < games[0].length; i++)
    {
      games[gruppe][i].playGame();
    }
    updatePointsFromGroup(teams, gruppe);
  }
  public ObservableList<Team> getGruppe1()
  {
    return gruppe1;
  }
  public ObservableList<Team> getGruppe2()
  {
    return gruppe2;
  }
  public ObservableList<Team> getGruppe3()
  {
    return gruppe3;
  }
  public ObservableList<Team> getGruppe4()
  {
    return gruppe4;
  }
  public ObservableList<Team> getGruppe5()
  {
    return gruppe5;
  }
  public ObservableList<Team> getGruppe6()
  {
    return gruppe6;
  }
  public ObservableList<Team> getGruppe7()
  {
    return gruppe7;
  }
  public ObservableList<Team> getGruppe8()
  {
    return gruppe8;
  }

  public List<ObservableList<Team>> getGruppen()
  {
    return gruppen;
  }
  
  
  
  @Override
  public String toString()
  {
    StringBuilder sb=new StringBuilder();
    for (Team team : teams)
    {
      sb.append(team.toString());
      sb.append("\n");
    }
    sb.append("\n");
    for (int i = 0; i < games.length; i++)
    {
      for (int j = 0; j < games[i].length; j++)
      {
        if(games[i][j]!=null)sb.append(games[i][j].toString());
      }
    }
    for (Team t:teams)
    {
      sb.append(t.getName()).append(": ").append(t.getPointsGroup());
    }
    return sb.toString();
  }
  
  public static void main(String[] args) throws IOException
  {
    GameHandler gameHandler=new GameHandler(DAL.getDal().getTeams("src/saves/gerd.txt"));
    gameHandler.shuffleTeams();
    gameHandler.playGroup(gameHandler.getGruppe1(), 0);
    System.out.println(gameHandler.toString());
  }
}
