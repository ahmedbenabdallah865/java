/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import IService.IService;
import Utils.DataBase;
import entite.Commentaire;
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
public class ServiceCommentaire implements IService<Commentaire> {

     private Connection con;
    private Statement ste;

    public ServiceCommentaire() {
        con = DataBase.getInstance().getConnection();
    }

    @Override
    public void ajouter(Commentaire a) throws SQLException {
        PreparedStatement PS = con.prepareStatement("INSERT INTO `commentaire` (`publication_id`, `user_id`, `contenu`,`actif`,`created_at`) VALUES (?, ?, ?, ?,?);");
        PS.setInt(1, a.getPublication_id());
        PS.setInt(2, a.getUser_id());
        PS.setString(3, a.getContenu());
        PS.setInt(4,a.getActif());
        PS.setDate(5,a.getCreated_at());
        PS.executeUpdate();
    }
    @Override
    public void delete(int id) throws SQLException {
        PreparedStatement PS = con.prepareStatement("DELETE FROM `commentaire` WHERE `id`=?");
        PS.setInt(1,id);
        PS.executeUpdate();
    }

    @Override
    public void update(Commentaire t) throws SQLException {
        PreparedStatement PS=con.prepareStatement("UPDATE `commentaire` SET  `publication_id`=?,`user_id`=? ,`contenu`=?,`actif`=? ,`created_at`=?WHERE `id`=?");
        PS.setInt(1,t.getPublication_id());
        PS.setInt(2, t.getUser_id());
        PS.setString(3,t.getContenu());
        PS.setInt(4,t.getActif());
        PS.setDate(5,t.getCreated_at());
        PS.setInt(6,t.getId());
        PS.executeUpdate();
    }

    
    
    
    
     @Override
    public List<Commentaire> readAll() throws SQLException {
       List<Commentaire> AL = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from commentaire");
       while (rs.next()) {
            int id = rs.getInt(1);
            int id_publication = rs.getInt(2);
            int id_user = rs.getInt(3);
            String contenu = rs.getString(4);
            int actif = rs.getInt(5);
            Date created_at = rs.getDate(6);
            Commentaire C = new Commentaire(id,id_publication,id_user,contenu,actif,created_at );
            AL.add(C);
        }
        return AL;
    }
    
    
    
    
    
    
    
    
    
    public List<Commentaire> readAllname() throws SQLException {
       List<Commentaire> AL = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select commentaire.id,publication.titre,user.username,commentaire.contenu,commentaire.created_at from publication,user,commentaire where user.id = commentaire.user_id and publication.id = commentaire.publication_id");
        while (rs.next()) {
            int id = rs.getInt(1);
            String titre = rs.getString(2);
            String username = rs.getString(3);
            String contenu = rs.getString(4);
            Date created_at = rs.getDate(5);
            Commentaire C = new Commentaire(id,contenu,created_at,username,titre );
            AL.add(C);
        }
        return AL;
    }
    
    
       public void approved(int x) throws SQLException {
          
        PreparedStatement PS=con.prepareStatement("UPDATE `commentaire` SET  `actif`=? WHERE `id`=?");
        PS.setInt(1,1);
        PS.setInt(2,x);
        PS.executeUpdate();
    }
       
       
        public void sing(int x) throws SQLException {
          
        PreparedStatement PS=con.prepareStatement("UPDATE `commentaire` SET  `actif`= `actif` + 1  WHERE `id`=?");
        PS.setInt(1,x);
        PS.executeUpdate();
        PreparedStatement PS2=con.prepareStatement("DELETE FROM commentaire WHERE actif >= 4");
        PS2.executeUpdate();

    }
    
    
     public List<Commentaire> Search(String x) throws SQLException {
       List<Commentaire> AL = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select commentaire.id,publication.titre,user.username,commentaire.contenu,commentaire.created_at from publication,user,commentaire where user.id = commentaire.user_id and publication.id = commentaire.publication_id and commentaire.created_at = '"+x+"'");
        while (rs.next()) {
            int id = rs.getInt(1);
            String titre = rs.getString(2);
            String username = rs.getString(3);
            String contenu = rs.getString(4);
            Date created_at = rs.getDate(5);
            Commentaire C = new Commentaire(id,contenu,created_at,username,titre );
            AL.add(C);
        }
        return AL;
    }
}
