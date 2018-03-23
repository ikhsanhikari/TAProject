/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ta.elearning.dao;

import java.util.List;
import project.ta.elearning.model.Tb_majorsModel;

/**
 *
 * @author Sou
 */
public interface Tb_majorsDao {
    public List<Tb_majorsModel> getData();
    public List<Tb_majorsModel> getData(String cari);
    public void saveData(Tb_majorsModel model);
    public void deleteData(Integer id);
    public void updateData(Tb_majorsModel model);
    public List<Tb_majorsModel> getDataById(Integer id);
}
