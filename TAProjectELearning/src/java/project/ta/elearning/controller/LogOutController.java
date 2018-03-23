/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ta.elearning.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.ta.elearning.dto.Tb_userDto;

/**
 *
 * @author Sou
 */
@Controller
public class LogOutController {
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logOut(HttpSession session,Tb_userDto userDto,ModelMap map){
        if(session!=null){
            session.invalidate();
        }
        map.addAttribute("loginDto", userDto);
        return "login";
    }
}
