/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ta.elearning.service;

import java.util.List;
import project.ta.elearning.dto.Tb_resultEssayDto;
import project.ta.elearning.dto.Tb_quizDto;
import project.ta.elearning.dto.Tb_resultExerciseDto;

/**
 *
 * @author Sou
 */

public interface Tb_resultEssayService {
    public List<Tb_resultEssayDto> getData();
    public List<Tb_resultEssayDto> getDataNative();
    public Tb_resultEssayDto getDataByIdNative(Integer id);
    public void saveData(Tb_resultEssayDto dto);
    public void deleteData(Integer id);
    public void updateData(Tb_resultEssayDto dto);
    public Tb_resultEssayDto getDataById(Integer id);
    public void uploadData(Tb_resultExerciseDto dto);
}
