/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ta.elearning.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
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
import project.ta.elearning.service.Tb_userService;

/**
 *
 * @author Sou
 */
@Controller
public class Tb_userController {

    @Autowired
    Tb_userService tb_userService;

    @Autowired
    Tb_roleService tb_roleService;

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String form_tambah_user(Tb_userDto userDto, ModelMap map, HttpSession session, HttpServletRequest req) {
        List<Tb_roleDto> listRole = tb_roleService.getData();
        map.addAttribute("userDto", userDto);
        map.addAttribute("listRole", listRole);
        return "user/form_tambah_user";
    }

//    @ResponseBody
    @RequestMapping(value = "/save_user", method = RequestMethod.POST)
    public String saveData(Tb_userDto userDto, ModelMap map) {
        List<Tb_userDto> listUser = tb_userService.cekData(userDto.getUsername());
        try {
            if (listUser.size() == 0) {
                tb_userService.saveData(userDto);
                map.addAttribute("loginDto", userDto);
                return "login";
            } else {
                map.addAttribute("pesan", "Username sudah digunakan");
                List<Tb_roleDto> listRole = tb_roleService.getData();
                map.addAttribute("userDto", userDto);
                map.addAttribute("listRole", listRole);
                return "user/form_tambah_user";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        map.addAttribute("loginDto", userDto);
                return "login";
//        if(userDto.getId_role()==1){
//            map.addAttribute("nama",userDto.getFirstname()+" "+userDto.getLastname());
//            return "mahasiswa/index";
//        }else if(userDto.getId_role()==2){
//            map.addAttribute("nama",userDto.getFirstname()+" "+userDto.getLastname());
//            return "dosen/index";
//        }else if(userDto.getId_role()==3){
//            map.addAttribute("nama",userDto.getFirstname()+" "+userDto.getLastname());
//            return "admin/index";
//        }
//        return "redirect:view_user.htm";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String viewLogin(HttpSession session, ModelMap map, Tb_userDto userDto) {
        map.addAttribute("loginDto", userDto);
        try {
            if (session.getAttribute("username") == null) {

                return "login";
            }
            Integer role = Integer.parseInt(session.getAttribute("role").toString());
            if (role == 1) {
                return "mahasiswa/index";
            } else if (role == 2) {
                return "dosen/index";
            }
        } catch (Exception e) {
            return "login";
        }
        return "login";
    }

    @RequestMapping(value = "/view_user", method = RequestMethod.GET)
    public String viewUser(ModelMap map, HttpSession session, Tb_userDto userDto) {
        List<Tb_userDto> listUser = tb_userService.getData();
        map.addAttribute("loginDto", userDto);
        map.addAttribute("userDto", userDto);
        try {
            if (session.getAttribute("username") == null) {
                return "login";
            } else {
                int role = Integer.parseInt(session.getAttribute("role").toString());
                if (role != 3) {
                    return "login";
                } else {
                    map.addAttribute("listUser", listUser);
                    return "user/view_user";
                }
            }
        } catch (Exception e) {
            return "login";
        }

    }

    @RequestMapping(value = "/search_user", method = RequestMethod.GET)
    public String searchUser(ModelMap map, HttpSession session, Tb_userDto userDto) {
        List<Tb_userDto> listUser = tb_userService.getData(userDto.getCari());
        map.addAttribute("loginDto", userDto);
        map.addAttribute("userDto", userDto);
        try {
            if (session.getAttribute("username") == null) {
                return "login";
            } else {
                int role = Integer.parseInt(session.getAttribute("role").toString());
                if (role != 3) {
                    return "login";
                } else {
                    map.addAttribute("listUser", listUser);
                    return "user/view_user";
                }
            }
        } catch (Exception e) {
            return "login";
        }

    }

    @RequestMapping(value = "/form_tambah_user", method = RequestMethod.GET)
    public String formTambahUser(ModelMap map, Tb_userDto userDto) {
        map.addAttribute("userDto", userDto);
        return "admin/user/form_tambah_user";
    }
//    @ResponseBody

    @RequestMapping(value = "/form_ubah_user", method = RequestMethod.GET)
    public String formUbahUser(ModelMap map, Integer id, HttpSession session, Tb_userDto userDto) {
        userDto = tb_userService.getDataById(id);
        List<Tb_roleDto> listRole = tb_roleService.getData();
        map.addAttribute("loginDto", userDto);
        try {
            if (session.getAttribute("username") == null) {
                return "login";
            } else {
                int role = Integer.parseInt(session.getAttribute("role").toString());
                if (role != 3) {
                    return "login";
                } else {
                    map.addAttribute("userDto", userDto);
                    map.addAttribute("listRole", listRole);
                    return "user/form_ubah_user";
                }
            }
        } catch (Exception e) {
            return "login";
        }

    }
    
    @RequestMapping(value = "/update_user", method = RequestMethod.POST)
    public String ubahUser(Tb_userDto userDto) {
        try {
            tb_userService.updateData(userDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return "redirect:view_user.htm";
    }
//    @ResponseBody

    @RequestMapping(value = "/delete_user", method = RequestMethod.GET)
    public String deleteUser(Integer id) {
        tb_userService.deleteData(id);
        return "redirect:view_user.htm";
    }
    @RequestMapping(value = "/view_mahasiswa", method = RequestMethod.GET)
    public String viewMahasiswa(ModelMap map, HttpSession session, Tb_userDto userDto) {
        List<Tb_userDto> listUser = tb_userService.getDataMahasiswa();
        map.addAttribute("loginDto", userDto);
        map.addAttribute("userDto", userDto);
        try {
            if (session.getAttribute("username") == null) {
                return "login";
            } else {
                int role = Integer.parseInt(session.getAttribute("role").toString());
                if (role != 2) {
                    return "login";
                } else {
                    map.addAttribute("listUser", listUser);
                    return "dosen/view_mahasiswa";
                }
            }
        } catch (Exception e) {
            return "login";
        }

    }
    
    @RequestMapping(value = "/edit_profil", method = RequestMethod.GET)
    public String formEditProfil(ModelMap map,  HttpSession session, Tb_userDto userDto) {
        userDto = tb_userService.getDataById(Integer.parseInt(session.getAttribute("iduser").toString()));
        List<Tb_roleDto> listRole = tb_roleService.getData();
        map.addAttribute("loginDto", userDto);
        try {
                    map.addAttribute("userDto", userDto);
                    map.addAttribute("listRole", listRole);
                    return "user/form_ubah_profil";
        } catch (Exception e) {
            return "login";
        }
        
    }
    @RequestMapping(value = "/edit_profil_dosen", method = RequestMethod.GET)
    public String formEditProfilDosen(ModelMap map,  HttpSession session, Tb_userDto userDto) {
        userDto = tb_userService.getDataById(Integer.parseInt(session.getAttribute("iduser").toString()));
        List<Tb_roleDto> listRole = tb_roleService.getData();
        map.addAttribute("loginDto", userDto);
        try {
                    map.addAttribute("userDto", userDto);
                    map.addAttribute("listRole", listRole);
                    return "user/form_ubah_profil_dosen";
        } catch (Exception e) {
            return "login";
        }
        
    }
    @RequestMapping(value = "/update_profil", method = RequestMethod.POST)
    public String ubahProfil(Tb_userDto userDto) {
        try {
            tb_userService.updateData(userDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return "redirect:profile.htm";
    }
    
    @RequestMapping(value = "/update_profil_admin", method = RequestMethod.POST)
    public String ubahProfilAdmin(Tb_userDto userDto) {
        try {
            tb_userService.updateData(userDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return "redirect:profilAdmin.htm";
    }
    
    @RequestMapping(value = "/update_profil_dosen", method = RequestMethod.POST)
    public String ubahProfilDosen(Tb_userDto userDto) {
        try {
            tb_userService.updateData(userDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return "redirect:profilDosen.htm";
    }
    
    @RequestMapping(value = "/edit_profil_mahasiswa", method = RequestMethod.GET)
    public String formEditProfilMahasiswa(ModelMap map,  HttpSession session, Tb_userDto userDto) {
        userDto = tb_userService.getDataById(Integer.parseInt(session.getAttribute("iduser").toString()));
        List<Tb_roleDto> listRole = tb_roleService.getData();
        map.addAttribute("loginDto", userDto);
        try {
                    map.addAttribute("userDto", userDto);
                    map.addAttribute("listRole", listRole);
                    return "user/form_ubah_profil_mahasiswa";
        } catch (Exception e) {
            return "login";
        }
        
    }
    @RequestMapping(value = "/update_profil_mahasiswa", method = RequestMethod.POST)
    public String ubahProfilMahasiswa(Tb_userDto userDto) {
        try {
            tb_userService.updateData(userDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return "redirect:profile.htm";
    }
}
