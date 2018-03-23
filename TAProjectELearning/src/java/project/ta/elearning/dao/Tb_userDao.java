/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ta.elearning.dao;

import java.util.List;
import project.ta.elearning.model.Tb_userModel;

/**
 *
 * @author Sou
 */
public interface Tb_userDao {
    public List<Tb_userModel> loginUser (String username,String password);
    public void saveData(Tb_userModel userModel);
    public List<Tb_userModel> getData();
    public List<Tb_userModel> getData(String cari);
    public List<Tb_userModel> cekData(String cari);
    public void deleteData(Integer id);
    public void updateData(Tb_userModel model);
    public List<Tb_userModel> getDataById(Integer id);
}
