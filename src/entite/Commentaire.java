/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.sql.Date;

/**
 *
 * @author admin
 */
public class Commentaire {
     private int id;
    private int  publication_id;
    private int user_id;
    private String contenu;
    private int actif;
    private Date created_at;
    
    private String username;
    private String titre;

    public Commentaire(int id, String contenu, Date created_at, String username, String titre) {
        this.id = id;
        this.contenu = contenu;
        this.created_at = created_at;
        this.username = username;
        this.titre = titre;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDt() {
        return Dt;
    }

    public void setDt(String Dt) {
        this.Dt = Dt;
    }
    
    
    String Dt;

    public Commentaire(int publication_id, int user_id, String contenu, int actif, Date created_at) {
        this.publication_id = publication_id;
        this.user_id = user_id;
        this.contenu = contenu;
        this.actif = actif;
        this.created_at = created_at;
    }

    public Commentaire(int id, int publication_id, int user_id, String contenu, int actif, Date created_at) {
        this.id = id;
        this.publication_id = publication_id;
        this.user_id = user_id;
        this.contenu = contenu;
        this.actif = actif;
        this.created_at = created_at;
    }
    
     /* public Commentaire( int publication_id, int user_id, String contenu, int actif, String created_at) {
       
        this.publication_id = publication_id;
        this.user_id = user_id;
        this.contenu = contenu;
        this.actif = actif;
        this.Dt = created_at;
    }*/

    @Override
    public String toString() {
        return "Commentaire{" + "id=" + id + ", publication_id=" + publication_id + ", user_id=" + user_id + ", contenu=" + contenu + ", actif=" + actif + ", created_at=" + created_at + ", username=" + username + ", titre=" + titre + ", Dt=" + Dt + '}';
    }

 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPublication_id() {
        return publication_id;
    }

    public void setPublication_id(int publication_id) {
        this.publication_id = publication_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public int getActif() {
        return actif;
    }

    public void setActif(int actif) {
        this.actif = actif;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

}
