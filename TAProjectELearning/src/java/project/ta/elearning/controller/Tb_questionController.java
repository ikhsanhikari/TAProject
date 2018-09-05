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
import project.ta.elearning.dto.Tb_quizDto;
import project.ta.elearning.dto.Tb_userDto;
import project.ta.elearning.service.Tb_quizService;

/**
 *
 * @author sou
 */
@Controller
public class Tb_questionController {
    @Autowired
    Tb_quizService tb_quizService;

    @RequestMapping(value = "/form_tambah_question", method = RequestMethod.GET)
    public String formTambahQuiz(ModelMap map, Tb_quizDto quizDto, HttpSession session, Tb_userDto userDto) {
        map.addAttribute("loginDto", userDto);
        List<Tb_quizDto> listDto = tb_quizService.getData();
        int id_question = Integer.parseInt(listDto.get(0).getId().toString());
//        map.addAttribute("id",id_question);
        quizDto.setId(id_question+1);
        try {
            if (session.getAttribute("username") == null) {
                return "login";
            } else {
                int role = Integer.parseInt(session.getAttribute("role").toString());
                if (role != 2) {
                    return "login";
                } else {
                    map.addAttribute("quizDto", quizDto);
                    return "admin/quiz/form_tambah_question";
                }
                
            }
        } catch (Exception e) {
            return "login";
        }
    }

    @RequestMapping(value = "/form_ubah_question", method = RequestMethod.GET)
    public String formUbahQuiz(ModelMap map, Tb_quizDto quizDto, Integer id, HttpSession session, Tb_userDto userDto) {
        quizDto = tb_quizService.getDataById(id);
        map.addAttribute("loginDto", userDto);
        try {
            if (session.getAttribute("username") == null) {
                return "login";
            } else {
                int role = Integer.parseInt(session.getAttribute("role").toString());
                if (role != 2) {
                    return "login";
                } else {
                    map.addAttribute("questionDto", quizDto);
                    return "admin/quiz/form_ubah_question";
                }
                
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "login";
        }

    }

    @RequestMapping(value = "/save_question", method = RequestMethod.POST)
    public String saveQuiz(Tb_quizDto quizDto) {
        tb_quizService.saveData(quizDto);
        return "redirect:view_question.htm";
    }

    @RequestMapping(value = "/update_question", method = RequestMethod.POST)
    public String ubahQuiz(Tb_quizDto quizDto) {
        tb_quizService.updateData(quizDto);
        return "redirect:view_question.htm";
    }
    
    @RequestMapping(value = "/view_question", method = RequestMethod.GET)
    public String viewQuiz(Tb_quizDto quizDto, ModelMap map, HttpSession session, Tb_userDto userDto) {
        map.addAttribute("loginDto", userDto);
        List<Tb_quizDto> listDto = tb_quizService.getData();
        try {
            if (session.getAttribute("username") == null) {
                return "login";
            } else {
                int role = Integer.parseInt(session.getAttribute("role").toString());
                if (role != 2) {
                    return "login";
                } else {
                    map.addAttribute("listQuestion", listDto);
                    return "admin/quiz/view_question";
                }
            }
        } catch (Exception e) {
            return "login";
        }
    }
    @RequestMapping(value = "/delete_question", method = RequestMethod.GET)
    public String deleteQuiz(Integer id) {
        tb_quizService.deleteData(id);
        return "redirect:view_question.htm";
    }
}
