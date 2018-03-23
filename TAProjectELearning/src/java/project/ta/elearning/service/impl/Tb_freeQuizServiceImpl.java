/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ta.elearning.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.ta.elearning.dao.Tb_freeQuizDao;
import project.ta.elearning.dto.Tb_freeQuizDto;
import project.ta.elearning.model.Tb_freeQuizModel;
import project.ta.elearning.service.Tb_freeQuizService;

/**
 *
 * @author Sou
 */
@Transactional
@Service
public class Tb_freeQuizServiceImpl implements Tb_freeQuizService {
    
    
    @Autowired
    Tb_freeQuizDao tb_freeQuizDao;

    @Override
    public List<Tb_freeQuizDto> getData() {
        Tb_freeQuizDto dto = new Tb_freeQuizDto();
        List<Tb_freeQuizDto> listData = new ArrayList<>();
        List<Tb_freeQuizModel> listModel = tb_freeQuizDao.getData();
        if (listModel.size() > 0) {
            for (Tb_freeQuizModel model : listModel) {
                dto = new Tb_freeQuizDto();
                dto.setId(model.getId());
                dto.setFree_quiz(model.getFree_quiz());
                dto.setAnswer(model.getAnswer());
                dto.setTimeopen(model.getTimeopen());
                dto.setTimeclose(model.getTimeclose());
                dto.setTimelimit(model.getTimelimit());
                dto.setTimecreated(model.getTimecreated());
                dto.setTimemodified(model.getTimemodified());
                dto.setId_course(model.getId_course());
                dto.setId_materi(model.getId_materi());
                dto.setId_level(model.getId_level());
                listData.add(dto);
            }
        }
        return listData;
    }

    @Override
    public void saveData(Tb_freeQuizDto dto) {
        Tb_freeQuizModel model = new Tb_freeQuizModel();
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            String currDate = dateFormat.format(date);
            model.setId(dto.getId());
            model.setFree_quiz(dto.getFree_quiz());
            model.setAnswer(dto.getAnswer());
            model.setTimeopen(dto.getTimeopen());
            model.setTimeclose(dto.getTimeclose());
            model.setTimelimit(dto.getTimelimit());
            model.setTimecreated(currDate);
            model.setTimemodified(currDate);
            model.setId_course(dto.getId_course());
            model.setId_materi(dto.getId_materi());
            model.setId_level(dto.getId_level());
            tb_freeQuizDao.saveData(model);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteData(Integer id) {
        try {
            tb_freeQuizDao.deleteData(id);
        } catch (Exception e) {
        }
    }

    @Override
    public void updateData(Tb_freeQuizDto dto) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String currDate = dateFormat.format(date);
        Tb_freeQuizModel model = new Tb_freeQuizModel();
        try {
            model.setId(dto.getId());
            model.setFree_quiz(dto.getFree_quiz());
            model.setAnswer(dto.getAnswer());
            model.setTimeopen(dto.getTimeopen());
            model.setTimeclose(dto.getTimeclose());
            model.setTimelimit(dto.getTimelimit());
            model.setTimecreated(dto.getTimecreated());
            model.setTimemodified(currDate);
            model.setId_course(dto.getId_course());
            model.setId_materi(dto.getId_materi());
            model.setId_level(dto.getId_level());
            tb_freeQuizDao.updateData(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Tb_freeQuizDto getDataById(Integer id) {
        Tb_freeQuizDto dto = new Tb_freeQuizDto();
        List<Tb_freeQuizModel> listModel = tb_freeQuizDao.getDataById(id);
        if (listModel.size() > 0) {
            for (Tb_freeQuizModel model : listModel) {
                dto = new Tb_freeQuizDto();
                dto.setId(model.getId());
                dto.setFree_quiz(model.getFree_quiz());
                dto.setAnswer(model.getAnswer());
                dto.setTimeopen(model.getTimeopen());
                dto.setTimeclose(model.getTimeclose());
                dto.setTimelimit(model.getTimelimit());
                dto.setTimecreated(model.getTimecreated());
                dto.setTimemodified(model.getTimemodified());
                dto.setId_course(model.getId_course());
                dto.setId_materi(model.getId_materi());
                dto.setId_level(model.getId_level());
            }
        }
        return dto;
    }

    @Override
    public List<Tb_freeQuizDto> getData(String cari) {
        Tb_freeQuizDto dto = new Tb_freeQuizDto();
        List<Tb_freeQuizDto> listData = new ArrayList<>();
        List<Tb_freeQuizModel> listModel = tb_freeQuizDao.getData(cari);
        if (listModel.size() > 0) {
            for (Tb_freeQuizModel model : listModel) {
                dto = new Tb_freeQuizDto();
                dto.setId(model.getId());
                dto.setFree_quiz(model.getFree_quiz());
                dto.setAnswer(model.getAnswer());
                dto.setTimeopen(model.getTimeopen());
                dto.setTimeclose(model.getTimeclose());
                dto.setTimelimit(model.getTimelimit());
                dto.setTimecreated(model.getTimecreated());
                dto.setTimemodified(model.getTimemodified());
                dto.setId_course(model.getId_course());
                dto.setId_materi(model.getId_materi());
                dto.setId_level(model.getId_level());
                listData.add(dto);
            }
        }
        return listData;
    }

}
