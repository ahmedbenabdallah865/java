/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Service.ServiceCommentaire;
import entite.Commentaire;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class ListController implements Initializable {

    /**
     * Initializes the controller class.
     */
    ObservableList list=FXCollections.observableArrayList();
    
    @FXML
    private ListView<String> listcommentaire;
    
       @FXML
    private Button next;
       @FXML
    private Label labelid;
       @FXML
    private TextArea commentaire;
    public  int i=0;
     @FXML
    private Label comm;
      @FXML
    private Button ajouter;
       @FXML
    private Button rafraîchir;
        @FXML
    private TextField searchbar;
    public     int j=0;
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
        try {
            loaddata();
        } catch (SQLException ex) {
            Logger.getLogger(ListController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ListController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    public void loaddata() throws SQLException,Exception
    { 
        
        String S=searchbar.getText();
        ServiceCommentaire serc=new ServiceCommentaire();
        if(S=="" || i<= serc.readAllname().size()-1)
        {
            list.clear();
        List<Commentaire> listcom= serc.readAllname();    
        System.out.println(i);
        String a=listcom.get(i).getUsername();
        String b=listcom.get(i).getContenu();
        String c=listcom.get(i).getCreated_at().toString();
        String d=listcom.get(i).getTitre();
        list.addAll(a,b,c,d);
        System.out.println(list);
        listcommentaire.getItems().clear();
        listcommentaire.getItems().addAll(list);
        i++;
        }
        
        if (S.equals("")==false)
        {   
             list.clear();
             System.out.println(S);
             List<Commentaire> listcom= serc.Search(S);
             System.out.println(i);
             String a=listcom.get(i).getUsername();
             String b=listcom.get(i).getContenu();
             String c=listcom.get(i).getCreated_at().toString();
             String d=listcom.get(i).getTitre();
             list.addAll(a,b,c,d);
             System.out.println(list);
             listcommentaire.getItems().clear();
             listcommentaire.getItems().addAll(list);
             i++;
        }
       
        
    }
    public void supprimeroumodifier() throws SQLException, IOException
    {
              if(i!=0)
              {
                  i--;
              }
              ServiceCommentaire serc=new ServiceCommentaire();
              List<Commentaire> listcom= serc.readAllname();
              FXMLLoader loader = new FXMLLoader(getClass().getResource("modifierousupprimer.fxml"));
              Parent root5 = loader.load();
              ModifierousupprimerController TEST = loader.getController();
              TEST.getval(listcom.get(i).getId());
              Stage stage = new Stage();
              stage.setScene(new Scene(root5));
              stage.show();
    }
     @FXML
    void ajouter(ActionEvent event) throws SQLException {
        String comment=commentaire.getText();
        if(comment.length()<1)
        {
             Alert alert = new Alert(AlertType.WARNING);
             alert.setTitle("vérifier votre commentaire");
             alert.showAndWait().ifPresent(rs -> {
             if (rs == ButtonType.OK) {
             System.out.println("OK");
               }
            });
        }else{    
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
                      +   "\"contents\": {\"en\": \"Votre Commentaire a été ajouté avec succé\"}"
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
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        Commentaire c=new Commentaire(1, 1,comment , 0,date);
        Service.ServiceCommentaire sc =new ServiceCommentaire();
        sc.ajouter(c); 
        
        comm.setText("commentaire ajouté!!");
               
    }}
    
    public void refresh() throws SQLException, Exception
    {
        i=0;
        loaddata();
        
    }
    
   
   
}
