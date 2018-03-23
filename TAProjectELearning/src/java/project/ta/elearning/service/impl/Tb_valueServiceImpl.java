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
import project.ta.elearning.dao.Tb_valueDao;
import project.ta.elearning.dto.Tb_valueDto;
import project.ta.elearning.model.Tb_valueModel;
import project.ta.elearning.service.Tb_valueService;

/**
 *
 * @author Sou
 */
@Transactional
@Service
public class Tb_valueServiceImpl implements Tb_valueService {

    @Autowired
    Tb_valueDao tb_valueDao;

    @Override
    public List<Tb_valueDto> getData() {
        List<Tb_valueDto> listData = new ArrayList<>();
        List<Tb_valueModel> listModel = tb_valueDao.getData();
        if (listModel.size() > 0) {
            for (Tb_valueModel model : listModel) {
                Tb_valueDto dto = new Tb_valueDto();
                dto.setId(model.getId());
                dto.setUserid(model.getUserid());
                dto.setFinal_value(model.getFinal_value());
                dto.setMid_value(model.getMid_value());
                listData.add(dto);
            }
        }

        return listData;
    }

    @Override
    public void saveData(Tb_valueDto dto) {
        Tb_valueModel model = new Tb_valueModel();
        try {
            model.setId(dto.getId());
            model.setUserid(dto.getUserid());
            model.setFinal_value(dto.getFinal_value());
            model.setMid_value(dto.getMid_value());
            tb_valueDao.saveData(model);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteData(Integer id) {
        try {
            tb_valueDao.deleteData(id);
        } catch (Exception e) {

        }
    }

    @Override
    public void updateData(Tb_valueDto dto) {
        Tb_valueModel model = new Tb_valueModel();
        try {
            model.setId(dto.getId());
            model.setUserid(dto.getUserid());
            model.setFinal_value(dto.getFinal_value());
            model.setMid_value(dto.getMid_value());
            tb_valueDao.updateData(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Tb_valueDto getDataById(Integer id) {
        Tb_valueDto dto = new Tb_valueDto();
        List<Tb_valueModel> listModel = tb_valueDao.getDataById(id);
        if (listModel.size() > 0) {
            for (Tb_valueModel model : listModel) {
                dto = new Tb_valueDto();
                dto.setId(model.getId());
                dto.setUserid(model.getUserid());
                dto.setFinal_value(model.getFinal_value());
                dto.setMid_value(model.getMid_value());
            }
        }

        return dto;
    }

}
