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
import project.ta.elearning.dao.Tb_userDao;
import project.ta.elearning.dto.Tb_userDto;
import project.ta.elearning.model.Tb_userModel;
import project.ta.elearning.service.Tb_modelService;
import project.ta.elearning.service.Tb_userService;

/**
 *
 * @author Sou
 */
@Transactional
@Service
public class Tb_userServiceImpl implements Tb_userService {

    @Autowired
    Tb_userDao tb_userDao;

    @Autowired
    Tb_modelService tb_modelService;

    @Override
    public void saveData(Tb_userDto userDto) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            String currDate = dateFormat.format(date);
            Tb_userModel userModel = new Tb_userModel();
            userModel.setId(1);
            userModel.setUsername(userDto.getUsername());
            userModel.setPassword(userDto.getPassword());
            userModel.setFirstname(userDto.getFirstname());
            userModel.setLastname(userDto.getLastname());
            userModel.setEmail(userDto.getEmail());
            userModel.setPhone1(userDto.getPhone1());
            userModel.setInstitution(userDto.getInstitution());
            userModel.setDepartment(userDto.getDepartment());
            userModel.setAddress(userDto.getAddress());
            userModel.setCity(userDto.getCity());
            userModel.setFirstaccess(userDto.getFirstaccess());
            userModel.setLastaccess(userDto.getLastaccess());
            userModel.setLastlogin(userDto.getLastlogin());
            userModel.setCurrentlogin(userDto.getCurrentlogin());
            userModel.setPicture(userDto.getPicture());
            userModel.setDescription(userDto.getDescription());
            userModel.setTimecreated(currDate);
            userModel.setTimemodified(currDate);
            userModel.setId_role(userDto.getId_role());
            userModel.setIdknowledge(0);
            if(userDto.getId_role()==3){ // 3 stands for student/colleger
                userModel.setDosen(userDto.getDosen());
            }else{
                userModel.setDosen(0);
            }
            tb_userDao.saveData(userModel);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Override
    public Integer loginUser(String username, String password) {
        List<Tb_userModel> listModel = tb_userDao.loginUser(username, password);
        return listModel.size();
    }

    @Override
    public Tb_userDto selectUser(String username, String password) {
        List<Tb_userDto> listDto = new ArrayList<>();
        List<Tb_userModel> listModel = tb_userDao.loginUser(username, password);
        Integer index = 0;
        Tb_userDto userDto = null;
        for (Tb_userModel lm : listModel) {
            userDto = new Tb_userDto();
            userDto.setId(lm.getId());
            userDto.setFirstname(lm.getFirstname());
            userDto.setLastname(lm.getLastname());
            userDto.setPassword(lm.getPassword());
            userDto.setUsername(lm.getUsername());
            userDto.setId_role(lm.getId_role());
        }
        return userDto;
    }

    @Override
    public List<Tb_userDto> getData() {
        List<Tb_userDto> listDto = new ArrayList<>();
        List<Tb_userModel> listModel = tb_userDao.getData();
        if (listModel.size() > 0) {
            for (Tb_userModel list : listModel) {
                Tb_userDto userDto = new Tb_userDto();
                userDto.setId(list.getId());
                userDto.setUsername(list.getUsername());
                userDto.setPassword(list.getPassword());
                userDto.setFirstname(list.getFirstname());
                userDto.setLastname(list.getLastname());
                userDto.setEmail(list.getEmail());
                userDto.setPhone1(list.getPhone1());
                userDto.setInstitution(list.getInstitution());
                userDto.setDepartment(list.getDepartment());
                userDto.setAddress(list.getAddress());
                userDto.setCity(list.getCity());
                userDto.setFirstaccess(list.getFirstaccess());
                userDto.setLastaccess(list.getLastaccess());
                userDto.setLastlogin(list.getLastlogin());
                userDto.setCurrentlogin(list.getCurrentlogin());
                userDto.setPicture(list.getPicture());
                userDto.setDescription(list.getDescription());
                userDto.setTimecreated(list.getTimecreated());
                userDto.setTimemodified(list.getTimemodified());
                userDto.setId_role(list.getId_role());
                listDto.add(userDto);
            }
        }
        return listDto;
    }

    @Override
    public void deleteData(Integer id) {
        try {
            tb_userDao.deleteData(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateData(Tb_userDto userDto) {
        Tb_userModel userModel = new Tb_userModel();
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            String currDate = dateFormat.format(date);
            userModel.setId(userDto.getId());
            userModel.setUsername(userDto.getUsername());
            userModel.setPassword(userDto.getPassword());
            userModel.setFirstname(userDto.getFirstname());
            userModel.setLastname(userDto.getLastname());
            userModel.setEmail(userDto.getEmail());
            userModel.setPhone1(userDto.getPhone1());
            userModel.setInstitution(userDto.getInstitution());
            userModel.setDepartment(userDto.getDepartment());
            userModel.setAddress(userDto.getAddress());
            userModel.setCity(userDto.getCity());
            userModel.setFirstaccess(userDto.getFirstaccess());
            userModel.setLastaccess(userDto.getLastaccess());
            userModel.setLastlogin(userDto.getLastlogin());
            userModel.setCurrentlogin(userDto.getCurrentlogin());
            userModel.setPicture(userDto.getPicture());
            userModel.setDescription(userDto.getDescription());
            userModel.setTimecreated(userDto.getTimecreated());
            userModel.setTimemodified(currDate);
            userModel.setId_role(userDto.getId_role());
            userModel.setIdknowledge(userDto.getIdknowledge());
            tb_userDao.updateData(userModel);
        } catch (Exception e) {

        }

    }

    @Override
    public Tb_userDto getDataById(Integer id) {
        Tb_userDto userDto = new Tb_userDto();
        List<Tb_userModel> listModel = tb_userDao.getDataById(id);
        if (listModel.size() > 0) {
            for (Tb_userModel list : listModel) {
                userDto = new Tb_userDto();
                userDto.setId(list.getId());
                userDto.setUsername(list.getUsername());
                userDto.setPassword(list.getPassword());
                userDto.setFirstname(list.getFirstname());
                userDto.setLastname(list.getLastname());
                userDto.setEmail(list.getEmail());
                userDto.setPhone1(list.getPhone1());
                userDto.setInstitution(list.getInstitution());
                userDto.setDepartment(list.getDepartment());
                userDto.setAddress(list.getAddress());
                userDto.setCity(list.getCity());
                userDto.setFirstaccess(list.getFirstaccess());
                userDto.setLastaccess(list.getLastaccess());
                userDto.setLastlogin(list.getLastlogin());
                userDto.setCurrentlogin(list.getCurrentlogin());
                userDto.setPicture(list.getPicture());
                userDto.setDescription(list.getDescription());
                userDto.setTimecreated(list.getTimecreated());
                userDto.setTimemodified(list.getTimemodified());
                userDto.setId_role(list.getId_role());
                userDto.setIdknowledge(list.getIdknowledge());
            }
        }
        return userDto;

    }

    @Override
    public List<Tb_userDto> getData(String cari) {
        List<Tb_userDto> listDto = new ArrayList<>();
        List<Tb_userModel> listModel = tb_userDao.getData(cari);
        if (listModel.size() > 0) {
            for (Tb_userModel list : listModel) {
                Tb_userDto userDto = new Tb_userDto();
                userDto.setId(list.getId());
                userDto.setUsername(list.getUsername());
                userDto.setPassword(list.getPassword());
                userDto.setFirstname(list.getFirstname());
                userDto.setLastname(list.getLastname());
                userDto.setEmail(list.getEmail());
                userDto.setPhone1(list.getPhone1());
                userDto.setInstitution(list.getInstitution());
                userDto.setDepartment(list.getDepartment());
                userDto.setAddress(list.getAddress());
                userDto.setCity(list.getCity());
                userDto.setFirstaccess(list.getFirstaccess());
                userDto.setLastaccess(list.getLastaccess());
                userDto.setLastlogin(list.getLastlogin());
                userDto.setCurrentlogin(list.getCurrentlogin());
                userDto.setPicture(list.getPicture());
                userDto.setDescription(list.getDescription());
                userDto.setTimecreated(list.getTimecreated());
                userDto.setTimemodified(list.getTimemodified());
                userDto.setId_role(list.getId_role());
                listDto.add(userDto);
            }
        }
        return listDto;
    }

    @Override
    public List<Tb_userDto> cekData(String cari) {
        List<Tb_userDto> listDto = new ArrayList<>();
        List<Tb_userModel> listModel = tb_userDao.getData(cari);
        if (listModel.size() > 0) {
            for (Tb_userModel list : listModel) {
                Tb_userDto userDto = new Tb_userDto();
                userDto.setId(list.getId());
                userDto.setUsername(list.getUsername());
                userDto.setPassword(list.getPassword());
                userDto.setFirstname(list.getFirstname());
                userDto.setLastname(list.getLastname());
                userDto.setEmail(list.getEmail());
                userDto.setPhone1(list.getPhone1());
                userDto.setInstitution(list.getInstitution());
                userDto.setDepartment(list.getDepartment());
                userDto.setAddress(list.getAddress());
                userDto.setCity(list.getCity());
                userDto.setFirstaccess(list.getFirstaccess());
                userDto.setLastaccess(list.getLastaccess());
                userDto.setLastlogin(list.getLastlogin());
                userDto.setCurrentlogin(list.getCurrentlogin());
                userDto.setPicture(list.getPicture());
                userDto.setDescription(list.getDescription());
                userDto.setTimecreated(list.getTimecreated());
                userDto.setTimemodified(list.getTimemodified());
                userDto.setId_role(list.getId_role());
                listDto.add(userDto);
            }
        }
        return listDto;
    }

    @Override
    public int getDataKnowledge(String username) {
        return tb_userDao.getDataKnowledge(username);
    }

    @Override
    public void updateKnowledgeUser(String username, int idKnowledge) {
        tb_userDao.updateKnowledgeUser(username, idKnowledge);
    }

    @Override
    public List<Tb_userDto> getDataMahasiswa() {
        List<Tb_userDto> listData = new ArrayList<>();
        List<Object[]> listModel = tb_userDao.getDataMahasiswa();
        String goodlearner = "";

        if (listModel.size() > 0) {
            for (Object[] obj : listModel) {
                Tb_userDto dto = new Tb_userDto();
                dto.setId(Integer.parseInt(obj[0].toString()));
                dto.setFirstname(obj[3].toString());
                dto.setPhone1(obj[6].toString());
                dto.setIdknowledge(Integer.parseInt(obj[20].toString()));
                if (tb_modelService.cekGoodLearner(dto.getId()) == 1) {
                    goodlearner = "Good Learner";
                } else {
                    goodlearner = "Non Good Learner";
                }
                dto.setGoodlearner(goodlearner);
                listData.add(dto);
            }
        }
        return listData;
    }

    @Override
    public List<Tb_userDto> getDataDosen() {
        List<Tb_userDto> listData = new ArrayList<>();
        List<Object[]> listModel = tb_userDao.getDataDosen();
        String goodlearner = "";

        if (listModel.size() > 0) {
            for (Object[] obj : listModel) {
                Tb_userDto dto = new Tb_userDto();
                dto.setId(Integer.parseInt(obj[0].toString()));
                dto.setFirstname(obj[3].toString());
                dto.setPhone1(obj[6].toString());
                dto.setIdknowledge(Integer.parseInt(obj[20].toString()));
                if (tb_modelService.cekGoodLearner(dto.getId()) == 1) {
                    goodlearner = "Good Learner";
                } else {
                    goodlearner = "Non Good Learner";
                }
                dto.setGoodlearner(goodlearner);
                listData.add(dto);
            }
        }
        return listData;
    }
    
    @Override
    public List<Tb_userDto> getDataMahasiswaBasedOnDosen(Integer dosen) {
        List<Tb_userDto> listData = new ArrayList<>();
        List<Object[]> listModel = tb_userDao.getDataMahasiswaBasedOnDosen(dosen);
        String goodlearner = "";

        if (listModel.size() > 0) {
            for (Object[] obj : listModel) {
                Tb_userDto dto = new Tb_userDto();
                dto.setId(Integer.parseInt(obj[0].toString()));
                dto.setFirstname(obj[3].toString());
                dto.setLastname(obj[4].toString());
                dto.setPhone1(obj[6].toString());
                dto.setIdknowledge(Integer.parseInt(obj[20].toString()));
                if (tb_modelService.cekGoodLearner(dto.getId()) == 1) {
                    goodlearner = "Good Learner";
                } else {
                    goodlearner = "Non Good Learner";
                }
                dto.setGoodlearner(goodlearner);
                listData.add(dto);
            }
        }
        return listData;
    }

    @Override
    public List<Tb_userDto> getDataByIdRole(Integer id_role) {
        List<Tb_userDto> listDto = new ArrayList<>();
        List<Tb_userModel> listModel = tb_userDao.getDataByRole(id_role);
        if (listModel.size() > 0) {
            for (Tb_userModel list : listModel) {
                Tb_userDto userDto = new Tb_userDto();
                userDto.setId(list.getId());
                userDto.setUsername(list.getUsername());
                userDto.setPassword(list.getPassword());
                userDto.setFirstname(list.getFirstname());
                userDto.setLastname(list.getLastname());
                userDto.setEmail(list.getEmail());
                userDto.setPhone1(list.getPhone1());
                userDto.setInstitution(list.getInstitution());
                userDto.setDepartment(list.getDepartment());
                userDto.setAddress(list.getAddress());
                userDto.setCity(list.getCity());
                userDto.setFirstaccess(list.getFirstaccess());
                userDto.setLastaccess(list.getLastaccess());
                userDto.setLastlogin(list.getLastlogin());
                userDto.setCurrentlogin(list.getCurrentlogin());
                userDto.setPicture(list.getPicture());
                userDto.setDescription(list.getDescription());
                userDto.setTimecreated(list.getTimecreated());
                userDto.setTimemodified(list.getTimemodified());
                userDto.setId_role(list.getId_role());
                listDto.add(userDto);
            }
        }
        return listDto;
    }
}
