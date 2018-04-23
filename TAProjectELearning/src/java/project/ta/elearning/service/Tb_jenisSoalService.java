/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ta.elearning.service;

import java.util.List;
import project.ta.elearning.dto.Tb_jenisSoalDto;

/**
 *
 * @author Sou
 */

public interface Tb_jenisSoalService {
    public List<Tb_jenisSoalDto> getData(); 
    public void saveData(Tb_jenisSoalDto dto);
    public void deleteData(Integer id);
    public void updateData(Tb_jenisSoalDto dto);
    public Tb_jenisSoalDto getDataById(Integer id);
}
