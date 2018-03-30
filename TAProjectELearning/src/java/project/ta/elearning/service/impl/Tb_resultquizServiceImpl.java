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
import project.ta.elearning.dto.Tb_resultQuizDto;
import project.ta.elearning.model.Tb_resultquizModel;
import project.ta.elearning.service.Tb_resultquizService;

/**
 *
 * @author Sou
 */
@Transactional
@Service
public class Tb_resultquizServiceImpl implements Tb_resultquizService {

    @Autowired
    Tb_resultquizDao tb_resultquizDao;

    @Override
    public List<Tb_resultQuizDto> getData() {
        List<Tb_resultQuizDto> listData = new ArrayList<>();
        List<Tb_resultquizModel> listModel = tb_resultquizDao.getData();
        if (listModel.size() > 0) {
            for (Tb_resultquizModel model : listModel) {
                Tb_resultQuizDto dto = new Tb_resultQuizDto();
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
    public void saveData(Tb_resultQuizDto dto) {
        Tb_resultquizModel model = new Tb_resultquizModel();
        try {
            model.setId(dto.getId());
            model.setId_category(dto.getId_category());
            model.setId_colleger(dto.getId_colleger());
            model.setId_matery(dto.getId_matery());
            model.setIdknowledge(dto.getIdknowledge());
            model.setScore(dto.getScore());
            tb_resultquizDao.saveData(model);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteData(Integer id) {
        try {
            tb_resultquizDao.deleteData(id);
        } catch (Exception e) {

        }
    }

    @Override
    public void updateData(Tb_resultQuizDto dto) {
        Tb_resultquizModel model = new Tb_resultquizModel();
        try {
            model.setId(dto.getId());
            model.setId_category(dto.getId_category());
            model.setId_colleger(dto.getId_colleger());
            model.setId_matery(dto.getId_matery());
            model.setIdknowledge(dto.getIdknowledge());
            model.setScore(dto.getScore());
            tb_resultquizDao.updateData(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Tb_resultQuizDto getDataById(Integer id) {
        Tb_resultQuizDto dto = new Tb_resultQuizDto();
        List<Tb_resultquizModel> listModel = tb_resultquizDao.getDataById(id);
        if (listModel.size() > 0) {
            for (Tb_resultquizModel model : listModel) {
                dto = new Tb_resultQuizDto();
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
