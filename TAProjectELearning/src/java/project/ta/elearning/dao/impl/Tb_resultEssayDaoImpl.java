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
import project.ta.elearning.dao.Tb_resultEssayDao;
import project.ta.elearning.model.Tb_resultEssayModel;

/**
 *
 * @author Sou
 */
@Repository
public class Tb_resultEssayDaoImpl extends HibernateUtil implements Tb_resultEssayDao{

    @Override
    public List<Tb_resultEssayModel> getData() {
        List<Tb_resultEssayModel> listData = new ArrayList<>();
        String sql = "select model from Tb_resultEssayModel model";
        Query query = createQuery(sql);
        listData = query.list();
        return listData;
    }

    @Override
    public void saveData(Tb_resultEssayModel model) {
        try {
            getSession().save(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteData(Integer id) {
        try {
            Tb_resultEssayModel model = new Tb_resultEssayModel();
            model.setId(id);
            getSession().delete(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateData(Tb_resultEssayModel model) {
        try {
            getSession().update(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Tb_resultEssayModel> getDataById(Integer id) {
        List<Tb_resultEssayModel> listData = new ArrayList<>();
        try {
            String sql = "select model from Tb_resultEssayModel model where id = :id";
            Query query = createQuery(sql).setParameter("id", id);
            listData = query.list();
            
        } catch (Exception e) {
            e.printStackTrace();;
        }
            
    return listData;
    }

    @Override
    public List<Object[]> getDataNative() {
        String sql = "SELECT res.id,concat(u.firstname,u.lastname) as mahasiswa,res.id_essay,e.essay,res.jawaban,res.nilai,res.latihan_ke," +
                    " res.timeopen,res.timeupdate " +
                    "from tb_resultessay res, tb_essay e ,tb_user u where res.id_essay=e.id  and res.id_user=u.id";
        Query query = createNativeQuery(sql);
        return query.list();
    }

    @Override
    public void uploadData(Tb_resultEssayModel model) {
        try {
            getSession().save(model);
        } catch (Exception e) {
        }
        
    }

    @Override
    public List<Object[]> getDataByIdNative(Integer id) {
        String sql = "SELECT  concat(u.firstname,u.lastname) as mahasiswa,res.id_essay,e.essay,res.jawaban,res.nilai,res.latihan_ke," +
                    " res.timeopen,res.timeupdate " +
                    "from tb_resultessay res, tb_essay e ,tb_user u where res.id_essay=e.id  and res.id_user=u.id and res.id = "+id+"";
        Query query = createNativeQuery(sql);
        return query.list();
    }
    
}
