package com.lorbarh.ems;

import com.lorbarh.ems.model.Employee;
import com.lorbarh.ems.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EmsApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {
//		Employee employee = new Employee();
//		employee.setFirstName("Oluwatobiloba");
//		employee.setLastName("Bolarinwa");
//		employee.setEmailId("bola@gmail.com");
//		employeeRepository.save(employee);
//
//		Employee employee1 = new Employee();
//		employee1.setFirstName("Samuel");
//		employee1.setLastName("Bolutife");
//		employee1.setEmailId("bolu@gmail.com");
//		employeeRepository.save(employee1);
	}
}
