/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ta.elearning.service;

import java.util.List;
import project.ta.elearning.dto.Tb_majorsDto;

/**
 *
 * @author Sou
 */

public interface Tb_majorsService {
    public List<Tb_majorsDto> getData();
    public List<Tb_majorsDto> getData(String cari);
    public void saveData(Tb_majorsDto dto);
    public void deleteData(Integer id);
    public void updateData(Tb_majorsDto dto);
    public Tb_majorsDto getDataById(Integer id);
}
