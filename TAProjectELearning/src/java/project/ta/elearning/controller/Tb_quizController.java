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
import project.ta.elearning.dto.Tb_qaDto;
import project.ta.elearning.dto.Tb_quizDto;
import project.ta.elearning.dto.Tb_userDto;
import project.ta.elearning.service.Tb_quizService;

/**
 *
 * @author Sou
 */
@Controller
public class Tb_quizController {

    @Autowired
    Tb_quizService tb_quizService;

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

    @RequestMapping(value = "/view_quiz", method = RequestMethod.GET)
    public String viewQuiz(Tb_quizDto quizDto, ModelMap map, HttpSession session, Tb_userDto userDto, Tb_qaDto tb_qaDto) {
        List<Tb_quizDto> listQuiz = tb_quizService.getData();
        List<Tb_quizDto> listAnswer = tb_quizService.getAnswerAllByQuiz(listQuiz.get(0).getId());
        map.addAttribute("listQuiz", listQuiz);
        map.addAttribute("tb_qaDto", tb_qaDto);
        int stat = 0;
        if(listAnswer.size()>1){
            map.addAttribute("listAnswer", listAnswer);
            stat = 1;
        }
        map.addAttribute("stat", stat);
        return "mahasiswa/view_quiz";
    }
    
    
    @RequestMapping(value = "/random_quiz", method = RequestMethod.GET)
    public String randomQuiz(ModelMap map,Tb_qaDto tb_qaDto) {
        List<Tb_quizDto> listQuiz = tb_quizService.getData();
        map.addAttribute("listQuiz", listQuiz);
        map.addAttribute("tb_qaDto", tb_qaDto);
        return "redirect:view_quiz.htm";
    }
    @RequestMapping(value = "/delete_quiz", method = RequestMethod.GET)
    public String deleteQuiz(Integer id) {
        tb_quizService.deleteData(id);
        return "redirect:view_quiz.htm";
    }

}
