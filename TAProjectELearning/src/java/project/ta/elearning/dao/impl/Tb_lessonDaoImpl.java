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
import project.ta.elearning.dao.Tb_lessonDao;
import project.ta.elearning.model.Tb_lessonModel;

/**
 *
 * @author Sou
 */
@Repository
public class Tb_lessonDaoImpl extends HibernateUtil implements Tb_lessonDao{

    @Override
    public List<Tb_lessonModel> getData() {
        List<Tb_lessonModel> listData = new ArrayList<>();
        String sql = "select model from Tb_lessonModel model";
        Query query = createQuery(sql);
        listData = query.list();
        return listData;
    }

    @Override
    public void saveData(Tb_lessonModel model) {
        try {
            getSession().save(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteData(Integer id) {
        try {
            Tb_lessonModel model = new Tb_lessonModel();
            model.setId(id);
            getSession().delete(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateData(Tb_lessonModel model) {
        try {
            getSession().update(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Tb_lessonModel> getDataById(Integer id) {
        List<Tb_lessonModel> listData = new ArrayList<>();
        try {
            String sql = "select model from Tb_lessonModel model where id = :id";
            Query query = createQuery(sql).setParameter("id", id);
            listData = query.list();
            
        } catch (Exception e) {
            e.printStackTrace();;
        }
            
    return listData;
    }

    @Override
    public List<Tb_lessonModel> getData(String cari) {
        List<Tb_lessonModel> listData = new ArrayList<>();
        String sql = "select model from Tb_lessonModel model where name like :cari";
        Query query = createQuery(sql).setParameter("cari", "%"+cari+"%");
        listData = query.list();
        return listData;
    }
    
}
