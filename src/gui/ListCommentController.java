/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Service.ServiceCommentaire;
import entite.Commentaire;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class ListCommentController implements Initializable {
   @FXML
    private TableView<Commentaire> PostComment;

    @FXML
    private TableColumn<Date,Commentaire> c1;

    @FXML
    private TableColumn<String,Commentaire> c2;

    @FXML
    private TableColumn<String, Commentaire> c3;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    try
    {
            ServiceCommentaire Servcom = new ServiceCommentaire();
            List<Commentaire> list = Servcom.readAll();
            System.out.println(list);
            ObservableList<Commentaire> cls = FXCollections.observableArrayList();
            for (Commentaire aux : list) {
          
                cls.add(new Commentaire(aux.getPublication_id(),aux.getUser_id(),aux.getContenu(),aux.getActif(),aux.getCreated_at()));
            }
             c1.setCellValueFactory(new PropertyValueFactory<>("created_at"));
             c2.setCellValueFactory(new PropertyValueFactory<>("user_id"));
             c3.setCellValueFactory(new PropertyValueFactory<>("contenu"));
            

            PostComment.setItems(cls);
           
            }catch(Exception ex){
                    System.out.println(ex);
                   
             }
     
    }
    }    
    

