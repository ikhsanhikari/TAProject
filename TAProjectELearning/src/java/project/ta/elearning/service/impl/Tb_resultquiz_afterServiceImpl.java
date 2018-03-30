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
import project.ta.elearning.dao.Tb_resultquizDao;
import project.ta.elearning.dao.Tb_resultquiz_afterDao;
import project.ta.elearning.dto.Tb_resultquiz_afterDto;
import project.ta.elearning.model.Tb_resultquiz_afterModel;
import project.ta.elearning.service.Tb_resultquizService;
import project.ta.elearning.service.Tb_resultquiz_afterService;

/**
 *
 * @author Sou
 */
@Transactional
@Service
public class Tb_resultquiz_afterServiceImpl implements Tb_resultquiz_afterService {

    @Autowired
    Tb_resultquiz_afterDao tb_resultquiz_afterDao;

    @Override
    public List<Tb_resultquiz_afterDto> getData() {
        List<Tb_resultquiz_afterDto> listData = new ArrayList<>();
        List<Tb_resultquiz_afterModel> listModel = tb_resultquiz_afterDao.getData();
        if (listModel.size() > 0) {
            for (Tb_resultquiz_afterModel model : listModel) {
                Tb_resultquiz_afterDto dto = new Tb_resultquiz_afterDto();
                dto.setId(model.getId());
                dto.setId_category(model.getId_category());
                dto.setId_colleger(model.getId_colleger());
                dto.setId_matery(model.getId_matery());
                dto.setIdknowledge(model.getIdknowledge());
                dto.setScore(model.getScore());
                listData.add(dto);
            }
        }

        return listData;
    }

    @Override
    public void saveData(Tb_resultquiz_afterDto dto) {
        Tb_resultquiz_afterModel model = new Tb_resultquiz_afterModel();
        try {
            model.setId(dto.getId());
            model.setId_category(dto.getId_category());
            model.setId_colleger(dto.getId_colleger());
            model.setId_matery(dto.getId_matery());
            model.setIdknowledge(dto.getIdknowledge());
            model.setScore(dto.getScore());
            tb_resultquiz_afterDao.saveData(model);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteData(Integer id) {
        try {
            tb_resultquiz_afterDao.deleteData(id);
        } catch (Exception e) {

        }
    }

    @Override
    public void updateData(Tb_resultquiz_afterDto dto) {
        Tb_resultquiz_afterModel model = new Tb_resultquiz_afterModel();
        try {
            model.setId(dto.getId());
            model.setId_category(dto.getId_category());
            model.setId_colleger(dto.getId_colleger());
            model.setId_matery(dto.getId_matery());
            model.setIdknowledge(dto.getIdknowledge());
            model.setScore(dto.getScore());
            tb_resultquiz_afterDao.updateData(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Tb_resultquiz_afterDto getDataById(Integer id) {
        Tb_resultquiz_afterDto dto = new Tb_resultquiz_afterDto();
        List<Tb_resultquiz_afterModel> listModel = tb_resultquiz_afterDao.getDataById(id);
        if (listModel.size() > 0) {
            for (Tb_resultquiz_afterModel model : listModel) {
                dto = new Tb_resultquiz_afterDto();
                dto.setId(model.getId());
                dto.setId_category(model.getId_category());
                dto.setId_colleger(model.getId_colleger());
                dto.setId_matery(model.getId_matery());
                dto.setIdknowledge(model.getIdknowledge());
                dto.setScore(model.getScore());
            }
        }

        return dto;
    }

}
