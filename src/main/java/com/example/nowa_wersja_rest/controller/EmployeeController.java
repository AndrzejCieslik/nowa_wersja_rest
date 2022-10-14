package com.example.nowa_wersja_rest.controller;

import com.example.nowa_wersja_rest.model.Employee;
import com.example.nowa_wersja_rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @PostMapping(value = "/employees")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }
    @GetMapping("/employees")
    public List<Employee> readEmployees(){
        return employeeService.getEmployees();
    }
    @PutMapping("/employees/{empId}")
    public Employee readEmployees(@PathVariable(value = "empId") Long id,@RequestBody Employee employee){
        return employeeService.updateEmployee(id,employee);
    }
    @DeleteMapping("/employees/{empId}")
    public void deleteEmployees(@PathVariable(value = "empId") Long id){
        employeeService.deleteEmployee(id);
    }
}
