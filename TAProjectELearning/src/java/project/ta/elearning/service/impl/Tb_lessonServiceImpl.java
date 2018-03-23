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
import project.ta.elearning.dao.Tb_lessonDao;
import project.ta.elearning.dto.Tb_lessonDto;
import project.ta.elearning.model.Tb_lessonModel;
import project.ta.elearning.service.Tb_lessonService;

/**
 *
 * @author Sou
 */
@Transactional
@Service
public class Tb_lessonServiceImpl implements Tb_lessonService{

    @Autowired
    Tb_lessonDao tb_lessonDao;
    
    @Override
    public List<Tb_lessonDto> getData() {
        List<Tb_lessonDto> listData = new ArrayList<>();
        List<Tb_lessonModel> listModel = tb_lessonDao.getData();
        if(listModel.size()>0){
            for (Tb_lessonModel model : listModel) {
                Tb_lessonDto dto = new Tb_lessonDto();
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
    public void saveData(Tb_lessonDto dto) {
        Tb_lessonModel model = new Tb_lessonModel();
        try {
            model.setId(dto.getId());
            model.setCourse(dto.getCourse());
            model.setName(dto.getName());
            tb_lessonDao.saveData(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void deleteData(Integer id) {
        try {
            tb_lessonDao.deleteData(id);
        } catch (Exception e) {
            
        }
    }

    @Override
    public void updateData(Tb_lessonDto dto) {
        Tb_lessonModel model = new Tb_lessonModel();
        try {
            model.setId(dto.getId());
            model.setCourse(dto.getCourse());
            model.setName(dto.getName());
            tb_lessonDao.updateData(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Tb_lessonDto getDataById(Integer id) {
        Tb_lessonDto dto = new Tb_lessonDto();
        List<Tb_lessonModel> listModel = tb_lessonDao.getDataById(id);
        if(listModel.size()>0){
            for (Tb_lessonModel model : listModel) {
                dto = new Tb_lessonDto();
                dto.setId(model.getId());
                dto.setId(model.getId());
                dto.setCourse(model.getCourse());
                dto.setName(model.getName());
            }
        }
        
        return dto;
    }

    @Override
    public List<Tb_lessonDto> getData(String cari) {
        List<Tb_lessonDto> listData = new ArrayList<>();
        List<Tb_lessonModel> listModel = tb_lessonDao.getData(cari);
        if(listModel.size()>0){
            for (Tb_lessonModel model : listModel) {
                Tb_lessonDto dto = new Tb_lessonDto();
                dto.setId(model.getId());
                dto.setId(model.getId());
                dto.setCourse(model.getCourse());
                dto.setName(model.getName());
                listData.add(dto);
            }
        }
        
        return listData;
    }
    
}
