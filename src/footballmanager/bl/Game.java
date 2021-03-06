/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package footballmanager.bl;

import java.util.Random;

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
  
  private Random r = new Random();
  
  public Game(Team team1, Team team2)
  {
    this.team1 = team1;
    this.team2 = team2;
  }

  public void setScoreTeam1(int scoreTeam1)
  {
    this.scoreTeam1 = scoreTeam1;
  }
  public void setScoreTeam2(int scoreTeam2)
  {
    this.scoreTeam2 = scoreTeam2;
  }
  
    public void playGame() {
        double strengtht1, strengtht2;

        strengtht1 = team1.getCoefficient()[4] * (r.nextFloat()/2+0.4);
        strengtht2 = team2.getCoefficient()[4] * (r.nextFloat()/2+0.4);

        scoreTeam1 = (int) strengtht1 /4;
        scoreTeam2 = (int) strengtht2 /4;
        
        System.out.println(team1.getName()+" : "+ team2.getName()+"  "+ scoreTeam1+" : "+ scoreTeam2+" bei Stärken von "+ strengtht1 + " : "+ strengtht2 +"\n");
    }
  
  public Team getTeam1()
  {
    return team1;
  }

  public Team getTeam2()
  {
    return team2;
  }
  
  public int getPoints(Team t)
  {
    if(t.equals(team1))
    {
      if(scoreTeam1<scoreTeam2)
      {
        return 0;
      }
      if(scoreTeam1==scoreTeam2)
      {
        return 1;
      }
      else if(scoreTeam1>scoreTeam2)
      {
        return 3;
      }
    }
    else if(t.equals(team2))
    {
      if(scoreTeam1>scoreTeam2)
      {
        return 0;
      }
      if(scoreTeam1==scoreTeam2)
      {
        return 1;
      }
      else if(scoreTeam1<scoreTeam2)
      {
        return 3;
      }
    }
    System.out.println();
    return -1;
  }
  
  public int getGetScoredGoals(Team t)
  {
      if(t.equals(team1))
      {
          return scoreTeam1;
      }
      else if(t.equals(team2))
      {
          return scoreTeam2;
      }
      
      return 0;
  }
  
  public int getCleanSheets(Team t)
  {
     if(t.equals(team1))
      {
          return scoreTeam2;
      }
      else if(t.equals(team2))
      {
          return scoreTeam1;
      }
      
      return 0; 
  }
  
  @Override
  public String toString()
  {
    return String.format("Game\n%s: %d\n%s: %d\n\n", team1.getName(),scoreTeam1,team2.getName(),scoreTeam2);
  }
  
}
