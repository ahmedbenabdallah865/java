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
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class ModifierousupprimerController implements Initializable {

    @FXML
    private TextArea contenu;
    @FXML
    private Button modifier;
    @FXML
    private Button supprimer;
    public int modif;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    public void rechercher(int id) throws SQLException {
            
            ServiceCommentaire Servc = new ServiceCommentaire();
            List<Commentaire> list= Servc.readAll();
            
             
            for (Commentaire aux:list) {
                String a=String.valueOf(aux.getId());
                String ID=String.valueOf(id);
                
                if(a.equals(ID))
                {
                    
                    contenu.setText(aux.getContenu());
                    modif=id;
                 
                }
                
                
            }

    }
    public void modifier() throws SQLException
    {
        ServiceCommentaire Servc = new ServiceCommentaire();
        List<Commentaire> list= Servc.readAll();
        String ID=String.valueOf(modif);
        for (Commentaire aux:list) {
                String a=String.valueOf(aux.getId());
                if(a.equals(ID))
                {
                    String C=contenu.getText();
                    System.out.println();
                    Commentaire c=new Commentaire(modif,aux.getPublication_id(),aux.getUser_id(), C,aux.getActif(),aux.getCreated_at());
                    Servc.update(c);
                }
        }
        
    }
    public void getval(int x){
     
        try {
            rechercher(x);  
        } catch (Exception e) {
            System.out.println(e);
        }

        
    }
}
