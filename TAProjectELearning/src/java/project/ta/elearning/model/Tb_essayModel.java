/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ta.elearning.model;

/**
 *
 * @author sou
 */
public class Tb_essayModel {
    private Integer id;
    private String essay;
    private Integer  id_matery;
    private Integer  id_level;
    private Integer  id_jenis_soal;
    private Integer  id_category;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEssay() {
        return essay;
    }

    public void setEssay(String essay) {
        this.essay = essay;
    }

    public Integer getId_matery() {
        return id_matery;
    }

    public void setId_matery(Integer id_matery) {
        this.id_matery = id_matery;
    }

    public Integer getId_level() {
        return id_level;
    }

    public void setId_level(Integer id_level) {
        this.id_level = id_level;
    }

    public Integer getId_jenis_soal() {
        return id_jenis_soal;
    }

    public void setId_jenis_soal(Integer id_jenis_soal) {
        this.id_jenis_soal = id_jenis_soal;
    }

    public Integer getId_category() {
        return id_category;
    }

    public void setId_category(Integer id_category) {
        this.id_category = id_category;
    }
    
    
}
