/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ta.elearning.dao;

import java.util.List;

/**
 *
 * @author Sou
 */

public interface UserDao {
    public List<Object[]> loginAction(String username,String jenis); 
    public List<Object[]> getUser();
}
