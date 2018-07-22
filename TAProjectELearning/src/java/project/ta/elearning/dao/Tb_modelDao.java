/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ta.elearning.dao;

import java.util.List;
import project.ta.elearning.model.Tb_modelModel;

/**
 *
 * @author Sou
 */
public interface Tb_modelDao {
    public List<Tb_modelModel> getData();
    public void saveData(Tb_modelModel model);
    public void deleteData(Integer id);
    public void updateData(Tb_modelModel model);
    public List<Tb_modelModel> getDataById(Integer id);
    public List<Object[]> getDataByKnowledgeBefore(Integer knowledgeBefore, Integer idMatery);
}
