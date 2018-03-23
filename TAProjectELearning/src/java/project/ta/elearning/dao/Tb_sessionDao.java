/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ta.elearning.dao;

import java.util.List;
import project.ta.elearning.model.Tb_sessionModel;

/**
 *
 * @author Sou
 */
public interface Tb_sessionDao {
    public List<Tb_sessionModel> getData();
    public void saveData(Tb_sessionModel model);
    public void deleteData(Integer id);
    public void updateData(Tb_sessionModel model);
    public List<Tb_sessionModel> getDataById(Integer id);
}
