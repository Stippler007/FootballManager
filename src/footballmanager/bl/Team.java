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

  public double[] getCoefficient()
  {
    return coefficient;
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
