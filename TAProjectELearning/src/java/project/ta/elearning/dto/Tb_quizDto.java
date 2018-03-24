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
public class Tb_quizDto {
    private Integer id;
    private String name;
    private Integer timeopen;
    private Integer timeclose;
    private Integer timelimit;
    private Integer timecreated;
    private Integer timemodified;
    private Integer id_matery;
    private Integer id_category;
    private String answer;
    private String id_status; 
    private Integer id_jenis_soal;
    private Integer id_answer;
    private String nama;
    private String soal;
    private String jenis_soal;
    private String benar_salah;
    private String jawaban;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getSoal() {
        return soal;
    }

    public void setSoal(String soal) {
        this.soal = soal;
    }

    public String getJenis_soal() {
        return jenis_soal;
    }

    public void setJenis_soal(String jenis_soal) {
        this.jenis_soal = jenis_soal;
    }

    public String getBenar_salah() {
        return benar_salah;
    }

    public void setBenar_salah(String benar_salah) {
        this.benar_salah = benar_salah;
    }

    public String getJawaban() {
        return jawaban;
    }

    public void setJawaban(String jawaban) {
        this.jawaban = jawaban;
    }

    public Integer getId_answer() {
        return id_answer;
    }

    public void setId_answer(Integer id_answer) {
        this.id_answer = id_answer;
    }

    public Integer getId_jenis_soal() {
        return id_jenis_soal;
    }

    public void setId_jenis_soal(Integer id_jenis_soal) {
        this.id_jenis_soal = id_jenis_soal;
    }

    public String getId_status() {
        return id_status;
    }

    public void setId_status(String id_status) {
        this.id_status = id_status;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTimeopen() {
        return timeopen;
    }

    public void setTimeopen(Integer timeopen) {
        this.timeopen = timeopen;
    }

    public Integer getTimeclose() {
        return timeclose;
    }

    public void setTimeclose(Integer timeclose) {
        this.timeclose = timeclose;
    }

    public Integer getTimelimit() {
        return timelimit;
    }

    public void setTimelimit(Integer timelimit) {
        this.timelimit = timelimit;
    }

    public Integer getTimecreated() {
        return timecreated;
    }

    public void setTimecreated(Integer timecreated) {
        this.timecreated = timecreated;
    }

    public Integer getTimemodified() {
        return timemodified;
    }

    public void setTimemodified(Integer timemodified) {
        this.timemodified = timemodified;
    }

    public Integer getId_matery() {
        return id_matery;
    }

    public void setId_matery(Integer id_matery) {
        this.id_matery = id_matery;
    }

    public Integer getId_category() {
        return id_category;
    }

    public void setId_category(Integer id_category) {
        this.id_category = id_category;
    }
}
