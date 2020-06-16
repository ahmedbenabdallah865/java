/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Service.ServiceCommentaire;
import entite.Commentaire;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author admin
 */
public class AdminComment implements Initializable { 

    
    @FXML
    private TableView<Commentaire> tab;

    @FXML
    private TableColumn<String, Commentaire> c1;

    @FXML
    private TableColumn<String, Commentaire> c2;

    @FXML
    private TableColumn<String, Commentaire> c3;

    @FXML
    private TableColumn<Date, Commentaire> c4;

 

    
    @FXML
    private DatePicker datapicker;
    
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try
    {
     
            ServiceCommentaire Servcom = new ServiceCommentaire();
            List<Commentaire> list = Servcom.readAllname();
            System.out.println(list);
            ObservableList<Commentaire> cls = FXCollections.observableArrayList();
            for (Commentaire aux : list) {
                System.out.println(list.toString());
                cls.add(new Commentaire(aux.getId(),aux.getContenu(),aux.getCreated_at(),aux.getUsername(),aux.getTitre()));
            }
            c1.setCellValueFactory(new PropertyValueFactory<>("titre"));
            c2.setCellValueFactory(new PropertyValueFactory<>("username"));
            c3.setCellValueFactory(new PropertyValueFactory<>("contenu"));
            c4.setCellValueFactory(new PropertyValueFactory<>("created_at")); 
           
           
           
            tab.setItems(cls);
           
            }catch(Exception ex){
                    System.out.println(ex);
                   
             }
     
    }
    
    
    
   @FXML
   public void search(){
   try{
             ServiceCommentaire Servcom = new ServiceCommentaire();
            String pattern = "yyyy-MM-dd";
             DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);
  
             
            List<Commentaire> list = Servcom.Search(dateFormatter.format( datapicker.getValue()));
            System.out.println(list);
            ObservableList<Commentaire> cls = FXCollections.observableArrayList();
            for (Commentaire aux : list) {
                System.out.println(list.toString());
                cls.add(new Commentaire(aux.getId(),aux.getContenu(),aux.getCreated_at(),aux.getUsername(),aux.getTitre()));
            }
            c1.setCellValueFactory(new PropertyValueFactory<>("titre"));
            c2.setCellValueFactory(new PropertyValueFactory<>("username"));
            c3.setCellValueFactory(new PropertyValueFactory<>("contenu"));
           c4.setCellValueFactory(new PropertyValueFactory<>("created_at")); 
           
           
           
            tab.setItems(cls);
           
            }catch(Exception ex){
                    System.out.println(ex);
                   
             }
   
   }
   
   
    
    @FXML
    public void OpenData(){
           try {
            Commentaire Tmp = tab.getSelectionModel().getSelectedItem();
            
            
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("approved.fxml"));
            Parent root5 = loader.load();
            approved TEST = loader.getController();
            TEST.getid(Tmp.getId());
            Stage stage = new Stage();
            stage.setScene(new Scene(root5));
            stage.show();
            
            
            
            
        
        } catch (Exception ex) {
            System.out.println(ex);
        }

        
    }
    
    
    @FXML
    public void refrech(){
    
    
            try
    {
     
            ServiceCommentaire Servcom = new ServiceCommentaire();
            List<Commentaire> list = Servcom.readAllname();
            System.out.println(list);
            ObservableList<Commentaire> cls = FXCollections.observableArrayList();
            for (Commentaire aux : list) {
                System.out.println(list.toString());
                cls.add(new Commentaire(aux.getId(),aux.getContenu(),aux.getCreated_at(),aux.getUsername(),aux.getTitre()));
            }
            c1.setCellValueFactory(new PropertyValueFactory<>("titre"));
            c2.setCellValueFactory(new PropertyValueFactory<>("username"));
            c3.setCellValueFactory(new PropertyValueFactory<>("contenu"));
            c4.setCellValueFactory(new PropertyValueFactory<>("created_at")); 
           
           
           
            tab.setItems(cls);
           
            }catch(Exception ex){
                    System.out.println(ex);
                   
             }
    
    }
        
    }
    
   

