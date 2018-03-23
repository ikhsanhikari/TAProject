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
public class Tb_valueModel {
    private Integer id;
    private Integer userid;
    private Double mid_value;
    private Double final_value;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Double getMid_value() {
        return mid_value;
    }

    public void setMid_value(Double mid_value) {
        this.mid_value = mid_value;
    }

    public Double getFinal_value() {
        return final_value;
    }

    public void setFinal_value(Double final_value) {
        this.final_value = final_value;
    }

}
