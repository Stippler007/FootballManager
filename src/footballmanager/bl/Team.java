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
public class Team
{
  private String name;
  private String nationality;
  private int number;
  private double coefficient[];
  
  private int pointsGroup=0;
  private int gameCounter=0;
  private int win=0;
  private int tie=0;
  private int loose=0;
  
  public Team(String name, String nationality, int number, double[] coefficient)
  {
    this.name = name;
    this.nationality = nationality;
    this.number = number;
    this.coefficient = coefficient;
  }

  public String getName()
  {
    return name;
  }
  public String getNationality()
  {
    return nationality;
  }

  public int getNumber()
  {
    return number;
  }
  
  public int getGameCounter()
  {
    return gameCounter;
  }

  public double[] getCoefficient()
  {
    return coefficient;
  }
  public void addpoints(int points)
  {
    pointsGroup+=points;
    gameCounter++;
    switch(points)
    {
      case 0:loose++;
        break;
      case 1:tie++;
        break;
      case 3:win++;
        break;
    }
    
    System.out.println("Name: "+name+" GameCounter"+": "+gameCounter);
    System.out.println("Name: "+name+" GruppenPunkte"+": "+pointsGroup);
  }

  public int getPointsGroup()
  {
    return pointsGroup;
  }

  public int getLoose()
  {
    return loose;
  }

  public int getTie()
  {
    return tie;
  }

  public int getWin()
  {
    return win;
  }
  
  @Override
  public String toString()
  {
    StringBuilder sb=new StringBuilder("");
    for (int i = 0; i < coefficient.length-1; i++)
    {
      sb.append(coefficient[i]).append("#");
    }
    sb.append(coefficient[coefficient.length-1]);
    return String.format("%s#%s#%d#%s", name,nationality,number,sb.toString());
  }
  
  
}
