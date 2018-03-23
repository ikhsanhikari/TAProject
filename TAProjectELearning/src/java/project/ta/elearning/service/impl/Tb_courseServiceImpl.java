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
import project.ta.elearning.dao.Tb_courseDao;
import project.ta.elearning.dto.Tb_courseDto;
import project.ta.elearning.model.Tb_courseModel;
import project.ta.elearning.service.Tb_courseService;

/**
 *
 * @author Sou
 */
@Transactional
@Service
public class Tb_courseServiceImpl implements Tb_courseService {

    @Autowired
    Tb_courseDao tb_courseDao;

    @Override
    public void saveData(Tb_courseDto courseDto) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            String currDate = dateFormat.format(date);
            Tb_courseModel courseModel = new Tb_courseModel();
            courseModel.setId(courseDto.getId());
            courseModel.setCategory(courseDto.getCategory());
            courseModel.setFullname(courseDto.getFullname());
            courseModel.setShortname(courseDto.getShortname());
            courseModel.setIdnumber(courseDto.getIdnumber());
            courseModel.setFormat(courseDto.getFormat());
            courseModel.setStartdate(courseDto.getStartdate());
            courseModel.setTimecreated(currDate);
            courseModel.setTimemodified(currDate);
            tb_courseDao.saveData(courseModel);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Override
    public List<Tb_courseDto> getData() {
        List<Tb_courseDto> listDto = new ArrayList<>();
        List<Tb_courseModel> listModel = tb_courseDao.getData();
        if (listModel.size() > 0) {
            for (Tb_courseModel list : listModel) {
                Tb_courseDto courseDto = new Tb_courseDto();
                courseDto.setId(list.getId());
                courseDto.setCategory(list.getCategory());
                courseDto.setFullname(list.getFullname());
                courseDto.setShortname(list.getShortname());
                courseDto.setIdnumber(list.getIdnumber());
                courseDto.setFormat(list.getFormat());
                courseDto.setStartdate(list.getStartdate());
                courseDto.setTimecreated(list.getTimecreated());
                courseDto.setTimemodified(list.getTimemodified());
                listDto.add(courseDto);
            }
        }
        return listDto;
    }

    @Override
    public void deleteData(Integer id) {
        try {
            tb_courseDao.deleteData(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateData(Tb_courseDto courseDto) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            String currDate = dateFormat.format(date);
            Tb_courseModel courseModel = new Tb_courseModel();
            courseModel.setId(courseDto.getId());
            courseModel.setCategory(courseDto.getCategory());
            courseModel.setFullname(courseDto.getFullname());
            courseModel.setShortname(courseDto.getShortname());
            courseModel.setIdnumber(courseDto.getIdnumber());
            courseModel.setFormat(courseDto.getFormat());
            courseModel.setStartdate(courseDto.getStartdate());
            courseModel.setTimecreated(courseDto.getTimecreated());
            courseModel.setTimemodified(currDate);
            tb_courseDao.updateData(courseModel);
        } catch (Exception e) {
        }

    }

    @Override
    public Tb_courseDto getDataById(Integer id) {
        Tb_courseDto courseDto = new Tb_courseDto();
        List<Tb_courseModel> listModel = tb_courseDao.getDataById(id);
        if (listModel.size() > 0) {
            for (Tb_courseModel list : listModel) {
                courseDto = new Tb_courseDto();
                courseDto.setId(list.getId());
                courseDto.setCategory(list.getCategory());
                courseDto.setFullname(list.getFullname());
                courseDto.setShortname(list.getShortname());
                courseDto.setIdnumber(list.getIdnumber());
                courseDto.setFormat(list.getFormat());
                courseDto.setStartdate(list.getStartdate());
                courseDto.setTimecreated(list.getTimecreated());
                courseDto.setTimemodified(list.getTimemodified());
            }
        }
        return courseDto;

    }

    @Override
    public List<Tb_courseDto> getData(String cari) {
        List<Tb_courseDto> listDto = new ArrayList<>();
        List<Tb_courseModel> listModel = tb_courseDao.getData(cari);
        if (listModel.size() > 0) {
            for (Tb_courseModel list : listModel) {
                Tb_courseDto courseDto = new Tb_courseDto();
                courseDto.setId(list.getId());
                courseDto.setCategory(list.getCategory());
                courseDto.setFullname(list.getFullname());
                courseDto.setShortname(list.getShortname());
                courseDto.setIdnumber(list.getIdnumber());
                courseDto.setFormat(list.getFormat());
                courseDto.setStartdate(list.getStartdate());
                courseDto.setTimecreated(list.getTimecreated());
                courseDto.setTimemodified(list.getTimemodified());
                listDto.add(courseDto);
            }
        }
        return listDto;
    }

}
