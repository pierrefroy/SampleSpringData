package com.example.demo;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        employeeService.persist(build(1, "Pierre"));
        employeeService.persist(build(2, "Roger"));
        employeeService.persist(build(3, "Max"));
        employeeService.persist(build(4, "Max1"));
        employeeService.persist(build(5, "Max2"));
        employeeService.persist(build(6, "Max3"));
        employeeService.persist(build(7, "Max4"));
//        employeeService.persist(build(8, "Max4"));
//        employeeService.persist(build(9, "Max4"));
//        employeeService.persist(build(10, "Max4"));
//        employeeService.persist(build(11, "Max4"));
//        employeeService.persist(build(12, "Max4"));
//        employeeService.persist(build(13, "Max4"));
//        employeeService.persist(build(14, "Max4"));
//        employeeService.persist(build(15, "Max4"));

        return employeeRepository.findAll();
    }

    private Employee build(int id, String name) {
        return Employee.builder()
                .id(id)
                .name(name)
                .build();
    }
}
