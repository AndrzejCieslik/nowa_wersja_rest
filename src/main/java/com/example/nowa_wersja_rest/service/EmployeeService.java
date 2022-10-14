package com.example.nowa_wersja_rest.service;

import com.example.nowa_wersja_rest.model.Employee;
import com.example.nowa_wersja_rest.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    /*@Autowired
    EmployeeRepository employeeRepository;*/
    public Employee createEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }
    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }
    public Employee updateEmployee(Long id,Employee employee){
        Optional<Employee> employeeOptional= employeeRepository.findById(id);
        Employee employee1 = new Employee();
        boolean flag = true;
        if(employeeOptional.isPresent()){
            employee1 = employeeOptional.get();
        }else {
            flag = false;
        }
        if(flag){
            employee1.setFirstName(employee.getFirstName());
            employee1.setLastName(employee.getLastName());
            employee1.setEmailId(employee.getEmailId());
            return employeeRepository.save(employee1);
        }
        return null;
    }
}
