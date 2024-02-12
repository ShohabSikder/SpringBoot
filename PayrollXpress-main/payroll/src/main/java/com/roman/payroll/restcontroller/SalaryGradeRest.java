package com.roman.payroll.restcontroller;

import com.roman.payroll.constants.Constants;
import com.roman.payroll.entity.SalaryGrade;
import com.roman.payroll.repository.ISalaryGradeRepo;
import com.roman.payroll.serviceImpl.SalaryGradeServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping(Constants.SALARY_GRADE)
@AllArgsConstructor
public class SalaryGradeRest {

    private SalaryGradeServiceImpl sgs;

    private ISalaryGradeRepo iSalaryGradeRepo;

    @GetMapping("/check")
    public int salaryLength(){
        return iSalaryGradeRepo.salaryTlenth();
    }

    @PostMapping("/add")
    public void salaryGradeSave(@RequestBody SalaryGrade s){
        sgs.saveSalaryGrade(s);
    }

    @GetMapping("/all")
    public List<SalaryGrade> allSalaryGrade(){
        return sgs.getAllSalaryGrade();
    }


    @PutMapping("/update/{id}")
    public void updateSalaryGrade(@RequestBody SalaryGrade sg ,@PathVariable("id")  Integer id){
        sgs.update(sg, id);

    }

    @DeleteMapping("/delete/{id}")
    public void deleteSalaryGrade(@PathVariable("id") int id){
        sgs.deleteSalaryGradeById(id);
    }

    @GetMapping("/{lid}")
    public SalaryGrade getSalaryGradeById(@PathVariable("sgid") int sgid){;
        return sgs.findSalaryGradeById(sgid);
    }
}
