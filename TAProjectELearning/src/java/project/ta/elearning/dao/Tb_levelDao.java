/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ta.elearning.dao;

import java.util.List;
import project.ta.elearning.model.Tb_levelModel;

/**
 *
 * @author Sou
 */
public interface Tb_levelDao {
    public List<Tb_levelModel> getData();
    public void saveData(Tb_levelModel model);
    public void deleteData(Integer id);
    public void updateData(Tb_levelModel model);
    public List<Tb_levelModel> getDataById(Integer id);
}
