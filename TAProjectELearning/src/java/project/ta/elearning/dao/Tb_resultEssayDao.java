/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ta.elearning.dao;

import java.util.List;
import project.ta.elearning.model.Tb_resultEssayModel;

/**
 *
 * @author Sou
 */
public interface Tb_resultEssayDao {
    public List<Tb_resultEssayModel> getData();
    public void saveData(Tb_resultEssayModel model);
    public void deleteData(Integer id);
    public void updateData(Tb_resultEssayModel model);
    public List<Tb_resultEssayModel> getDataById(Integer id);
    public List<Object[]> getDataNative();
    public List<Object[]> getDataByIdNative(Integer id);
    public void uploadData(Tb_resultEssayModel model);
    
}
