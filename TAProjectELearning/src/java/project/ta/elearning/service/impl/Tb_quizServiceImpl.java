/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ta.elearning.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.ta.elearning.dao.Tb_quizDao;
import project.ta.elearning.dto.Tb_quizDto;
import project.ta.elearning.dto.Tb_resultExerciseDto;
import project.ta.elearning.dto.Tb_resultQuizDto;
import project.ta.elearning.model.Tb_quizModel;
import project.ta.elearning.model.Tb_resultExcerciseModel;
import project.ta.elearning.model.Tb_resultquizModel;
import project.ta.elearning.service.Tb_quizService;

/**
 *
 * @author Sou
 */
@Transactional
@Service
public class Tb_quizServiceImpl implements Tb_quizService {

    @Autowired
    Tb_quizDao tb_quizDao;

    @Override
    public List<Tb_quizDto> getData() {
        List<Tb_quizDto> listData = new ArrayList<>();
        List<Tb_quizModel> listModel = tb_quizDao.getData();
        if (listModel.size() > 0) {
            for (Tb_quizModel model : listModel) {
                Tb_quizDto tb_quizDto =  new Tb_quizDto();
                tb_quizDto.setId(model.getId());
                tb_quizDto.setName(model.getName());
                listData.add(tb_quizDto);
            }
        }
        return listData;
    }

    @Override
    public void saveData(Tb_quizDto dto) {
        Tb_quizModel model = new Tb_quizModel();
        try {
            model.setId(1);
            model.setName(dto.getName());
            model.setId_category(dto.getId_category());
            model.setId_matery(dto.getId_matery());
            tb_quizDao.saveData(model);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteData(Integer id) {
        try {
            tb_quizDao.deleteData(id);
        } catch (Exception e) {

        }
    }

    @Override
    public void updateData(Tb_quizDto dto) {
        Tb_quizModel model = new Tb_quizModel();
        try {
            model.setId(dto.getId());
            model.setName(dto.getName());
            model.setId_category(dto.getId_category());
            model.setId_matery(dto.getId_matery());
            tb_quizDao.updateData(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Tb_quizDto getDataById(Integer id) {
        Tb_quizDto dto = new Tb_quizDto();
        List<Tb_quizModel> listModel = tb_quizDao.getDataById(id);
        if (listModel.size() > 0) {
            for (Tb_quizModel model : listModel) {
                dto = new Tb_quizDto();
                dto.setId(model.getId());
                dto.setName(model.getName());
                dto.setId_matery(model.getId_matery());
                dto.setId_category(model.getId_category());
            }
        }

        return dto;
    }

    @Override
    public List<Tb_quizDto> getAnswerAllByQuiz(Integer id) {
        List<Tb_quizDto> listData = new ArrayList<>();
        List<Object[]> listModel = tb_quizDao.getAnswerAllByQuiz(id);
        if (listModel.size() > 0) {
            for (Object[] obj : listModel) {
                Tb_quizDto dto = new Tb_quizDto();
                dto.setId(Integer.parseInt(obj[0].toString()));
                dto.setAnswer(obj[1].toString());
                dto.setId_answer(Integer.parseInt(obj[2].toString()));
                listData.add(dto);
            }
        }
        return listData;
    }

    @Override
    public Integer saveQuiz(Integer id, Integer id_collerger, Integer id_matery, Integer id_qa, Integer status) {
        try {
        } catch (Exception e) {
        }
        return 1;
    }

    @Override
    public void saveData(Tb_resultExerciseDto dto) {
        Tb_resultExcerciseModel model = new Tb_resultExcerciseModel();
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            String currDate = dateFormat.format(date);
            model.setId(1);
            model.setId_collerger(dto.getId_collerger());
            model.setId_matery(dto.getId_matery());
            model.setId_qa(dto.getId_qa());
            model.setShort_answer(dto.getShort_answer());
            model.setStatus(dto.getStatus());
            model.setTimeclose(currDate);
            model.setTimecreated(currDate);
            model.setTimemodified(currDate);
            model.setTimeopen(currDate);
            model.setId_category(dto.getId_categoory());
            if(dto.getStatus()==1){
                model.setPoin(1);
            }else{
                model.setPoin(0);
            }
            
            tb_quizDao.saveData(model);
        } catch (Exception e) {
        }
    }

    @Override
    public List<Tb_quizDto> getDataHistoris(Integer id) {
        String benarsalah = "";
        String jenissoal="";
        List<Tb_quizDto> listData = new ArrayList<>();
        List<Object[]> listModel = tb_quizDao.getHistorisExercise(id);
        if (listModel.size() > 0) {
            for (Object[] obj : listModel) {
                Tb_quizDto dto = new Tb_quizDto();
//                dto.setId(Integer.parseInt(obj[0].toString()));
                benarsalah = Integer.parseInt(obj[5].toString())==1?"Benar":"Salah";
                jenissoal = Integer.parseInt(obj[3].toString())==1?"Short Answer":"Choice";
                
                dto.setNama(obj[1].toString());
                dto.setSoal(obj[2].toString());
                dto.setJenis_soal(jenissoal);
                dto.setBenar_salah(benarsalah);
                dto.setJawaban(obj[6].toString());
                listData.add(dto);
            }
        }
        return listData;
    }

    @Override
    public List<Tb_quizDto> getJawabanBenar(Integer id) {
        List<Tb_quizDto> listData = new ArrayList<>();
        List<Object[]> listModel = tb_quizDao.getJawabanBenar(id);
        if (listModel.size() > 0) {
            for (Object[] obj : listModel) {
                Tb_quizDto dto = new Tb_quizDto();
                dto.setId(Integer.parseInt(obj[0].toString()));
                dto.setAnswer(obj[1].toString());
                listData.add(dto);
            }
        }
        return listData;
    }

    @Override
    public List<Tb_quizDto> getQuizRandomByLevel(int idLevel, int idMateri , int idUser) {
        List<Tb_quizDto> listData = new ArrayList<>();
        List<Object[]> listModel = tb_quizDao.getQuizRandomByLevel(idLevel, idMateri,idUser);
        if (listModel.size() > 0) {
            for (Object[] obj : listModel) {
                Tb_quizDto dto = new Tb_quizDto();
                dto.setId(Integer.parseInt(obj[0].toString()));
                dto.setName(obj[1].toString());
                dto.setId_jenis_soal(Integer.parseInt(obj[2].toString()));
                dto.setId_qa(Integer.parseInt(obj[4].toString()));
                dto.setId_category(Integer.parseInt(obj[5].toString()));
                dto.setId_matery(Integer.parseInt(obj[6].toString()));
                listData.add(dto);
            }
        }
        return listData;
    }

    @Override
    public int getTotalSoalByLevelAndMatery(int idLevel, int idMateri) {
        return tb_quizDao.getTotalSoalByLevelAndMatery(idLevel, idMateri);
    }

    @Override
    public List<Tb_quizDto> getStatus(Integer id_quiz, Integer id_answer) {
        List<Tb_quizDto> listData = new ArrayList<>();
        List<Object[]> listModel = tb_quizDao.getStatus(id_quiz, id_answer);
        if (listModel.size() > 0) {
            for (Object[] obj : listModel) {
                Tb_quizDto dto = new Tb_quizDto();
                dto.setId(Integer.parseInt(obj[0].toString()));
                dto.setId_status(Integer.parseInt(obj[1].toString()));
//                dto.setId_answer(Integer.parseInt(obj[2].toString()));
                listData.add(dto);
            }
        }
        return listData;
    }

    @Override
    public void saveData(Tb_resultQuizDto dto) {
        Tb_resultquizModel model = new Tb_resultquizModel();
        try {
            model.setId(1);
            model.setId_colleger(dto.getId_colleger());
            model.setId_matery(dto.getId_matery());
            model.setIdknowledge(dto.getIdknowledge());
            model.setId_category(dto.getId_category());
            model.setScore(dto.getScore());
            tb_quizDao.saveData(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Integer getTotalPoin(Integer id_user) {
        return tb_quizDao.getTotalPoin(id_user);
    }

//    Permulaan Menu Quiz

    @Override
    public List<HashMap> getSoalQuiz(int jumlahSoalPerLevel, int idMateri, int idKnowledge) {
        List<Tb_quizDto> listData = new ArrayList<>();
        List<HashMap> listSoalQuizLow = new ArrayList<>();
        List<HashMap> listSoalQuizMedium = new ArrayList<>();
        List<HashMap> listSoalQuizHigh = new ArrayList<>();
        List<HashMap> listSoalModelLow = new ArrayList<>();
        List<HashMap> listSoalModelMedium = new ArrayList<>();
        List<HashMap> listSoalModelHigh = new ArrayList<>();
        List<Object[]> listSoalQuiz = null;
        List<Object[]> listSoalModel = null;
        List<Object[]> listModel = tb_quizDao.getModel(idMateri);
        
        int kSebelumModel = 0, kUser = idKnowledge, idModel = -1;
        if(listModel!=null){
            for(Object[] obj : listModel){
                kSebelumModel = Integer.parseInt(obj[3].toString()); // obj[3] -> kolom knowledge_sebelum
                if(kSebelumModel==kUser){
                    idModel = Integer.parseInt(obj[1].toString());
                    break;
                }
            }
        }
        

//        Memisahkan soal quiz berdasarkan level ke dalam list yang berbeda.
        int nomor = 0;
        for(int i=1;i<=3;i++){
            listSoalQuiz = tb_quizDao.getQuizByLevelAndMateri(i, idMateri);
            listSoalModel = tb_quizDao.getSoalModel(i, idMateri, idModel);
            nomor = 1;
            if (listSoalQuiz.size() > 0) {
                for (Object[] obj : listSoalQuiz) {
                    HashMap hm = new HashMap();
                    
                    hm.put("no", nomor);
                    hm.put("id", Integer.parseInt(obj[0].toString()));
                    hm.put("name", obj[1].toString());
                    hm.put("id_jenis_soal", Integer.parseInt(obj[2].toString()));
                    hm.put("id_level", Integer.parseInt(obj[3].toString()));
                    hm.put("id_qa", Integer.parseInt(obj[4].toString()));
                    hm.put("id_category", Integer.parseInt(obj[5].toString()));
                    hm.put("id_matery", Integer.parseInt(obj[6].toString()));
                    if(i==1){
                        listSoalQuizLow.add(hm);
                        System.out.println("00000000000909\n" + listSoalQuizLow);
                    } else if(i==2){
                        listSoalQuizMedium.add(hm);
                        System.out.println("\n1111111111111111111100000000000909\n" + listSoalQuizMedium);
                    } else if(i==3){
                        listSoalQuizHigh.add(hm);
                        System.out.println("\n2222222222222200000000000909\n" + listSoalQuizHigh);
                    }
                    nomor++;
                }
            }
            
            if (listSoalModel.size() > 0) {
                for (Object[] obj : listSoalModel) {
                    HashMap hm = new HashMap();
                    
                    hm.put("no", nomor);
                    hm.put("id", Integer.parseInt(obj[0].toString()));
                    hm.put("name", obj[1].toString());
                    hm.put("id_jenis_soal", Integer.parseInt(obj[2].toString()));
                    hm.put("id_level", Integer.parseInt(obj[3].toString()));
                    hm.put("id_qa", Integer.parseInt(obj[4].toString()));
                    hm.put("id_category", Integer.parseInt(obj[5].toString()));
                    hm.put("id_matery", Integer.parseInt(obj[6].toString()));
                    if(i==1){
                        listSoalModelLow.add(hm);
                        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAA\n" + listSoalModelLow);
                    } else if(i==2){
                        listSoalModelMedium.add(hm);
                        System.out.println("\nBBBBBBBBBBBBBBBBBBBBB\n" + listSoalModelMedium);
                    } else if(i==3){
                        listSoalModelHigh.add(hm);
                        System.out.println("\nCCCCCCCCCCCCCCCCCCCCCC\n" + listSoalModelHigh);
                    }
                    nomor++;
                }
            }
        }
        
//        Merandom Soal
        List<HashMap> listSoalQuizHasilRandomLow = randomNSoal(jumlahSoalPerLevel, listSoalQuizLow, listSoalModelLow);
        List<HashMap> listSoalQuizHasilRandomMedium = randomNSoal(jumlahSoalPerLevel, listSoalQuizMedium, listSoalModelMedium);
        List<HashMap> listSoalQuizHasilRandomHigh = randomNSoal(jumlahSoalPerLevel, listSoalQuizHigh, listSoalModelHigh);
        
//        Menggabungkan hasil random dari ketiga level menjadi satu list
        List<HashMap> listSoalQuizHasilRandom = new ArrayList<>();
        int no = 1;
        for(HashMap hashMap : listSoalQuizHasilRandomLow){
            HashMap hm = new HashMap();
//            hm.put("no", Integer.parseInt(hashMap.get("no").toString()));
            hm.put("no", no);
            hm.put("id", Integer.parseInt(hashMap.get("id").toString()));
            hm.put("name", hashMap.get("name").toString());
            hm.put("id_jenis_soal", Integer.parseInt(hashMap.get("id_jenis_soal").toString()));
            hm.put("id_level", Integer.parseInt(hashMap.get("id_level").toString()));
            hm.put("id_qa", Integer.parseInt(hashMap.get("id_qa").toString()));
            hm.put("id_category", Integer.parseInt(hashMap.get("id_category").toString()));
            hm.put("id_matery", Integer.parseInt(hashMap.get("id_matery").toString()));
            listSoalQuizHasilRandom.add(hm);
            no++;
        }
        for(HashMap hashMap : listSoalQuizHasilRandomMedium){
            HashMap hm = new HashMap();
//            hm.put("no", Integer.parseInt(hashMap.get("no").toString()));
            hm.put("no", no);
            hm.put("id", Integer.parseInt(hashMap.get("id").toString()));
            hm.put("name", hashMap.get("name").toString());
            hm.put("id_jenis_soal", Integer.parseInt(hashMap.get("id_jenis_soal").toString()));
            hm.put("id_level", Integer.parseInt(hashMap.get("id_level").toString()));
            hm.put("id_qa", Integer.parseInt(hashMap.get("id_qa").toString()));
            hm.put("id_category", Integer.parseInt(hashMap.get("id_category").toString()));
            hm.put("id_matery", Integer.parseInt(hashMap.get("id_matery").toString()));
            listSoalQuizHasilRandom.add(hm);
            no++;
        }
        for(HashMap hashMap : listSoalQuizHasilRandomHigh){
            HashMap hm = new HashMap();
//            hm.put("no", Integer.parseInt(hashMap.get("no").toString()));
            hm.put("no", no);
            hm.put("id", Integer.parseInt(hashMap.get("id").toString()));
            hm.put("name", hashMap.get("name").toString());
            hm.put("id_jenis_soal", Integer.parseInt(hashMap.get("id_jenis_soal").toString()));
            hm.put("id_level", Integer.parseInt(hashMap.get("id_level").toString()));
            hm.put("id_qa", Integer.parseInt(hashMap.get("id_qa").toString()));
            hm.put("id_category", Integer.parseInt(hashMap.get("id_category").toString()));
            hm.put("id_matery", Integer.parseInt(hashMap.get("id_matery").toString()));
            listSoalQuizHasilRandom.add(hm);
            no++;
        }
        
        System.out.println("\n44444444444444444444444444444444444444444444000000\n" + listSoalQuizHasilRandom);
        
        return listSoalQuizHasilRandom;
    }
    
    public List<HashMap> randomNSoal(int jumlahSoalQuizPerLevel, List<HashMap> listSoalQuiz, List<HashMap> listSoalModel){
        Random random = new Random();
        
        ArrayList arrayList = new ArrayList();
        int banyakSoalModel = listSoalModel.size();
        int n = jumlahSoalQuizPerLevel - banyakSoalModel;
        
        List<HashMap> listSoalQuizHasilRandom = new ArrayList<>();
        int penghitung = 1;
        if(listSoalModel!=null){
            for(HashMap hashMap : listSoalModel){
                if(penghitung>jumlahSoalQuizPerLevel){
                    break;
                }
                HashMap hm = new HashMap();
                hm.put("no", Integer.parseInt(hashMap.get("no").toString()));
                hm.put("id", Integer.parseInt(hashMap.get("id").toString()));
                hm.put("name", hashMap.get("name").toString());
                hm.put("id_jenis_soal", Integer.parseInt(hashMap.get("id_jenis_soal").toString()));
                hm.put("id_level", Integer.parseInt(hashMap.get("id_level").toString()));
                hm.put("id_qa", Integer.parseInt(hashMap.get("id_qa").toString()));
                hm.put("id_category", Integer.parseInt(hashMap.get("id_category").toString()));
                hm.put("id_matery", Integer.parseInt(hashMap.get("id_matery").toString()));
                listSoalQuizHasilRandom.add(hm);
                penghitung++;
            }
        }
        int a = 0;
        int indexList = 0;
        int jumlah = 0;
        int jumlahSoalDalamList = listSoalQuiz.size();
//        int n = jumlahSoalQuizPerLevel;
        if(n>0){
            for(int i=1;i!=0;i++){
                System.out.println("Putaran " + (i));
                a = random.nextInt(jumlahSoalDalamList) + 1;
                System.out.println("Isi random baru " + a);

                indexList = 0;
                jumlah=0;

    //            Mengeset dua angka random awal
                if(i==0) { 
                    arrayList.add(a);
                    a = random.nextInt(jumlahSoalDalamList) + 1;
                    int j = 1;

    //                Mengecek apakah angka random kedua sama dengan angka random 1. Jika sama, 
    //                tidak dimasukkan ke list dan melakukan random lagi.
                    while(j!=0){
                        if(a != (int) arrayList.get(indexList)){
                            arrayList.add(a);
                            break;
                        }
                    }

                }

    //            Mengecek apakah angka random sudah pernah muncul atau belum. Jika pernah muncul, 
    //            tidak dimasukkan ke list dan sebaliknya.
                for (Object object : arrayList) {
                    System.out.println("Isi arrayList " + (indexList+1) + " : " + (int) arrayList.get(indexList));
                    if(a == (int) arrayList.get(indexList)){
                        jumlah++;
                    }
                    indexList++;
                }
                if(jumlah==0) arrayList.add(a);

    //            Menghentikan perulangan saat banyaknya angka random dalam list sesuai banyak soal per level 
    //            yang telah ditentukan.
                if(indexList==n) break;
            }
        
            int counter = 0;
            while(counter<n){
                for(HashMap hashMap : listSoalQuiz){
                    if((int) arrayList.get(counter) == (int) hashMap.get("no")){
                        HashMap hm = new HashMap();
                        hm.put("no", Integer.parseInt(hashMap.get("no").toString()));
                        hm.put("id", Integer.parseInt(hashMap.get("id").toString()));
                        hm.put("name", hashMap.get("name").toString());
                        hm.put("id_jenis_soal", Integer.parseInt(hashMap.get("id_jenis_soal").toString()));
                        hm.put("id_level", Integer.parseInt(hashMap.get("id_level").toString()));
                        hm.put("id_qa", Integer.parseInt(hashMap.get("id_qa").toString()));
                        hm.put("id_category", Integer.parseInt(hashMap.get("id_category").toString()));
                        hm.put("id_matery", Integer.parseInt(hashMap.get("id_matery").toString()));
                        listSoalQuizHasilRandom.add(hm);
                    }
                }

                counter++;
            }
        }
        return listSoalQuizHasilRandom;
    }

    @Override
    public List<Tb_resultQuizDto> getInformationOfExercise(Integer id) {
        List<Tb_resultQuizDto> listData = new ArrayList<>();
        List<Object[]> listModel = tb_quizDao.getInformationOfExercise(id);
        if (listModel.size() > 0) {
            for (Object[] obj : listModel) {
                Tb_resultQuizDto dto = new Tb_resultQuizDto();
                dto.setId(Integer.parseInt(obj[0].toString()));
                dto.setName(obj[1].toString());
                dto.setScore(Integer.parseInt(obj[2].toString()));
                dto.setKnowledge(obj[3].toString());
                listData.add(dto);
            }
        }
        return listData;
    }

    @Override
    public void saveDataScore(Tb_resultQuizDto dto) {
        
        Tb_resultquizModel model = new Tb_resultquizModel();
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            String currDate = dateFormat.format(date);
            model.setId(1);
            model.setId_colleger(dto.getId_colleger());
            model.setId_matery(dto.getId_matery());
            model.setIdknowledge(dto.getIdknowledge());
            model.setId_category(dto.getId_category());
            model.setScore(dto.getScore());
            
            tb_quizDao.saveData(model);
        } catch (Exception e) {
        }
    }

    @Override
    public List<Tb_quizDto> getQuizRandomByLevelAndidQuiz(int idLevel, int id_quiz) {
        List<Tb_quizDto> listData = new ArrayList<>();
        List<Object[]> listModel = tb_quizDao.getQuizRandomByLevelandIdQuiz(idLevel,id_quiz);
        if (listModel.size() > 0) {
            for (Object[] obj : listModel) {
                Tb_quizDto dto = new Tb_quizDto();
                dto.setId(Integer.parseInt(obj[0].toString()));
                dto.setName(obj[1].toString());
                dto.setId_jenis_soal(Integer.parseInt(obj[2].toString()));
                dto.setId_qa(Integer.parseInt(obj[4].toString()));
                dto.setId_category(Integer.parseInt(obj[5].toString()));
                dto.setId_matery(Integer.parseInt(obj[6].toString()));
                dto.setDescription(obj[7].toString());
                listData.add(dto);
            }
        }
        return listData;
    }

    @Override
    public int getStatusMateri() {
        return tb_quizDao.getStatusMateri();
    }

    @Override
    public List<Tb_quizDto> getQuizRandomByLevelPG(int idLevel, int idMateri, int idUser) {
        List<Tb_quizDto> listData = new ArrayList<>();
        List<Object[]> listModel = tb_quizDao.getQuizRandomByLevelPG(idLevel, idMateri,idUser);
        if (listModel.size() > 0) {
            for (Object[] obj : listModel) {
                Tb_quizDto dto = new Tb_quizDto();
                dto.setId(Integer.parseInt(obj[0].toString()));
                dto.setName(obj[1].toString());
                dto.setId_jenis_soal(Integer.parseInt(obj[2].toString()));
                dto.setId_qa(Integer.parseInt(obj[4].toString()));
                dto.setId_category(Integer.parseInt(obj[5].toString()));
                dto.setId_matery(Integer.parseInt(obj[6].toString()));
                listData.add(dto);
            }
        }
        return listData;
    }

    @Override
    public List<Tb_quizDto> getQuizRandomByLevelEssay(int idLevel, int idMateri, int idUser) {
        List<Tb_quizDto> listData = new ArrayList<>();
        List<Object[]> listModel = tb_quizDao.getQuizRandomByLevelEssay(idLevel, idMateri,idUser);
        if (listModel.size() > 0) {
            for (Object[] obj : listModel) {
                Tb_quizDto dto = new Tb_quizDto();
                dto.setId(Integer.parseInt(obj[0].toString()));
                dto.setName(obj[1].toString());
                dto.setId_matery(Integer.parseInt(obj[2].toString()));
                dto.setId_jenis_soal(Integer.parseInt(obj[4].toString()));
                dto.setId_category(Integer.parseInt(obj[5].toString()));
                
                listData.add(dto);
            }
        }
        return listData;
    }

    @Override
    public int soalHabis(int id_colleger) {
        int result = 0;
        try {
             result = tb_quizDao.soalHabis(id_colleger);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    @Override
    public int updateStatusMateri(int status) {
        int result = 0;
        try {
             result = tb_quizDao.updateStatusMateri(status);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int getStatusJumlahSoalPerLevel() {
        return tb_quizDao.getStatusJumlahSOal();
    }
    
    @Override
    public int updateJumlahSoalPerLevel(int jumlah) {
        int result = 0;
        try {
             result = tb_quizDao.updateJumlahSoalPerLevel(jumlah);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
