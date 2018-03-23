/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ta.elearning.dao;

import java.util.List;
import project.ta.elearning.model.Tb_assignmentModel;

/**
 *
 * @author Sou
 */
public interface Tb_assignmentDao {
    public List<Tb_assignmentModel> getData();
    public void saveData(Tb_assignmentModel model);
    public void deleteData(Integer id);
    public void updateData(Tb_assignmentModel model);
    public List<Tb_assignmentModel> getDataById(Integer id);
}
