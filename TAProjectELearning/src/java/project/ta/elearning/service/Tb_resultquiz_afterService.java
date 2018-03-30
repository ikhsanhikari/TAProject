/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ta.elearning.service;

import java.util.List;
import project.ta.elearning.dto.Tb_resultquiz_afterDto;

/**
 *
 * @author Sou
 */

public interface Tb_resultquiz_afterService {
    public List<Tb_resultquiz_afterDto> getData(); 
    public void saveData(Tb_resultquiz_afterDto dto);
    public void deleteData(Integer id);
    public void updateData(Tb_resultquiz_afterDto dto);
    public Tb_resultquiz_afterDto getDataById(Integer id);
}
