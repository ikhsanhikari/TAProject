/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ta.elearning.dto;

import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Sou
 */
public class Tb_resultExerciseDto {
    private Integer id;
    private Integer id_collerger;
    private Integer id_matery;
    private Integer id_qa;
    private Integer status;
    private String timeopen;
    private String timeclose;
    private String timecreated;
    private String timemodified;
    private String short_answer;
    private String jawaban_benar;
    private Integer id_answer;
    private Integer poin;
    private MultipartFile jawaban;
    private Integer id_categoory;

    public MultipartFile getJawaban() {
        return jawaban;
    }

    public Integer getId_categoory() {
        return id_categoory;
    }

    public void setId_categoory(Integer id_categoory) {
        this.id_categoory = id_categoory;
    }

    public void setJawaban(MultipartFile jawaban) {
        this.jawaban = jawaban;
    }

    public Integer getPoin() {
        return poin;
    }

    public void setPoin(Integer poin) {
        this.poin = poin;
    }

    public String getJawaban_benar() {
        return jawaban_benar;
    }

    public Integer getId_answer() {
        return id_answer;
    }

    public void setId_answer(Integer id_answer) {
        this.id_answer = id_answer;
    }

    public void setJawaban_benar(String jawaban_benar) {
        this.jawaban_benar = jawaban_benar;
    }

    public String getShort_answer() {
        return short_answer;
    }

    public void setShort_answer(String short_answer) {
        this.short_answer = short_answer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_collerger() {
        return id_collerger;
    }

    public void setId_collerger(Integer id_collerger) {
        this.id_collerger = id_collerger;
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

}
