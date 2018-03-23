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
import project.ta.elearning.dto.Tb_lessonDto;
import project.ta.elearning.dto.Tb_userDto;
import project.ta.elearning.service.Tb_lessonService;

/**
 *
 * @author Sou
 */
@Controller
public class Tb_lessonController {
    @Autowired
    Tb_lessonService tb_lessonService;
    
    @RequestMapping(value = "/form_tambah_lesson",method = RequestMethod.GET)
    public String formTambahLesson(ModelMap map,Tb_lessonDto lessonDto,HttpSession session, Tb_userDto userDto){
        map.addAttribute("loginDto", userDto);
        try {
            if (session.getAttribute("username") == null) {
                return "login";
            } else {
                int role = Integer.parseInt(session.getAttribute("role").toString());
                if (role != 3) {
                    return "login";
                } else {
                    map.addAttribute("lessonDto", lessonDto);
                    return "admin/lesson/form_tambah_lesson";
                }
                
            }
        } catch (Exception e) {
            return "login";
        }
        
    }
    
    @RequestMapping(value = "/form_ubah_lesson",method = RequestMethod.GET)
    public String formUbahLesson(ModelMap map,Tb_lessonDto lessonDto,Integer id,HttpSession session, Tb_userDto userDto){
        lessonDto = tb_lessonService.getDataById(id);
        map.addAttribute("loginDto", userDto);
        try {
            if (session.getAttribute("username") == null) {
                return "login";
            } else {
                int role = Integer.parseInt(session.getAttribute("role").toString());
                if (role != 3) {
                    return "login";
                } else {
                    map.addAttribute("lessonDto", lessonDto);
                    return "admin/lesson/form_ubah_lesson";
                }
                
            }
        } catch (Exception e) {
            return "login";
        }
        
    }
    
    @RequestMapping(value = "/save_lesson",method = RequestMethod.POST)
    public String saveLesson(Tb_lessonDto lessonDto){
        tb_lessonService.saveData(lessonDto);
        return "redirect:view_lesson.htm";
    }
    
    @RequestMapping(value = "/update_lesson",method = RequestMethod.POST)
    public String ubahLesson(Tb_lessonDto lessonDto){
        tb_lessonService.updateData(lessonDto);
        return "redirect:view_lesson.htm";
    }
//    @ResponseBody
    @RequestMapping(value = "/view_lesson",method = RequestMethod.GET)
    public String viewLesson(Tb_lessonDto lessonDto,ModelMap map,HttpSession session, Tb_userDto userDto){
        List<Tb_lessonDto> listDto = tb_lessonService.getData();
        map.addAttribute("lessonDto", lessonDto);
        map.addAttribute("loginDto", userDto);
        try {
            if (session.getAttribute("username") == null) {
                return "login";
            } else {
                int role = Integer.parseInt(session.getAttribute("role").toString());
                if (role != 3) {
                    return "login";
                } else {
                    map.addAttribute("listLesson", listDto);
                    return "admin/lesson/view_lesson";
                }
                
            }
        } catch (Exception e) {
            return "login";
        }
        
    }
    @RequestMapping(value = "/search_lesson",method = RequestMethod.GET)
    public String searchLesson(Tb_lessonDto lessonDto,ModelMap map,HttpSession session, Tb_userDto userDto){
        List<Tb_lessonDto> listDto = tb_lessonService.getData(lessonDto.getCari());
        map.addAttribute("loginDto", userDto);
        map.addAttribute("lessonDto", lessonDto);
        try {
            if (session.getAttribute("username") == null) {
                return "login";
            } else {
                int role = Integer.parseInt(session.getAttribute("role").toString());
                if (role != 3) {
                    return "login";
                } else {
                    map.addAttribute("listLesson", listDto);
                    return "admin/lesson/view_lesson";
                }
                
            }
        } catch (Exception e) {
            return "login";
        }
        
    }
//    @ResponseBody
    @RequestMapping(value = "/delete_lesson",method = RequestMethod.GET)
    public String deleteLesson(Integer id){
        tb_lessonService.deleteData(id);
        return "redirect:view_lesson.htm";
    }
    
}
