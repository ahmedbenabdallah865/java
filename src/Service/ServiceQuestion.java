/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import IService.IService;
import Utils.DataBase;
import entite.Commentaire;
import entite.Question;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class ServiceQuestion implements IService<Question> {

     private Connection con;
     private Statement ste;
     public ServiceQuestion() {
        con = DataBase.getInstance().getConnection();
    }

    @Override
    public void ajouter(Question a) throws SQLException {
          PreparedStatement PS = con.prepareStatement("INSERT INTO `question` (`enonce`, `rep1`, `rep2`,`rep3`,`correct`,`sujet`) VALUES (?, ?, ?, ?,?,?);");
          PS.setString(1,a.getEnonce());
          PS.setString(2,a.getRep1());
          PS.setString(3,a.getRep2());
          PS.setString(4,a.getRep3());
          PS.setString(5,a.getCorrect());
          PS.setString(6,a.getSujet());
          PS.executeUpdate();
    }

    @Override
    public void delete(int id) throws SQLException {
        PreparedStatement PS = con.prepareStatement("DELETE FROM `question` WHERE `id`=?");
        PS.setInt(1,id);
        PS.executeUpdate();
    }

    @Override
    public void update(Question a) throws SQLException {
        PreparedStatement PS=con.prepareStatement("UPDATE `question` SET  `enonce`=? ,`rep1`=?,`rep2`=? ,`rep3`=?,`correct`=?,`sujet`=?WHERE `id`=?");
       
        PS.setString(1,a.getEnonce());
        PS.setString(2,a.getRep1());
        PS.setString(3,a.getRep2());
        PS.setString(4,a.getRep3());
        PS.setString(5,a.getCorrect());
        PS.setString(6,a.getSujet());
        PS.setInt(7,a.getId());
        PS.executeUpdate();
    }

    @Override
    public List<Question> readAll() throws SQLException {
       List<Question> AL = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from question");
        while (rs.next()) {
            int id = rs.getInt(1);
            String enonce = rs.getString(2);
            String rep1 = rs.getString(3);
            String rep2 = rs.getString(4);
            String rep3 = rs.getString(5);
            String correct = rs.getString(6);
            String sujet = rs.getString(7);
           
            Question C = new Question(id,enonce,rep1,rep2,rep3,correct,sujet );
            AL.add(C);
        }
        return AL;
    }
    
    
    public Question Searchbyid(int idd) throws SQLException {
 
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from question where `id`="+idd);
        rs.next();
            int id = rs.getInt(1);
            String enonce = rs.getString(2);
            String rep1 = rs.getString(3);
            String rep2 = rs.getString(4);
            String rep3 = rs.getString(5);
            String correct = rs.getString(6);
            String sujet = rs.getString(7);
           
            Question C = new Question(id,enonce,rep1,rep2,rep3,correct,sujet );
             return C;

        }    
    }
