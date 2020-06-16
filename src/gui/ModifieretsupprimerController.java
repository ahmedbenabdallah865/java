/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Service.ServiceQuestion;
import entite.Question;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class ModifieretsupprimerController implements Initializable {

    int id;
    @FXML
    private TextField sujet;

    @FXML
    private TextField enonce;

    @FXML
    private TextField prop1;

    @FXML
    private TextField prop2;

    @FXML
    private TextField prop3;


    
    
    @FXML
    private RadioButton correct1;

    @FXML
    private RadioButton correct2;

    @FXML
    private RadioButton correct3;
    
    @FXML
    public void rechercher(int id) throws SQLException {
            
            ServiceQuestion Servq = new ServiceQuestion();
            List<Question> list= Servq.readAll();
            
             
            for (Question aux:list) {
                String a=String.valueOf(aux.getId());
                String ID=String.valueOf(id);
                
                if(a.equals(ID))
                {
                    
                    sujet.setText(aux.getSujet());
                    enonce.setText(aux.getEnonce());
                    prop1.setText(aux.getRep1());
                    prop2.setText(aux.getRep2());
                    prop3.setText(aux.getRep3());
                     
                 
                }
                
                
            }

    }

    @FXML
    public void supprimer() throws SQLException {
           ServiceQuestion Servq = new ServiceQuestion();
           List<Question> list= Servq.readAll();
           for (Question aux:list) {
                String a=String.valueOf(aux.getId());
                String ID=String.valueOf(id);
                
                if(a.equals(ID))
                {
                    int i = Integer.parseInt(a);
                    Servq.delete(i);
                 
                }
                
                
            }
           
    }
    @FXML
    public void modifier() throws SQLException {
            ServiceQuestion Servq = new ServiceQuestion();
            List<Question> list= Servq.readAll();
            
             
            for (Question aux:list) {
                String a=String.valueOf(aux.getId());
                String ID=String.valueOf(id);
                
                if(a.equals(ID))
                {
                   int i = Integer.parseInt(a);
                   String s=sujet.getText();
                   String e= enonce.getText();
                   String p1=prop1.getText();
                   String p2=prop2.getText();
                   String p3= prop3.getText();
                  // String c= correct.getText();
                    String pc = "";
                    if (correct1.isSelected()){
                       pc = prop1.getText();
                    }
                     if (correct2.isSelected()){
                           pc = prop2.getText();
                    }
                       if (correct3.isSelected()){
                             pc = prop3.getText();
                    }
                   Question q=new Question(i,e, p1, p2, p3, pc, s);
                   Servq.update(q);
                 
                }
                
                
            }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }    
    
    
    public void setval(int x){
     //id.setText(String.valueOf(x));
        try {
            id=x;
            rechercher(x);  
        } catch (Exception e) {
            System.out.println(e);
        }

        
    }
    
}
