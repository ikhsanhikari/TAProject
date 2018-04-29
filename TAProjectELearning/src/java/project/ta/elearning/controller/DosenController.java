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
import project.ta.elearning.dto.Tb_resultEssayDto;
import project.ta.elearning.service.Tb_resultEssayService;

/**
 *
 * @author IT
 */
@Controller
public class DosenController {
    @Autowired
    Tb_resultEssayService tb_resultEssayService;
    
    @RequestMapping(value = "/halaman_maintenance", method = RequestMethod.GET)
    public String viewHalamanMaintenance(){
        
        return "halaman_maintenance";
    }
    
    @RequestMapping(value = "/listEssay", method = RequestMethod.GET)
    public String viewListEssay(ModelMap map,Tb_resultEssayDto tb_resultEssayDto){
        List<Tb_resultEssayDto> listEssay = tb_resultEssayService.getDataNative();
        map.addAttribute("listEssay", listEssay);
        return "dosen/listEssay";
    }
    
    @RequestMapping(value = "/form_result_essay", method = RequestMethod.GET)
    public String saveListEssay(ModelMap map,Tb_resultEssayDto tb_resultEssayDto,Integer id){
        Tb_resultEssayDto dto = tb_resultEssayService.getDataByIdNative(id);
        tb_resultEssayDto = tb_resultEssayService.getDataById(id);
//        map.addAttribute("resultEssayDto", tb_resultEssayDto);
        map.addAttribute("resultEssayDto", tb_resultEssayDto);
        map.addAttribute("dto", dto);
        System.out.println("============="+dto.getEssay());
        return "dosen/koreksi";
    }
    
    @RequestMapping(value = "/update_resultEssay", method = RequestMethod.POST)
    public String ubahAnswers(Tb_resultEssayDto resultEssayDto,HttpSession session) {
        resultEssayDto.setId_korektor(Integer.parseInt(session.getAttribute("iduser").toString()));
        tb_resultEssayService.updateData(resultEssayDto);
        return "redirect:listEssay.htm";
    }
}
