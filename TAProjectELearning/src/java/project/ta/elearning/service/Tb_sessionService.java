/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ta.elearning.service;

import java.util.List;
import project.ta.elearning.dto.Tb_sessionDto;

/**
 *
 * @author Sou
 */

public interface Tb_sessionService {
    public List<Tb_sessionDto> getData(); 
    public void saveData(Tb_sessionDto dto);
    public void deleteData(Integer id);
    public void updateData(Tb_sessionDto dto);
    public Tb_sessionDto getDataById(Integer id);
}
