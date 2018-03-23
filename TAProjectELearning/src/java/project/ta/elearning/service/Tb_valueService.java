/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ta.elearning.service;

import java.util.List;
import project.ta.elearning.dto.Tb_valueDto;

/**
 *
 * @author Sou
 */

public interface Tb_valueService {
    public List<Tb_valueDto> getData(); 
    public void saveData(Tb_valueDto dto);
    public void deleteData(Integer id);
    public void updateData(Tb_valueDto dto);
    public Tb_valueDto getDataById(Integer id);
}
