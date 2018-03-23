/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ta.elearning.service;

import java.util.List;
import project.ta.elearning.dto.UserDto;

/**
 *
 * @author Sou
 */
public interface UserService {
   public List<UserDto> getUser();
   public int actionLogin(String username,String password);
}
