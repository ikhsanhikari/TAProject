/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ta.elearning.dao;

import java.util.List;
import project.ta.elearning.model.Tb_answersModel;

/**
 *
 * @author Sou
 */
public interface Tb_answersDao {
    public List<Tb_answersModel> getData();
    public void saveData(Tb_answersModel model);
    public void deleteData(Integer id);
    public void updateData(Tb_answersModel model);
    public List<Tb_answersModel> getDataById(Integer id);
}
