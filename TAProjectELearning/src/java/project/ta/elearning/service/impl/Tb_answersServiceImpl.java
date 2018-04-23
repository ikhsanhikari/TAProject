/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ta.elearning.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.ta.elearning.dao.Tb_answersDao;
import project.ta.elearning.dto.Tb_answersDto;
import project.ta.elearning.model.Tb_answersModel;
import project.ta.elearning.service.Tb_answersService;

/**
 *
 * @author Sou
 */
@Transactional
@Service
public class Tb_answersServiceImpl implements Tb_answersService{

    @Autowired
    Tb_answersDao tb_answersDao;
    
    @Override
    public List<Tb_answersDto> getData() {
        List<Tb_answersDto> listData = new ArrayList<>();
        List<Tb_answersModel> listModel = tb_answersDao.getData();
        if(listModel.size()>0){
            for (Tb_answersModel model : listModel) {
                Tb_answersDto dto = new Tb_answersDto();
                dto.setId(model.getId());
                dto.setAnswers(model.getAnswers());
                listData.add(dto);
            }
        }
        
        return listData;
    }

    @Override
    public void saveData(Tb_answersDto dto) {
        Tb_answersModel model = new Tb_answersModel();
        try {
            model.setId(dto.getId());
            model.setAnswers(dto.getAnswers());
            tb_answersDao.saveData(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void deleteData(Integer id) {
        try {
            tb_answersDao.deleteData(id);
        } catch (Exception e) {
            
        }
    }

    @Override
    public void updateData(Tb_answersDto dto) {
        Tb_answersModel model = new Tb_answersModel();
        try {
            model.setId(dto.getId());
            model.setAnswers(dto.getAnswers());
            tb_answersDao.updateData(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Tb_answersDto getDataById(Integer id) {
        Tb_answersDto dto = new Tb_answersDto();
        List<Tb_answersModel> listModel = tb_answersDao.getDataById(id);
        if(listModel.size()>0){
            for (Tb_answersModel model : listModel) {
                dto = new Tb_answersDto();
                dto.setId(model.getId());
                dto.setAnswers(model.getAnswers());
            }
        }
        
        return dto;
    }
    
}
