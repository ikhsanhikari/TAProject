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
    
    public void saveData(Tb_resultExcerciseModel model);
    
    public List<Object[]> getJawabanBenar(Integer id);
    
    public List<Object[]> getQuizRandomByLevel(int idLevel, int idMateri , int idUser);
    
    public List<Object[]> getQuizRandomByLevelEssay(int idLevel, int idMateri , int idUser);
    
    public List<Object[]> getQuizRandomByLevelPG(int idLevel, int idMateri , int idUser);
    
    public List<Object[]> getQuizRandomByLevelandIdQuiz(int idLevel,int id_quiz);
    
    public int getTotalSoalByLevelAndMatery(int idLevel, int idMateri);

    public List<Object[]> getStatus(Integer id_qa,Integer id_answer);
    
    public Integer getTotalPoin(Integer id_user);
    
//    Permulaan untuk Menu Quiz
    public List<Object[]> getQuizByLevelAndMateri(int idLevel, int idMateri);
    
//    Menampilkan nilai
    public List<Object[]> getInformationOfExercise(Integer id);
    
    public int getStatusMateri();
    
    public int updateStatusMateri(int status);
    
    public int soalHabis(int id_colleger);
    
    public int getStatusJumlahSOal();
    
    public int updateJumlahSoalPerLevel(int jumlah);
    
    public List<Object[]> getSoalModel(int idLevel, int idMateri, int idUser);
    
    public List<Object[]> getModel(int idMatery);
}
