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
import project.ta.elearning.model.Tb_resultExcerciseModel;

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
        try {
            getSession().save(model);
        } catch (Exception e) {
        }
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
        String sql = "select q.id , a.answers, a.id as id_answer " +
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

    @Override
    public void saveData(Tb_resultExcerciseModel model) {
        try {
            getSession().save(model);
        } catch (Exception e) {
        }
    }

    @Override
    public List<Object[]> getHistorisExercise(Integer id) {
        String sql = "select  q.id,u.firstname,q.name,qa.id_jenis_soal, q.id_matery , qa.id_status , re.id_qa as jawaban" +
                    " from tb_quiz q,tb_qa qa,tb_answers a , tb_resultexercise re, tb_user u" +
                    " where q.id=qa.id_quiz " +
                    " and qa.id=a.id  " +
                    " and qa.id=re.id_qa" +
                    " and u.id=re.id_collerger and re.id_collerger = "+id+"";
        Query query = createNativeQuery(sql);
        return query.list();
    }

    @Override
    public List<Object[]> getJawabanBenar(Integer id) {
        String sql = "select q.id , a.answers,qa.id_status  " +
                    " from tb_quiz q  " +
                    " inner join  " +
                    " tb_answers a  " +
                    " inner join tb_qa qa  " +
                    " on q.id=qa.id_quiz   " +
                    " and qa.id_answers=a.id   " +
                    " and qa.id_status = 1" +
                    " and q.id = "+id+"";
        Query query = createNativeQuery(sql);
        return query.list();
    }
    
}
