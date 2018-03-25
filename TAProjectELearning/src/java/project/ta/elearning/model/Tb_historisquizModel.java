/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ta.elearning.model;

/**
 *
 * @author Sou
 */
public class Tb_historisquizModel {
    private Integer id;
    private Integer id_colleger;
    private Integer id_matery;
    private Integer id_qa;
    private Integer status;
    private String timeupdate;

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

    public Integer getId_qa() {
        return id_qa;
    }

    public void setId_qa(Integer id_qa) {
        this.id_qa = id_qa;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTimeupdate() {
        return timeupdate;
    }

    public void setTimeupdate(String timeupdate) {
        this.timeupdate = timeupdate;
    }
    

}
