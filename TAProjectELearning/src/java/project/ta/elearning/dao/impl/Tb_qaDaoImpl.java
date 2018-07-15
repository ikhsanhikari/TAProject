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
import project.ta.elearning.dao.Tb_qaDao;
import project.ta.elearning.model.Tb_qaModel;

/**
 *
 * @author Sou
 */
@Repository
public class Tb_qaDaoImpl extends HibernateUtil implements Tb_qaDao{

    @Override
    public List<Tb_qaModel> getData() {
        List<Tb_qaModel> listData = new ArrayList<>();
        String sql = "select model from Tb_qaModel model order by id desc";
        Query query = createQuery(sql);
        listData = query.list();
        return listData;
    }

    @Override
    public void saveData(Tb_qaModel model) {
        try {
            getSession().save(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteData(Integer id) {
        try {
            Tb_qaModel model = new Tb_qaModel();
            model.setId(id);
            getSession().delete(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateData(Tb_qaModel model) {
        try {
            getSession().update(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Tb_qaModel> getDataById(Integer id) {
        List<Tb_qaModel> listData = new ArrayList<>();
        try {
            String sql = "select model from Tb_qaModel model where id = :id";
            Query query = createQuery(sql).setParameter("id", id);
            listData = query.list();
            
        } catch (Exception e) {
            e.printStackTrace();;
        }
            
    return listData;
    }

    @Override
    public List<Object[]> getDataNative() {
        String sql = "select distinct qa.id,q.name,a.answers,l.level,j.jenissoal \n" +
                    "from tb_qa qa, tb_answers a,tb_quiz q,tb_level l,tb_jenissoal j \n" +
                    "where qa.id_answers = a.id and qa.id_quiz = q.id and qa.id_level = l.id \n" +
                    "and qa.id_jenis_soal = j.id\n" +
                    "order by qa.id desc";
        Query query = createNativeQuery(sql);
        return query.list();
    }
    
}
