/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shohab.midevdtest.controller;
import com.shohab.midevdtest.dao.StudentDao;
import com.shohab.midevdtest.model.Student;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 *
 * @author user
 */
@Controller
public class StudentController {
    @Autowired
    private StudentDao sd;
    
    @GetMapping("/viewallstu")
    public  String viewAllStu(Model m){
        List<Student> stuList=sd.getAllStu();        
        m.addAttribute("stuList", stuList);
        return "viewallstu";
     
    }
    
     @GetMapping("/stusaveform")
    public  String saveForm(Model m){        
     m.addAttribute("student", new Student());        
        return "stusaveform";    
    } 
   @PostMapping("/stusave")
    public  String saveStudent(@ModelAttribute Student s){        
        sd.saveStu(s);            
        return "redirect:/viewallstu";   
    } 
    
    @RequestMapping("/deletestu/{id}")
    public  String deleteStu(@PathVariable("sid") int id){
        
        sd.deleteStu(id);
        return "redirect:/viewallstu";         
    }
    @RequestMapping("/stueditform/{id}")
    public String stuEditForm(@PathVariable("sid") int id,Model m){
        Student student=sd.getStuById(id);
        m.addAttribute("student", student);
        return  "stuEdit";  
    }
    
    @RequestMapping("/editempsave")
    public String editStuSave(@ModelAttribute("student") Student student){
       sd.updateStu(student);
        return "redirect:/viewallstu";
    }
    
}
