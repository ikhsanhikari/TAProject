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
import project.ta.elearning.dao.Tb_resultquiz_beforeDao;
import project.ta.elearning.dto.Tb_resultquiz_beforeDto;
import project.ta.elearning.model.Tb_resultquiz_beforeModel;
import project.ta.elearning.service.Tb_resultquizService;
import project.ta.elearning.service.Tb_resultquiz_beforeService;

/**
 *
 * @author Sou
 */
@Transactional
@Service
public class Tb_resultquiz_beforeServiceImpl implements Tb_resultquiz_beforeService {

    @Autowired
    Tb_resultquiz_beforeDao tb_resultquiz_beforeDao;

    @Override
    public List<Tb_resultquiz_beforeDto> getData() {
        List<Tb_resultquiz_beforeDto> listData = new ArrayList<>();
        List<Tb_resultquiz_beforeModel> listModel = tb_resultquiz_beforeDao.getData();
        if (listModel.size() > 0) {
            for (Tb_resultquiz_beforeModel model : listModel) {
                Tb_resultquiz_beforeDto dto = new Tb_resultquiz_beforeDto();
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
    public void saveData(Tb_resultquiz_beforeDto dto) {
        Tb_resultquiz_beforeModel model = new Tb_resultquiz_beforeModel();
        try {
            model.setId(dto.getId());
            model.setId_category(dto.getId_category());
            model.setId_colleger(dto.getId_colleger());
            model.setId_matery(dto.getId_matery());
            model.setIdknowledge(dto.getIdknowledge());
            model.setScore(dto.getScore());
            tb_resultquiz_beforeDao.saveData(model);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteData(Integer id) {
        try {
            tb_resultquiz_beforeDao.deleteData(id);
        } catch (Exception e) {

        }
    }

    @Override
    public void updateData(Tb_resultquiz_beforeDto dto) {
        Tb_resultquiz_beforeModel model = new Tb_resultquiz_beforeModel();
        try {
            model.setId(dto.getId());
            model.setId_category(dto.getId_category());
            model.setId_colleger(dto.getId_colleger());
            model.setId_matery(dto.getId_matery());
            model.setIdknowledge(dto.getIdknowledge());
            model.setScore(dto.getScore());
            tb_resultquiz_beforeDao.updateData(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Tb_resultquiz_beforeDto getDataById(Integer id) {
        Tb_resultquiz_beforeDto dto = new Tb_resultquiz_beforeDto();
        List<Tb_resultquiz_beforeModel> listModel = tb_resultquiz_beforeDao.getDataById(id);
        if (listModel.size() > 0) {
            for (Tb_resultquiz_beforeModel model : listModel) {
                dto = new Tb_resultquiz_beforeDto();
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
