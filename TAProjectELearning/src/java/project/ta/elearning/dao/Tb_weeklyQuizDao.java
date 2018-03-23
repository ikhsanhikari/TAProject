/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ta.elearning.dao;

import java.util.List;
import project.ta.elearning.model.Tb_weeklyQuizModel;

/**
 *
 * @author Sou
 */
public interface Tb_weeklyQuizDao {
    public List<Tb_weeklyQuizModel> getData();
    public List<Tb_weeklyQuizModel> getData(String cari);
    public void saveData(Tb_weeklyQuizModel model);
    public void deleteData(Integer id);
    public void updateData(Tb_weeklyQuizModel model);
    public List<Tb_weeklyQuizModel> getDataById(Integer id);
}
