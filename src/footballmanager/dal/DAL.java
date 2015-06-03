/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package footballmanager.dal;

import footballmanager.bl.Team;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import sun.dc.pr.PathStroker;

/**
 *
 * @author Christian
 */
public class DAL
{
  private static DAL dal;

  public static DAL getDal()
  {
    if(dal==null)dal=new DAL();
    return dal;
  }
  public void readConnection(String link) throws MalformedURLException, FileNotFoundException, IOException
  {
    // GET      /HTTP/1.0 \n\n
    URL url=new URL(link);
    OutputStream out=new FileOutputStream(link);
    InputStream in = url.openStream();
    int len;
    byte[] b = new byte[100];
    while((len=in.read(b))!=-1)
    {
      out.write(b,0,len);
    }
    out.close();
    in.close();
  }
  private List<Team> getTeams(String path) throws IOException
  {
    List<String> lines=getLines(path);
    List<Team> teams=new LinkedList<>();
    
    for (String line : lines)
    {
      String tokens[]=line.split("\t");
      String name=tokens[0];
      
//      Team t=new Team(line, line, number, coefficient)
      
      
    }
    
    return teams;
  }
  
  private List<String> getLines(String path) throws IOException
  {
    List<String> lines;
    final Path exampleFile = Paths.get(path);
    lines=Files.readAllLines(exampleFile);
    
    lines=lines.stream().filter(s->!s.startsWith("#")).collect(Collectors.toList());
    
    return lines;
  }
  public static void main(String[] args)
  {
    try
    {
      DAL.getDal().getLines("src/saves/gerd.txt").stream().forEach(s->System.out.println(s));
      
//    try
//    {
//      String link=new String("http://www.google.at");
//      DAL.getDal().readConnection(link);
//    }
//    catch (FileNotFoundException ex)
//    {
//      Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
//    }
//    catch (IOException ex)
//    {
//      Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
//    }
    }
    catch (IOException ex)
    {
      Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
