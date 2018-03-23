/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ta.elearning.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import project.ta.elearning.dao.Tb_courseDao;
import project.ta.elearning.model.Tb_courseModel;

/**
 *
 * @author Sou
 */
public class Tb_courseDaoImpl extends HibernateUtil implements Tb_courseDao{

    @Override
    public void saveData(Tb_courseModel courseModel) {
        try {
            getSession().save(courseModel);
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    @Override
    public List<Tb_courseModel> getData() {
        List<Tb_courseModel> listData = new ArrayList<>();
        String sql = "select model from Tb_courseModel model";
        Query query = createQuery(sql);
        listData = query.list();
        return listData;
    }

    @Override
    public void deleteData(Integer id) {
        Tb_courseModel courseModel = new Tb_courseModel();
        courseModel.setId(id);
        try {
            getSession().delete(courseModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateData(Tb_courseModel model) {
        getSession().update(model);
    }

    @Override
    public List<Tb_courseModel> getDataById(Integer id) {
        List<Tb_courseModel> listData = new ArrayList<>();
        String sql = "select model from Tb_courseModel model where id = :id";
        Query query = createQuery(sql).setParameter("id", id);
        listData = query.list();
        return listData;
    }

    @Override
    public List<Tb_courseModel> getData(String cari) {
        List<Tb_courseModel> listData = new ArrayList<>();
        String sql = "select model from Tb_courseModel model where fullname = :cari or shortname = :cari";
        Query query = createQuery(sql).setParameter("cari", cari).setParameter("cari", cari);
        listData = query.list();
        return listData;
    }
    
}
