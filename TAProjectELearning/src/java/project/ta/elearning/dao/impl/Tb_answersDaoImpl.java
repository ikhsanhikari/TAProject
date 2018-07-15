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
import project.ta.elearning.dao.Tb_answersDao;
import project.ta.elearning.model.Tb_answersModel;

/**
 *
 * @author Sou
 */
@Repository
public class Tb_answersDaoImpl extends HibernateUtil implements Tb_answersDao{

    @Override
    public List<Tb_answersModel> getData() {
        List<Tb_answersModel> listData = new ArrayList<>();
        String sql = "select model from Tb_answersModel model order by id desc";
        Query query = createQuery(sql);
        listData = query.list();
        return listData;
    }

    @Override
    public void saveData(Tb_answersModel model) {
        try {
            getSession().save(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteData(Integer id) {
        try {
            Tb_answersModel model = new Tb_answersModel();
            model.setId(id);
            getSession().delete(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateData(Tb_answersModel model) {
        try {
            getSession().update(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Tb_answersModel> getDataById(Integer id) {
        List<Tb_answersModel> listData = new ArrayList<>();
        try {
            String sql = "select model from Tb_answersModel model where id = :id";
            Query query = createQuery(sql).setParameter("id", id);
            listData = query.list();
            
        } catch (Exception e) {
            e.printStackTrace();;
        }
            
    return listData;
    }
    
}
