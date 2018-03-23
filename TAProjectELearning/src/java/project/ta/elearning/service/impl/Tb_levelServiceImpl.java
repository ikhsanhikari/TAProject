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
import project.ta.elearning.dao.Tb_levelDao;
import project.ta.elearning.dto.Tb_levelDto;
import project.ta.elearning.model.Tb_levelModel;
import project.ta.elearning.service.Tb_levelService;

/**
 *
 * @author Sou
 */
@Transactional
@Service
public class Tb_levelServiceImpl implements Tb_levelService{

    @Autowired
    Tb_levelDao tb_levelDao;
    
    @Override
    public List<Tb_levelDto> getData() {
        List<Tb_levelDto> listData = new ArrayList<>();
        List<Tb_levelModel> listModel = tb_levelDao.getData();
        if(listModel.size()>0){
            for (Tb_levelModel model : listModel) {
                Tb_levelDto dto = new Tb_levelDto();
                dto.setId(model.getId());
                dto.setLevel(model.getLevel());
                listData.add(dto);
            }
        }
        
        return listData;
    }

    @Override
    public void saveData(Tb_levelDto dto) {
        Tb_levelModel model = new Tb_levelModel();
        try {
            model.setId(dto.getId());
            model.setLevel(dto.getLevel());
            tb_levelDao.saveData(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void deleteData(Integer id) {
        try {
            tb_levelDao.deleteData(id);
        } catch (Exception e) {
            
        }
    }

    @Override
    public void updateData(Tb_levelDto dto) {
        Tb_levelModel model = new Tb_levelModel();
        try {
            model.setId(dto.getId());
            model.setLevel(dto.getLevel());
            tb_levelDao.updateData(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Tb_levelDto getDataById(Integer id) {
        Tb_levelDto dto = new Tb_levelDto();
        List<Tb_levelModel> listModel = tb_levelDao.getDataById(id);
        if(listModel.size()>0){
            for (Tb_levelModel model : listModel) {
                dto = new Tb_levelDto();
                dto.setId(model.getId());
                dto.setLevel(model.getLevel());
            }
        }
        
        return dto;
    }
    
}
