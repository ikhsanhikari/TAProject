/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ta.elearning.dto;

/**
 *
 * @author sou
 */
public class Tb_modelDto {

    private Integer id;
    private Integer id_user;
    private Integer id_matery;
    private Integer knowledge_sebelum;
    private Integer knowledge_sesudah;
    private Integer score_sesudah;
    private Integer score_sebelum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public Integer getId_matery() {
        return id_matery;
    }

    public void setId_matery(Integer id_matery) {
        this.id_matery = id_matery;
    }

    public Integer getKnowledge_sebelum() {
        return knowledge_sebelum;
    }

    public void setKnowledge_sebelum(Integer knowledge_sebelum) {
        this.knowledge_sebelum = knowledge_sebelum;
    }

    public Integer getKnowledge_sesudah() {
        return knowledge_sesudah;
    }

    public void setKnowledge_sesudah(Integer knowledge_sesudah) {
        this.knowledge_sesudah = knowledge_sesudah;
    }

    public Integer getScore_sesudah() {
        return score_sesudah;
    }

    public void setScore_sesudah(Integer score_sesudah) {
        this.score_sesudah = score_sesudah;
    }

    public Integer getScore_sebelum() {
        return score_sebelum;
    }

    public void setScore_sebelum(Integer score_sebelum) {
        this.score_sebelum = score_sebelum;
    }
}
