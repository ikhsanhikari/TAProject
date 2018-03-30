/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ta.elearning.dao;

import java.util.List;
import project.ta.elearning.model.Tb_resultquizModel;

/**
 *
 * @author Sou
 */
public interface Tb_resultquizDao {
    public List<Tb_resultquizModel> getData();
    public void saveData(Tb_resultquizModel model);
    public void deleteData(Integer id);
    public void updateData(Tb_resultquizModel model);
    public List<Tb_resultquizModel> getDataById(Integer id);
}
