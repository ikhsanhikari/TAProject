/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ta.elearning.service;

import java.util.HashMap;
import java.util.List;
import project.ta.elearning.dto.Tb_resultQuizDto;
import project.ta.elearning.dto.Tb_resultquiz_afterDto;
import project.ta.elearning.model.Tb_resultquiz_afterModel;

/**
 *
 * @author Sou
 */

public interface Tb_resultquiz_afterService {
    public List<Tb_resultquiz_afterDto> getData(); 
    public void saveData(Tb_resultQuizDto dto);
    public void deleteData(Integer id);
    public void updateData(Tb_resultquiz_afterDto dto);
    public Tb_resultquiz_afterDto getDataById(int idColleger, int idMatery);
    public int isDataExistByIdAndMateri(int id, int idMateri);
    public void update(Tb_resultQuizDto rqDto);
    public int getKnowledgePerMateri(int idColleger, int idMateri);
}
