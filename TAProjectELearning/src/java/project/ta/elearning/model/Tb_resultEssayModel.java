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
public class Tb_resultEssayModel {

    private Integer id;
    private Integer id_user;
    private Integer id_essay;
    private String jawaban;
    private Integer nilai;
    private String latihan_ke;
    private Integer id_korektor;
    private String timeupdate;
    private String timeopen;
    private String pathName;

    public String getPathName() {
        return pathName;
    }

    public void setPathName(String pathName) {
        this.pathName = pathName;
    }

    public String getTimeopen() {
        return timeopen;
    }

    public void setTimeopen(String timeopen) {
        this.timeopen = timeopen;
    }
    public Integer getId_korektor() {
        return id_korektor;
    }

    public void setId_korektor(Integer id_korektor) {
        this.id_korektor = id_korektor;
    }

    public String getTimeupdate() {
        return timeupdate;
    }

    public void setTimeupdate(String timeupdate) {
        this.timeupdate = timeupdate;
    }

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

    public Integer getId_essay() {
        return id_essay;
    }

    public void setId_essay(Integer id_essay) {
        this.id_essay = id_essay;
    }

    public String getJawaban() {
        return jawaban;
    }

    public void setJawaban(String jawaban) {
        this.jawaban = jawaban;
    }

    public Integer getNilai() {
        return nilai;
    }

    public void setNilai(Integer nilai) {
        this.nilai = nilai;
    }

    public String getLatihan_ke() {
        return latihan_ke;
    }

    public void setLatihan_ke(String latihan_ke) {
        this.latihan_ke = latihan_ke;
    }
    

}
