/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ta.elearning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Sou
 */
@Controller
public class ExerciseController {
    @RequestMapping(value = "/exercise",method = RequestMethod.GET)
    public String formUbahAssignment(ModelMap map){
            return "mahasiswa/exercise";  
    }
}
