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
public class Tb_resultEssayDto {

    private Integer id;
    private Integer id_user;
    private Integer id_essay;
    private MultipartFile jawaban;
    private Integer nilai;
    private String latihan_ke;
    private Integer id_korektor;
    private String timeupdate;
    private String timeopen;
    private String mahasiswa;
    private String essay;
    private String korektor;
    private String namafile;

    public String getMahasiswa() {
        return mahasiswa;
    }

    public void setMahasiswa(String mahasiswa) {
        this.mahasiswa = mahasiswa;
    }

    public String getEssay() {
        return essay;
    }

    public void setEssay(String essay) {
        this.essay = essay;
    }

    public String getKorektor() {
        return korektor;
    }

    public void setKorektor(String korektor) {
        this.korektor = korektor;
    }

    public String getNamafile() {
        return namafile;
    }

    public void setNamafile(String namafile) {
        this.namafile = namafile;
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

    public MultipartFile getJawaban() {
        return jawaban;
    }

    public void setJawaban(MultipartFile jawaban) {
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

    public String getTimeopen() {
        return timeopen;
    }

    public void setTimeopen(String timeopen) {
        this.timeopen = timeopen;
    }

}
