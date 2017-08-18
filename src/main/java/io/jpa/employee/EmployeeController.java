package io.jpa.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping
	public List<Employee> findAll() {
		return employeeService.findAll();
	}

	@GetMapping(value = "/{id}")
	public Employee findOne(@PathVariable String id) {
		return employeeService.findOne(id);
	}

	@PostMapping
	public Employee create(@RequestBody Employee employee) {
		return employeeService.create(employee);
	}

	@PostMapping(value = "/{id}")
	public Employee update(@PathVariable String id, @RequestBody Employee employee) {
		return employeeService.update(id,employee);
	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable String id) {
		employeeService.delete(id);
	}

}
