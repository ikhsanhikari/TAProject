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
import project.ta.elearning.dao.Tb_assignmentDao;
import project.ta.elearning.model.Tb_assignmentModel;

/**
 *
 * @author Sou
 */
@Repository
public class Tb_assignmentDaoImpl extends HibernateUtil implements Tb_assignmentDao{

    @Override
    public List<Tb_assignmentModel> getData() {
        List<Tb_assignmentModel> listData = new ArrayList<>();
        String sql = "select model from Tb_assignmentModel model";
        Query query = createQuery(sql);
        listData = query.list();
        return listData;
    }

    @Override
    public void saveData(Tb_assignmentModel model) {
        try {
            getSession().save(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteData(Integer id) {
        try {
            Tb_assignmentModel model = new Tb_assignmentModel();
            model.setId(id);
            getSession().delete(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateData(Tb_assignmentModel model) {
        try {
            getSession().update(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Tb_assignmentModel> getDataById(Integer id) {
        List<Tb_assignmentModel> listData = new ArrayList<>();
        try {
            String sql = "select model from Tb_assignmentModel model where id = :id";
            Query query = createQuery(sql).setParameter("id", id);
            listData = query.list();
            
        } catch (Exception e) {
            e.printStackTrace();;
        }
            
    return listData;
    }
    
}
