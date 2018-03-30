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
import project.ta.elearning.dao.Tb_resultquizDao;
import project.ta.elearning.dao.Tb_resultquiz_afterDao;
import project.ta.elearning.model.Tb_resultquiz_afterModel;

/**
 *
 * @author Sou
 */
@Repository
public class Tb_resultquiz_afterDaoImpl extends HibernateUtil implements Tb_resultquiz_afterDao{

    @Override
    public List<Tb_resultquiz_afterModel> getData() {
        List<Tb_resultquiz_afterModel> listData = new ArrayList<>();
        String sql = "select model from Tb_resultquiz_afterModel model";
        Query query = createQuery(sql);
        listData = query.list();
        return listData;
    }

    @Override
    public void saveData(Tb_resultquiz_afterModel model) {
        try {
            getSession().save(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteData(Integer id) {
        try {
            Tb_resultquiz_afterModel model = new Tb_resultquiz_afterModel();
            model.setId(id);
            getSession().delete(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateData(Tb_resultquiz_afterModel model) {
        try {
            getSession().update(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Tb_resultquiz_afterModel> getDataById(Integer id) {
        List<Tb_resultquiz_afterModel> listData = new ArrayList<>();
        try {
            String sql = "select model from Tb_resultquiz_afterModel model where id = :id";
            Query query = createQuery(sql).setParameter("id", id);
            listData = query.list();
            
        } catch (Exception e) {
            e.printStackTrace();;
        }
    return listData;
    }
    
}
