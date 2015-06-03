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
  private float coefficient[];

  public Team(String name, String nationality, int number, float[] coefficient)
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

  public float[] getCoefficient()
  {
    return coefficient;
  }
  
  
}
