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
public class Tb_qaDto {

    private Integer id;
    private String id_quiz;
    private String id_answers;
    private String id_status;
    private String id_level;
    private String timeopen;
    private String timeclose;
    private String timecreated;
    private String timemodified;
    private String id_jenis_soal;
    private String id_jenisSoal;

    public String getId_jenisSoal() {
        return id_jenisSoal;
    }

    public void setId_jenisSoal(String id_jenisSoal) {
        this.id_jenisSoal = id_jenisSoal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getId_quiz() {
        return id_quiz;
    }

    public void setId_quiz(String id_quiz) {
        this.id_quiz = id_quiz;
    }

    public String getId_answers() {
        return id_answers;
    }

    public void setId_answers(String id_answers) {
        this.id_answers = id_answers;
    }

    public String getId_status() {
        return id_status;
    }

    public void setId_status(String id_status) {
        this.id_status = id_status;
    }

    public String getId_level() {
        return id_level;
    }

    public void setId_level(String id_level) {
        this.id_level = id_level;
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

    public String getId_jenis_soal() {
        return id_jenis_soal;
    }

    public void setId_jenis_soal(String id_jenis_soal) {
        this.id_jenis_soal = id_jenis_soal;
    }

}
