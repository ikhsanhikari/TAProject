/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ta.elearning.dao;

import java.util.List;
import project.ta.elearning.model.Tb_courseModel;

/**
 *
 * @author Sou
 */
public interface Tb_courseDao {
    public void saveData(Tb_courseModel courseModel);
    public List<Tb_courseModel> getData();
    public List<Tb_courseModel> getData(String cari);
    public void deleteData(Integer id);
    public void updateData(Tb_courseModel model);
    public List<Tb_courseModel> getDataById(Integer id);
}
