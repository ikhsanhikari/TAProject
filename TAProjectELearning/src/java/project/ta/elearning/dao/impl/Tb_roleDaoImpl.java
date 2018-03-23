/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ta.elearning.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import project.ta.elearning.dao.Tb_roleDao;
import project.ta.elearning.model.Tb_roleModel;

/**
 *
 * @author Sou
 */
@Repository
public class Tb_roleDaoImpl extends HibernateUtil implements Tb_roleDao{

    @Override
    public List<Tb_roleModel> getData() {
        List<Tb_roleModel> listData = new ArrayList<>();
        String sql = "select model from Tb_roleModel model";
        Query query = createQuery(sql);
        listData = query.list();
        return listData;
    }

    @Override
    public void saveData(Tb_roleModel userModel) {
        try {
            getSession().save(userModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteData(Integer id) {
        Tb_roleModel roleModel = new Tb_roleModel();
        try {
            roleModel.setId(id);
            getSession().delete(roleModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void updateData(Tb_roleModel model) {
        try {
            getSession().update(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Tb_roleModel> getDataById(Integer id) {
        List<Tb_roleModel> listData = new ArrayList<>();
        String sql = "select model from Tb_roleModel model where id = :id";
        Query query = createQuery(sql).setParameter("id", id);
        listData = query.list();
        return listData;
    }
    
}
