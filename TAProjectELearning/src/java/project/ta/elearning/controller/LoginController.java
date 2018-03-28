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
import org.springframework.web.bind.annotation.SessionAttributes;
import project.ta.elearning.dto.Tb_sessionDto;
import project.ta.elearning.dto.Tb_userDto;
import project.ta.elearning.dto.UserDto;
import project.ta.elearning.service.Tb_sessionService;
import project.ta.elearning.service.Tb_userService;
import project.ta.elearning.service.UserService;

/**
 *
 * @author Sou
 */
@SessionAttributes({"id","username", "password", "firstname", "lastname", "role", "nama", "iduser"})
@Controller
public class LoginController {

    @Autowired
    Tb_userService tb_userService;
    @Autowired
    Tb_sessionService tb_sessionService;

    @RequestMapping(value = "/loginAction", method = RequestMethod.GET)
    public String loginAction(String username, String password, HttpSession session, ModelMap modelMap) {
        int data = tb_userService.loginUser(username, password);
        Tb_userDto listUser = tb_userService.selectUser(username, password);
        String nama = listUser.getFirstname() + " " + listUser.getLastname();
        int idKnowledge = 0;

        modelMap.addAttribute("nama", nama);
        if (data > 0) {
            idKnowledge = tb_userService.getDataKnowledge(username);
            modelMap.addAttribute("username", username);
            modelMap.addAttribute("password", password);
            modelMap.addAttribute("role", listUser.getId_role());
            modelMap.addAttribute("firstname", listUser.getFirstname());
            modelMap.addAttribute("iduser", listUser.getId());
            Tb_sessionDto tb_sessionDto = new Tb_sessionDto();
            tb_sessionDto.setFirstip("10.10.10.142");
            tb_sessionDto.setLastip("10.10.10.142");
            tb_sessionDto.setUsername(username);
            tb_sessionDto.setUserid(listUser.getId());
            tb_sessionService.saveData(tb_sessionDto);
            if (listUser.getId_role() == 1) {
                String knowledge = "";
                String ada = "ada";
                switch (idKnowledge) {
                    case 0: knowledge = "none"; ada = "belum ada"; break;
                    case 1: knowledge = "poor"; break;
                    case 2: knowledge = "fair"; break;
                    case 3: knowledge = "good"; break;
                }
                modelMap.addAttribute("knowledge", knowledge);
                modelMap.addAttribute("ada", ada);
                return "mahasiswa/index";
            } else if (listUser.getId_role() == 2) {
                return "dosen/index";
            } else if (listUser.getId_role() == 3) {
                return "admin/index";
            }
            return "index";
        } else {
            Tb_userDto userDto = new Tb_userDto();
            modelMap.addAttribute("loginDto", userDto);
            return "login";
        }
    }
}
