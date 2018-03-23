/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ta.elearning.service;

import java.util.List;
import project.ta.elearning.dto.Tb_freeQuizDto;

/**
 *
 * @author Sou
 */

public interface Tb_freeQuizService {
    public List<Tb_freeQuizDto> getData();
    public List<Tb_freeQuizDto> getData(String cari);
    public void saveData(Tb_freeQuizDto dto);
    public void deleteData(Integer id);
    public void updateData(Tb_freeQuizDto dto);
    public Tb_freeQuizDto getDataById(Integer id);
}
