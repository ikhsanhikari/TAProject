/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ta.elearning.service;

import java.util.List;
import project.ta.elearning.dto.Tb_lessonDto;

/**
 *
 * @author Sou
 */

public interface Tb_lessonService {
    public List<Tb_lessonDto> getData();
    public List<Tb_lessonDto> getData(String cari);
    public void saveData(Tb_lessonDto dto);
    public void deleteData(Integer id);
    public void updateData(Tb_lessonDto dto);
    public Tb_lessonDto getDataById(Integer id);
}
