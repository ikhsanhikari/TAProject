/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ta.elearning.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import project.ta.elearning.dao.Tb_userDao;
import project.ta.elearning.model.Tb_userModel;

/**
 *
 * @author Sou
 */
public class Tb_userDaoImpl extends HibernateUtil implements Tb_userDao{

    @Override
    public void saveData(Tb_userModel userModel) {
        try {
            getSession().save(userModel);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public List<Tb_userModel> loginUser(String username, String password) {
        List<Tb_userModel> listUser = null;
        String sql = "select model from Tb_userModel model where username=:uname and password= :pwd";
        Query q = null;
        q = createQuery(sql).setParameter("uname", username).setParameter("pwd", password);
        listUser = q.list();
        return listUser;
    }

    @Override
    public List<Tb_userModel> getData() {
        List<Tb_userModel> listData = new ArrayList<>();
        String sql = "select model from Tb_userModel model";
        Query query = createQuery(sql);
        listData = query.list();
        return listData;
    }

    @Override
    public void deleteData(Integer id) {
        Tb_userModel userModel = new Tb_userModel();
        userModel.setId(id);
        try {
            getSession().delete(userModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateData(Tb_userModel model) {
        getSession().update(model);
    }

    @Override
    public List<Tb_userModel> getDataById(Integer id) {
        List<Tb_userModel> listData = new ArrayList<>();
        String sql = "select model from Tb_userModel model where id = :id";
        Query query = createQuery(sql).setParameter("id", id);
        listData = query.list();
        return listData;
    }

    @Override
    public List<Tb_userModel> getData(String cari) {
        List<Tb_userModel> listData = new ArrayList<>();
        String sql = "select model from Tb_userModel model where username like :cari or firstname like :cari or lastname like :cari";
        Query query = createQuery(sql).setParameter("cari", "%"+cari+"%").setParameter("cari", "%"+cari+"%").setParameter("cari", "%"+cari+"%");
        listData = query.list();
        return listData;
    }   

    @Override
    public List<Tb_userModel> cekData(String cari) {
        List<Tb_userModel> listData = new ArrayList<>();
        String sql = "select model from Tb_userModel model where username = :cari";
        Query query = createQuery(sql).setParameter("cari", cari);
        listData = query.list();
        return listData;
    }

    @Override
    public int getDataKnowledge(String username) {
        Query query = createNativeQuery("SELECT idknowledge FROM tb_user WHERE username ='" + username + "'");
        List<Object> list = new ArrayList();
        list = query.list();
        System.out.println("knowledge : " + list.get(0));
        
        return Integer.parseInt(list.get(0).toString());
    }

    @Override
    public void updateKnowledgeUser(String username, int idKnowledge) {
         Query query = createNativeQuery("UPDATE tb_user SET idknowledge = " + idKnowledge 
                + " WHERE id = " + username);
        int result = query.executeUpdate();
    }
}