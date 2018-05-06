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
import project.ta.elearning.dto.Tb_modelDto;
import project.ta.elearning.dto.Tb_qaDto;
import project.ta.elearning.dto.Tb_quizDto;
import project.ta.elearning.dto.Tb_resultExerciseDto;
import project.ta.elearning.dto.Tb_resultQuizDto;
import project.ta.elearning.dto.Tb_resultquiz_afterDto;
import project.ta.elearning.dto.Tb_resultquiz_beforeDto;
import project.ta.elearning.dto.Tb_sessionDto;
import project.ta.elearning.dto.Tb_userDto;
import project.ta.elearning.service.Tb_modelService;
import project.ta.elearning.service.Tb_quizService;
import project.ta.elearning.service.Tb_resultEssayService;
import project.ta.elearning.service.Tb_resultquiz_afterService;
import project.ta.elearning.service.Tb_resultquiz_beforeService;
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

    @Autowired
    Tb_resultquiz_afterService tb_resultquiz_afterService;

    @Autowired
    Tb_resultquiz_beforeService tb_resultquiz_beforeService;

    @Autowired
    Tb_modelService tb_modelService;

    @Autowired
    Tb_resultEssayService tb_resultEssayService;

    List<HashMap> listSoalQuiz = new ArrayList<>();
    int sudahMasuk = 0;
    int noSoal = 1;
    int jumlahBenar = 0;
    int jumlahSalah = 0;
    Tb_resultQuizDto rqDto = new Tb_resultQuizDto();

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
    int no = 0;

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
        try {
            List<Tb_quizDto> listQuizRandomByLevel = new ArrayList<>();
            no++;
            if (no % 2 == 1) {
                listQuizRandomByLevel = tb_quizService.getQuizRandomByLevel(idLevel, idMateri, Integer.parseInt(session.getAttribute("iduser").toString()));
            } else if (no % 2 == 0) {
                listQuizRandomByLevel = tb_quizService.getQuizRandomByLevelPG(idLevel, idMateri, Integer.parseInt(session.getAttribute("iduser").toString()));
            } else {
//                listQuizRandomByLevel = tb_quizService.getQuizRandomByLevelEssay(idLevel, idMateri, Integer.parseInt(session.getAttribute("iduser").toString()));
            }

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
            if (listAnswer.size() > 1 && getJenis_soal() != 3) {
                map.addAttribute("listAnswer", listAnswer);
                stat = 1;
            } else if (getJenis_soal() == 3) {
                stat = 2;
            }

            System.out.println("listAnswer and jenis soal : " + listAnswer.size() + " = " + getJenis_soal());
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

//            Rabu, 11-04-2018
            map.addAttribute("knowledge", getKnowledgeUntukMunculSetiapSaat(session));

            return "mahasiswa/view_quiz";
        } catch (Exception e) {
            return "mahasiswa/soalhabis";
        }

    }

    @RequestMapping(value = "/onsubmit", method = RequestMethod.GET)
    public String onSubmitQuiz(@RequestParam int idMateri, @RequestParam int idLevel, Tb_quizDto quizDto, ModelMap map, HttpSession session, Tb_userDto userDto, Tb_resultExerciseDto reDto) {
        try {
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

            if (getJenis_soal() == 1) {
                if (getJawaban_benar().equals(reDto.getShort_answer())) {
                    reDto.setId_qa(getId_qa());
                    reDto.setStatus(1);
                } else {
                    reDto.setId_qa(getId_qa());
                    reDto.setStatus(0);
                }
            } else {
                List<Tb_quizDto> listStatus = tb_quizService.getStatus(getId_quiz(), reDto.getId_answer());
                reDto.setId_qa(listStatus.get(0).getId());
                reDto.setStatus(listStatus.get(0).getId_status());
            }
            map.addAttribute("status", reDto.getStatus());
            reDto.setId_matery(getId_matery());
            reDto.setId_categoory(2);
            System.out.println("jns sl :" + getJenis_soal());
//            if(getJenis_soal() == 3){
//                System.out.println("Masuk Upload");
//                tb_resultEssayService.uploadData(reDto);
//            }else{
            tb_quizService.saveData(reDto);
//            }

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

//            Rabu, 11-04-2018
            map.addAttribute("knowledge", getKnowledgeUntukMunculSetiapSaat(session));

            return "mahasiswa/onsubmit";
        } catch (Exception e) {
            return "mahasiswa/soalhabis";
        }

    }

    @RequestMapping(value = "/random_quiz", method = RequestMethod.GET)
    public String randomQuiz(@RequestParam int idLevel, ModelMap map, Tb_resultExerciseDto reDto, HttpSession session) {
        map.addAttribute("reDto", reDto);
        if (getJenis_soal() == 1) {
            if (getJawaban_benar().equals(reDto.getShort_answer())) {
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

//        Rabu, 11-04-2018
        map.addAttribute("knowledge", getKnowledgeUntukMunculSetiapSaat(session));

        return "redirect:view_quiz.htm?idLevel=" + idLevel;
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

//        Rabu, 11-04-2018
        modelMap.addAttribute("knowledge", getKnowledgeUntukMunculSetiapSaat(session));
        return "mahasiswa/pra_exercise";
    }

    @RequestMapping(value = "/quiz", method = RequestMethod.GET)
    public String menuQuiz(@RequestParam String action, @RequestParam int idMateri, @RequestParam int noSoalParam, @RequestParam int statusMasuk, Tb_quizDto quizDto, ModelMap map, HttpSession session, Tb_userDto userDto, Tb_resultExerciseDto reDto) {
        try {
            System.out.println("Nilai statusMasuk : " + statusMasuk);
            int jumlahSoalPerLevel = 3;

            if (statusMasuk == 1 && sudahMasuk == 0) {
                listSoalQuiz = tb_quizService.getSoalQuiz(jumlahSoalPerLevel, idMateri);
                sudahMasuk++;
            }
            List<HashMap> listSoalQuizTetap = listSoalQuiz;

            List<HashMap> tampList = new ArrayList<>();
            HashMap tampHashMap = new HashMap();

            int totalSoal = jumlahSoalPerLevel * 3;
            System.out.println("noSoalParam = " + noSoalParam);
            if (noSoalParam == totalSoal) {
                System.out.println("jumlahBenar = " + jumlahBenar + "\njumlahSalah = " + jumlahSalah);
                float presentaseBenar = (float) ((jumlahBenar * 4) - jumlahSalah) / (totalSoal * 4);
                int score = Math.round(presentaseBenar * 100);
                System.out.println("presentaseBenar : " + presentaseBenar + "\n" + score);
                rqDto.setScore(score);

                int knowledge = 0;
                if (score <= 33) {
                    knowledge = 1;
                } else if (score > 33 && score <= 66) {
                    knowledge = 2;
                } else if (score > 66) {
                    knowledge = 3;
                }
                rqDto.setIdknowledge(knowledge);

                int existAfter = tb_resultquiz_afterService.isDataExistByIdAndMateri(rqDto.getId_colleger(), rqDto.getId_matery());
                if (existAfter == 0) {
                    System.out.println("Data di after tidak ada.");
                    tb_resultquiz_afterService.saveData(rqDto);
                    System.out.println("Berhasil save data di tb_resultquiz_after");
                } else {
                    System.out.println("Data di after ada.");
                    Tb_resultquiz_afterDto afterDto = tb_resultquiz_afterService.getDataById(rqDto.getId_colleger(), rqDto.getId_matery());
                    System.out.println("Isi afterDto = " + afterDto);
                    HashMap dataQuizBefore = new HashMap();
                    dataQuizBefore.put("score", afterDto.getScore());
                    dataQuizBefore.put("idknowledge", afterDto.getIdknowledge());
                    dataQuizBefore.put("id_category", afterDto.getId_category());
                    dataQuizBefore.put("id_colleger", afterDto.getId_colleger());
                    dataQuizBefore.put("id_matery", afterDto.getId_matery());
                    System.out.println("Isi dataQuizBefore = " + dataQuizBefore);
                    int existBefore = tb_resultquiz_beforeService.isDataExistByIdAndMateri(rqDto.getId_colleger(), rqDto.getId_matery());
                    if (existBefore == 0) {
                        System.out.println("Data di before tidak ada.");
                        tb_resultquiz_beforeService.saveData(rqDto);
                        System.out.println("Berhasil save data di tb_resultquiz_before");
                    } else {
                        System.out.println("Data di before ada.");
                        tb_resultquiz_beforeService.update(dataQuizBefore);
                        System.out.println("Berhasil update data di tb_resultquiz_before");
                    }
                    tb_resultquiz_afterService.update(rqDto);
                    System.out.println("Berhasil update data di tb_resultquiz_after");
                }
                System.out.println("Keluar if tb after dan before. Sebelum save score.");
                tb_quizService.saveDataScore(rqDto);
                map.addAttribute("username", session.getAttribute("username").toString());
                map.addAttribute("score", score);

                int idUser = Integer.parseInt(session.getAttribute("iduser").toString());
                Tb_resultquiz_afterDto raDto = tb_resultquiz_afterService.getDataById(idUser, rqDto.getId_matery());
                Tb_resultquiz_beforeDto rbDto = tb_resultquiz_beforeService.getDataById(idUser, rqDto.getId_matery());

                if (raDto.getIdknowledge() > rbDto.getIdknowledge()) { //good learner
                    System.out.println("Good Learner");
                    Tb_modelDto modelDto = new Tb_modelDto();
                    modelDto.setId_user(idUser);
                    modelDto.setId_matery(rqDto.getId_matery());
                    modelDto.setKnowledge_sebelum(rbDto.getIdknowledge());
                    modelDto.setKnowledge_sesudah(raDto.getIdknowledge());
                    modelDto.setScore_sebelum(rbDto.getScore());
                    modelDto.setScore_sesudah(raDto.getScore());
                    tb_modelService.saveData(modelDto);
                } else {
                    System.out.println("Bukan Good Learner");
                }
                return "mahasiswa/post_quiz";
            }

            if (action.equals("Submit")) {
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
            System.out.println("Soal : " + tampList);
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

            System.out.println("Isi :\n");
            System.out.println("id_colleger = " + rqDto.getId_colleger());
            System.out.println("id_matery = " + rqDto.getId_matery());
            System.out.println("score = " + rqDto.getScore());
            System.out.println("category = " + rqDto.getId_category());
            System.out.println("knowledge = " + rqDto.getIdknowledge());

            map.addAttribute("knowledge", getKnowledgeUntukMunculSetiapSaat(session));

            return "mahasiswa/quiz";
        } catch (Exception e) {
            return "mahasiswa/soalhabis";
        }

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
        } else {
            jumlahSalah++;
        }
        reDto.setId_matery(getId_matery());
        reDto.setId_categoory(1);
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
        noSoal++;

//        Rabu, 11-04-2018
        model.addAttribute("knowledge", getKnowledgeUntukMunculSetiapSaat(session));

        return "mahasiswa/information_of_exercise";
    }

    @RequestMapping(value = "/halamanAwal", method = RequestMethod.GET)
    public String halamanAwalMahasiswa(ModelMap model, HttpSession session) {
        jumlahBenar = 0;
        jumlahSalah = 0;
        jumlah_exercise = 0;
        exercise_benar = 0;
        exercise_salah = 0;
        noSoal = 1;

        int idKnowledge = 0;
        idKnowledge = tb_userService.getDataKnowledge(session.getAttribute("username").toString());
        String knowledge = "";
        String ada = "ada";
        switch (idKnowledge) {
            case 0:
                knowledge = "none";
                ada = "belum ada";
                break;
            case 1:
                knowledge = "poor";
                break;
            case 2:
                knowledge = "fair";
                break;
            case 3:
                knowledge = "good";
                break;
        }

//        Rabu, 11-04-2018
        model.addAttribute("knowledge", knowledge);
        model.addAttribute("ada", ada);
        return "mahasiswa/index";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String halamanProfil(Tb_quizDto quizDto, ModelMap map, HttpSession session, Tb_userDto userDto, Tb_resultExerciseDto reDto) {
        Tb_userDto listUser = tb_userService.getDataById(Integer.parseInt(session.getAttribute("iduser").toString()));
        map.addAttribute("listUser", listUser);

        int knowledgeSekuensial = tb_resultquiz_afterService.getKnowledgePerMateri(Integer.parseInt(session.getAttribute("iduser").toString()), 1);
        int knowledgeKondisional = tb_resultquiz_afterService.getKnowledgePerMateri(Integer.parseInt(session.getAttribute("iduser").toString()), 2);
        int knowledgePerulangan = tb_resultquiz_afterService.getKnowledgePerMateri(Integer.parseInt(session.getAttribute("iduser").toString()), 3);

        int knowledgeUmum = 0;
        int scoreSeq = 0, scoreCond = 0, scoreLoop = 0, totalScore = 0;
        Tb_resultquiz_afterDto afterDtoSeq = tb_resultquiz_afterService.getDataById(Integer.parseInt(session.getAttribute("iduser").toString()), 1);
        if (afterDtoSeq.getScore() == null) {
            scoreSeq = 0;
        } else {
            scoreSeq = afterDtoSeq.getScore();
        }
        System.out.println("scoreSeq = " + scoreSeq);
        Tb_resultquiz_afterDto afterDtoCond = tb_resultquiz_afterService.getDataById(Integer.parseInt(session.getAttribute("iduser").toString()), 2);
        if (afterDtoCond.getScore() == null) {
            scoreCond = 0;
        } else {
            scoreCond = afterDtoCond.getScore();
        }
        System.out.println("scoreCond = " + scoreCond);
        Tb_resultquiz_afterDto afterDtoLoop = tb_resultquiz_afterService.getDataById(Integer.parseInt(session.getAttribute("iduser").toString()), 3);
        if (afterDtoLoop.getScore() == null) {
            scoreLoop = 0;
        } else {
            scoreLoop = afterDtoLoop.getScore();
        }
        System.out.println("scoreLoop = " + scoreLoop);
        totalScore = (scoreSeq + scoreCond + scoreLoop) / 3;
        System.out.println("totalScore = " + totalScore);

        if (totalScore <= 33) {
            knowledgeUmum = 1;
        } else if (totalScore > 33 && totalScore <= 66) {
            knowledgeUmum = 2;
        } else if (totalScore > 66 && totalScore <= 100) {
            knowledgeUmum = 3;
        } else {
            // total score tidak valid
        }

        tb_userService.updateKnowledgeUser(session.getAttribute("iduser").toString(), knowledgeUmum);

        String ks = "";
        if (knowledgeSekuensial == 0) {
            ks = "None";
        } else {
            if (knowledgeSekuensial == 1) {
                ks = "Poor";
            } else if (knowledgeSekuensial == 2) {
                ks = "Fair";
            } else if (knowledgeSekuensial == 3) {
                ks = "Good";
            }
        }

        String kk = "";
        if (knowledgeKondisional == 0) {
            kk = "None";
        } else {
            if (knowledgeKondisional == 1) {
                kk = "Poor";
            } else if (knowledgeKondisional == 2) {
                kk = "Fair";
            } else if (knowledgeKondisional == 3) {
                kk = "Good";
            }
        }

        String kp = "";
        if (knowledgePerulangan == 0) {
            kp = "None";
        } else {
            if (knowledgePerulangan == 1) {
                kp = "Poor";
            } else if (knowledgePerulangan == 2) {
                kp = "Fair";
            } else if (knowledgePerulangan == 3) {
                kp = "Good";
            }
        }

        String ku = "";
        if (knowledgeUmum == 0) {
            ku = "None";
        } else {
            if (knowledgeUmum == 1) {
                ku = "Poor";
            } else if (knowledgeUmum == 2) {
                ku = "Fair";
            } else if (knowledgeUmum == 3) {
                ku = "Good";
            }
        }
        System.out.println("ku : " + ku);

        map.addAttribute("knowledgeSekuensial", ks);
        map.addAttribute("knowledgeKondisional", kk);
        map.addAttribute("knowledgePerulangan", kp);
        map.addAttribute("knowledgeUmum", ku);

//        Rabu, 11-04-2018
        map.addAttribute("knowledge", getKnowledgeUntukMunculSetiapSaat(session));

        return "mahasiswa/halamanProfil";
    }

    @RequestMapping(value = "/pilihan_materi", method = RequestMethod.GET)
    public String halamanPilihanMateri(ModelMap map, HttpSession session) {
        int statusMateri = tb_quizService.getStatusMateri();
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

//        Rabu, 11-04-2018
        map.addAttribute("knowledge", getKnowledgeUntukMunculSetiapSaat(session));

        return "mahasiswa/pilihan_materi";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logOut(HttpSession session, Tb_userDto userDto, ModelMap map) {
        jumlahBenar = 0;
        jumlah_exercise = 0;
        exercise_benar = 0;
        exercise_salah = 0;
        sudahMasuk = 0;
        if (session != null) {
            session.invalidate();
        }
        map.addAttribute("loginDto", userDto);
        return "login";
    }

    @RequestMapping(value = "/pilihan_materi_quiz", method = RequestMethod.GET)
    public String halamanPilihanMateriQuiz(ModelMap map, HttpSession session) {
        int statusMateri = tb_quizService.getStatusMateri();
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

//        Rabu, 11-04-2018
        map.addAttribute("knowledge", getKnowledgeUntukMunculSetiapSaat(session));

        return "mahasiswa/pilihan_materi_quiz";
    }

//        Rabu, 11-04-2018
    public String getKnowledgeUntukMunculSetiapSaat(HttpSession session) {
        int idKnowledge = 0;
        idKnowledge = tb_userService.getDataKnowledge(session.getAttribute("username").toString());
        String knowledge = "";
        String ada = "ada";
        switch (idKnowledge) {
            case 0:
                knowledge = "none";
                ada = "belum ada";
                break;
            case 1:
                knowledge = "poor";
                break;
            case 2:
                knowledge = "fair";
                break;
            case 3:
                knowledge = "good";
                break;
        }

        return knowledge;
    }

    public String convertSpas(String arg) {
        String tamp = "";
        for (int i = 0; i < arg.length(); i++) {
            if (arg.charAt(i) == '$') {
                tamp = tamp + "\n";
            } else if (arg.charAt(i) == '@') {
                tamp = tamp + "\t";
            } else {
                tamp = tamp + arg.charAt(i);
            }

        }
        return tamp;
    }

    @ResponseBody
    @RequestMapping(value = "/onsubmit2", method = RequestMethod.GET)
    public String onsubmit2(Tb_resultExerciseDto rdto,@RequestParam int idMateri, @RequestParam int idLevel,  ModelMap map, HttpSession session) {
        System.out.println("Masuk onsubmit 2");
        try {
            map.addAttribute("reDto", rdto);
//            tb_resultEssayService.uploadData(rdto);
            return "jadi";
        } catch (Exception e) {
            return "tidak jadi";
        }

    }   
}
