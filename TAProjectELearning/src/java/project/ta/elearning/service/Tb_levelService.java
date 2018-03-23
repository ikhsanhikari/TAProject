/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ta.elearning.service;

import java.util.List;
import project.ta.elearning.dto.Tb_levelDto;

/**
 *
 * @author Sou
 */

public interface Tb_levelService {
    public List<Tb_levelDto> getData(); 
    public void saveData(Tb_levelDto dto);
    public void deleteData(Integer id);
    public void updateData(Tb_levelDto dto);
    public Tb_levelDto getDataById(Integer id);
}
