/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ta.elearning.dao;

import java.util.List;
import project.ta.elearning.model.Tb_lessonModel;

/**
 *
 * @author Sou
 */
public interface Tb_lessonDao {
    public List<Tb_lessonModel> getData();
    public List<Tb_lessonModel> getData(String cari);
    public void saveData(Tb_lessonModel model);
    public void deleteData(Integer id);
    public void updateData(Tb_lessonModel model);
    public List<Tb_lessonModel> getDataById(Integer id);
}
