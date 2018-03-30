/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ta.elearning.dao;

import java.util.HashMap;
import java.util.List;
import project.ta.elearning.model.Tb_resultquiz_beforeModel;

/**
 *
 * @author Sou
 */
public interface Tb_resultquiz_beforeDao {
    public List<Tb_resultquiz_beforeModel> getData();
    public void saveData(Tb_resultquiz_beforeModel model);
    public void deleteData(Integer id);
    public void updateData(Tb_resultquiz_beforeModel model);
    public List<Tb_resultquiz_beforeModel> getDataById(Integer id);
    public int isDataExistByIdAndMateri(int id, int idMateri);
    public void update(HashMap data);
}
