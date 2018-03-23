/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ta.elearning.service;

import java.util.List;
import project.ta.elearning.dto.Tb_roleDto;

/**
 *
 * @author Sou
 */

public interface Tb_roleService {
    public List<Tb_roleDto> getData(); 
    public void saveData(Tb_roleDto dto);
    public void deleteData(Integer id);
    public void updateData(Tb_roleDto dto);
    public Tb_roleDto getDataById(Integer id);
}
