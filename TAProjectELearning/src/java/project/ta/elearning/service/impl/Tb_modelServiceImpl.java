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
import project.ta.elearning.dao.Tb_modelDao;
import project.ta.elearning.dto.Tb_modelDto;
import project.ta.elearning.model.Tb_modelModel;
import project.ta.elearning.service.Tb_modelService;

/**
 *
 * @author Sou
 */
@Transactional
@Service
public class Tb_modelServiceImpl implements Tb_modelService {

    @Autowired
    Tb_modelDao tb_modelDao;

    @Override
    public List<Tb_modelDto> getData() {
        List<Tb_modelDto> listData = new ArrayList<>();
        List<Tb_modelModel> listModel = tb_modelDao.getData();
        if (listModel.size() > 0) {
            for (Tb_modelModel model : listModel) {
                Tb_modelDto dto = new Tb_modelDto();
                dto.setId(model.getId());
                dto.setId_user(model.getId_user());
                dto.setId_matery(model.getId_matery());
                dto.setKnowledge_sebelum(model.getKnowledge_sebelum());
                dto.setKnowledge_sesudah(model.getKnowledge_sesudah());
                dto.setScore_sebelum(model.getScore_sebelum());
                dto.setScore_sesudah(model.getScore_sesudah());
                listData.add(dto);
            }
        }

        return listData;
    }

    @Override
    public void saveData(Tb_modelDto dto) {
        Tb_modelModel model = new Tb_modelModel();
        try {
            model.setId(dto.getId());
            model.setId_user(dto.getId_user());
            model.setId_matery(dto.getId_matery());
            model.setKnowledge_sebelum(dto.getKnowledge_sebelum());
            model.setKnowledge_sesudah(dto.getKnowledge_sesudah());
            model.setScore_sebelum(dto.getScore_sebelum());
            model.setScore_sesudah(dto.getScore_sesudah());
            tb_modelDao.saveData(model);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteData(Integer id) {
        try {
            tb_modelDao.deleteData(id);
        } catch (Exception e) {

        }
    }

    @Override
    public void updateData(Tb_modelDto dto) {
        Tb_modelModel model = new Tb_modelModel();
        try {
            model.setId(dto.getId());
            model.setId_user(dto.getId_user());
            model.setId_matery(dto.getId_matery());
            model.setKnowledge_sebelum(dto.getKnowledge_sebelum());
            model.setKnowledge_sesudah(dto.getKnowledge_sesudah());
            model.setScore_sebelum(dto.getScore_sebelum());
            model.setScore_sesudah(dto.getScore_sesudah());
            tb_modelDao.updateData(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Tb_modelDto getDataById(Integer id) {
        Tb_modelDto dto = new Tb_modelDto();
        List<Tb_modelModel> listModel = tb_modelDao.getDataById(id);
        if (listModel.size() > 0) {
            for (Tb_modelModel model : listModel) {
                dto = new Tb_modelDto();
                dto.setId(model.getId());
                dto.setId_user(model.getId_user());
                dto.setId_matery(model.getId_matery());
                dto.setKnowledge_sebelum(model.getKnowledge_sebelum());
                dto.setKnowledge_sesudah(model.getKnowledge_sesudah());
                dto.setScore_sebelum(model.getScore_sebelum());
                dto.setScore_sesudah(model.getScore_sesudah());
            }
        }

        return dto;
    }

    @Override
    public int cekGoodLearner(int id) {
        return tb_modelDao.getDataById(id).size();
    }

}
