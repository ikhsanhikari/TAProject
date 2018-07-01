/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ta.elearning.service;

import java.util.List;
import project.ta.elearning.dto.Tb_modelDto;

/**
 *
 * @author Sou
 */

public interface Tb_modelService {
    public List<Tb_modelDto> getData(); 
    public void saveData(Tb_modelDto dto);
    public void deleteData(Integer id);
    public void updateData(Tb_modelDto dto);
    public Tb_modelDto getDataById(Integer id);
    public int cekGoodLearner(int id);
}
