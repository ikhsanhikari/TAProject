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
import project.ta.elearning.dao.UserDao;

/**
 *
 * @author Sou
 */
@Repository
public class UserDaoImpl extends HibernateUtil implements UserDao {

    @Override
    public List<Object[]> loginAction(String username,String jenis) {
        List<Object> listResult = new ArrayList<>();
        String sql = "select * from user_tbl where username = '"+username+"' and password = '"+jenis+"' ; ";
        Query query = createNativeQuery(sql);
        return query.list();
    }

    @Override
    public List<Object[]> getUser() {
       List<Object[]> listResult = new ArrayList<>();
        String sql = "select * from user_tbl";
        Query query = createNativeQuery(sql);
        return query.list();
    }
    
}
