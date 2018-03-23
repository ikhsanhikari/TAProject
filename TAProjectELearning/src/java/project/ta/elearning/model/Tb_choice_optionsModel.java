/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ta.elearning.model;

/**
 *
 * @author premium
 */
public class Tb_choice_optionsModel {
    private Integer id,userid;
    private String text;
    private Integer maxanswer;
    private String timemodified;
    private String timecreated;

    public Integer getMaxanswer() {
        return maxanswer;
    }

    public void setMaxanswer(Integer maxanswer) {
        this.maxanswer = maxanswer;
    }

    public String getTimecreated() {
        return timecreated;
    }

    public void setTimecreated(String timecreated) {
        this.timecreated = timecreated;
    }

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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    public String getTimemodified() {
        return timemodified;
    }

    public void setTimemodified(String timemodified) {
        this.timemodified = timemodified;
    }
}
