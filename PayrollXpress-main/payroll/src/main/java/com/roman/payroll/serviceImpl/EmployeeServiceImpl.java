package com.roman.payroll.serviceImpl;

import com.roman.payroll.dto.EmployeeDTO;
import com.roman.payroll.entity.Employee;
import com.roman.payroll.repository.IEmployeeRepo;
import com.roman.payroll.response.ResponseWithResults;
import com.roman.payroll.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private final IEmployeeRepo iEmployeeRepo;

    @Override
    public void saveEmployee(Employee e) {
        iEmployeeRepo.save(e);
    }

    @Override
    public void deleteEmployeeById(int eid) {
        iEmployeeRepo.deleteById(eid);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return iEmployeeRepo.findAll();
    }

    @Override
    public ResponseWithResults findEmployeeById(int eid) {
        Employee e = iEmployeeRepo.findById(eid).get();
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(e.getId());
        employeeDTO.setName(e.getName());
        employeeDTO.setAddress(e.getAddress());
        employeeDTO.setMobile(e.getMobile());
        return new ResponseWithResults(200, "Success", employeeDTO);
    }

    @Override
    public void update(Employee e, int id) {
        iEmployeeRepo.save(e);
    }
}
