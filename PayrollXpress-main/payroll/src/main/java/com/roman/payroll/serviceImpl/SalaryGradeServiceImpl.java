package com.roman.payroll.serviceImpl;

import com.roman.payroll.entity.SalaryGrade;
import com.roman.payroll.repository.ISalaryGradeRepo;
import com.roman.payroll.service.SalaryGradeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SalaryGradeServiceImpl implements SalaryGradeService {
    private ISalaryGradeRepo iSalaryGradeRepo;


    public  void  saveSalaryGrade(SalaryGrade s){
        //get basic salary from user
        double bSalary = s.getBasic_salary();
        //get id no of salary grade
        int sgId = s.getId();
            for (int i = 6; i >= 1; i-- ){
                SalaryGrade sg = new SalaryGrade();
                // declear variable and increment it for increment salary range
                int incrSalary = 0;
                incrSalary++;

                if(sgId == 6 ){
                    sg.setId(i);
                }

                //Grade_name/id means which grade belong like grade-1, grade-2 etc.
                sg.setGrade_name(i);
                if (i == 6){
                    sg.setBasic_salary(bSalary);
                }else{
                    // increment salary range each grade +5000
                    bSalary = bSalary+(5000*incrSalary);
                    sg.setBasic_salary(bSalary);
                }

                // calculate and set value of house rent and medical allowance for each grade
                sg.setHouse_rent(bSalary*.20);
                sg.setMedical_allowance(bSalary*.15);
                sg.setTotal_salary(bSalary+sg.getHouse_rent()+sg.getMedical_allowance());

                // save grade for 6 time (for each grade)
                iSalaryGradeRepo.save(sg);
            }

    }


    public void deleteSalaryGradeById(int sid){
        iSalaryGradeRepo.deleteById(sid);
    }

    public List<SalaryGrade> getAllSalaryGrade(){
        return iSalaryGradeRepo.findAll();
    }

    public  SalaryGrade findSalaryGradeById(int sid){
        return iSalaryGradeRepo.findById(sid).get();
    }
    public void update(SalaryGrade sg, int id){
        iSalaryGradeRepo.save(sg);
    }
}
