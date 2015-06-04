/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package footballmanager.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Philip
 */
public class MainPageApp extends Application
{
  private static Stage primaryStage;
    public static void main(String[] args) 
    {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception
    {
      MainPageApp.primaryStage=primaryStage;
      StackPane root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
      root.setId("pane");
      Scene scene = new Scene(root);
      scene.getStylesheets().addAll(this.getClass().getResource("mainpage.css").toExternalForm());

      setScene(scene);
    }
    public static void setScene(Scene scene)
    {
      primaryStage.setScene(scene);
      primaryStage.show();
    }
}
