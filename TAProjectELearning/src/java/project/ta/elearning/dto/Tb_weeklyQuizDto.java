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
public class Tb_weeklyQuizDto {
    private Integer id;
    private String weekly_quiz;
    private String answer;
    private String timeopen;
    private String timeclose;
    private String timelimit;
    private String timecreated;
    private String timemodified;
    private Integer id_course;
    private Integer id_materi;
    private String cari;

    public String getCari() {
        return cari;
    }

    public void setCari(String cari) {
        this.cari = cari;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWeekly_quiz() {
        return weekly_quiz;
    }

    public void setWeekly_quiz(String weekly_quiz) {
        this.weekly_quiz = weekly_quiz;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getTimeopen() {
        return timeopen;
    }

    public void setTimeopen(String timeopen) {
        this.timeopen = timeopen;
    }

    public String getTimeclose() {
        return timeclose;
    }

    public void setTimeclose(String timeclose) {
        this.timeclose = timeclose;
    }

    public String getTimelimit() {
        return timelimit;
    }

    public void setTimelimit(String timelimit) {
        this.timelimit = timelimit;
    }

    public String getTimecreated() {
        return timecreated;
    }

    public void setTimecreated(String timecreated) {
        this.timecreated = timecreated;
    }

    public String getTimemodified() {
        return timemodified;
    }

    public void setTimemodified(String timemodified) {
        this.timemodified = timemodified;
    }

    public Integer getId_course() {
        return id_course;
    }

    public void setId_course(Integer id_course) {
        this.id_course = id_course;
    }

    public Integer getId_materi() {
        return id_materi;
    }

    public void setId_materi(Integer id_materi) {
        this.id_materi = id_materi;
    }

   

}
