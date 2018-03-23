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
import project.ta.elearning.dto.Tb_freeQuizDto;
import project.ta.elearning.dto.Tb_userDto;
import project.ta.elearning.service.Tb_freeQuizService;

/**
 *
 * @author Sou
 */
@Controller
public class Tb_freeQuizController {
    @Autowired
    Tb_freeQuizService tb_freeQuizService;
    
    @RequestMapping(value = "/form_tambah_freeQuiz",method = RequestMethod.GET)
    public String formTambahFreeQuiz(ModelMap map,Tb_freeQuizDto freeQuizDto,HttpSession session, Tb_userDto userDto){
        map.addAttribute("loginDto", userDto);
        try {
            if (session.getAttribute("username") == null) {
                return "login";
            } else {
                int role = Integer.parseInt(session.getAttribute("role").toString());
                if (role != 3) {
                    return "login";
                } else {
                    map.addAttribute("freeQuizDto", freeQuizDto);
                    return "admin/freeQuiz/form_tambah_freeQuiz";
                }
                
            }
        } catch (Exception e) {
            return "login";
        }
        
    }
    
    @RequestMapping(value = "/form_ubah_freeQuiz",method = RequestMethod.GET)
    public String formUbahFreeQuiz(ModelMap map,Tb_freeQuizDto freeQuizDto,Integer id,HttpSession session, Tb_userDto userDto){
        freeQuizDto = tb_freeQuizService.getDataById(id);
        map.addAttribute("loginDto", userDto);
        try {
            if (session.getAttribute("username") == null) {
                return "login";
            } else {
                int role = Integer.parseInt(session.getAttribute("role").toString());
                if (role != 3) {
                    return "login";
                } else {
                    map.addAttribute("freeQuizDto", freeQuizDto);
                    return "admin/freeQuiz/form_ubah_freeQuiz";
                }
                
            }
        } catch (Exception e) {
            return "login";
        }
        
    }
    
    @RequestMapping(value = "/save_freeQuiz",method = RequestMethod.POST)
    public String saveFreeQuiz(Tb_freeQuizDto freeQuizDto){
        tb_freeQuizService.saveData(freeQuizDto);
        return "redirect:view_freeQuiz.htm";
    }
    
    @RequestMapping(value = "/update_freeQuiz",method = RequestMethod.POST)
    public String ubahFreeQuiz(Tb_freeQuizDto freeQuizDto){
        tb_freeQuizService.updateData(freeQuizDto);
        return "redirect:view_freeQuiz.htm";
    }
    
    @RequestMapping(value = "/view_freeQuiz",method = RequestMethod.GET)
    public String viewFreeQuiz(Tb_freeQuizDto freeQuizDto,ModelMap map,HttpSession session, Tb_userDto userDto){
        List<Tb_freeQuizDto> listDto = tb_freeQuizService.getData();
        map.addAttribute("loginDto", userDto);
        map.addAttribute("freeQuizDto", freeQuizDto);
        try {
            if (session.getAttribute("username") == null) {
                return "login";
            } else {
                int role = Integer.parseInt(session.getAttribute("role").toString());
                if (role != 3) {
                    return "login";
                } else {
                    map.addAttribute("listFreeQuiz", listDto);
                    return "admin/freeQuiz/view_freeQuiz";
                }
                
            }
        } catch (Exception e) {
            return "login";
        }    
    }
    @RequestMapping(value = "/search_freeQuiz",method = RequestMethod.GET)
    public String searchFreeQuiz(Tb_freeQuizDto freeQuizDto,ModelMap map,HttpSession session, Tb_userDto userDto){
        List<Tb_freeQuizDto> listDto = tb_freeQuizService.getData(freeQuizDto.getCari());
        map.addAttribute("loginDto", userDto);
        map.addAttribute("freeQuizDto", freeQuizDto);
        try {
            if (session.getAttribute("username") == null) {
                return "login";
            } else {
                int role = Integer.parseInt(session.getAttribute("role").toString());
                if (role != 3) {
                    return "login";
                } else {
                    map.addAttribute("listFreeQuiz", listDto);
                    return "admin/freeQuiz/view_freeQuiz";
                }
                
            }
        } catch (Exception e) {
            return "login";
        }
        
    }
    @RequestMapping(value = "/delete_freeQuiz",method = RequestMethod.GET)
    public String deleteFreeQuiz(Integer id){
        tb_freeQuizService.deleteData(id);
        return "redirect:view_freeQuiz.htm";
    }
    
}
