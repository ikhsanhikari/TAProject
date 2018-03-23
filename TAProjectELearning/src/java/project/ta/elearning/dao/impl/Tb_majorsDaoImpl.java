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
import project.ta.elearning.dao.Tb_majorsDao;
import project.ta.elearning.model.Tb_majorsModel;

/**
 *
 * @author Sou
 */
@Repository
public class Tb_majorsDaoImpl extends HibernateUtil implements Tb_majorsDao{

    @Override
    public List<Tb_majorsModel> getData() {
        List<Tb_majorsModel> listData = new ArrayList<>();
        String sql = "select model from Tb_majorsModel model";
        Query query = createQuery(sql);
        listData = query.list();
        return listData;
    }

    @Override
    public void saveData(Tb_majorsModel model) {
        try {
            getSession().save(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteData(Integer id) {
        try {
            Tb_majorsModel model = new Tb_majorsModel();
            model.setId(id);
            getSession().delete(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateData(Tb_majorsModel model) {
        try {
            getSession().update(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Tb_majorsModel> getDataById(Integer id) {
        List<Tb_majorsModel> listData = new ArrayList<>();
        try {
            String sql = "select model from Tb_majorsModel model where id = :id";
            Query query = createQuery(sql).setParameter("id", id);
            listData = query.list();
            
        } catch (Exception e) {
            e.printStackTrace();;
        }
            
    return listData;
    }

    @Override
    public List<Tb_majorsModel> getData(String cari) {
        List<Tb_majorsModel> listData = new ArrayList<>();
        String sql = "select model from Tb_majorsModel model where majors like :cari";
        Query query = createQuery(sql).setParameter("cari", "%"+cari+"%");
        listData = query.list();
        return listData;
    }
    
}
