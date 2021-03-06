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
import org.springframework.web.bind.annotation.ResponseBody;
import project.ta.elearning.dto.Tb_answersDto;
import project.ta.elearning.dto.Tb_jenisSoalDto;
import project.ta.elearning.dto.Tb_levelDto;
import project.ta.elearning.dto.Tb_qaDto;
import project.ta.elearning.dto.Tb_quizDto;
import project.ta.elearning.dto.Tb_userDto;
import project.ta.elearning.service.Tb_answersService;
import project.ta.elearning.service.Tb_jenisSoalService;
import project.ta.elearning.service.Tb_levelService;
import project.ta.elearning.service.Tb_qaService;
import project.ta.elearning.service.Tb_quizService;

/**
 *
 * @author sou
 */
@Controller
public class Tb_qaController {

    @Autowired
    Tb_qaService tb_qaService;
    
    @Autowired
    Tb_quizService tb_quizService;
    
    @Autowired
    Tb_answersService tb_anwersService;
    
    @Autowired
    Tb_levelService tb_levelService;
    
    @Autowired
    Tb_jenisSoalService tb_jenisSoalService;

    @RequestMapping(value = "/form_tambah_qa", method = RequestMethod.GET)
    public String formTambahQa(ModelMap map, Tb_qaDto qaDto, HttpSession session, Tb_userDto userDto) {
        map.addAttribute("loginDto", userDto);
        List<Tb_quizDto> listDto = tb_qaService.getDataNative();
        int id_qa =(int) listDto.get(0).getId();
        qaDto.setId(id_qa+1);
        List<Tb_answersDto> listAnswer = tb_anwersService.getData();
        map.addAttribute("listAnswer", listAnswer);
        
        List<Tb_levelDto> listLevel = tb_levelService.getData();
        map.addAttribute("listLevel", listLevel);
        
        List<Tb_jenisSoalDto> listJenisSoal = tb_jenisSoalService.getData();
        map.addAttribute("listJenisSoal", listJenisSoal);
        
        List<Tb_quizDto> listQuiz = tb_quizService.getData();
        map.addAttribute("listQuiz", listQuiz);
        
        try {
            if (session.getAttribute("username") == null) {
                return "login";
            } else {
                int role = Integer.parseInt(session.getAttribute("role").toString());
                if (role != 2) {
                    return "login";
                } else {
                    map.addAttribute("qaDto", qaDto);
                    return "admin/qa/form_tambah_qa";
                }

            }
        } catch (Exception e) {
            return "login";
        }
    }

    @RequestMapping(value = "/form_ubah_qa", method = RequestMethod.GET)
    public String formUbahQa(ModelMap map, Tb_qaDto qaDto, Integer id, HttpSession session, Tb_userDto userDto) {
        qaDto = tb_qaService.getDataById(id);
        map.addAttribute("loginDto", userDto);
        
        List<Tb_answersDto> listAnswer = tb_anwersService.getData();
        map.addAttribute("listAnswer", listAnswer);
        
        List<Tb_levelDto> listLevel = tb_levelService.getData();
        map.addAttribute("listLevel", listLevel);
        
        List<Tb_jenisSoalDto> listJenisSoal = tb_jenisSoalService.getData();
        map.addAttribute("listJenisSoal", listJenisSoal);
        
        List<Tb_quizDto> listQuiz = tb_quizService.getData();
        map.addAttribute("listQuiz", listQuiz);
        try {
            if (session.getAttribute("username") == null) {
                return "login";
            } else {
                int role = Integer.parseInt(session.getAttribute("role").toString());
                if (role != 2) {
                    return "login";
                } else {
                    map.addAttribute("qaDto", qaDto);
                    return "admin/qa/form_ubah_qa";
                }

            }
        } catch (Exception e) {
            return "login";
        }

    }

    @RequestMapping(value = "/save_qa", method = RequestMethod.POST)
    public String saveQa(Tb_qaDto qaDto) {
        try {
            tb_qaService.saveData(qaDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return "redirect:view_qa.htm";
    }

    @RequestMapping(value = "/update_qa", method = RequestMethod.POST)
    public String ubahQa(Tb_qaDto qaDto) {
        tb_qaService.updateData(qaDto);
        return "redirect:view_qa.htm";
    }
//    @ResponseBody
    @RequestMapping(value = "/view_qa", method = RequestMethod.GET)
    public String viewQa(Tb_qaDto qaDto, ModelMap map, HttpSession session, Tb_userDto userDto) {
        map.addAttribute("loginDto", userDto);
        List<Tb_quizDto> listDto = tb_qaService.getDataNative();
        try {
            if (session.getAttribute("username") == null) {
                return "login";
            } else {
                int role = Integer.parseInt(session.getAttribute("role").toString());
                if (role != 2) {
                    return "login";
                } else {
                    map.addAttribute("listQa", listDto);
                    return "admin/qa/view_qa";
                }
            }
        } catch (Exception e) {
            return "login";
        }
//        return "=====";
    }

    @RequestMapping(value = "/delete_qa", method = RequestMethod.GET)
    public String deleteQa(Integer id) {
        tb_qaService.deleteData(id);
        return "redirect:view_qa.htm";
    }
}
