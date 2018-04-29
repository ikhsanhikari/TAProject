/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ta.elearning.service.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.ta.elearning.dao.Tb_resultEssayDao;
import project.ta.elearning.dto.Tb_resultEssayDto;
import project.ta.elearning.dto.Tb_quizDto;
import project.ta.elearning.dto.Tb_resultExerciseDto;
import project.ta.elearning.model.Tb_resultEssayModel;
import project.ta.elearning.service.Tb_resultEssayService;

/**
 *
 * @author Sou
 */
@Transactional
@Service
public class Tb_resultEssayServiceImpl implements Tb_resultEssayService {

    @Autowired
    Tb_resultEssayDao tb_resultEssayDao;

    @Override
    public List<Tb_resultEssayDto> getData() {
        List<Tb_resultEssayDto> listData = new ArrayList<>();
        List<Tb_resultEssayModel> listModel = tb_resultEssayDao.getData();
        if (listModel.size() > 0) {
            for (Tb_resultEssayModel model : listModel) {
                Tb_resultEssayDto dto = new Tb_resultEssayDto();
                dto.setId(model.getId());
                dto.setId_user(model.getId_user());
                dto.setId_essay(model.getId_essay());
//                dto.setJawaban(model.getJawaban());
                dto.setNilai(model.getNilai());
                dto.setLatihan_ke(model.getLatihan_ke());
                dto.setId_korektor(model.getId_korektor());
                dto.setTimeupdate(model.getTimeupdate());
                dto.setTimeopen(model.getTimeopen());
                listData.add(dto);
            }
        }

        return listData;
    }

    @Override
    public void saveData(Tb_resultEssayDto dto) {
        Tb_resultEssayModel model = new Tb_resultEssayModel();
        try {
            model.setId(dto.getId());
            model.setId_user(dto.getId_user());
            model.setId_essay(dto.getId_essay());
//            model.setJawaban(dto.getJawaban());
            model.setNilai(dto.getNilai());
            model.setLatihan_ke(dto.getLatihan_ke());
            model.setId_korektor(dto.getId_korektor());
            model.setTimeopen(dto.getTimeopen());
            model.setTimeupdate(dto.getTimeupdate());
            tb_resultEssayDao.saveData(model);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteData(Integer id) {
        try {
            tb_resultEssayDao.deleteData(id);
        } catch (Exception e) {

        }
    }

    @Override
    public void updateData(Tb_resultEssayDto dto) {
        Tb_resultEssayModel model = new Tb_resultEssayModel();
        try {
            model.setId(dto.getId());
            model.setId_user(dto.getId_user());
            model.setId_essay(dto.getId_essay());
            model.setJawaban(dto.getNamafile());
            model.setNilai(dto.getNilai());
            model.setLatihan_ke(dto.getLatihan_ke());
            model.setId_korektor(dto.getId_korektor());
            model.setTimeopen(dto.getTimeopen());
            model.setTimeupdate(dto.getTimeupdate());
            tb_resultEssayDao.updateData(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Tb_resultEssayDto getDataById(Integer id) {
        Tb_resultEssayDto dto = new Tb_resultEssayDto();
        List<Tb_resultEssayModel> listModel = tb_resultEssayDao.getDataById(id);
        if (listModel.size() > 0) {
            for (Tb_resultEssayModel model : listModel) {
                dto = new Tb_resultEssayDto();
                dto.setId(model.getId());
                dto.setId_user(model.getId_user());
                dto.setId_essay(model.getId_essay());
//                dto.setJawaban(model.getJawaban());
                dto.setNilai(model.getNilai());
                dto.setLatihan_ke(model.getLatihan_ke());
                dto.setId_korektor(model.getId_korektor());
                dto.setTimeupdate(model.getTimeupdate());
                dto.setTimeopen(model.getTimeopen());
            }
        }

        return dto;
    }

    @Override
    public List<Tb_resultEssayDto> getDataNative() {
        List<Tb_resultEssayDto> listData = new ArrayList<>();
        List<Object[]> listModel = tb_resultEssayDao.getDataNative();
        if (listModel.size() > 0) {
            for (Object[] obj : listModel) {
                Tb_resultEssayDto dto = new Tb_resultEssayDto();
                dto.setId(Integer.parseInt(obj[0].toString()));
                dto.setMahasiswa(obj[1].toString());
                dto.setId_essay(Integer.parseInt(obj[2].toString()));
                dto.setEssay(obj[3].toString());
                dto.setNamafile(obj[4].toString());
                dto.setNilai(Integer.parseInt(obj[5].toString()));
                dto.setLatihan_ke(obj[6].toString());
//                dto.setKorektor(obj[6].toString());
                dto.setTimeopen(obj[7].toString());
                dto.setTimeupdate(obj[8].toString());
                listData.add(dto);
            }
        }
        return listData;
    }

    
    @Override
    public void uploadData(Tb_resultExerciseDto dto) {
        if (!dto.getJawaban().isEmpty()) {
            try {
                byte[] bytes = dto.getJawaban().getBytes();
                
                // Creating the directory to store file
                String rootPath = "D:\\upload_foto";
                Tb_resultEssayModel uploadModel= new Tb_resultEssayModel();
                uploadModel.setId(1);
                uploadModel.setId_essay(1);
                uploadModel.setId_korektor(1);
                uploadModel.setId_user(1);
                uploadModel.setNilai(1);
//                uploadModel.setJawaban(dto.getJawaban());
                uploadModel.setPathName(rootPath+"/"+dto.getJawaban().getOriginalFilename());
                tb_resultEssayDao.uploadData(uploadModel);
                File dir = new File(rootPath);
                if (!dir.exists())
                        dir.mkdirs();
                
                File serverFile = new File(dir.getAbsolutePath()
                                + File.separator + dto.getJawaban().getOriginalFilename());
                BufferedOutputStream stream = new BufferedOutputStream(
                                new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();                  

                //return "sukses upload file" + dto.getFile().getName();
            } catch (Exception e) {
                  //  return "gagal upload " + dto.getFile().getName() + " => " + e.getMessage();
            }
        } else {
                //return "file kosong " + dto.getFile().getName();
        }
    }

    @Override
    public Tb_resultEssayDto getDataByIdNative(Integer id) {
//        List<Tb_resultEssayDto> listData = new ArrayList<>();
        List<Object[]> listModel = tb_resultEssayDao.getDataByIdNative(id);
        Tb_resultEssayDto dto = new Tb_resultEssayDto();
        if (listModel.size() > 0) {
            for (Object[] obj : listModel) {
                dto = new Tb_resultEssayDto();
                dto.setMahasiswa(obj[0].toString());
                dto.setId_essay(Integer.parseInt(obj[1].toString()));
                dto.setEssay(obj[2].toString());
                dto.setNamafile(obj[3].toString());
                dto.setNilai(Integer.parseInt(obj[4].toString()));
                dto.setLatihan_ke(obj[5].toString());
//                dto.setKorektor(obj[6].toString());
                dto.setTimeopen(obj[6].toString());
                dto.setTimeupdate(obj[7].toString());
//                listData.add(dto);
            }
        }
        return dto;
    }

}
