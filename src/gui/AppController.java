/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.util.List;
import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;



/**
 * FXML Controller class
 *
 * @author admin
 */
public class AppController extends Application {
   
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("App.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @FXML
    public void opencomment(){
        try {
            //Load second scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("list.fxml"));
            Parent root2 = loader.load();
//            List  C1  = loader.getController();
            //Pass whatever data you want. You can have multiple method calls here
           // C1.transferMessage("AhmedTest","PosteStatic");
            //Show scene 2 in new window            
            Stage stage = new Stage();
            stage.setScene(new Scene(root2));
            stage.setTitle("Comment Window");
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
    
    @FXML
    public void opencommentadmin(){
        try {
            //Load second scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminComment.fxml"));
            Parent root6 = loader.load();
 
            //Pass whatever data you want. You can have multiple method calls here
            //Show scene 2 in new window            
            Stage stage = new Stage();
            stage.setScene(new Scene(root6));
            stage.setTitle("Admin Comment");
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
    
        @FXML
        public void openquizz(){
        try {
            //Load second scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AjoutquizzadminFXML.fxml"));
            Parent root3 = loader.load();
             
            //Get controller of scene2
            //AjoutquizzadminFXMLController  A1  = loader.getController();
            //Pass whatever data you want. You can have multiple method calls here
            //C1.transferMessage("AhmedTest","PosteStatic");
 
            //Show scene 2 in new window  
                       
                        
            Stage stage = new Stage();
           
            stage.setScene(new Scene(root3));
            stage.setTitle("Les Question");
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex);
        }  
    
    }
        
             @FXML
        public void openquizzuser(){ 
        
        
              try {
            //Load second scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Quizuser.fxml"));
            Parent root3 = loader.load();
             

            Stage stage = new Stage();
            stage.setScene(new Scene(root3));
            stage.setTitle("Quiz user");
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex);
        }  
        
        
        }
   
   }
