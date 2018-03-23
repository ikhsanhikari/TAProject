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
import project.ta.elearning.dao.Tb_majorsDao;
import project.ta.elearning.dto.Tb_majorsDto;
import project.ta.elearning.model.Tb_majorsModel;
import project.ta.elearning.service.Tb_majorsService;

/**
 *
 * @author Sou
 */
@Transactional
@Service
public class Tb_majorsServiceImpl implements Tb_majorsService{

    @Autowired
    Tb_majorsDao tb_majorsDao;
    
    @Override
    public List<Tb_majorsDto> getData() {
        List<Tb_majorsDto> listData = new ArrayList<>();
        List<Tb_majorsModel> listModel = tb_majorsDao.getData();
        if(listModel.size()>0){
            for (Tb_majorsModel model : listModel) {
                Tb_majorsDto dto = new Tb_majorsDto();
                dto.setId(model.getId());
                dto.setMajors(model.getMajors());
                listData.add(dto);
            }
        }
        return listData;
    }

    @Override
    public void saveData(Tb_majorsDto dto) {
        Tb_majorsModel model = new Tb_majorsModel();
        try {
            model.setId(dto.getId());
            model.setMajors(dto.getMajors());
            tb_majorsDao.saveData(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void deleteData(Integer id) {
        try {
            tb_majorsDao.deleteData(id);
        } catch (Exception e) {
            
        }
    }

    @Override
    public void updateData(Tb_majorsDto dto) {
        Tb_majorsModel model = new Tb_majorsModel();
        try {
            model.setId(dto.getId());
            model.setMajors(dto.getMajors());
            tb_majorsDao.updateData(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Tb_majorsDto getDataById(Integer id) {
        Tb_majorsDto dto = new Tb_majorsDto();
        List<Tb_majorsModel> listModel = tb_majorsDao.getDataById(id);
        if(listModel.size()>0){
            for (Tb_majorsModel model : listModel) {
                dto = new Tb_majorsDto();
                dto.setId(model.getId());
                dto.setMajors(model.getMajors());
            }
        }
        
        return dto;
    }

    @Override
    public List<Tb_majorsDto> getData(String cari) {
        List<Tb_majorsDto> listData = new ArrayList<>();
        List<Tb_majorsModel> listModel = tb_majorsDao.getData(cari);
        if(listModel.size()>0){
            for (Tb_majorsModel model : listModel) {
                Tb_majorsDto dto = new Tb_majorsDto();
                dto.setId(model.getId());
                dto.setMajors(model.getMajors());
                listData.add(dto);
            }
        }        
        return listData;
    }
    
}
