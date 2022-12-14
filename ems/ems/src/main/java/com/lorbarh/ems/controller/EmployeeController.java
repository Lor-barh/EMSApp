package com.lorbarh.ems.controller;

import com.lorbarh.ems.exception.ResourceNotFoundException;
import com.lorbarh.ems.model.Employee;
import com.lorbarh.ems.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping()
    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    @PostMapping()
    public Employee createEmployee(@RequestBody Employee employee){
       return employeeRepository.save(employee);
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
        Employee employee = employeeRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException(
                "Employee with id " + id + " do not exist"
        ));
        return ResponseEntity.ok(employee);
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employeeDetails){
        Employee previousEmployeeDetails = employeeRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException(
                "Employee with id " + id + " do not exist"
        ));

        previousEmployeeDetails.setFirstName(employeeDetails.getFirstName());
        previousEmployeeDetails.setLastName(employeeDetails.getLastName());
        previousEmployeeDetails.setEmailId(employeeDetails.getEmailId());

        employeeRepository.save(previousEmployeeDetails);

        return ResponseEntity.ok(previousEmployeeDetails);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){
         Employee employee = employeeRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException(
                 "Employee with id " + id + " do not exist"
         ));

         employeeRepository.delete(employee);
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
