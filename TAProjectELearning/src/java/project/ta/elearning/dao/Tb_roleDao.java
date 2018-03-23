/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ta.elearning.dao;

import java.util.List;
import project.ta.elearning.model.Tb_roleModel;

/**
 *
 * @author Sou
 */
public interface Tb_roleDao {
    public List<Tb_roleModel> getData();
    public void saveData(Tb_roleModel userModel);
    public void deleteData(Integer id);
    public void updateData(Tb_roleModel model);
    public List<Tb_roleModel> getDataById(Integer id);
}
