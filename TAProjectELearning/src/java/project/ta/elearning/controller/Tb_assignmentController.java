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
import project.ta.elearning.dto.Tb_assignmentDto;
import project.ta.elearning.dto.Tb_courseDto;
import project.ta.elearning.dto.Tb_userDto;
import project.ta.elearning.service.Tb_assignmentService;
import project.ta.elearning.service.Tb_courseService;

/**
 *
 * @author Sou
 */
@Controller
public class Tb_assignmentController {
    @Autowired
    Tb_assignmentService tb_assignmentService;
    
    @Autowired
    Tb_courseService tb_courseService;
    
    @RequestMapping(value = "/form_tambah_assignment",method = RequestMethod.GET)
    public String formTambahAssignment(ModelMap map,Tb_assignmentDto assignmentDto,HttpSession session, Tb_userDto userDto){
        map.addAttribute("loginDto", userDto);
        List<Tb_courseDto> listCourse = tb_courseService.getData();
        map.addAttribute("listCourse", listCourse);
        try {
            if (session.getAttribute("username") == null) {
                return "login";
            } else {
                int role = Integer.parseInt(session.getAttribute("role").toString());
                if (role != 3) {
                    return "login";
                } else {
                    map.addAttribute("assignmentDto", assignmentDto);
                    return "admin/assignment/form_tambah_assignment";
                }
                
            }
        } catch (Exception e) {
            return "login";
        }
        
    }
    
    @RequestMapping(value = "/form_ubah_assignment",method = RequestMethod.GET)
    public String formUbahAssignment(ModelMap map,Tb_assignmentDto assignmentDto,Integer id,HttpSession session, Tb_userDto userDto){
        assignmentDto = tb_assignmentService.getDataById(id);
        map.addAttribute("loginDto", userDto);
        List<Tb_courseDto> listCourse = tb_courseService.getData();
        map.addAttribute("listCourse", listCourse);
        try {
            if (session.getAttribute("username") == null) {
                return "login";
            } else {
                int role = Integer.parseInt(session.getAttribute("role").toString());
                if (role != 3) {
                    return "login";
                } else {
                    map.addAttribute("assignmentDto", assignmentDto);
                    return "admin/assignment/form_ubah_assignment";
                }
                
            }
        } catch (Exception e) {
            return "login";
        }
        
    }
    
    @RequestMapping(value = "/save_assignment",method = RequestMethod.POST)
    public String saveAssignment(Tb_assignmentDto assignmentDto){
        tb_assignmentService.saveData(assignmentDto);
        return "redirect:view_assignment.htm";
    }
    
    @RequestMapping(value = "/update_assignment",method = RequestMethod.POST)
    public String ubahAssignment(Tb_assignmentDto assignmentDto){
        tb_assignmentService.updateData(assignmentDto);
        return "redirect:view_assignment.htm";
    }
//    @ResponseBody
    @RequestMapping(value = "/view_assignment",method = RequestMethod.GET)
    public String viewAssignment(Tb_assignmentDto assignmentDto,ModelMap map,HttpSession session, Tb_userDto userDto){
        List<Tb_assignmentDto> listDto = tb_assignmentService.getData();
        map.addAttribute("loginDto", userDto);
        try {
            if (session.getAttribute("username") == null) {
                return "login";
            } else {
                int role = Integer.parseInt(session.getAttribute("role").toString());
                if (role != 3) {
                    return "login";
                } else {
                    map.addAttribute("listAssignment", listDto);
                    return "admin/assignment/view_assignment";
                }
                
            }
        } catch (Exception e) {
            return "login";
        }
        
    }
//    @ResponseBody
    @RequestMapping(value = "/delete_assignment",method = RequestMethod.GET)
    public String deleteAssignment(Integer id){
        tb_assignmentService.deleteData(id);
        return "redirect:view_assignment.htm";
    }
    
}
