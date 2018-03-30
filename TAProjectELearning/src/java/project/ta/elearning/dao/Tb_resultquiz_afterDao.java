/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ta.elearning.dao;

import java.util.List;
import project.ta.elearning.model.Tb_resultquiz_afterModel;

/**
 *
 * @author Sou
 */
public interface Tb_resultquiz_afterDao {
    public List<Tb_resultquiz_afterModel> getData();
    public void saveData(Tb_resultquiz_afterModel model);
    public void deleteData(Integer id);
    public void updateData(Tb_resultquiz_afterModel model);
    public List<Tb_resultquiz_afterModel> getDataById(Integer id);
}
