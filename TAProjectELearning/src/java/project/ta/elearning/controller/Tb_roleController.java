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
import project.ta.elearning.dto.Tb_roleDto;
import project.ta.elearning.dto.Tb_userDto;
import project.ta.elearning.service.Tb_roleService;

/**
 *
 * @author Sou
 */
@Controller
public class Tb_roleController {

    @Autowired
    Tb_roleService tb_roleService;

    @RequestMapping(value = "/form_tambah_role", method = RequestMethod.GET)
    public String formTambahRole(ModelMap map, Tb_roleDto roleDto, HttpSession session, Tb_userDto userDto) {
        map.addAttribute("loginDto", userDto);
        try {
            if (session.getAttribute("username") == null) {
                return "login";
            } else {
                int role = Integer.parseInt(session.getAttribute("role").toString());
                if (role != 3) {
                    return "login";
                } else {
                    map.addAttribute("roleDto", roleDto);
                    return "admin/role/form_tambah_role";
                }
            }
        } catch (Exception e) {
            return "login";
        }

    }

    @RequestMapping(value = "/form_ubah_role", method = RequestMethod.GET)
    public String formUbahRole(ModelMap map, Tb_roleDto roleDto, Integer id,HttpSession session, Tb_userDto userDto) {
        roleDto = tb_roleService.getDataById(id);
        map.addAttribute("loginDto", userDto);
        try {
            if (session.getAttribute("username") == null) {
                return "login";
            } else {
                int role = Integer.parseInt(session.getAttribute("role").toString());
                if (role != 3) {
                    return "login";
                } else {
                    map.addAttribute("roleDto", roleDto);
                    return "admin/role/form_ubah_role";
                }
                
            }
        } catch (Exception e) {
            return "login";
        }

    }

    @RequestMapping(value = "/save_role", method = RequestMethod.POST)
    public String saveRole(Tb_roleDto roleDto) {
        tb_roleService.saveData(roleDto);
        return "redirect:view_role.htm";
    }

    @RequestMapping(value = "/update_role", method = RequestMethod.POST)
    public String ubahRole(Tb_roleDto roleDto) {
        tb_roleService.updateData(roleDto);
        return "redirect:view_role.htm";
    }

    @RequestMapping(value = "/view_role", method = RequestMethod.GET)
    public String viewRole(Tb_roleDto roleDto, ModelMap map,HttpSession session, Tb_userDto userDto) {
        List<Tb_roleDto> listDto = tb_roleService.getData();
        map.addAttribute("loginDto", userDto);
        try {
            if (session.getAttribute("username") == null) {
                return "login";
            } else {
                int role = Integer.parseInt(session.getAttribute("role").toString());
                if (role != 3) {
                    return "login";
                } else {
                    map.addAttribute("listRole", listDto);
                    return "admin/role/view_role";
                }
                
            }
        } catch (Exception e) {
            return "login";
        }
    }
//    @ResponseBody

    @RequestMapping(value = "/delete_role", method = RequestMethod.GET)
    public String deleteRole(Integer id) {
        tb_roleService.deleteData(id);
        return "redirect:view_role.htm";
    }

}
