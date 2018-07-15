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
import project.ta.elearning.dao.Tb_qaDao;
import project.ta.elearning.dto.Tb_qaDto;
import project.ta.elearning.dto.Tb_quizDto;
import project.ta.elearning.model.Tb_qaModel;
import project.ta.elearning.service.Tb_qaService;

/**
 *
 * @author Sou
 */
@Transactional
@Service
public class Tb_qaServiceImpl implements Tb_qaService {

    @Autowired
    Tb_qaDao tb_qaDao;

    @Override
    public List<Tb_qaDto> getData() {
        List<Tb_qaDto> listData = new ArrayList<>();
        List<Tb_qaModel> listModel = tb_qaDao.getData();
        if (listModel.size() > 0) {
            for (Tb_qaModel model : listModel) {
                Tb_qaDto dto = new Tb_qaDto();
                dto.setId(model.getId());
                dto.setId_quiz(model.getId_quiz());
                dto.setId_answers(model.getId_answers());
                dto.setId_status(model.getId_status());
                dto.setId_level(model.getId_level());
                dto.setId_jenis_soal(model.getId_jenis_soal());
                dto.setTimeopen(model.getTimeopen());
                dto.setTimeclose(model.getTimeclose());
                dto.setTimecreated(model.getTimecreated());
                dto.setTimemodified(model.getTimemodified());
                listData.add(dto);
            }
        }

        return listData;
    }

    @Override
    public void saveData(Tb_qaDto dto) {
        Tb_qaModel model = new Tb_qaModel();
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            String currDate = dateFormat.format(date);
            model.setId(dto.getId());
            model.setId_quiz(dto.getId_quiz());
            model.setId_answers(dto.getId_answers());
            model.setId_status(dto.getId_status());
            model.setId_level(dto.getId_level());
            model.setId_jenis_soal(dto.getId_jenis_soal());
            model.setTimeopen(currDate);
            model.setTimeclose(currDate);
            model.setTimecreated(currDate);
            model.setTimemodified(currDate);
            tb_qaDao.saveData(model);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteData(Integer id) {
        try {
            tb_qaDao.deleteData(id);
        } catch (Exception e) {

        }
    }

    @Override
    public void updateData(Tb_qaDto dto) {
        Tb_qaModel model = new Tb_qaModel();
        try {
            model.setId(dto.getId());
            model.setId_quiz(dto.getId_quiz());
            model.setId_answers(dto.getId_answers());
            model.setId_status(dto.getId_status());
            model.setId_level(dto.getId_level());
            model.setId_jenis_soal(dto.getId_jenis_soal());
            model.setTimeopen(dto.getTimeopen());
            model.setTimeclose(dto.getTimeclose());
            model.setTimecreated(dto.getTimecreated());
            model.setTimemodified(dto.getTimemodified());
            tb_qaDao.updateData(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Tb_qaDto getDataById(Integer id) {
        Tb_qaDto dto = new Tb_qaDto();
        List<Tb_qaModel> listModel = tb_qaDao.getDataById(id);
        if (listModel.size() > 0) {
            for (Tb_qaModel model : listModel) {
                dto = new Tb_qaDto();
                dto.setId(model.getId());
                dto.setId_quiz(model.getId_quiz());
                dto.setId_answers(model.getId_answers());
                dto.setId_status(model.getId_status());
                dto.setId_level(model.getId_level());
                dto.setId_jenis_soal(model.getId_jenis_soal());
                dto.setTimeopen(model.getTimeopen());
                dto.setTimeclose(model.getTimeclose());
                dto.setTimecreated(model.getTimecreated());
                dto.setTimemodified(model.getTimemodified());
            }
        }

        return dto;
    }

    @Override
    public List<Tb_quizDto> getDataNative() {
        List<Tb_quizDto> listData = new ArrayList<>();
        List<Object[]> listModel = tb_qaDao.getDataNative();
        if (listModel.size() > 0) {
            for (Object[] obj : listModel) {
                Tb_quizDto dto = new Tb_quizDto();
                dto.setId(Integer.parseInt(obj[0].toString()));
                dto.setName(obj[1].toString());
                dto.setAnswer(obj[2].toString());
                dto.setLevel(obj[3].toString());
                dto.setJenis_soal(obj[4].toString());
                listData.add(dto);
            }
        }
        return listData;
    }

}
