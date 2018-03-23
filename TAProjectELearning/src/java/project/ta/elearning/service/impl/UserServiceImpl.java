/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ta.elearning.service.impl;

import convert.Convert;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.ta.elearning.dao.UserDao;
import project.ta.elearning.dto.UserDto;
import project.ta.elearning.service.UserService;

/**
 *
 * @author Sou
 */
@Transactional
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserDao userDao ;
    

    @Override
    public List<UserDto> getUser() {
        List<Object[]> listUser = userDao.getUser();
        List<UserDto> listResult = new ArrayList<>();
        for (Object[] obj : listUser) {
            UserDto userDto= new UserDto();
            userDto.setId(Integer.parseInt(obj[0].toString()));
            userDto.setNama(obj[1].toString());
            userDto.setUsername(obj[2].toString());
            userDto.setPassword(obj[3].toString());
            listResult.add(userDto);
        }
        return listResult ;
    }

    @Override
    public int actionLogin(String username, String password) {
        List<Object[]> cek = userDao.loginAction(username, password);
        return cek.size();
    }
    
}
