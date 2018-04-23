/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ta.elearning.dao;

import java.util.List;
import project.ta.elearning.model.Tb_qaModel;

/**
 *
 * @author Sou
 */
public interface Tb_qaDao {
    public List<Tb_qaModel> getData();
    public void saveData(Tb_qaModel model);
    public void deleteData(Integer id);
    public void updateData(Tb_qaModel model);
    public List<Tb_qaModel> getDataById(Integer id);
    public List<Object[]> getDataNative();
}
