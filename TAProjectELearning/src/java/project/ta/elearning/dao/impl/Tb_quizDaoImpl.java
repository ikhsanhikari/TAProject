/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ta.elearning.dao.impl;

import java.util.List;
import org.hibernate.Query;
import project.ta.elearning.dao.Tb_quizDao;
import project.ta.elearning.model.Tb_quizModel;

/**
 *
 * @author Sou
 */
public class Tb_quizDaoImpl extends HibernateUtil implements Tb_quizDao{

    @Override
    public List<Tb_quizModel> getData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveData(Tb_quizModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteData(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateData(Tb_quizModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Tb_quizModel> getDataById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object[]> getQuizAll() {
        String sql = "select distinct q.id,q.name,qa.id_jenis_soal   " +
                    "from tb_quiz q,tb_qa qa,tb_answers a " +
                    "where q.id=qa.id_quiz " +
                    "and qa.id=a.id  order by rand() limit 0,1";
        Query query = createNativeQuery(sql);
        return query.list();
    }
    
    @Override
    public List<Object[]> getAnswerAllByQuiz(Integer id) {
        String sql = "select q.id , a.answers " +
                    "from tb_quiz q " +
                    "inner join " +
                    "tb_answers a " +
                    "inner join tb_qa qa " +
                    "on q.id=qa.id_quiz  " +
                    "and qa.id_answers=a.id  " +
                    "and q.id = "+id+"";
        Query query = createNativeQuery(sql);
        return query.list();
    }
    
}
