package com.roman.payroll.restcontroller;

import com.roman.payroll.constants.Constants;
import com.roman.payroll.entity.Employee;
import com.roman.payroll.response.ResponseWithResults;
import com.roman.payroll.serviceImpl.EmployeeServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping(Constants.EMPLOYEE)
@AllArgsConstructor
public class EmployeeRest {

    private EmployeeServiceImpl es;

    @PostMapping("/add")
    public void employeeSave(@RequestBody Employee e){
        es.saveEmployee(e);
    }

    @GetMapping("/all")
    public List<Employee> allEmployee(){
        return es.getAllEmployee();
    }

    @PutMapping("/update/{id}")
    public void updateEmployee(@RequestBody Employee e ,@PathVariable("id")  Integer id){
        es.update(e, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable("id") int id){
        es.deleteEmployeeById(id);
    }

    @GetMapping("/{id}")
    public ResponseWithResults getEmployeeById(@PathVariable("id") int id){;
        return es.findEmployeeById(id);
    }
}
