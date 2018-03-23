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
import project.ta.elearning.dao.Tb_assignmentDao;
import project.ta.elearning.dto.Tb_assignmentDto;
import project.ta.elearning.model.Tb_assignmentModel;
import project.ta.elearning.service.Tb_assignmentService;

/**
 *
 * @author Sou
 */
@Transactional
@Service
public class Tb_assignmentServiceImpl implements Tb_assignmentService{

    @Autowired
    Tb_assignmentDao tb_assignmentDao;
    
    @Override
    public List<Tb_assignmentDto> getData() {
        List<Tb_assignmentDto> listData = new ArrayList<>();
        List<Tb_assignmentModel> listModel = tb_assignmentDao.getData();
        if(listModel.size()>0){
            for (Tb_assignmentModel model : listModel) {
                Tb_assignmentDto dto = new Tb_assignmentDto();
                dto.setId(model.getId());
                dto.setId(model.getId());
                dto.setCourse(model.getCourse());
                dto.setName(model.getName());
                listData.add(dto);
            }
        }
        
        return listData;
    }

    @Override
    public void saveData(Tb_assignmentDto dto) {
        Tb_assignmentModel model = new Tb_assignmentModel();
        try {
            model.setId(dto.getId());
            model.setCourse(dto.getCourse());
            model.setName(dto.getName());
            tb_assignmentDao.saveData(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void deleteData(Integer id) {
        try {
            tb_assignmentDao.deleteData(id);
        } catch (Exception e) {
            
        }
    }

    @Override
    public void updateData(Tb_assignmentDto dto) {
        Tb_assignmentModel model = new Tb_assignmentModel();
        try {
            model.setId(dto.getId());
            model.setCourse(dto.getCourse());
            model.setName(dto.getName());
            tb_assignmentDao.updateData(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Tb_assignmentDto getDataById(Integer id) {
        Tb_assignmentDto dto = new Tb_assignmentDto();
        List<Tb_assignmentModel> listModel = tb_assignmentDao.getDataById(id);
        if(listModel.size()>0){
            for (Tb_assignmentModel model : listModel) {
                dto = new Tb_assignmentDto();
                dto.setId(model.getId());
                dto.setId(model.getId());
                dto.setCourse(model.getCourse());
                dto.setName(model.getName());
            }
        }
        
        return dto;
    }
    
}
