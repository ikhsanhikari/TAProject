/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ta.elearning.service;

import java.util.List;
import project.ta.elearning.dto.Tb_qaDto;
import project.ta.elearning.dto.Tb_quizDto;

/**
 *
 * @author Sou
 */

public interface Tb_qaService {
    public List<Tb_qaDto> getData();
    public List<Tb_quizDto> getDataNative();
    public void saveData(Tb_qaDto dto);
    public void deleteData(Integer id);
    public void updateData(Tb_qaDto dto);
    public Tb_qaDto getDataById(Integer id);
}
