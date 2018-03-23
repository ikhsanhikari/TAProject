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
import project.ta.elearning.dao.Tb_weeklyQuizDao;
import project.ta.elearning.dto.Tb_weeklyQuizDto;
import project.ta.elearning.model.Tb_weeklyQuizModel;
import project.ta.elearning.service.Tb_weeklyQuizService;

/**
 *
 * @author Sou
 */
@Transactional
@Service
public class Tb_weeklyQuizServiceImpl implements Tb_weeklyQuizService {

    @Autowired
    Tb_weeklyQuizDao tb_weeklyQuizDao;

    @Override
    public List<Tb_weeklyQuizDto> getData() {
        Tb_weeklyQuizDto dto = new Tb_weeklyQuizDto();
        List<Tb_weeklyQuizDto> listData = new ArrayList<>();
        List<Tb_weeklyQuizModel> listModel = tb_weeklyQuizDao.getData();
        if (listModel.size() > 0) {
            for (Tb_weeklyQuizModel model : listModel) {
                dto = new Tb_weeklyQuizDto();
                dto.setId(model.getId());
                dto.setWeekly_quiz(model.getWeekly_quiz());
                dto.setAnswer(model.getAnswer());
                dto.setTimeopen(model.getTimeopen());
                dto.setTimeclose(model.getTimeclose());
                dto.setTimelimit(model.getTimelimit());
                dto.setTimecreated(model.getTimecreated());
                dto.setTimemodified(model.getTimemodified());
                dto.setId_course(model.getId_course());
                dto.setId_materi(model.getId_materi());
                listData.add(dto);
            }
        }
        return listData;
    }

    @Override
    public void saveData(Tb_weeklyQuizDto dto) {
        Tb_weeklyQuizModel model = new Tb_weeklyQuizModel();
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            String currDate = dateFormat.format(date);
            model.setId(dto.getId());
            model.setWeekly_quiz(dto.getWeekly_quiz());
            model.setAnswer(dto.getAnswer());
            model.setTimeopen(dto.getTimeopen());
            model.setTimeclose(dto.getTimeclose());
            model.setTimelimit(dto.getTimelimit());
            model.setTimecreated(currDate);
            model.setTimemodified(currDate);
            model.setId_course(dto.getId_course());
            model.setId_materi(dto.getId_materi());
            tb_weeklyQuizDao.saveData(model);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteData(Integer id) {
        try {
            tb_weeklyQuizDao.deleteData(id);
        } catch (Exception e) {
        }
    }

    @Override
    public void updateData(Tb_weeklyQuizDto dto) {
        Tb_weeklyQuizModel model = new Tb_weeklyQuizModel();
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            String currDate = dateFormat.format(date);
            model.setId(dto.getId());
            model.setWeekly_quiz(dto.getWeekly_quiz());
            model.setAnswer(dto.getAnswer());
            model.setTimeopen(dto.getTimeopen());
            model.setTimeclose(dto.getTimeclose());
            model.setTimelimit(dto.getTimelimit());
            model.setTimecreated(dto.getTimecreated());
            model.setTimemodified(currDate);
            model.setId_course(dto.getId_course());
            model.setId_materi(dto.getId_materi());
            tb_weeklyQuizDao.updateData(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Tb_weeklyQuizDto getDataById(Integer id) {
        Tb_weeklyQuizDto dto = new Tb_weeklyQuizDto();
        List<Tb_weeklyQuizModel> listModel = tb_weeklyQuizDao.getDataById(id);
        if (listModel.size() > 0) {
            for (Tb_weeklyQuizModel model : listModel) {
                dto = new Tb_weeklyQuizDto();
                dto.setId(model.getId());
                dto.setWeekly_quiz(model.getWeekly_quiz());
                dto.setAnswer(model.getAnswer());
                dto.setTimeopen(model.getTimeopen());
                dto.setTimeclose(model.getTimeclose());
                dto.setTimelimit(model.getTimelimit());
                dto.setTimecreated(model.getTimecreated());
                dto.setTimemodified(model.getTimemodified());
                dto.setId_course(model.getId_course());
                dto.setId_materi(model.getId_materi());
            }
        }
        return dto;
    }

    @Override
    public List<Tb_weeklyQuizDto> getData(String cari) {
        Tb_weeklyQuizDto dto = new Tb_weeklyQuizDto();
        List<Tb_weeklyQuizDto> listData = new ArrayList<>();
        List<Tb_weeklyQuizModel> listModel = tb_weeklyQuizDao.getData(cari);
        if (listModel.size() > 0) {
            for (Tb_weeklyQuizModel model : listModel) {
                dto = new Tb_weeklyQuizDto();
                dto.setId(model.getId());
                dto.setWeekly_quiz(model.getWeekly_quiz());
                dto.setAnswer(model.getAnswer());
                dto.setTimeopen(model.getTimeopen());
                dto.setTimeclose(model.getTimeclose());
                dto.setTimelimit(model.getTimelimit());
                dto.setTimecreated(model.getTimecreated());
                dto.setTimemodified(model.getTimemodified());
                dto.setId_course(model.getId_course());
                dto.setId_materi(model.getId_materi());
                listData.add(dto);
            }
        }
        return listData;
    }

}
