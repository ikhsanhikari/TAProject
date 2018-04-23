/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ta.elearning.dao;

import java.util.List;
import project.ta.elearning.model.Tb_jenisSoalModel;

/**
 *
 * @author Sou
 */
public interface Tb_jenisSoalDao {
    public List<Tb_jenisSoalModel> getData();
    public void saveData(Tb_jenisSoalModel model);
    public void deleteData(Integer id);
    public void updateData(Tb_jenisSoalModel model);
    public List<Tb_jenisSoalModel> getDataById(Integer id);
}
