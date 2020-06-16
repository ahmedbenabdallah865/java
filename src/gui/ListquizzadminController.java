/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Service.ServiceQuestion;
import entite.Question;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class ListquizzadminController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private TableColumn<String,Question> ennonce;

    @FXML
    private TableColumn<String,Question> question;


    @FXML
    private TableColumn<String,Question> prop1;

    @FXML
    private TableColumn<String,Question> prop2;

    @FXML
    private TableColumn<String,Question> prop3;

    @FXML
    private TableColumn<String,Question> correct;

     @FXML
    private TableView<Question> quizz;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            
            
            ServiceQuestion Servq = new ServiceQuestion();
            List<Question> list= Servq.readAll();
            ObservableList<Question> cls = FXCollections.observableArrayList();
             
            for (Question aux : list) {
             
                cls.add(new Question(aux.getId(),aux.getEnonce(),aux.getRep1(),aux.getRep2(),aux.getRep3(),aux.getCorrect(),aux.getSujet()));
                
            }
                ennonce.setCellValueFactory(new PropertyValueFactory<>("sujet"));
                question.setCellValueFactory(new PropertyValueFactory<>("enonce"));
                prop1.setCellValueFactory(new PropertyValueFactory<>("rep1"));
                prop2.setCellValueFactory(new PropertyValueFactory<>("rep2"));
                prop3.setCellValueFactory(new PropertyValueFactory<>("rep3"));
                correct.setCellValueFactory(new PropertyValueFactory<>("correct"));
                quizz.setItems(cls);
             
            } catch (SQLException ex) {
            System.out.println("err");
       }
  }
    
    public void  modifieretsupprimer (int data) throws IOException
    {
        System.out.println("ahmed");
         FXMLLoader loader = new FXMLLoader(getClass().getResource("modifieretsupprimer.fxml"));
            Parent root5 = loader.load();
            ModifieretsupprimerController TEST = loader.getController();
            TEST.setval(data);
            
            Stage stage = new Stage();
            stage.setScene(new Scene(root5));
            stage.show();
    }
    
    @FXML
    public void OpenData(){
           try {
            Question Tmp = quizz.getSelectionModel().getSelectedItem();
            modifieretsupprimer(Tmp.getId());
        } catch (Exception ex) {
            System.out.println(ex);
        }

        
    }
    
    
      @FXML
    public void refresh(){
     try {
     
            ServiceQuestion Servq = new ServiceQuestion();
            List<Question> list= Servq.readAll();
            ObservableList<Question> cls = FXCollections.observableArrayList();
             
            for (Question aux : list) {
            
                cls.add(new Question(aux.getId(),aux.getEnonce(),aux.getRep1(),aux.getRep2(),aux.getRep3(),aux.getCorrect(),aux.getSujet()));
                
            }
                ennonce.setCellValueFactory(new PropertyValueFactory<>("sujet"));
                question.setCellValueFactory(new PropertyValueFactory<>("enonce"));
                prop1.setCellValueFactory(new PropertyValueFactory<>("rep1"));
                prop2.setCellValueFactory(new PropertyValueFactory<>("rep2"));
                prop3.setCellValueFactory(new PropertyValueFactory<>("rep3"));
                correct.setCellValueFactory(new PropertyValueFactory<>("correct"));
                quizz.setItems(cls);
             
            } catch (SQLException ex) {
            System.out.println("err");
       }
    
        }
}
