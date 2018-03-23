/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ta.elearning.service;

import java.util.List;
import project.ta.elearning.dto.Tb_courseDto;

/**
 *
 * @author Sou
 */
public interface Tb_courseService {
    public List<Tb_courseDto> getData();
    public List<Tb_courseDto> getData(String cari);
    public void saveData(Tb_courseDto courseDto);
    public void deleteData(Integer id);
    public void updateData(Tb_courseDto dao);
    public Tb_courseDto getDataById(Integer id);
}
