/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ta.elearning.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import project.ta.elearning.dao.Tb_resultquizDao;
import project.ta.elearning.dao.Tb_resultquiz_beforeDao;
import project.ta.elearning.model.Tb_resultquiz_beforeModel;

/**
 *
 * @author Sou
 */
@Repository
public class Tb_resultquiz_beforeDaoImpl extends HibernateUtil implements Tb_resultquiz_beforeDao{

    @Override
    public List<Tb_resultquiz_beforeModel> getData() {
        List<Tb_resultquiz_beforeModel> listData = new ArrayList<>();
        String sql = "select model from Tb_resultquiz_beforeModel model";
        Query query = createQuery(sql);
        listData = query.list();
        return listData;
    }

    @Override
    public void saveData(Tb_resultquiz_beforeModel model) {
        try {
            getSession().save(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteData(Integer id) {
        try {
            Tb_resultquiz_beforeModel model = new Tb_resultquiz_beforeModel();
            model.setId(id);
            getSession().delete(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateData(Tb_resultquiz_beforeModel model) {
        try {
            getSession().update(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Tb_resultquiz_beforeModel> getDataById(int idColleger, int idMatery) {
        List<Tb_resultquiz_beforeModel> listData = new ArrayList<>();
        try {
            String sql = "select model from Tb_resultquiz_beforeModel model where id_colleger=:idColleger AND id_matery=:idMatery";
            Query query = createQuery(sql).setParameter("idColleger", idColleger).setParameter("idMatery", idMatery);
            listData = query.list();
            
        } catch (Exception e) {
            e.printStackTrace();;
        }
    return listData;
    }

    @Override
    public void update(HashMap data) {
        Query query = createNativeQuery("UPDATE tb_resultquiz_before SET score = " + data.get("score") + ", idknowledge = " + data.get("idknowledge") + ", id_category = " + data.get("id_category") +
                " WHERE id_colleger = " + data.get("id_colleger") + " AND id_matery = " + data.get("id_matery"));
        int result = query.executeUpdate();
    }

    @Override
    public int isDataExistByIdAndMateri(int id, int idMateri) {
        Query query = createNativeQuery("SELECT count(1) FROM tb_resultquiz_before "
                + "WHERE id_colleger = " + id + " AND id_matery = " + idMateri);
        List<Object> list = new ArrayList();
        list = query.list();
        
        return Integer.parseInt(list.get(0).toString());
    }
    
}
