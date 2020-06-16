/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Service.ServiceCommentaire;
import Service.ServiceQuestion;
import entite.Commentaire;
import entite.Question;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.annotation.PostConstruct;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class AjoutquizzadminFXMLController extends AnchorPane{

 
    @FXML
    private ComboBox<String> sujet;
    
    @FXML
    private TextField question;

    @FXML
    private TextField prop1;

    @FXML
    private TextField prop2;

    @FXML
    private TextField prop3;

    @FXML
    private Button ajout;

    @FXML 
    private Button affichequestion;
    
 
   
    @FXML
    private RadioButton r1;

    @FXML
    private RadioButton r2;

    @FXML
    private RadioButton r3;


    
    
    @FXML
    void ajout(ActionEvent event) throws SQLException {
   
    
      if (!(sujet.getValue() == null))  
      {
          /////////////////////// TRUE /////////////////////////
          
      String s= sujet.getValue();
      String q=question.getText();
      String p1=prop1.getText();
      String p2=prop2.getText();
      String p3=prop3.getText();
      int test = 0;
      
    if (q.length() < 1) {
        test = -1;
             Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("vérifier question");
        alert.showAndWait().ifPresent(rs -> {
      if (rs == ButtonType.OK) {
        System.out.println("OK");
       }
        });
      
      }
      
    if (p1.length() < 1) {  
            test = -1;
           Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("vérifier Proposition 1");
        alert.showAndWait().ifPresent(rs -> {
      if (rs == ButtonType.OK) {
        System.out.println("OK");
       }
        });
      }
        if (p2.length() < 1) {
                test = -1;
               Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("vérifier Proposition 2");
        alert.showAndWait().ifPresent(rs -> {
      if (rs == ButtonType.OK) {
        System.out.println("OK");
       }
        });
      
      }
        if (p3.length() < 1) {
                test = -1;
               Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("vérifier Proposition 3");
        alert.showAndWait().ifPresent(rs -> {
      if (rs == ButtonType.OK) {
        System.out.println("OK");
       }
        });
      }
      
      
      if (test == 0){
      
                        String pc = "";
                    if (r1.isSelected()){
                       pc = p1;
                    }
                     if (r2.isSelected()){
                           pc = p2;
                    }
                       if (r3.isSelected()){
                             pc = p3;
                    }

                    Question qu=new Question(q, p1, p2, p3, pc, s);
                    ServiceQuestion sq=new ServiceQuestion();
                    sq.ajouter(qu);

                     Alert alert = new Alert(AlertType.CONFIRMATION);
                     alert.setTitle("Question ajouter avec sucess");
                     alert.showAndWait().ifPresent(rs -> {
                    if (rs == ButtonType.OK) {
                     System.out.println("OK");
                    }
                     });
                     
                     
                  
    try {
   String jsonResponse;
   
   URL url = new URL("https://onesignal.com/api/v1/notifications");
   HttpURLConnection con = (HttpURLConnection)url.openConnection();
   con.setUseCaches(false);
   con.setDoOutput(true);
   con.setDoInput(true);

   con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
   con.setRequestProperty("Authorization", "Basic YzA3YmI4YjctNDA3Yi00MGUzLWI0ZjQtYjdhYTk1YTIyMmI3");
   con.setRequestMethod("POST");

   String strJsonBody = "{"
                      +   "\"app_id\": \"31ddc0b1-309d-464d-b593-8cf74fb740ca\","
                      +   "\"included_segments\": [\"All\"],"
                      +   "\"data\": {\"foo\": \"bar\"},"
                      +   "\"contents\": {\"en\": \"NOUVOU QUIZZ DISPO\"}"
                      + "}";
         
   
   System.out.println("strJsonBody:\n" + strJsonBody);

   byte[] sendBytes = strJsonBody.getBytes("UTF-8");
   con.setFixedLengthStreamingMode(sendBytes.length);

   OutputStream outputStream = con.getOutputStream();
   outputStream.write(sendBytes);

   int httpResponse = con.getResponseCode();
   System.out.println("httpResponse: " + httpResponse);

   if (  httpResponse >= HttpURLConnection.HTTP_OK
      && httpResponse < HttpURLConnection.HTTP_BAD_REQUEST) {
      Scanner scanner = new Scanner(con.getInputStream(), "UTF-8");
      jsonResponse = scanner.useDelimiter("\\A").hasNext() ? scanner.next() : "";
      scanner.close();
   }
   else {
      Scanner scanner = new Scanner(con.getErrorStream(), "UTF-8");
      jsonResponse = scanner.useDelimiter("\\A").hasNext() ? scanner.next() : "";
      scanner.close();
   }
   System.out.println("jsonResponse:\n" + jsonResponse);
   
} catch(Throwable t) {
   t.printStackTrace();
}
    
    

 
      
      } else {
          
          /***************** ERROR ******************/
     Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("vérifier sujet");
        alert.showAndWait().ifPresent(rs -> {
      if (rs == ButtonType.OK) {
        System.out.println("OK");
       }
        });
        }
     }
  }
    
   public void afficherquestion() throws  SQLException, IOException {
             FXMLLoader loader = new FXMLLoader(getClass().getResource("listquizzadmin.fxml"));
             Parent root4 = loader.load();
             Stage stage=new Stage();
            
             Scene scene = new Scene(root4);
             stage.setScene(scene);
             stage.show();
    }
   
    @FXML
    public void initialize()  {
        
          sujet.setPromptText("sélectionner sujet");
        // Create a combo box 
         sujet.getItems().addAll(
        "Théâtre",
        "Musique",
        "Sport",
        "Autre"
        );
                                               
          
    }
}
