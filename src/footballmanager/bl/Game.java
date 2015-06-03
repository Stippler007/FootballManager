/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package footballmanager.bl;

/**
 *
 * @author Christian
 */
public class Game
{
  private Team team1;
  private Team team2;
  
  private int scoreTeam1=0;
  private int scoreTeam2=0;
  
  public Game(Team team1, Team team2)
  {
    this.team1 = team1;
    this.team2 = team2;
  }

  
  public Team getTeam1()
  {
    return team1;
  }

  public Team getTeam2()
  {
    return team2;
  }

  @Override
  public String toString()
  {
    return String.format("Game\n%s: %d\n%s: %d", team1.getName(),scoreTeam1,team2.getName(),scoreTeam2);
  }
  
}
