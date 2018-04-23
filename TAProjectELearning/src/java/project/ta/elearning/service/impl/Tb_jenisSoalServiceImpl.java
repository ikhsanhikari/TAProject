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
import project.ta.elearning.dao.Tb_jenisSoalDao;
import project.ta.elearning.dto.Tb_jenisSoalDto;
import project.ta.elearning.model.Tb_jenisSoalModel;
import project.ta.elearning.service.Tb_jenisSoalService;

/**
 *
 * @author Sou
 */
@Transactional
@Service
public class Tb_jenisSoalServiceImpl implements Tb_jenisSoalService{

    @Autowired
    Tb_jenisSoalDao tb_jenisSoalDao;
    
    @Override
    public List<Tb_jenisSoalDto> getData() {
        List<Tb_jenisSoalDto> listData = new ArrayList<>();
        List<Tb_jenisSoalModel> listModel = tb_jenisSoalDao.getData();
        if(listModel.size()>0){
            for (Tb_jenisSoalModel model : listModel) {
                Tb_jenisSoalDto dto = new Tb_jenisSoalDto();
                dto.setId(model.getId());
                dto.setJenisSoal(model.getJenisSoal());
                listData.add(dto);
            }
        }
        
        return listData;
    }

    @Override
    public void saveData(Tb_jenisSoalDto dto) {
        Tb_jenisSoalModel model = new Tb_jenisSoalModel();
        try {
            model.setId(dto.getId());
            model.setJenisSoal(dto.getJenisSoal());
            tb_jenisSoalDao.saveData(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void deleteData(Integer id) {
        try {
            tb_jenisSoalDao.deleteData(id);
        } catch (Exception e) {
            
        }
    }

    @Override
    public void updateData(Tb_jenisSoalDto dto) {
        Tb_jenisSoalModel model = new Tb_jenisSoalModel();
        try {
            model.setId(dto.getId());
            model.setJenisSoal(dto.getJenisSoal());
            tb_jenisSoalDao.updateData(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Tb_jenisSoalDto getDataById(Integer id) {
        Tb_jenisSoalDto dto = new Tb_jenisSoalDto();
        List<Tb_jenisSoalModel> listModel = tb_jenisSoalDao.getDataById(id);
        if(listModel.size()>0){
            for (Tb_jenisSoalModel model : listModel) {
                dto = new Tb_jenisSoalDto();
                dto.setId(model.getId());
                dto.setJenisSoal(model.getJenisSoal());
            }
        }
        
        return dto;
    }
    
}
