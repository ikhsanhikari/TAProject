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
import project.ta.elearning.dao.Tb_sessionDao;
import project.ta.elearning.dto.Tb_sessionDto;
import project.ta.elearning.model.Tb_sessionModel;
import project.ta.elearning.service.Tb_sessionService;

/**
 *
 * @author Sou
 */
@Transactional
@Service
public class Tb_sessionServiceImpl implements Tb_sessionService {

    @Autowired
    Tb_sessionDao tb_sessionDao;

    @Override
    public List<Tb_sessionDto> getData() {
        List<Tb_sessionDto> listData = new ArrayList<>();
        List<Tb_sessionModel> listModel = tb_sessionDao.getData();
        if (listModel.size() > 0) {
            for (Tb_sessionModel model : listModel) {
                Tb_sessionDto dto = new Tb_sessionDto();
                dto.setId(model.getId());
                dto.setUserid(model.getUserid());
                dto.setFirstip(model.getFirstip());
                dto.setFirstip(model.getLastip());
                dto.setTimecreated(model.getTimecreated());
                dto.setUsername(model.getUsername());
                dto.setTimeout(model.getTimeout());
                listData.add(dto);
            }
        }

        return listData;
    }

    @Override
    public void saveData(Tb_sessionDto dto) {
        Tb_sessionModel model = new Tb_sessionModel();
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            String currDate = dateFormat.format(date);
            model.setId(1);
            model.setUserid(dto.getUserid());
            model.setFirstip(dto.getFirstip());
            model.setLastip(dto.getLastip());
            model.setTimecreated(currDate);
            model.setUsername(dto.getUsername());
//            model.setTimeout(currDate);
            tb_sessionDao.saveData(model);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteData(Integer id) {
        try {
            tb_sessionDao.deleteData(id);
        } catch (Exception e) {

        }
    }

    @Override
    public void updateData(Tb_sessionDto dto) {
        Tb_sessionModel model = new Tb_sessionModel();
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            String currDate = dateFormat.format(date);
            model.setId(model.getId());
            model.setUserid(dto.getUserid());
            model.setFirstip(dto.getFirstip());
            model.setLastip(dto.getLastip());
            model.setTimecreated(currDate);
            tb_sessionDao.updateData(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Tb_sessionDto getDataById(Integer id) {
        Tb_sessionDto dto = new Tb_sessionDto();
        List<Tb_sessionModel> listModel = tb_sessionDao.getDataById(id);
        if (listModel.size() > 0) {
            for (Tb_sessionModel model : listModel) {
                dto = new Tb_sessionDto();
                dto.setId(model.getId());
                dto.setUserid(model.getUserid());
                dto.setFirstip(model.getFirstip());
                dto.setFirstip(model.getLastip());
                dto.setTimecreated(model.getTimecreated());
            }
        }

        return dto;
    }

}
