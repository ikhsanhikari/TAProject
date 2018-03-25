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
    int idx =  0;
    @RequestMapping(value = "/view_quiz", method = RequestMethod.GET)
    public String viewQuiz(@RequestParam int idLevel, Tb_quizDto quizDto, ModelMap map, HttpSession session, Tb_userDto userDto, Tb_resultExerciseDto reDto) {
        System.out.println("Cek @RequestParam viewQuiz...\nidLevel : " + idLevel);
//        List<Tb_quizDto> listQuiz = tb_quizService.getData();
        List<Tb_quizDto> listQuizRandomByLevel = tb_quizService.getQuizRandomByLevel(idLevel);
        List<Tb_quizDto> listAnswer = tb_quizService.getAnswerAllByQuiz(listQuizRandomByLevel.get(0).getId());
        reDto.setId_collerger(Integer.parseInt(session.getAttribute("iduser").toString()));
        map.addAttribute("listQuiz", listQuizRandomByLevel);
        map.addAttribute("reDto", reDto);
        idx++;
        map.addAttribute("idx", idx);
        int stat = 0;
        if(listAnswer.size()>1){
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
            case 0: knowledge = "none"; nilaiDisabledLow = "false"; break;
            case 1: knowledge = "poor"; nilaiDisabledLow = "false"; break;
            case 2: knowledge = "fair"; nilaiDisabledLow = "false"; nilaiDisabledMedium = "false"; break;
            case 3: knowledge = "good"; nilaiDisabledLow = "false"; nilaiDisabledMedium = "false"; nilaiDisabledHigh = "false"; break;
        }
        System.out.println("poor " + nilaiDisabledLow + "\nfair " + nilaiDisabledMedium + "\ngood " + nilaiDisabledHigh);
        map.addAttribute("nilaiDisabledLow", nilaiDisabledLow);
        map.addAttribute("nilaiDisabledMedium", nilaiDisabledMedium);
        map.addAttribute("nilaiDisabledHigh", nilaiDisabledHigh);
        map.addAttribute("idKnowledge", idKnowledge);
        
        String level = "";
        level = (idLevel==1?"Low":idLevel==2?"Medium":idLevel==3?"High":"");
        map.addAttribute("idLevel", idLevel);
        map.addAttribute("level", level);
        
        int totalSoalByLevel = tb_quizService.getTotalSoalByLevel(idLevel);
        map.addAttribute("totalSoalByLevel", totalSoalByLevel);
        
        return "mahasiswa/view_quiz";
    }
    
    @RequestMapping(value = "/random_quiz", method = RequestMethod.GET)
    public String randomQuiz(@RequestParam int idLevel, ModelMap map,Tb_resultExerciseDto reDto) {
        System.out.println("Cek @RequestParam randomQuiz...\nidLevel : " + idLevel);
        List<Tb_quizDto> listQuiz = tb_quizService.getData();
        map.addAttribute("listQuiz", listQuiz);
        map.addAttribute("reDto", reDto);
        tb_quizService.saveData(reDto);
        return "redirect:view_quiz.htm?idLevel=" + idLevel;
    }
    @RequestMapping(value = "/delete_quiz", method = RequestMethod.GET)
    public String deleteQuiz(Integer id) {
        tb_quizService.deleteData(id);
        return "redirect:view_quiz.htm";
    }
    
    @RequestMapping(value = "/view_historis", method = RequestMethod.GET)
    public String historis(ModelMap model,HttpSession session) {
        List<Tb_quizDto> listHistoris = tb_quizService.getDataHistoris(Integer.parseInt(session.getAttribute("iduser").toString()));
        model.addAttribute("listHistoris", listHistoris);
        return "mahasiswa/historis_exercise";
    }

    @RequestMapping(value = "/pra_exercise", method = RequestMethod.GET)
    public String praExercise(ModelMap modelMap, HttpSession session){
//        Setting button disabled/enabled
        int idKnowledge = tb_userService.getDataKnowledge(session.getAttribute("username").toString());
        System.out.println("Checking inside praExercise for Disabled Setting, idKnowledge is " + idKnowledge);
        String knowledge = "";
        String nilaiDisabledLow = "true";
        String nilaiDisabledMedium = "true";
        String nilaiDisabledHigh = "true";
        switch (idKnowledge) {
            case 0: knowledge = "none"; nilaiDisabledLow = "false"; break;
            case 1: knowledge = "poor"; nilaiDisabledLow = "false"; break;
            case 2: knowledge = "fair"; nilaiDisabledLow = "false"; nilaiDisabledMedium = "false"; break;
            case 3: knowledge = "good"; nilaiDisabledLow = "false"; nilaiDisabledMedium = "false"; nilaiDisabledHigh = "false"; break;
        }
        System.out.println("poor " + nilaiDisabledLow + "\nfair " + nilaiDisabledMedium + "\ngood " + nilaiDisabledHigh);
        modelMap.addAttribute("nilaiDisabledLow", nilaiDisabledLow);
        modelMap.addAttribute("nilaiDisabledMedium", nilaiDisabledMedium);
        modelMap.addAttribute("nilaiDisabledHigh", nilaiDisabledHigh);
//        modelMap.addAttribute("idKnowledge", idKnowledge);
        
        return "mahasiswa/pra_exercise";
    }
}
