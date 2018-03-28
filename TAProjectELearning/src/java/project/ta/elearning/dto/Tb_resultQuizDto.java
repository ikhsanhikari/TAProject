/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ta.elearning.dto;

/**
 *
 * @author Sou
 */
public class Tb_resultQuizDto {
    private Integer id;
    private Integer id_colleger;
    private Integer id_matery;
    private Integer score;
    private Integer idknowledge;
    private Integer id_category;
    private String knowledge;
    private String name;

    public String getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(String knowledge) {
        this.knowledge = knowledge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId_category() {
        return id_category;
    }

    public void setId_category(Integer id_category) {
        this.id_category = id_category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_colleger() {
        return id_colleger;
    }

    public void setId_colleger(Integer id_colleger) {
        this.id_colleger = id_colleger;
    }

    public Integer getId_matery() {
        return id_matery;
    }

    public void setId_matery(Integer id_matery) {
        this.id_matery = id_matery;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getIdknowledge() {
        return idknowledge;
    }

    public void setIdknowledge(Integer idknowledge) {
        this.idknowledge = idknowledge;
    }
}
