/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ta.elearning.service;

import java.util.List;
import project.ta.elearning.dto.Tb_quizDto;

/**
 *
 * @author Sou
 */
public interface Tb_quizService {

    public List<Tb_quizDto> getData();

    public void saveData(Tb_quizDto dto);

    public void deleteData(Integer id);

    public void updateData(Tb_quizDto dto);

    public Tb_quizDto getDataById(Integer id);
    
    public List<Tb_quizDto> getAnswerAllByQuiz(Integer id);
    
    public Integer saveQuiz(Integer id,Integer id_collerger,Integer id_matery,Integer id_qa,Integer status);
}
