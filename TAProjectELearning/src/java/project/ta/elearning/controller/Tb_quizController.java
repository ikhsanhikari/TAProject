/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ta.elearning.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import project.ta.elearning.dto.Tb_qaDto;
import project.ta.elearning.dto.Tb_quizDto;
import project.ta.elearning.dto.Tb_resultExerciseDto;
import project.ta.elearning.dto.Tb_resultQuizDto;
import project.ta.elearning.dto.Tb_sessionDto;
import project.ta.elearning.dto.Tb_userDto;
import project.ta.elearning.service.Tb_quizService;
import project.ta.elearning.service.Tb_userService;

/**
 *
 * @author Sou
 */
@Controller
public class Tb_quizController {

    @Autowired
    Tb_quizService tb_quizService;

    @Autowired
    Tb_userService tb_userService;

    List<HashMap> listSoalQuiz = new ArrayList<>();
    int sudahMasuk = 0;
    int noSoal = 1;
    int jumlahBenar = 0;
    Tb_resultQuizDto rqDto = new Tb_resultQuizDto();

    @RequestMapping(value = "/form_tambah_quiz", method = RequestMethod.GET)
    public String formTambahQuiz(ModelMap map, Tb_quizDto quizDto, HttpSession session, Tb_userDto userDto) {
        map.addAttribute("loginDto", userDto);
        try {
            if (session.getAttribute("username") == null) {
                return "login";
            } else {
                int role = Integer.parseInt(session.getAttribute("role").toString());
                if (role != 3) {
                    return "login";
                } else {
                    map.addAttribute("quizDto", quizDto);
                    return "admin/quiz/form_tambah_quiz";
                }

            }
        } catch (Exception e) {
            return "login";
        }
    }

    @RequestMapping(value = "/form_ubah_quiz", method = RequestMethod.GET)
    public String formUbahQuiz(ModelMap map, Tb_quizDto quizDto, Integer id, HttpSession session, Tb_userDto userDto) {
        quizDto = tb_quizService.getDataById(id);
        map.addAttribute("loginDto", userDto);
        try {
            if (session.getAttribute("username") == null) {
                return "login";
            } else {
                int role = Integer.parseInt(session.getAttribute("role").toString());
                if (role != 3) {
                    return "login";
                } else {
                    map.addAttribute("quizDto", quizDto);
                    return "admin/quiz/form_ubah_quiz";
                }

            }
        } catch (Exception e) {
            return "login";
        }

    }

    @RequestMapping(value = "/save_quiz", method = RequestMethod.POST)
    public String saveQuiz(Tb_quizDto quizDto) {
        tb_quizService.saveData(quizDto);
        return "redirect:view_quiz.htm";
    }

    @RequestMapping(value = "/update_quiz", method = RequestMethod.POST)
    public String ubahQuiz(Tb_quizDto quizDto) {
        tb_quizService.updateData(quizDto);
        return "redirect:view_quiz.htm";
    }
    int idx = 0;
    Integer id_quiz;
    Integer jenis_soal;
    String jawaban_benar;
    Integer id_qa;
    Integer id_matery;
    Integer id_category;
    String jawaban_di_pilih;
    Integer jumlah_exercise = 0;
    Integer exercise_salah = 0;
    Integer exercise_benar = 0;

    public String getJawaban_di_pilih() {
        return jawaban_di_pilih;
    }

    public void setJawaban_di_pilih(String jawaban_di_pilih) {
        this.jawaban_di_pilih = jawaban_di_pilih;
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

    public Integer getId_qa() {
        return id_qa;
    }

    public void setId_qa(Integer id_qa) {
        this.id_qa = id_qa;
    }

    public String getJawaban_benar() {
        return jawaban_benar;
    }

    public void setJawaban_benar(String jawaban_benar) {
        this.jawaban_benar = jawaban_benar;
    }

    public Integer getJenis_soal() {
        return jenis_soal;
    }

    public void setJenis_soal(Integer jenis_soal) {
        this.jenis_soal = jenis_soal;
    }

    public Integer getId_quiz() {
        return id_quiz;
    }

    public void setId_quiz(Integer id_quiz) {
        this.id_quiz = id_quiz;
    }

    @RequestMapping(value = "/view_quiz", method = RequestMethod.GET)
    public String viewQuiz(@RequestParam int idMateri, @RequestParam int idLevel, Tb_quizDto quizDto, ModelMap map, HttpSession session, Tb_userDto userDto, Tb_resultExerciseDto reDto) {
        System.out.println("Cek @RequestParam viewQuiz...\nidLevel : " + idLevel);
        
        List<Tb_quizDto> listQuizRandomByLevel = tb_quizService.getQuizRandomByLevel(idLevel, idMateri,Integer.parseInt(session.getAttribute("iduser").toString()));

        setId_quiz(listQuizRandomByLevel.get(0).getId());

        List<Tb_quizDto> listJawabanBenar = tb_quizService.getJawabanBenar(getId_quiz());

        setJenis_soal(listQuizRandomByLevel.get(0).getId_jenis_soal());

        setJawaban_benar(listJawabanBenar.get(0).getAnswer());

        setId_qa(listQuizRandomByLevel.get(0).getId_qa());

        setId_matery(listQuizRandomByLevel.get(0).getId_matery());

        setId_category(listQuizRandomByLevel.get(0).getId_category());

        List<Tb_quizDto> listAnswer = tb_quizService.getAnswerAllByQuiz(listQuizRandomByLevel.get(0).getId());
        reDto.setId_collerger(Integer.parseInt(session.getAttribute("iduser").toString()));
        map.addAttribute("listQuiz", listQuizRandomByLevel);
        map.addAttribute("reDto", reDto);
        idx++;
        map.addAttribute("idx", idx);
        int stat = 0;
        if (listAnswer.size() > 1) {
            map.addAttribute("listAnswer", listAnswer);
            stat = 1;
        }
        map.addAttribute("stat", stat);

//        Setting button disabled/enabled
        int idKnowledge = tb_userService.getDataKnowledge(session.getAttribute("username").toString());
        System.out.println("Checking inside viewQuiz for Disabled Setting, idKnowledge is " + idKnowledge);
        String knowledge = "";
        String nilaiDisabledLow = "true";
        String nilaiDisabledMedium = "true";
        String nilaiDisabledHigh = "true";
        switch (idKnowledge) {
            case 0:
                knowledge = "none";
                nilaiDisabledLow = "false";
                break;
            case 1:
                knowledge = "poor";
                nilaiDisabledLow = "false";
                break;
            case 2:
                knowledge = "fair";
                nilaiDisabledLow = "false";
                nilaiDisabledMedium = "false";
                break;
            case 3:
                knowledge = "good";
                nilaiDisabledLow = "false";
                nilaiDisabledMedium = "false";
                nilaiDisabledHigh = "false";
                break;
        }
        System.out.println("poor " + nilaiDisabledLow + "\nfair " + nilaiDisabledMedium + "\ngood " + nilaiDisabledHigh);
        map.addAttribute("nilaiDisabledLow", nilaiDisabledLow);
        map.addAttribute("nilaiDisabledMedium", nilaiDisabledMedium);
        map.addAttribute("nilaiDisabledHigh", nilaiDisabledHigh);
        map.addAttribute("idKnowledge", idKnowledge);

        String level = "";
        level = (idLevel == 1 ? "Low" : idLevel == 2 ? "Medium" : idLevel == 3 ? "High" : "");
        map.addAttribute("idLevel", idLevel);
        map.addAttribute("level", level);

        int totalSoalByLevelAndMatery = tb_quizService.getTotalSoalByLevelAndMatery(idLevel, idMateri);
        map.addAttribute("totalSoalByLevelAndMatery", totalSoalByLevelAndMatery);

        String materi = "";
        if (idMateri == 1) {
            materi = "Sekuensial";
        } else if (idMateri == 2) {
            materi = "Kondisional";
        } else if (idMateri == 3) {
            materi = "Perulangan";
        }
        map.addAttribute("idMateri", idMateri);
        map.addAttribute("materi", materi);

        return "mahasiswa/view_quiz";
    }

    @RequestMapping(value = "/onsubmit", method = RequestMethod.GET)
    public String onSubmitQuiz(@RequestParam int idMateri, @RequestParam int idLevel, Tb_quizDto quizDto, ModelMap map, HttpSession session, Tb_userDto userDto, Tb_resultExerciseDto reDto) {
        jumlah_exercise++;
        System.out.println("Cek @RequestParam viewQuiz...\nidLevel : " + idLevel);
        List<Tb_quizDto> listQuizRandomByLevel = tb_quizService.getQuizRandomByLevelAndidQuiz(idLevel, getId_quiz());
        map.addAttribute("jawaban_benar", getJawaban_benar());
        List<Tb_quizDto> listAnswer = tb_quizService.getAnswerAllByQuiz(listQuizRandomByLevel.get(0).getId());
        reDto.setId_collerger(Integer.parseInt(session.getAttribute("iduser").toString()));
        map.addAttribute("listQuiz", listQuizRandomByLevel);
        map.addAttribute("reDto", reDto);
        idx++;
        map.addAttribute("idx", idx);
        int stat = 0;
        if (listAnswer.size() > 1) {
            map.addAttribute("listAnswer", listAnswer);
            stat = 1;
        }
        map.addAttribute("stat", stat);
        int idKnowledge = tb_userService.getDataKnowledge(session.getAttribute("username").toString());
        System.out.println("Checking inside viewQuiz for Disabled Setting, idKnowledge is " + idKnowledge);
        String knowledge = "";
        String nilaiDisabledLow = "true";
        String nilaiDisabledMedium = "true";
        String nilaiDisabledHigh = "true";
        switch (idKnowledge) {
            case 0:
                knowledge = "none";
                nilaiDisabledLow = "false";
                break;
            case 1:
                knowledge = "poor";
                nilaiDisabledLow = "false";
                break;
            case 2:
                knowledge = "fair";
                nilaiDisabledLow = "false";
                nilaiDisabledMedium = "false";
                break;
            case 3:
                knowledge = "good";
                nilaiDisabledLow = "false";
                nilaiDisabledMedium = "false";
                nilaiDisabledHigh = "false";
                break;
        }
        System.out.println("poor " + nilaiDisabledLow + "\nfair " + nilaiDisabledMedium + "\ngood " + nilaiDisabledHigh);
        map.addAttribute("nilaiDisabledLow", nilaiDisabledLow);
        map.addAttribute("nilaiDisabledMedium", nilaiDisabledMedium);
        map.addAttribute("nilaiDisabledHigh", nilaiDisabledHigh);
        map.addAttribute("idKnowledge", idKnowledge);

        String level = "";
        level = (idLevel == 1 ? "Low" : idLevel == 2 ? "Medium" : idLevel == 3 ? "High" : "");
        map.addAttribute("idLevel", idLevel);
        map.addAttribute("level", level);

        int totalSoalByLevelAndMatery = tb_quizService.getTotalSoalByLevelAndMatery(idLevel, idMateri);
        map.addAttribute("totalSoalByLevelAndMatery", totalSoalByLevelAndMatery);

        System.out.println("Jenis Soal " + getJenis_soal());
        System.out.println("Id Qa " + getId_qa());
        System.out.println("======================== id_quiz " + getId_quiz() + "= = = = id_answer " + reDto.getId_answer() + " ".trim());

        System.out.println("Jenis Soal " + getJenis_soal());

        if (getJenis_soal() == 1) {
            reDto.getShort_answer().replaceAll("\\s+", " ");
            reDto.getShort_answer().replaceAll(" ", "");
            if (getJawaban_benar().equals(reDto.getShort_answer())) {
                System.out.println("Masuk sama = " + getJawaban_benar() + " ==" + reDto.getShort_answer());
                reDto.setId_qa(getId_qa());
                reDto.setStatus(1);
            } else {
                System.out.println("Masuk beda = " + getId_qa());
                reDto.setId_qa(getId_qa());
                reDto.setStatus(0);
            }
            System.out.println("jawaban kang field e " + reDto.getShort_answer());
        } else {
            List<Tb_quizDto> listStatus = tb_quizService.getStatus(getId_quiz(), reDto.getId_answer());
            System.out.println("=====+ id qa " + listStatus.get(0).getId());
            System.out.println("=====+ Status " + listStatus.get(0).getId_status());

            reDto.setId_qa(listStatus.get(0).getId());
            reDto.setStatus(listStatus.get(0).getId_status());
        }
        map.addAttribute("status", reDto.getStatus());
        reDto.setId_matery(getId_matery());
        tb_quizService.saveData(reDto);
        map.addAttribute("jawaban_di_pilih", reDto.getShort_answer());

        String materi = "";
        if (idMateri == 1) {
            materi = "Sekuensial";
        } else if (idMateri == 2) {
            materi = "Kondisional";
        } else if (idMateri == 3) {
            materi = "Perulangan";
        }
        map.addAttribute("idMateri", idMateri);
        map.addAttribute("materi", materi);
        if (reDto.getStatus() == 1) {
            exercise_benar++;
        } else {
            exercise_salah++;
        }

        return "mahasiswa/onsubmit";
    }

    @RequestMapping(value = "/random_quiz", method = RequestMethod.GET)
    public String randomQuiz(@RequestParam int idLevel, ModelMap map, Tb_resultExerciseDto reDto) {
        System.out.println("Cek @RequestParam randomQuiz...\nidLevel : " + idLevel);
        map.addAttribute("reDto", reDto);
        System.out.println("======================== id_quiz " + getId_quiz() + "= = = = id_answer " + reDto.getId_answer() + " ".trim());
        System.out.println("jenis soal : " + getJenis_soal() + " = " + getJawaban_benar());
        if (getJenis_soal() == 1) {
            reDto.getShort_answer().replaceAll("\\s+", " ");
            reDto.getShort_answer().replaceAll(" ", "");
            if (getJawaban_benar().equals(reDto.getShort_answer())) {
                System.out.println("Masuk sama = " + getJawaban_benar() + " ==" + reDto.getShort_answer());
                reDto.setId_qa(getId_qa());
                reDto.setStatus(1);
            } else {
                System.out.println("Masuk beda = " + getId_qa());
                reDto.setId_qa(getId_qa());
                reDto.setStatus(0);
            }
            System.out.println("jawaban kang field e " + reDto.getShort_answer());
        } else {
            List<Tb_quizDto> listStatus = tb_quizService.getStatus(getId_quiz(), reDto.getId_answer());
            reDto.setId_qa(listStatus.get(0).getId());
            reDto.setStatus(listStatus.get(0).getId_status());
        }
        reDto.setId_matery(getId_matery());
        tb_quizService.saveData(reDto);

        return "redirect:view_quiz.htm?idLevel=" + idLevel;
    }

    @RequestMapping(value = "/delete_quiz", method = RequestMethod.GET)
    public String deleteQuiz(Integer id) {
        tb_quizService.deleteData(id);
        return "redirect:view_quiz.htm";
    }

    @RequestMapping(value = "/view_historis", method = RequestMethod.GET)
    public String historis(ModelMap model, HttpSession session) {
        List<Tb_quizDto> listHistoris = tb_quizService.getDataHistoris(Integer.parseInt(session.getAttribute("iduser").toString()));
        Tb_resultQuizDto quizDto = new Tb_resultQuizDto();
        quizDto.setId_matery(getId_matery());
        quizDto.setId_category(getId_category());
        quizDto.setId_colleger(Integer.parseInt(session.getAttribute("iduser").toString()));
        Integer score = tb_quizService.getTotalPoin(Integer.parseInt(session.getAttribute("iduser").toString()));
        quizDto.setScore(tb_quizService.getTotalPoin(Integer.parseInt(session.getAttribute("iduser").toString())));
        if (score < 30) {
            quizDto.setIdknowledge(1);
        } else if (score >= 30 && score < 60) {
            quizDto.setIdknowledge(2);
        } else if (score >= 60) {
            quizDto.setIdknowledge(3);
        }
        tb_quizService.saveData(quizDto);
        model.addAttribute("listHistoris", listHistoris);
        return "mahasiswa/historis_exercise";
    }

    @RequestMapping(value = "/pra_exercise", method = RequestMethod.GET)
    public String praExercise(@RequestParam int idMateri, ModelMap modelMap, HttpSession session) {
//        Setting button disabled/enabled
        int idKnowledge = tb_userService.getDataKnowledge(session.getAttribute("username").toString());
        System.out.println("Checking inside praExercise for Disabled Setting, idKnowledge is " + idKnowledge);
        String knowledge = "";
        String nilaiDisabledLow = "true";
        String nilaiDisabledMedium = "true";
        String nilaiDisabledHigh = "true";
        switch (idKnowledge) {
            case 0:
                knowledge = "none";
                nilaiDisabledLow = "false";
                break;
            case 1:
                knowledge = "poor";
                nilaiDisabledLow = "false";
                break;
            case 2:
                knowledge = "fair";
                nilaiDisabledLow = "false";
                nilaiDisabledMedium = "false";
                break;
            case 3:
                knowledge = "good";
                nilaiDisabledLow = "false";
                nilaiDisabledMedium = "false";
                nilaiDisabledHigh = "false";
                break;
        }
        System.out.println("poor " + nilaiDisabledLow + "\nfair " + nilaiDisabledMedium + "\ngood " + nilaiDisabledHigh);
        modelMap.addAttribute("nilaiDisabledLow", nilaiDisabledLow);
        modelMap.addAttribute("nilaiDisabledMedium", nilaiDisabledMedium);
        modelMap.addAttribute("nilaiDisabledHigh", nilaiDisabledHigh);

        String materi = "";
        if (idMateri == 1) {
            materi = "Sekuensial";
        } else if (idMateri == 2) {
            materi = "Kondisional";
        } else if (idMateri == 3) {
            materi = "Perulangan";
        }
        modelMap.addAttribute("idMateri", idMateri);
        modelMap.addAttribute("materi", materi);
//        modelMap.addAttribute("idKnowledge", idKnowledge);

        return "mahasiswa/pra_exercise";
    }

//    Awal kode untuk MENU QUIZ
    @RequestMapping(value = "quiz", method = RequestMethod.GET)
    public String menuQuiz(@RequestParam String action, @RequestParam int noSoalParam, @RequestParam int statusMasuk, Tb_quizDto quizDto, ModelMap map, HttpSession session, Tb_userDto userDto, Tb_resultExerciseDto reDto) {
        System.out.println("Nilai statusMasuk : " + statusMasuk);
        int jumlahSoalPerLevel = 3;

        if (statusMasuk == 1 && sudahMasuk == 0) {
            listSoalQuiz = tb_quizService.getSoalQuiz(jumlahSoalPerLevel);
            sudahMasuk++;
        }
        List<HashMap> listSoalQuizTetap = listSoalQuiz;

        if (noSoalParam == (jumlahSoalPerLevel * 3)) {
            System.out.println("jumlahBenar = " + jumlahBenar);
            float presentaseBenar = (float) jumlahBenar / (jumlahSoalPerLevel * 3);
            int presentase = Math.round(presentaseBenar * 100);
            System.out.println("presentaseBenar : " + presentaseBenar + "\n" + presentase + "%");
            rqDto.setScore(presentase);
            tb_quizService.saveDataScore(rqDto);
            map.addAttribute("username", session.getAttribute("username").toString());
            map.addAttribute("score", presentase);

            return "mahasiswa/post_quiz";
        }

        List<HashMap> tampList = new ArrayList<>();
        HashMap tampHashMap = new HashMap();

        if (action.equals("Next")) {
            doSave(reDto);
            noSoalParam++;
        } else if (action.equals("Previous")) {
            noSoalParam--;
        }
        noSoal = noSoalParam - 1;
        tampHashMap.put("no", listSoalQuizTetap.get(noSoal).get("no"));
        tampHashMap.put("id", listSoalQuizTetap.get(noSoal).get("id"));
        tampHashMap.put("name", listSoalQuizTetap.get(noSoal).get("name"));
        tampHashMap.put("id_jenis_soal", listSoalQuizTetap.get(noSoal).get("id_jenis_soal"));
        tampHashMap.put("id_level", listSoalQuizTetap.get(noSoal).get("id_level"));
        tampHashMap.put("id_qa", listSoalQuizTetap.get(noSoal).get("id_qa"));
        tampHashMap.put("id_category", listSoalQuizTetap.get(noSoal).get("id_category"));
        tampHashMap.put("id_matery", listSoalQuizTetap.get(noSoal).get("id_matery"));
        tampList.add(tampHashMap);

        setId_quiz((int) tampList.get(0).get("id"));

        List<Tb_quizDto> listJawabanBenar = tb_quizService.getJawabanBenar(getId_quiz());
        setJenis_soal((int) tampList.get(0).get("id_jenis_soal"));
        setJawaban_benar(listJawabanBenar.get(0).getAnswer());
        setId_category((int) tampList.get(0).get("id_level"));
        setId_qa((int) tampList.get(0).get("id_qa"));
        setId_matery((int) tampList.get(0).get("id_category"));
        setId_category((int) tampList.get(0).get("id_matery"));

        rqDto.setId_colleger(Integer.parseInt(session.getAttribute("iduser").toString()));
        rqDto.setId_matery((int) tampList.get(0).get("id_matery"));
        int idKnowledge = tb_userService.getDataKnowledge(session.getAttribute("username").toString());
        rqDto.setIdknowledge(idKnowledge);
        rqDto.setId_category((int) tampList.get(0).get("id_category"));

        List<Tb_quizDto> listAnswer = tb_quizService.getAnswerAllByQuiz((int) tampList.get(0).get("id"));
        reDto.setId_collerger(Integer.parseInt(session.getAttribute("iduser").toString()));
        map.addAttribute("listQuiz", tampList);
        map.addAttribute("reDto", reDto);
        idx++;
        map.addAttribute("idx", idx);
        int stat = 0;
        if (listAnswer.size() > 1) {
            map.addAttribute("listAnswer", listAnswer);
            stat = 1;
        }
        map.addAttribute("stat", stat);
        map.addAttribute("no", listSoalQuizTetap.get(noSoal).get("no"));
        map.addAttribute("id", listSoalQuizTetap.get(noSoal).get("id"));
        map.addAttribute("name", listSoalQuizTetap.get(noSoal).get("name"));
        map.addAttribute("id_jenis_soal", listSoalQuizTetap.get(noSoal).get("id_jenis_soal"));
        String level = "";
        if ((int) listSoalQuizTetap.get(noSoal).get("id_level") == 1) {
            level = "Low";
        } else if ((int) listSoalQuizTetap.get(noSoal).get("id_level") == 2) {
            level = "Medium";
        } else if ((int) listSoalQuizTetap.get(noSoal).get("id_level") == 3) {
            level = "High";
        }
        map.addAttribute("level", level);

//        if(noSoal==1){
//            System.out.println("masuk disabled previous");
//            map.addAttribute("nilaiDisabledPrevious", "true");
//        }
//        if(noSoal==9){
//            System.out.println("masuk disabled next");
//            map.addAttribute("nilaiDisabledNext", "true");
//        }
        return "mahasiswa/quiz";
    }

    public void doSave(Tb_resultExerciseDto reDto) {
        if (getJenis_soal() == 1) {
            if (getJawaban_benar().equals(reDto.getShort_answer())) {
                System.out.println("Masuk sama = " + getJawaban_benar() + " ==" + reDto.getShort_answer());
                reDto.setId_qa(getId_qa());
                reDto.setStatus(1);
            } else {
                System.out.println("Masuk beda = " + getId_qa());
                reDto.setId_qa(getId_qa());
                reDto.setStatus(0);
            }
            System.out.println("jawaban kang field e " + reDto.getShort_answer());
        } else {
            System.out.println("status 0129111111111111111111111310\n" + getId_quiz() + " " + reDto.getId_answer());
            List<Tb_quizDto> listStatus = tb_quizService.getStatus(getId_quiz(), reDto.getId_answer());
            reDto.setId_qa(listStatus.get(0).getId());
            reDto.setStatus(listStatus.get(0).getId_status());
        }
        if (reDto.getStatus() == 1) {
            jumlahBenar++;
        }
        System.out.println("77777777777777777777777777777\nJumlah Benar = " + jumlahBenar);

        reDto.setId_matery(getId_matery());
        tb_quizService.saveData(reDto);
    }

    public void doSaveScore() {

    }

//    Melihat informasi exercise
    @RequestMapping(value = "/view_informaion_of_exercise", method = RequestMethod.GET)
    public String informationOfEcxercise(ModelMap model, HttpSession session) {
        model.addAttribute("exercise_salah", exercise_salah);
        model.addAttribute("exercise_benar", exercise_benar);
        model.addAttribute("jumlah_e", jumlah_exercise);
        float presentaseBenar = (float) exercise_benar / (jumlah_exercise);
        int presentase = Math.round(presentaseBenar * 100);
        System.out.println("presentaseBenar : " + presentaseBenar + "\n" + presentase + "%");
        model.addAttribute("presentase_exercise", presentase);
//        Tb_resultQuizDto quizDto = new Tb_resultQuizDto();
//        quizDto.setId_matery(getId_matery());
//        quizDto.setId_category(getId_category());
//        quizDto.setId_colleger(Integer.parseInt(session.getAttribute("iduser").toString()));
//        Integer score = tb_quizService.getTotalPoin(Integer.parseInt(session.getAttribute("iduser").toString()));
//        quizDto.setScore(tb_quizService.getTotalPoin(Integer.parseInt(session.getAttribute("iduser").toString())));
//        if (score < 30) {
//            quizDto.setIdknowledge(3);
//        } else if (score >= 30 && score < 60) {
//            quizDto.setIdknowledge(2);
//        } else if (score >= 60) {
//            quizDto.setIdknowledge(1);
//        }
//        tb_quizService.saveData(quizDto);
//        List<Tb_resultQuizDto> listHistoris = tb_quizService.getInformationOfExercise(Integer.parseInt(session.getAttribute("iduser").toString()));
//        model.addAttribute("listInformationOfexercise", listHistoris);
        noSoal++;
        return "mahasiswa/information_of_exercise";
    }

    public static String allTrim(String str) {
        int j = 0;
        int count = 0;  // Number of extra spaces
        int lspaces = 0;// Number of left spaces
        char ch[] = str.toCharArray();
        int len = str.length();
        StringBuffer bchar = new StringBuffer();
        if (ch[0] == ' ') {
            while (ch[j] == ' ') {
                lspaces++;
                j++;
            }
        }
        for (int i = lspaces; i < len; i++) {
            if (ch[i] != ' ') {
                if (count > 1 || count == 1) {
                    bchar.append(' ');
                    count = 0;
                }
                bchar.append(ch[i]);
            } else if (ch[i] == ' ') {
                count++;
            }
        }
        return bchar.toString();
    }

    @RequestMapping(value = "/halamanAwal", method = RequestMethod.GET)
    public String halamanAwalMahasiswa() {
        jumlahBenar = 0;
        jumlah_exercise = 0;
        exercise_benar = 0;
        exercise_salah = 0;
        return "mahasiswa/index";
    }

    

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String halamanProfil(Tb_quizDto quizDto, ModelMap map, HttpSession session, Tb_userDto userDto, Tb_resultExerciseDto reDto) {
        Tb_userDto listUser = tb_userService.getDataById(Integer.parseInt(session.getAttribute("iduser").toString()));
        System.out.println("=====+++" + listUser);
        map.addAttribute("listUser", listUser);
        return "mahasiswa/halamanProfil";
    }

    @RequestMapping(value = "/pilihan_materi", method = RequestMethod.GET)
    public String halamanPilihanMateri(ModelMap map) {
        int statusMateri = 3;
        String nilaiDisabledSekuensial = "false"; // true = disabled, false = enabled
        String nilaiDisabledKondisional = "false";
        String nilaiDisabledPerulangan = "false";
        switch (statusMateri) {
            case 1:
                nilaiDisabledKondisional = "true";
                nilaiDisabledPerulangan = "true";
                break;
            case 2:
                nilaiDisabledPerulangan = "true";
                break;
            case 3:
                // Tidak melakukan apapun karena semua tombol enabled.
                break;
        }
        map.addAttribute("nilaiDisabledSekuensial", nilaiDisabledSekuensial);
        map.addAttribute("nilaiDisabledKondisional", nilaiDisabledKondisional);
        map.addAttribute("nilaiDisabledPerulangan", nilaiDisabledPerulangan);

        return "mahasiswa/pilihan_materi";
    }
    
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logOut(HttpSession session,Tb_userDto userDto,ModelMap map){
        jumlahBenar = 0;
        jumlah_exercise = 0;
        exercise_benar = 0;
        exercise_salah = 0;
        if(session!=null){
            session.invalidate();
        }
        map.addAttribute("loginDto", userDto);
        return "login";
    }

}
