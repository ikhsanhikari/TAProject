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
import project.ta.elearning.dto.UserDto;
import project.ta.elearning.service.UserService;

/**
 *
 * @author Sou
 */
@Controller
public class UserController {
    
    @Autowired
    UserService  userService;
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String viewAdmin(ModelMap map,HttpSession session, Tb_userDto userDto){
        map.addAttribute("loginDto", userDto);
        try {
            if (session.getAttribute("username") == null) {
                return "login";
            } else {
                int role = Integer.parseInt(session.getAttribute("role").toString());
                if (role != 3) {
                    return "login";
                } else {
                    return "linkAdmin";
                }
                
            }
        } catch (Exception e) {
            return "login";
        }
        
    }
}
