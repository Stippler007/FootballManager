/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package footballmanager.bl;

import footballmanager.dal.DAL;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
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
  
  
    ObservableList<Team> gruppe1=FXCollections.observableArrayList();
    ObservableList<Team> gruppe2=FXCollections.observableArrayList();
    ObservableList<Team> gruppe3=FXCollections.observableArrayList();
    ObservableList<Team> gruppe4=FXCollections.observableArrayList();
  
    ObservableList<Team> gruppe5=FXCollections.observableArrayList();
    ObservableList<Team> gruppe6=FXCollections.observableArrayList();
    ObservableList<Team> gruppe7=FXCollections.observableArrayList();
    ObservableList<Team> gruppe8=FXCollections.observableArrayList();
  
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
    update();
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
  public void sortTeams()
  {
    for (ObservableList<Team> obs : gruppen)
    {
      Team t=obs.get(0);
      for (int i = 1; i < gruppen.size(); i++)
      {
        for (int j = 2; j < games.length; j++)
        {
          
        }
      }
    }
  }
  public void update()
  {
    gruppe1.clear();
    gruppe2.clear();
    gruppe3.clear();
    gruppe4.clear();
    gruppe5.clear();
    gruppe6.clear();
    gruppe7.clear();
    gruppe8.clear();
    gruppen.clear();
    
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
      sb.append(t.getName()).append(": ").append(t.getPointsGroup()+"\n");
    }
    return sb.toString();
  }
  public List<Team> getPrometedTeams()
  {
    List<Team> gewinner=new LinkedList<>();
    List<Team> zweitGewinner=new LinkedList<>();
    List<Team> promotedTeam=new LinkedList<>();
    
    for (ObservableList<Team> listTeam:gruppen)
    {
      Team strongest=listTeam.get(0);
      for (int i = 1; i < listTeam.size(); i++)
      {
        if(strongest.getPointsGroup()<listTeam.get(i).getPointsGroup())
        {
          strongest=listTeam.get(i);
        }
      }
      gewinner.add(strongest);
      listTeam.remove(strongest);
    }
    
    for (ObservableList<Team> listTeam:gruppen)
    {
      Team strongest=listTeam.get(0);
      for (int i = 1; i < listTeam.size(); i++)
      {
        if(strongest.getPointsGroup()<listTeam.get(i).getPointsGroup())
        {
          strongest=listTeam.get(i);
        }
      }
      zweitGewinner.add(strongest);
    }
    Collections.shuffle(gewinner);
    Collections.shuffle(zweitGewinner);
    for (int i = 0; i < gewinner.size(); i++)
    {
      promotedTeam.add(gewinner.get(i));
      promotedTeam.add(zweitGewinner.get(i));
    }
    return promotedTeam;
  }
  public static void main(String[] args) throws IOException
  {
    GameHandler gameHandler=new GameHandler(DAL.getDal().getTeams("src/saves/gerd.txt"));
    gameHandler.shuffleTeams();
    gameHandler.playAllGames();
    System.out.println(gameHandler.toString());
  }
}
