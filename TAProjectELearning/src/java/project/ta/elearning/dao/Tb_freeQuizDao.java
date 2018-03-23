/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ta.elearning.dao;

import java.util.List;
import project.ta.elearning.model.Tb_freeQuizModel;

/**
 *
 * @author Sou
 */
public interface Tb_freeQuizDao {
    public List<Tb_freeQuizModel> getData();
    public List<Tb_freeQuizModel> getData(String cari);
    public void saveData(Tb_freeQuizModel model);
    public void deleteData(Integer id);
    public void updateData(Tb_freeQuizModel model);
    public List<Tb_freeQuizModel> getDataById(Integer id);
}
