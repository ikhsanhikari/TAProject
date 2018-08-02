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
import project.ta.elearning.dto.Tb_answersDto;
import project.ta.elearning.dto.Tb_userDto;
import project.ta.elearning.service.Tb_answersService;

/**
 *
 * @author Sou
 */
@Controller
public class Tb_answersController {

    @Autowired
    Tb_answersService tb_answersService;

    @RequestMapping(value = "/form_tambah_answers", method = RequestMethod.GET)
    public String formTambahAnswers(ModelMap map, Tb_answersDto answersDto, HttpSession session, Tb_userDto userDto) {
        List<Tb_answersDto> listDto = tb_answersService.getData();
        int id_answer = (int)listDto.get(0).getId();
        answersDto.setId(id_answer+1);
        map.addAttribute("loginDto", userDto);
        try {
            if (session.getAttribute("username") == null) {
                return "login";
            } else {
                int role = Integer.parseInt(session.getAttribute("role").toString());
                if (role != 3) {
                    return "login";
                } else {
                    map.addAttribute("answersDto", answersDto);
                    return "admin/answers/form_tambah_answers";
                }
                
            }
        } catch (Exception e) {
            return "login";
        }
    }

    @RequestMapping(value = "/form_ubah_answers", method = RequestMethod.GET)
    public String formUbahAnswers(ModelMap map, Tb_answersDto answersDto, Integer id, HttpSession session, Tb_userDto userDto) {
        answersDto = tb_answersService.getDataById(id);
        map.addAttribute("loginDto", userDto);
        try {
            if (session.getAttribute("username") == null) {
                return "login";
            } else {
                int role = Integer.parseInt(session.getAttribute("role").toString());
                if (role != 3) {
                    return "login";
                } else {
                    map.addAttribute("answersDto", answersDto);
                    return "admin/answers/form_ubah_answers";
                }
                
            }
        } catch (Exception e) {
            return "login";
        }

    }

    @RequestMapping(value = "/save_answers", method = RequestMethod.POST)
    public String saveAnswers(Tb_answersDto answersDto) {
        tb_answersService.saveData(answersDto);
        return "redirect:view_answers.htm";
    }

    @RequestMapping(value = "/update_answers", method = RequestMethod.POST)
    public String ubahAnswers(Tb_answersDto answersDto) {
        tb_answersService.updateData(answersDto);
        return "redirect:view_answers.htm";
    }

    @RequestMapping(value = "/view_answers", method = RequestMethod.GET)
    public String viewAnswers(Tb_answersDto answersDto, ModelMap map, HttpSession session, Tb_userDto userDto) {
        map.addAttribute("loginDto", userDto);
        List<Tb_answersDto> listDto = tb_answersService.getData();
        try {
            if (session.getAttribute("username") == null) {
                return "login";
            } else {
                int role = Integer.parseInt(session.getAttribute("role").toString());
                if (role != 3) {
                    return "login";
                } else {
                    map.addAttribute("listAnswers", listDto);
                    return "admin/answers/view_answers";
                }
            }
        } catch (Exception e) {
            return "login";
        }
    }
    @RequestMapping(value = "/delete_answers", method = RequestMethod.GET)
    public String deleteAnswers(Integer id) {
        tb_answersService.deleteData(id);
        return "redirect:view_answers.htm";
    }

}
