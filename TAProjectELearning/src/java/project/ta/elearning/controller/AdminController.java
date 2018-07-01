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

/**
 *
 * @author hikari
 */
@Controller
public class AdminController {
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String viewIndexDosen(ModelMap modelMap,HttpSession session){
        String nama = session.getAttribute("firstname").toString()+" "+session.getAttribute("lastname").toString();
        modelMap.addAttribute("nama",nama);
        return "admin/index";
    }
}
