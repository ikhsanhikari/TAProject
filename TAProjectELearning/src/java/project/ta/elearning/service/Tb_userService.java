/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ta.elearning.service;

import java.util.List;
import project.ta.elearning.dto.Tb_userDto;

/**
 *
 * @author Sou
 */
public interface Tb_userService {
    public List<Tb_userDto> getData();
    public List<Tb_userDto> getData(String cari);
    public List<Tb_userDto> cekData(String cari);
    public void saveData(Tb_userDto userDto);
    public Integer loginUser(String username,String password);
    public Tb_userDto selectUser(String username,String password);
    public void deleteData(Integer id);
    public void updateData(Tb_userDto dao);
    public Tb_userDto getDataById(Integer id);
    public int getDataKnowledge(String username);
    public void updateKnowledgeUser(String username, int idKnowledge);
    public List<Tb_userDto> getDataMahasiswa();
    public List<Tb_userDto> getDataDosen();
    public List<Tb_userDto> getDataMahasiswaBasedOnDosen(Integer dosen);
}
