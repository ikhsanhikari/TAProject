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
import project.ta.elearning.dto.Tb_userDto;
import project.ta.elearning.dto.Tb_valueDto;
import project.ta.elearning.service.Tb_userService;
import project.ta.elearning.service.Tb_valueService;

/**
 *
 * @author Sou
 */
@Controller
public class Tb_valueController {
    @Autowired
    Tb_valueService tb_valueService;
    
    @Autowired
    Tb_userService tb_userService;
    
    @RequestMapping(value = "/form_tambah_value",method = RequestMethod.GET)
    public String formTambahValue(ModelMap map,Tb_valueDto valueDto,HttpSession session, Tb_userDto userDto){
        map.addAttribute("loginDto", userDto);
        List<Tb_userDto> listUser = tb_userService.getData();
        map.addAttribute("listUser", listUser);
        try {
            if (session.getAttribute("username") == null) {
                return "login";
            } else {
                int role = Integer.parseInt(session.getAttribute("role").toString());
                if (role != 3) {
                    return "login";
                } else {
                    map.addAttribute("valueDto", valueDto);
                    return "admin/value/form_tambah_value";
                }
                
            }
        } catch (Exception e) {
            return "login";
        }
        
    }
    
    @RequestMapping(value = "/form_ubah_value",method = RequestMethod.GET)
    public String formUbahValue(ModelMap map,Tb_valueDto valueDto,Integer id,HttpSession session, Tb_userDto userDto){
        valueDto = tb_valueService.getDataById(id);
        map.addAttribute("loginDto", userDto);
        List<Tb_userDto> listUser = tb_userService.getData();
        map.addAttribute("listUser", listUser);
        try {
            if (session.getAttribute("username") == null) {
                return "login";
            } else {
                int role = Integer.parseInt(session.getAttribute("role").toString());
                if (role != 3) {
                    return "login";
                } else {
                    map.addAttribute("valueDto", valueDto);
                    return "admin/value/form_ubah_value";
                }
                
            }
        } catch (Exception e) {
            return "login";
        }
        
    }
    
    @RequestMapping(value = "/save_value",method = RequestMethod.POST)
    public String saveValue(Tb_valueDto valueDto){
        tb_valueService.saveData(valueDto);
        return "redirect:view_value.htm";
    }
    
    @RequestMapping(value = "/update_value",method = RequestMethod.POST)
    public String ubahValue(Tb_valueDto valueDto){
        tb_valueService.updateData(valueDto);
        return "redirect:view_value.htm";
    }
    
    @RequestMapping(value = "/view_value",method = RequestMethod.GET)
    public String viewValue(Tb_valueDto valueDto,ModelMap map,HttpSession session, Tb_userDto userDto){
        List<Tb_valueDto> listDto = tb_valueService.getData();
        map.addAttribute("loginDto", userDto);
        try {
            if (session.getAttribute("username") == null) {
                return "login";
            } else {
                int role = Integer.parseInt(session.getAttribute("role").toString());
                if (role != 3) {
                    return "login";
                } else {
                    map.addAttribute("listValue", listDto);
                    return "admin/value/view_value";
                }
                
            }
        } catch (Exception e) {
            return "login";
        }
        
    }
//    @ResponseBody
    @RequestMapping(value = "/delete_value",method = RequestMethod.GET)
    public String deleteValue(Integer id){
        tb_valueService.deleteData(id);
        return "redirect:view_value.htm";
    }
    
}
