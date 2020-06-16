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
import Service.ServiceQuestion;
import entite.Question;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.animation.TranslateTransition;
import javafx.animation.Animation;
import javafx.util.Duration;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;
import gui.reusltat;


/*************** sms ***************/

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.util.Timer;
import java.util.TimerTask;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

 /*********** mail ***********/
import Service.SendMail;

import javafx.animation.Animation;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.event.Event;
import javafx.scene.Node;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Translate;
import javax.swing.JLabel;

/**
 *
 * @author admin
 */
public class Quizuser  extends AnchorPane implements Initializable{ 
  
    @FXML
    private Button next;
    @FXML
    private Label timerlabe;
    @FXML
    private AnchorPane Aquizz;   
    @FXML
    private Label q;
    
     @FXML
    private Label cnt;
    @FXML
    private Label score;
    
    @FXML
    private ComboBox<String> sujet;
    
    @FXML
    private Button start;
     @FXML
    private Button confirme;
    public static int second = 60;
    
    @FXML
    private RadioButton p1;
    @FXML
    private RadioButton p2;

    @FXML
    private RadioButton p3;
    
    public static final String ACCOUNT_SID = "AC70bccdf70299be8e759e511406dfeb73";
    public static final String AUTH_TOKEN = "508719e45a5ecf4b74ace88aa30f2b3d";
    static int a =  1;
    static int test =  0;
    static int cpt =1;
    private String correct=""; 
    int int_score = 0;
    int int_second=second ;
   
    private ObservableList<Question> cls = FXCollections.observableArrayList();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        confirme.setVisible(false);
        sujet.setPromptText("sélectionner sujet");
        // Create a combo box 
        sujet.getItems().addAll(
        "Théâtre",
        "Musique",
        "Sport",
        "Autre"
        );
                  
                        
                       
    }
    
    @FXML
   
    public void  Read(){
       
       
        if (test == 0)
        {               
                        timerlabe.setText(""+int_second); 
                         confirme.setVisible(false);
                        Circle circle=new Circle();
                        circle.setFill(Color.RED);
                        circle.setRadius(10);
                        circle.setLayoutX(150);
                        circle.setLayoutY(200);
                        TranslateTransition transition =new TranslateTransition();
                        transition.setToX(500);
                        transition.setDuration(Duration.seconds(1));
                        transition.setAutoReverse(true);
                        transition.setCycleCount(Animation.INDEFINITE);
                        transition.setNode(circle);
                        transition.play();
                        Aquizz.getChildren().add(circle);
                       
               Timer T=new Timer();
               T.schedule(new TimerTask(){ 
               @Override
                    public void run() 
                    {
                        if (int_second == 0)
                        {
                           cpt = 0;    
                           this.cancel(); 
                           transition.stop();
                           next.setVisible(false);
                           confirme.setVisible(true);
                        }
                        int_second=int_second- 1; 
                        System.out.println(int_second);
                    }},0, 1000);
                     try {
                     ServiceQuestion Servq = new ServiceQuestion();
                     List<Question> list= Servq.readAll();
                       for (Question aux : list) {
                       if (aux.getSujet().equals(sujet.getValue())){
                           cls.add(new Question(aux.getEnonce(),aux.getRep1(),aux.getRep2(),aux.getRep3(),aux.getCorrect(),aux.getSujet()));
                          
                          }
                     }
                     
                     System.out.println(cls.toString());
                    // System.out.println("cpt"+cpt);
                     q.setText(cls.get(0).getEnonce());
                     p1.setText(cls.get(0).getRep1());
                     p2.setText(cls.get(0).getRep2());
                     p3.setText(cls.get(0).getRep3());
                     correct = (cls.get(0).getCorrect());
                     System.out.println(correct);
                     test = 1;
                    } catch (Exception e) {
                       System.out.println();
                    }
        }
}
 @FXML
public void quizz() throws IOException{
    
       timerlabe.setText("Il vous reste:"+int_second+"seconds");
       String Test;
        if (p1.isSelected()){  Test = p1.getText();
        }else if (p2.isSelected()){
        Test = p2.getText();}    
        else if(p3.isSelected()){
        Test = p3.getText();}
        else{Test="";}
        System.out.println(correct);
        System.out.println(Test);

        if (Test.equals(correct)){
            int_score += 100;
            score.setText(String.valueOf(int_score));
            
        }
        if(cpt==(cls.size()))
        {
             
             confirme.setVisible(true);
             next.setVisible(false);
             timerlabe.setText("cliquer sur confirmer");
             
              
        }
        if(cpt<(cls.size()))
        {
             q.setText(cls.get(cpt).getEnonce());
             p1.setText(cls.get(cpt).getRep1());
             p2.setText(cls.get(cpt).getRep2());
             p3.setText(cls.get(cpt).getRep3());
             correct = (cls.get(cpt).getCorrect());
            cpt++;
        }
            
            
         
            System.out.println(correct);
           
        System.out.println("cpt:"+cpt); 
        
    }
 
  public void confirmer(Event event) throws IOException  
  {
          System.out.println("sayé");
         ((Node)(event.getSource())).getScene().getWindow().hide();        
           FXMLLoader loader = new FXMLLoader(getClass().getResource("reusltat.fxml"));
            Parent root5 = loader.load();
            reusltat TEST = loader.getController();
          String Remarque ="";
          if( Integer.valueOf(score.getText()) >  (cls.size() * 100 )/ 2) {Remarque  = "PASS"; }
         else{Remarque  = "FAILD";  }
          
            TEST.tranfert(score.getText()+ " / " + String.valueOf(cls.size() * 100),Remarque);
            
            Stage stage = new Stage();
            stage.setScene(new Scene(root5));
            stage.show();
            String msg = "Votre Note est " +
                score.getText()+ " / " + String.valueOf(cls.size() * 100);
       
            
            /*********sms ***************/
          /*  try {
       // Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
       // Message message = Message.creator(
              //  new com.twilio.type.PhoneNumber("+21625288647"),
               // new com.twilio.type.PhoneNumber("+21629009291"),
               // msg)
            //.create();
               //System.out.println(message.getSid());
            
        } catch (Exception e) {
      
        }*/ 
       System.out.println("mail ... ");
       SendMail.sendMail("ahmed.benabdallah.1@esprit.tn","QUIZZ", msg);   
       
}  
}













