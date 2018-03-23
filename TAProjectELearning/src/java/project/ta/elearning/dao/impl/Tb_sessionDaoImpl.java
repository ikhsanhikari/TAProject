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
import project.ta.elearning.dao.Tb_sessionDao;
import project.ta.elearning.model.Tb_sessionModel;

/**
 *
 * @author Sou
 */
@Repository
public class Tb_sessionDaoImpl extends HibernateUtil implements Tb_sessionDao{

    @Override
    public List<Tb_sessionModel> getData() {
        List<Tb_sessionModel> listData = new ArrayList<>();
        String sql = "select model from Tb_sessionModel model";
        Query query = createQuery(sql);
        listData = query.list();
        return listData;
    }

    @Override
    public void saveData(Tb_sessionModel model) {
        try {
            getSession().save(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteData(Integer id) {
        try {
            Tb_sessionModel model = new Tb_sessionModel();
            model.setId(id);
            getSession().delete(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateData(Tb_sessionModel model) {
        try {
            getSession().update(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Tb_sessionModel> getDataById(Integer id) {
        List<Tb_sessionModel> listData = new ArrayList<>();
        try {
            String sql = "select model from Tb_sessionModel model where id = :id";
            Query query = createQuery(sql).setParameter("id", id);
            listData = query.list();
            
        } catch (Exception e) {
            e.printStackTrace();;
        }
            
    return listData;
    }
    
}
