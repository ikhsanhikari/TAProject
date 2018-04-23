/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ta.elearning.service;

import java.util.List;
import project.ta.elearning.dto.Tb_answersDto;

/**
 *
 * @author Sou
 */

public interface Tb_answersService {
    public List<Tb_answersDto> getData(); 
    public void saveData(Tb_answersDto dto);
    public void deleteData(Integer id);
    public void updateData(Tb_answersDto dto);
    public Tb_answersDto getDataById(Integer id);
}
