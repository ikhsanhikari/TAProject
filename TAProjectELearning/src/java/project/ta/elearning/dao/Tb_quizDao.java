/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ta.elearning.dao;

import java.util.List;
import project.ta.elearning.model.Tb_quizModel;
import project.ta.elearning.model.Tb_resultExcerciseModel;
import project.ta.elearning.model.Tb_resultquizModel;

/**
 *
 * @author Sou
 */
public interface Tb_quizDao {

    public List<Tb_quizModel> getData();

    public void saveData(Tb_quizModel model);
    
    public void saveData(Tb_resultquizModel model);

    public void deleteData(Integer id);

    public void updateData(Tb_quizModel model);

    public List<Tb_quizModel> getDataById(Integer id);

    public List<Object[]> getQuizAll();
    
    public List<Object[]> getAnswerAllByQuiz(Integer id);
    
    public List<Object[]> getHistorisExercise(Integer id);
    
    public  final String queryQuizAll = "select q.id,q.name,a.answers,qa.id_status   " +
                                        "from tb_quiz q,tb_qa qa,tb_answers a  " +
                                        "where q.id=qa.id_quiz  " +
                                        "and qa.id=a.id " +
                                        "";
    public void saveData(Tb_resultExcerciseModel model);
    
    public List<Object[]> getJawabanBenar(Integer id);
    
    public List<Object[]> getQuizRandomByLevel(int idLevel);
    
    public int getTotalSoalByLevel(int idLevel);

    public List<Object[]> getStatus(Integer id_qa,Integer id_answer);
    
    public Integer getTotalPoin(Integer id_user);
}
