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
import project.ta.elearning.dao.Tb_quizDao;
import project.ta.elearning.dto.Tb_quizDto;
import project.ta.elearning.model.Tb_quizModel;
import project.ta.elearning.service.Tb_quizService;

/**
 *
 * @author Sou
 */
@Transactional
@Service
public class Tb_quizServiceImpl implements Tb_quizService{

    @Autowired
    Tb_quizDao tb_quizDao;
    
    @Override
    public List<Tb_quizDto> getData() {
        List<Tb_quizDto> listData = new ArrayList<>();
        List<Object[]> listModel = tb_quizDao.getQuizAll();
        if(listModel.size()>0){
            for (Object[] obj : listModel) {
                Tb_quizDto dto = new Tb_quizDto();
                dto.setId(Integer.parseInt(obj[0].toString()));
                dto.setName(obj[1].toString());
                dto.setId_jenis_soal(Integer.parseInt(obj[2].toString()));
                listData.add(dto);
            }
        }
        return listData;
    }

    @Override
    public void saveData(Tb_quizDto dto) {
        Tb_quizModel model = new Tb_quizModel();
        try {
            model.setId(dto.getId());
//            model.setLevel(dto.getLevel());
            tb_quizDao.saveData(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void deleteData(Integer id) {
        try {
            tb_quizDao.deleteData(id);
        } catch (Exception e) {
            
        }
    }

    @Override
    public void updateData(Tb_quizDto dto) {
        Tb_quizModel model = new Tb_quizModel();
        try {
            model.setId(dto.getId());
//            model.setLevel(dto.getLevel());
            tb_quizDao.updateData(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Tb_quizDto getDataById(Integer id) {
        Tb_quizDto dto = new Tb_quizDto();
        List<Tb_quizModel> listModel = tb_quizDao.getDataById(id);
        if(listModel.size()>0){
            for (Tb_quizModel model : listModel) {
                dto = new Tb_quizDto();
                dto.setId(model.getId());
//                dto.setLevel(model.getLevel());
            }
        }
        
        return dto;
    }

    @Override
    public List<Tb_quizDto> getAnswerAllByQuiz(Integer id) {
        List<Tb_quizDto> listData = new ArrayList<>();
        List<Object[]> listModel = tb_quizDao.getAnswerAllByQuiz(id);
        if(listModel.size()>0){
            for (Object[] obj : listModel) {
                Tb_quizDto dto = new Tb_quizDto();
                dto.setId(Integer.parseInt(obj[0].toString()));
                dto.setAnswer(obj[1].toString());
                listData.add(dto);
            }
        }
        return listData;
    }

    @Override
    public Integer saveQuiz(Integer id, Integer id_collerger, Integer id_matery, Integer id_qa,Integer status ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
