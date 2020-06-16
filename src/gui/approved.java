/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
 
import Service.ServiceCommentaire;
import entite.Commentaire;

import Service.SendMail;
/**
 *
 * @author admin
 */
public class approved implements  Initializable { 

    private int id;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
    }
    
   public void getid(int x){
       id = x;
  


   }
   
  @FXML 
   public void Delete(){
    ServiceCommentaire Servcom = new ServiceCommentaire();
           try {
        Servcom.delete(id);
                

       } catch (Exception e) {
           System.out.println(e);
       }
   }
   @FXML 
   public void approuve(){
    ServiceCommentaire Servcom = new ServiceCommentaire();
           try {
        Servcom.approved(id);
               

       } catch (Exception e) {
           System.out.println(e);
       }
   }
  

}

