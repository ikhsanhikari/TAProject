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
import project.ta.elearning.dto.Tb_resultQuizDto;
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
    public List<Tb_resultquiz_afterModel> getDataById(int idColleger, int idMatery) {
        List<Tb_resultquiz_afterModel> listData = new ArrayList<>();
        try {
            String sql = "select model from Tb_resultquiz_afterModel model where id_colleger=:idColleger AND id_matery=:idMatery";
            Query query = createQuery(sql).setParameter("idColleger", idColleger).setParameter("idMatery", idMatery);
            listData = query.list();
            
        } catch (Exception e) {
            e.printStackTrace();;
        }
    return listData;
    }

    @Override
    public int isDataExistByIdAndMateri(int id, int idMateri) {
        Query query = createNativeQuery("SELECT count(1) FROM tb_resultquiz_after "
                + "WHERE id_colleger = " + id + " AND id_matery = " + idMateri);
        List<Object> list = new ArrayList();
        list = query.list();
        
        return Integer.parseInt(list.get(0).toString());
    }

    @Override
    public void update(Tb_resultQuizDto rqDto) {
        Query query = createNativeQuery("UPDATE tb_resultquiz_after SET score = " + rqDto.getScore()+ ", idknowledge = " + rqDto.getIdknowledge()+ ", id_category = " + rqDto.getId_category()
                + " WHERE id_colleger = " + rqDto.getId_colleger() + " AND id_matery = " + rqDto.getId_matery());
        int result = query.executeUpdate();
    }

    @Override
    public int getKnowledgePerMateri(int idColleger, int idMateri) {
        String sql = "SELECT idknowledge FROM tb_resultquiz_after WHERE id_colleger = " + idColleger + 
                " AND id_matery = " + idMateri;
        Query query = createNativeQuery(sql);
        
        if(query.list().size()==0)
            return 0;
        
        return Integer.parseInt(query.list().get(0).toString());
    }
    
}
