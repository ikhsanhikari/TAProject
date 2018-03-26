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
import project.ta.elearning.dao.Tb_quizDao;
import project.ta.elearning.dto.Tb_quizDto;
import project.ta.elearning.dto.Tb_resultExerciseDto;
import project.ta.elearning.model.Tb_quizModel;
import project.ta.elearning.model.Tb_resultExcerciseModel;
import project.ta.elearning.service.Tb_quizService;

/**
 *
 * @author Sou
 */
@Transactional
@Service
public class Tb_quizServiceImpl implements Tb_quizService {

    @Autowired
    Tb_quizDao tb_quizDao;

    @Override
    public List<Tb_quizDto> getData() {
        List<Tb_quizDto> listData = new ArrayList<>();
        List<Object[]> listModel = tb_quizDao.getQuizAll();
        if (listModel.size() > 0) {
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
        if (listModel.size() > 0) {
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
        if (listModel.size() > 0) {
            for (Object[] obj : listModel) {
                Tb_quizDto dto = new Tb_quizDto();
                dto.setId(Integer.parseInt(obj[0].toString()));
                dto.setAnswer(obj[1].toString());
                dto.setId_answer(Integer.parseInt(obj[2].toString()));
                listData.add(dto);
            }
        }
        return listData;
    }

    @Override
    public Integer saveQuiz(Integer id, Integer id_collerger, Integer id_matery, Integer id_qa, Integer status) {
        try {
        } catch (Exception e) {
        }
        return 1;
    }

    @Override
    public void saveData(Tb_resultExerciseDto dto) {
        Tb_resultExcerciseModel model = new Tb_resultExcerciseModel();
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            String currDate = dateFormat.format(date);
            model.setId(1);
            model.setId_collerger(dto.getId_collerger());
            model.setId_matery(1);
            model.setId_qa(dto.getId_qa());
            model.setShort_answer(dto.getShort_answer());
            model.setStatus(dto.getStatus());
            model.setTimeclose(currDate);
            model.setTimecreated(currDate);
            model.setTimemodified(currDate);
            model.setTimeopen(currDate);
            tb_quizDao.saveData(model);
        } catch (Exception e) {
        }
    }

    @Override
    public List<Tb_quizDto> getDataHistoris(Integer id) {
        String benarsalah = "";
        String jenissoal="";
        List<Tb_quizDto> listData = new ArrayList<>();
        List<Object[]> listModel = tb_quizDao.getHistorisExercise(id);
        if (listModel.size() > 0) {
            for (Object[] obj : listModel) {
                Tb_quizDto dto = new Tb_quizDto();
//                dto.setId(Integer.parseInt(obj[0].toString()));
                benarsalah = Integer.parseInt(obj[4].toString())==1?"Benar":"Salah";
                jenissoal = Integer.parseInt(obj[3].toString())==1?"Short Answer":"Choice";
                
                dto.setNama(obj[1].toString());
                dto.setSoal(obj[2].toString());
                dto.setJenis_soal(jenissoal);
                dto.setBenar_salah(benarsalah);
                dto.setJawaban(obj[5].toString());
                listData.add(dto);
            }
        }
        return listData;
    }

    @Override
    public List<Tb_quizDto> getJawabanBenar(Integer id) {
        List<Tb_quizDto> listData = new ArrayList<>();
        List<Object[]> listModel = tb_quizDao.getJawabanBenar(id);
        if (listModel.size() > 0) {
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
    public List<Tb_quizDto> getQuizRandomByLevel(int idLevel) {
        List<Tb_quizDto> listData = new ArrayList<>();
        List<Object[]> listModel = tb_quizDao.getQuizRandomByLevel(idLevel);
        if (listModel.size() > 0) {
            for (Object[] obj : listModel) {
                Tb_quizDto dto = new Tb_quizDto();
                dto.setId(Integer.parseInt(obj[0].toString()));
                dto.setName(obj[1].toString());
                dto.setId_jenis_soal(Integer.parseInt(obj[2].toString()));
                dto.setId_qa(Integer.parseInt(obj[4].toString()));
                listData.add(dto);
            }
        }
        return listData;
    }

    @Override
    public int getTotalSoalByLevel(int idLevel) {
        return tb_quizDao.getTotalSoalByLevel(idLevel);
    }

    @Override
    public List<Tb_quizDto> getStatus(Integer id_quiz, Integer id_answer) {
        List<Tb_quizDto> listData = new ArrayList<>();
        List<Object[]> listModel = tb_quizDao.getStatus(id_quiz, id_answer);
        if (listModel.size() > 0) {
            for (Object[] obj : listModel) {
                Tb_quizDto dto = new Tb_quizDto();
                dto.setId(Integer.parseInt(obj[0].toString()));
                dto.setId_status(Integer.parseInt(obj[1].toString()));
//                dto.setId_answer(Integer.parseInt(obj[2].toString()));
                listData.add(dto);
            }
        }
        return listData;
    }

}
