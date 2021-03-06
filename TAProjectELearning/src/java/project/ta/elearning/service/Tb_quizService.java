/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ta.elearning.service;

import java.util.HashMap;
import java.util.List;
import project.ta.elearning.dto.Tb_quizDto;
import project.ta.elearning.dto.Tb_resultExerciseDto;
import project.ta.elearning.dto.Tb_resultQuizDto;

/**
 *
 * @author Sou
 */
public interface Tb_quizService {

    public List<Tb_quizDto> getData();

    public List<Tb_quizDto> getDataHistoris(Integer id);

    public void saveData(Tb_quizDto dto);

    public void saveData(Tb_resultQuizDto dto);

    public void deleteData(Integer id);

    public void updateData(Tb_quizDto dto);

    public Tb_quizDto getDataById(Integer id);

    public List<Tb_quizDto> getAnswerAllByQuiz(Integer id);

    public List<Tb_quizDto> getJawabanBenar(Integer id);

    public Integer saveQuiz(Integer id, Integer id_collerger, Integer id_matery, Integer id_qa, Integer status);

    public void saveData(Tb_resultExerciseDto dto);

    public List<Tb_quizDto> getQuizRandomByLevel(int idLevel, int idMateri,int idUser);
    
    public List<Tb_quizDto> getQuizRandomByLevelPG(int idLevel, int idMateri,int idUser);
    
    public List<Tb_quizDto> getQuizRandomByLevelEssay(int idLevel, int idMateri,int idUser);
    
    public List<Tb_quizDto> getQuizRandomByLevelAndidQuiz(int idLevel,int id_quiz);

    public int getTotalSoalByLevelAndMatery(int idLevel, int idMateri);

    public List<Tb_quizDto> getStatus(Integer id_quiz, Integer id_answer);

    public Integer getTotalPoin(Integer id_user);

//    Permulaan Menu Quiz
    public List<HashMap> getSoalQuiz(int idLevel, int idMateri, int idKnowledge);
    
    public void saveDataScore(Tb_resultQuizDto dto);
    
//    Menampilkan nilai Exercise
    public List<Tb_resultQuizDto> getInformationOfExercise(Integer id);
    
    public int getStatusMateri();
    
//    ketika soal habis
    public int soalHabis(int id_colleger);
    
    public int updateStatusMateri(int status);
    
    public int getStatusJumlahSoalPerLevel();
    
    public int updateJumlahSoalPerLevel(int jumlah);
}
