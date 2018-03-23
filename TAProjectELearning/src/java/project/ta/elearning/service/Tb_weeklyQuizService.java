/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ta.elearning.service;

import java.util.List;
import project.ta.elearning.dto.Tb_weeklyQuizDto;

/**
 *
 * @author Sou
 */

public interface Tb_weeklyQuizService {
    public List<Tb_weeklyQuizDto> getData();
    public List<Tb_weeklyQuizDto> getData(String cari);
    public void saveData(Tb_weeklyQuizDto dto);
    public void deleteData(Integer id);
    public void updateData(Tb_weeklyQuizDto dto);
    public Tb_weeklyQuizDto getDataById(Integer id);
}
