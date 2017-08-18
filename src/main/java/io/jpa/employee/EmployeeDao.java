package io.jpa.employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeDao {

	List<Employee> findAll();

	Optional<Employee> findByEmail(String email);

	Optional<Employee> findOne(String id);

	Employee create(Employee employee);

	Employee update(Employee employee);

	void delete(Employee employee);

}
