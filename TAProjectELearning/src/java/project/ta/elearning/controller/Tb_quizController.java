/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ta.elearning.controller;

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
    public String viewQuiz(@RequestParam int idLevel, Tb_quizDto quizDto, ModelMap map, HttpSession session, Tb_userDto userDto, Tb_resultExerciseDto reDto) {
        System.out.println("Cek @RequestParam viewQuiz...\nidLevel : " + idLevel);
//        List<Tb_quizDto> listQuiz = tb_quizService.getData();
        List<Tb_quizDto> listQuizRandomByLevel = tb_quizService.getQuizRandomByLevel(idLevel);

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

        int totalSoalByLevel = tb_quizService.getTotalSoalByLevel(idLevel);
        map.addAttribute("totalSoalByLevel", totalSoalByLevel);

        return "mahasiswa/view_quiz";
    }

    @RequestMapping(value = "/random_quiz", method = RequestMethod.GET)
    public String randomQuiz(@RequestParam int idLevel, ModelMap map, Tb_resultExerciseDto reDto) {
        System.out.println("Cek @RequestParam randomQuiz...\nidLevel : " + idLevel);
        List<Tb_quizDto> listQuiz = tb_quizService.getData();
        map.addAttribute("listQuiz", listQuiz);
        map.addAttribute("reDto", reDto);
        System.out.println("======================== id_quiz " + getId_quiz() + "= = = = id_answer " + reDto.getId_answer() + " ".trim());
        System.out.println("jenis soal : " + getJenis_soal() + " = " + getJawaban_benar());
        if (getJenis_soal() == 1) {
            if (getJawaban_benar().equals(reDto.getShort_answer())) {
                System.out.println("Masuk sama = " + getId_qa());
                reDto.setId_qa(getId_qa());
                reDto.setStatus(1);
            } else {
                System.out.println("Masuk beda = " + getId_qa());
                reDto.setId_qa(getId_qa());
                reDto.setStatus(0);
            }
            System.out.println("jawaban kang field e " + reDto.getShort_answer());
        } else {
//            reDto.setShort_answer("");
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
//        List<Tb_quizDto> listTotalPoin = tb_quizService.getTotalPoin(Integer.parseInt(session.getAttribute("iduser").toString()));
        Integer score = tb_quizService.getTotalPoin(Integer.parseInt(session.getAttribute("iduser").toString()));
        quizDto.setScore(tb_quizService.getTotalPoin(Integer.parseInt(session.getAttribute("iduser").toString())));
        if(score<30){
            quizDto.setIdknowledge(1);
        }else if(score>=30 && score<60){
            quizDto.setIdknowledge(2);
        }else if(score>=60){
            quizDto.setIdknowledge(3);
        }
        tb_quizService.saveData(quizDto);
        model.addAttribute("listHistoris", listHistoris);
        return "mahasiswa/historis_exercise";
    }

    @RequestMapping(value = "/pra_exercise", method = RequestMethod.GET)
    public String praExercise(ModelMap modelMap, HttpSession session) {
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
//        modelMap.addAttribute("idKnowledge", idKnowledge);

        return "mahasiswa/pra_exercise";
    }
}
