/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

/**
 *
 * @author admin
 */
public class Question {
   private int id;
    private String enonce;
    private String rep1;
    private String rep2;
    private String rep3;
    private String correct;
    private String sujet;

    public Question(String enonce, String rep1, String rep2, String rep3, String correct, String sujet) {
        this.enonce = enonce;
        this.rep1 = rep1;
        this.rep2 = rep2;
        this.rep3 = rep3;
        this.correct = correct;
        this.sujet = sujet;
    }

    public Question(int id, String enonce, String rep1, String rep2, String rep3, String correct, String sujet) {
        this.id = id;
        this.enonce = enonce;
        this.rep1 = rep1;
        this.rep2 = rep2;
        this.rep3 = rep3;
        this.correct = correct;
        this.sujet = sujet;
    }

    @Override
    public String toString() {
        return "question{" + "id=" + id + ", enonce=" + enonce + ", rep1=" + rep1 + ", rep2=" + rep2 + ", rep3=" + rep3 + ", correct=" + correct + ", sujet=" + sujet + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEnonce() {
        return enonce;
    }

    public void setEnonce(String enonce) {
        this.enonce = enonce;
    }

    public String getRep1() {
        return rep1;
    }

    public void setRep1(String rep1) {
        this.rep1 = rep1;
    }

    public String getRep2() {
        return rep2;
    }

    public void setRep2(String rep2) {
        this.rep2 = rep2;
    }

    public String getRep3() {
        return rep3;
    }

    public void setRep3(String rep3) {
        this.rep3 = rep3;
    }

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    } 
}
