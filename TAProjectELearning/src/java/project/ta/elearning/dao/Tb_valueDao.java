/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ta.elearning.dao;

import java.util.List;
import project.ta.elearning.model.Tb_valueModel;

/**
 *
 * @author Sou
 */
public interface Tb_valueDao {
    public List<Tb_valueModel> getData();
    public void saveData(Tb_valueModel model);
    public void deleteData(Integer id);
    public void updateData(Tb_valueModel model);
    public List<Tb_valueModel> getDataById(Integer id);
}
